
package BUS;

import DAO.ChiTietPhieuMuonDAO;
import DAO.SachDAO;
import DTO.ChiTietPhieuMuon;
import DTO.PhieuMuon;
import DTO.Sach;
import GUI.UIComponents.Table.Table;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import raven.toast.Notifications;


public class ChiTietPhieuMuon_BUS {
    private ArrayList<ChiTietPhieuMuon> CTPM;
    private static Sach_BUS sach_BUS;
    private static PhieuMuon_BUS phieuMuon_BUS;
    private static PhieuMuon pm;

    public ChiTietPhieuMuon_BUS() {
        CTPM = ChiTietPhieuMuonDAO.getInstance().selectAll();
    }
    
    public ChiTietPhieuMuon SelectedCTPM(int ma){
        ChiTietPhieuMuon ctpm = ChiTietPhieuMuonDAO.getInstance().selectByID(ma);
        return ctpm;
    }
    
       public String FormatDate(LocalDate dateinp){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 
        String formattedDate = dateinp.format(format);  
        return formattedDate;
    }
    
    public LocalDate FormatDateSQL(String dateinp){

        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(dateinp, inputFormatter);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String outputDate = localDate.format(outputFormatter);
        LocalDate date = LocalDate.parse(outputDate);
        return date;
        
    }
    
        public boolean XoaCTPM(ChiTietPhieuMuon pn){
        if (pn != null) {
            ChiTietPhieuMuonDAO.getInstance().delete(pn);
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT,
                        "Xóa chi tiết phiếu mượn thành công.");
            return true;
        }
        return false;
        
    }
    
    public boolean isExsit(int ma){
        ChiTietPhieuMuon pn = ChiTietPhieuMuonDAO.getInstance().selectByID(ma);
        if (pn != null) {
            return true;
        }
        return false;
    }
        
    public boolean ThemCTPM(ChiTietPhieuMuon pn){
        
        LocalDate now = LocalDate.now();
        sach_BUS = new Sach_BUS();
        phieuMuon_BUS = new PhieuMuon_BUS();
        
        
        if (pn != null) {

            
            if (isExsit(pn.getMaCTPM())) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Chi tiết phiếu mượn đã tồn tại.");
                return false;
            }
            
            if (pn.getNgayTra().isBefore(now)) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Ngày trả không đúng.");
                return false;
            }
            
            if (!sach_BUS.isExsit(pn.getMaSach())) {
                 Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Sách không tồn tại.");
                return false;
            }
            
            if (!phieuMuon_BUS.isExsit(pn.getMaPhieuMuon())) {
                 Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Mã phiếu mượn không tồn tại.");
                return false;
            }
            
            if (pn.getGhiChu().equals("")) {
                 Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Ghi chú không được để trống.");
                return false;
            }
            
            if (ChiTietPhieuMuonDAO.getInstance().insert(pn) == -1) {
                 Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Chi tiết phiếu mượn (Mã Phiếu Mượn \"" + pn.getMaPhieuMuon() + "\") đã tồn tại.");
                return false;
            }
            
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 
                    "Thêm chi tiết phiếu mượn thành công.");
            
            Sach s = sach_BUS.SelectedSach(pn.getMaSach());
            if (s != null) {
                s.setSoLuong(s.getSoLuong() - 1);
            }
            SachDAO.getInstance().update(s);
            
            return true;
            
         
        }
        return false;
        
    }    
    
    public boolean CompareTo(ChiTietPhieuMuon pn, ChiTietPhieuMuon curent){
        if (pn.getMaCTPM()== curent.getMaCTPM()&&
            pn.getMaPhieuMuon()== curent.getMaPhieuMuon()&&
            pn.getMaSach()== curent.getMaSach()&&
            pn.getGhiChu().equals(curent.getGhiChu()) &&
            pn.getNgayTra().isEqual(curent.getNgayTra())
                ){
            return true;
        }
        return false;
    }
        
    public boolean SuaCTPM(ChiTietPhieuMuon pn, ChiTietPhieuMuon current){

        LocalDate now = LocalDate.now();
        sach_BUS = new Sach_BUS();
        phieuMuon_BUS = new PhieuMuon_BUS();
        pm = phieuMuon_BUS.SelectedPhieuMuon(pn.getMaPhieuMuon());
        
        if (pn != null && current != null) {
            if (!CompareTo(pn, current)) {
            
                if (pn.getNgayTra().isBefore(pm.getNgayMuon())) {
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                        "Ngày trả không đúng.");
                    return false;
                }

                if (!sach_BUS.isExsit(pn.getMaSach())) {
                     Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                        "Sách không tồn tại.");
                    return false;
                }

                if (!phieuMuon_BUS.isExsit(pn.getMaPhieuMuon())) {
                     Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                        "Mã phiếu mượn không tồn tại.");
                    return false;
                }

                 if (pn.getGhiChu().equals("")) {
                     Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                        "Ghi chú không được để trống.");
                    return false;
                }


                ChiTietPhieuMuonDAO.getInstance().update(pn);
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 
                        "Lưu thành công.");
                return true;
            
            }else{
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 
                    "Lưu thành công.");
                return true;
            }
        }
        return false;
    }
      
    public void RenderCTPM(Table table){
        
        CTPM = ChiTietPhieuMuonDAO.getInstance().selectAll();
        
        for(ChiTietPhieuMuon s : CTPM){
               int mapm = s.getMaPhieuMuon();
               int mactpm =s.getMaCTPM();
               int ms = s.getMaSach();
               String ghichu = s.getGhiChu();
               String date = FormatDate(s.getNgayTra());
            table.addRow(new Object[] {mactpm, mapm, ms, date, ghichu});
            
        }
    }    
    
           
}
