
package BUS;

import DAO.ChiTietPhieuMuonDAO;
import DAO.PhieuMuonDAO;
import DAO.PhieuPhatDAO;
import DTO.PhieuMuon;
import DTO.PhieuPhat;
import GUI.UIComponents.Table.Table;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import raven.toast.Notifications;


public class PhieuPhat_BUS {
    
    private ArrayList<PhieuPhat> PP_ArrayList;
    private static PhieuMuon_BUS phieuMuon_BUS;
    private static ChiTietPhieuMuon_BUS chiTietPhieuMuon_BUS;
    private static PhieuMuon phieumuon;

    public PhieuPhat_BUS() {
        PP_ArrayList = PhieuPhatDAO.getInstance().selectAll();
    }
    
    
    public PhieuPhat SelectedPhieuPhat(int ma){
        PhieuPhat pp = PhieuPhatDAO.getInstance().selectByID(ma);
        return pp;
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
    
        
    public boolean isExsit(int ma){
        PhieuPhat pp = PhieuPhatDAO.getInstance().selectByID(ma);
        if (pp != null) {
            return true;
        }
        return false;
    }
    
    public boolean XoaPhieuPhat(PhieuPhat pp){
        if (pp != null) {
            PhieuPhatDAO.getInstance().delete(pp);
             Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 
                    "Xóa phiếu phạt thành công.");
            return true;
        }
        return false;
        
    }
    
     public boolean ThemPhieuPhat(PhieuPhat pp){
        
        LocalDate now = LocalDate.now();
        phieuMuon_BUS = new PhieuMuon_BUS();
        phieumuon = PhieuMuonDAO.getInstance().selectByID(pp.getMaPM());
        
        if (pp != null) {

            
            if (isExsit(pp.getMaPP())) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Phiếu phạt đã tồn tại.");
                return false;
            }
            
            if (pp.getNgaytra().isAfter(now) || pp.getNgaytra().isBefore(phieumuon.getNgayMuon())) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Ngày trả không đúng.");
                return false;
            }
            

            if (!phieuMuon_BUS.isExsit(pp.getMaPM())) {
                 Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Mã phiếu mượn không tồn tại.");
                return false;
            }
            
            if (pp.getLyDo().equals("")) {
                 Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Lý do không được để trống.");
                return false;
            }
            
            if (pp.getSoTien() <= 0) {
                 Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Số tiền không đúng.");
                return false;
            }
            
            
            PhieuPhatDAO.getInstance().insert(pp);
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 
                    "Thêm phiếu phạt thành công.");
            return true;
            
         
        }
        return false;
        
    }
     
   public boolean CompareTo(PhieuPhat pp, PhieuPhat curent){
        if (pp.getMaPM()== curent.getMaPM()&&
            pp.getMaPP()== curent.getMaPP()&&
            pp.getSoTien()== curent.getSoTien()&&
            pp.getLyDo().equals(curent.getLyDo()) &&
            pp.getNgaytra().isEqual(curent.getNgaytra())
                ){
            return true;
        }
        return false;
    }
        
    public boolean SuaPhieuPhat(PhieuPhat pp, PhieuPhat current){

        LocalDate now = LocalDate.now();
        phieuMuon_BUS = new PhieuMuon_BUS();
        phieumuon = PhieuMuonDAO.getInstance().selectByID(pp.getMaPM());
        
        if (pp != null && current != null) {
            if (!CompareTo(pp, current)) {


                if (pp.getNgaytra().isAfter(now) || pp.getNgaytra().isBefore(phieumuon.getNgayMuon())) {
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                        "Ngày trả không đúng.");
                    return false;
                }


                if (!phieuMuon_BUS.isExsit(pp.getMaPM())) {
                     Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                        "Mã phiếu mượn không tồn tại.");
                    return false;
                }

                if (pp.getLyDo().equals("")) {
                     Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                        "Lý do không được để trống.");
                    return false;
                }

                if (pp.getSoTien() <= 0) {
                     Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                        "Số tiền không đúng.");
                    return false;
                }


                PhieuPhatDAO.getInstance().update(pp);
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
    
          
    public void RenderPhieuPhat(Table table){
        
        for(PhieuPhat s : PP_ArrayList){
               int mapp = s.getMaPP();
               int mapm =s.getMaPM();
               int sotien = s.getSoTien();
               String lydo = s.getLyDo();
               String date = FormatDate(s.getNgaytra());
            table.addRow(new Object[] {mapp, mapm, date, lydo, sotien});
            
        }
    }  
      
}
