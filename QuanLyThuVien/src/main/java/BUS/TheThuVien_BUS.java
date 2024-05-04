
package BUS;

import DAO.TheThuVienDAO;
import DTO.TheThuVien;
import DTO.TheThuVien;
import GUI.UIComponents.Table.Table;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import raven.toast.Notifications;


public class TheThuVien_BUS {
    private ArrayList<TheThuVien> TTV_ArrayList;

    public TheThuVien_BUS() {
        TTV_ArrayList = TheThuVienDAO.getInstance().selectAll();
    }
    
    public boolean isExsit(int ma){
        TheThuVien ttv = TheThuVienDAO.getInstance().selectByID(ma);
        if (ttv != null) {
            return true;
        }
        return false;
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
    

    public void RenderTheThuVien(Table table){
        
        
        for(TheThuVien s : TTV_ArrayList){
            
            int mathe = s.getMaThe();
            String ngaybd = FormatDate(s.getNgayBatDau());
            String ngaykt = FormatDate(s.getNgayKetthuc());

            table.addRow(new Object[] {mathe, ngaybd, ngaykt});
            
        }
    }
    
    public TheThuVien SelectedTheThuVien(int ma){
        TheThuVien pm = TheThuVienDAO.getInstance().selectByID(ma);
        return pm;
    } 
     
    public boolean CompareTo(TheThuVien ttv, TheThuVien curent){
        if (
            ttv.getMaThe()== curent.getMaThe() &&
            ttv.getNgayBatDau().isEqual(curent.getNgayBatDau()) &&
            ttv.getNgayKetthuc().isEqual(curent.getNgayKetthuc()) 
         ){
            return true;
        }
        return false;
    }
    
    public boolean XoaTheThuVien(TheThuVien ttv){
        if (ttv != null) {
            TheThuVienDAO.getInstance().delete(ttv);
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 
                    "Xóa thẻ thành công.");
            return true;
        }
        return false;
        
    }
    
    public boolean ThemTheThuVien(TheThuVien ttv){

        LocalDate now = LocalDate.now();

        if (ttv != null) {
            if (isExsit(ttv.getMaThe())) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Thẻ đã tồn tại.");
                return false;
            }
            
            if (ttv.getNgayBatDau().isAfter(now)) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Ngày bắt đầu không đúng.");
                return false;
            }
            if (ttv.getNgayKetthuc().isBefore(now)) {
                 Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Ngày kết thúc không đúng.");
                return false;
            }
            
            TheThuVienDAO.getInstance().insert(ttv);
             Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 
                    "Thêm thẻ thành công.");
            return true;
            
        }
        return false;
    }    
    
    public boolean SuaTheThuVien(TheThuVien ttv, TheThuVien current){

        LocalDate now = LocalDate.now();
        
        if (ttv != null && current != null) {
            if (!CompareTo(ttv, current)) {
                if (ttv.getNgayBatDau().isAfter(now)) {
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                        "Ngày bắt đầu không đúng.");
                    return false;
                }
                if (ttv.getNgayKetthuc().isBefore(now)) {
                     Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                        "Ngày kết thúc không đúng.");
                    return false;
                }
                
                TheThuVienDAO.getInstance().update(ttv);
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
