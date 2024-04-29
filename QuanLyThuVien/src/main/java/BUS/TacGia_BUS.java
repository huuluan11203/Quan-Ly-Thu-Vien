
package BUS;


import DTO.TacGia;
import java.util.ArrayList;
import DAO.TacGiaDAO;
import GUI.UIComponents.Combobox;
import GUI.UIComponents.Table.Table;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import raven.toast.Notifications;


public class TacGia_BUS {

    
    private static ArrayList<TacGia> tacgia_ArrayList;

    public TacGia_BUS() {
        tacgia_ArrayList = TacGiaDAO.getInstance().selectAll();
    }

    public ArrayList<TacGia> getTacgia() {
        return tacgia_ArrayList;
    }
    
    public void ChonTG(Combobox cb){
        for (TacGia tg : tacgia_ArrayList){
            cb.addItem(tg);
        }
    }
    
    public String getTTG(int matacgia){
        TacGia tg = TacGiaDAO.getInstance().selectByID(matacgia);
        if (tg != null) {
            return tg.getTenTacGia();
        }
        return "ERR";
    }
    
    public int getMatacgia(String tentg){
        
        TacGia tg = TacGiaDAO.getInstance().selectByID(tentg);
        if (tg != null) {
            return tg.getMaTacGia();
        }
        return -1;
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
     
    public void RenderTacGia(Table table){
        for (TacGia tg : tacgia_ArrayList){
             int matacgia = tg.getMaTacGia();
             String tentacgia = tg.getTenTacGia();
             String namsinh = FormatDate(tg.getNamSinh());
             String diachi = tg.getDiachi();
             String gioithieu = tg.getGioiThieu();
             table.addRow(new Object[]{matacgia, tentacgia, namsinh, diachi, gioithieu});
        }
    }
    
    public TacGia SelectedTacGia(int matacgia){
        TacGia tg = TacGiaDAO.getInstance().selectByID(matacgia);
        return tg;
    }
    
    public boolean isExsit(int ma){
        TacGia tg = TacGiaDAO.getInstance().selectByID(ma);
        if (tg != null) {
            return  true;
        }
        return false;
    }
    
    public boolean XoaTacGia(TacGia tg){
        if (tg != null) {
            
            TacGiaDAO.getInstance().delete(tg);
             Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 
                    "Xóa tác giả thành công.");
            return true;
        }
        return false;
    }
    
    public boolean ThemTacGia(TacGia tg){
        LocalDate now = LocalDate.now();
        
        if (tg != null) {
            if (isExsit(tg.getMaTacGia())) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Tác giả đã tồn tại.");
                return false;
            }
            
            if (tg.getNamSinh().isAfter(now)) {
                 Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Ngày sinh không đúng.");
                return false;
            }
            
            if (tg.getTenTacGia().equals("")) {
                 Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                "Tên không được để trống.");
                 return  false;
            }
            
            TacGiaDAO.getInstance().insert(tg);
             Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 
                    "Thêm tác giả thành công.");
                return true;
        }
        return false;
    }
    
    public boolean CompareTo(TacGia tg, TacGia current){
        if (tg.getMaTacGia() == current.getMaTacGia() && 
            tg.getDiachi().equals(current.getDiachi()) &&
            tg.getGioiThieu().equals(current.getGioiThieu()) &&
            tg.getHinhanh().equals(current.getHinhanh()) &&
            tg.getNamSinh().equals(current.getNamSinh()) &&
            tg.getTenTacGia().equals(current.getTenTacGia())
            ){
            return true;
        }
        return false;
    }
    
    public boolean SuaTacGia(TacGia tg, TacGia current){
        LocalDate now = LocalDate.now();
        if (tg != null && current != null) {
            if (CompareTo(tg, current)) {
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 
                    "Lưu thành công.");
                return true;
            }else{
                
                if (tg.getNamSinh().isAfter(now)) {
                     Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Năm sinh không đúng.");
                     return  false;
                }
                
                if (tg.getTenTacGia().equals("")) {
                     Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Tên không được để trống.");
                     return  false;
                }
                
                TacGiaDAO.getInstance().update(tg);
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 
                    "Lưu thành công.");
                return true;
                
            }
        }
        return false;
    }
    
    
}
