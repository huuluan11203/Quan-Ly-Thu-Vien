
package BUS;

import DAO.PhieuMuonDAO;
import DTO.PhieuMuon;
import GUI.UIComponents.Table.Table;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import raven.toast.Notifications;


public class PhieuMuon_BUS {
    private static ArrayList<PhieuMuon> PM_ArrayList;
    private static NhanVien_BUS nhanvien;
    private static DocGia_BUS docgia;

    public PhieuMuon_BUS() {
        this.PM_ArrayList = PhieuMuonDAO.getInstance().selectAll();
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
    
    public PhieuMuon SelectedPhieuMuon(int ma){
        PhieuMuon pm = PhieuMuonDAO.getInstance().selectByID(ma);
        return pm;
    }
    
    public void RenderPhieuMuon(Table table){
        
        for(PhieuMuon s : PM_ArrayList){
               int mapm = s.getMaPhieuMuon();
               int manv =s.getMaNV();
               int madocgia = s.getMaDocGia();
               String tt = s.getTinhTrang();
               String date = FormatDate(s.getNgayMuon());
            table.addRow(new Object[] {mapm, manv, madocgia, date, tt});
            
        }
    }
    
    public boolean isExsit(int ma){
        PhieuMuon pn = PhieuMuonDAO.getInstance().selectByID(ma);
        if (pn != null) {
            return true;
        }
        return false;
    }
    
    public boolean CompareTo(PhieuMuon pn, PhieuMuon curent){
        if (pn.getMaNV() == curent.getMaNV() &&
            pn.getMaPhieuMuon()== curent.getMaPhieuMuon()&&
            pn.getMaDocGia()== curent.getMaDocGia()&&
            pn.getTinhTrang().equals(curent.getTinhTrang()) &&
            pn.getNgayMuon().isEqual(curent.getNgayMuon())
                ){
            return true;
        }
        return false;
    }
    
    public boolean XoaPhieuMuon(PhieuMuon pn){
        if (pn != null) {
            PhieuMuonDAO.getInstance().delete(pn);
            return true;
        }
        return false;
        
    }
    
    public boolean ThemPhieuMuon(PhieuMuon pn){
        
        nhanvien = new NhanVien_BUS();
        docgia = new DocGia_BUS();
        
        LocalDate now = LocalDate.now();
        
        
        if (pn != null) {
            if (!nhanvien.isExsit(pn.getMaNV())) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Nhân viên không tồn tại.");
                return false;
            }
            
            if (isExsit(pn.getMaPhieuMuon())) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Phiếu mượn đã tồn tại.");
                return false;
            }
            
            if (pn.getNgayMuon().isAfter(now)) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Ngày mượn không đúng.");
                return false;
            }
            
            if (!docgia.isExsit(pn.getMaDocGia())) {
                 Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Độc giả không tồn tại.");
                return false;
            }
            
            
            PhieuMuonDAO.getInstance().insert(pn);
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 
                    "Thêm phiếu mượn thành công.");
            return true;
            
         
        }
        return false;
        
    }    
    
    
    public boolean SuaPhieuMuon(PhieuMuon pn, PhieuMuon current){
        
        nhanvien = new NhanVien_BUS();
        docgia = new DocGia_BUS();
        LocalDate now = LocalDate.now();
        
        if (pn != null && current != null) {
            if (!CompareTo(pn, current)) {
                if (pn.getNgayMuon().isAfter(now)) {
                     Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Ngày mượn Không đúng");
                    return false;
                }
                
                if (!nhanvien.isExsit(pn.getMaNV())) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Nhân viên không tồn tại");
                    return false;
                }
                
                if (!docgia.isExsit(pn.getMaDocGia())) {
                     Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                        "Độc giả không tồn tại.");
                    return false;
                }               

                PhieuMuonDAO.getInstance().update(pn);
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
      
    
    
    
}
