
package BUS;

import DAO.DocGiaDAO;
import DTO.DocGia;
import GUI.UIComponents.Table.Table;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import raven.toast.Notifications;


public class DocGia_BUS {
    private static ArrayList<DocGia> DG_ArrayList;
    private static TheThuVien_BUS theThuVien_BUS;
    private static DocGia docgia;

    public DocGia_BUS() {
        DG_ArrayList = DocGiaDAO.getInstance().selectAll();
    }
    
    public boolean isExsit(int ma){
        DocGia dg = DocGiaDAO.getInstance().selectByID(ma);
        if (dg != null) {
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
    
    
    public void RenderDocGia(Table table){
        
        
        for(DocGia s : DG_ArrayList){
            
            int madg = s.getMaDocGia();
            String tendg = s.getTenDocGia();
            String namsinh = FormatDate(s.getNamSinh());
            String gt = s.getGioiTinh();
            int mathe = s.getMaThe();


            table.addRow(new Object[] {madg, tendg, namsinh, gt, mathe});
            
        }
    }
     
    public DocGia SelectedDocGia(int ma){
        DocGia pm = DocGiaDAO.getInstance().selectByID(ma);
        return pm;
    } 
     
    public boolean CompareTo(DocGia dg, DocGia curent){
        if (dg.getMaDocGia()== curent.getMaDocGia()&&
            dg.getMaThe()== curent.getMaThe()&&
            dg.getGioiTinh().equals(curent.getGioiTinh())&&
            dg.getHinhanh().equals(curent.getHinhanh()) &&
            dg.getNamSinh().isEqual(curent.getNamSinh()) &&   
            dg.getSdt().equals(curent.getSdt())&&  
            dg.getTenDocGia().equals(curent.getTenDocGia())
         ){
            return true;
        }
        return false;
    }
    
    public boolean XoaDocGia(DocGia dg){
        if (dg != null) {
            DocGiaDAO.getInstance().delete(dg);
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 
                    "Xóa độc giả thành công.");
            return true;
        }
        return false;
        
    }
    
    public boolean ThemDocGia(DocGia dg){
        theThuVien_BUS = new TheThuVien_BUS();
        LocalDate now = LocalDate.now();

        if (dg != null) {
            if (dg.getGioiTinh().equals("")) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Giới tính không được để trống.");
                return false;
            }
            
            if (dg.getTenDocGia().equals("")) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Tên không được để trống.");
                return false;
            }
            
            if (!theThuVien_BUS.isExsit(dg.getMaThe())) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Thẻ viện không tồn tại.");
                return false;
            }
            
            if (dg.getSdt().equals("")) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Số điện thoại không được để trống.");
                return false;
            }else{
                String regex = "^(0|84)(2(0[3-9]|1[0-6|8|9]|2[0-2|5-9]|3[2-9]|4[0-9]|5[1|2|4-9]|6[0-3|9]|7[0-7]|8[0-9]|9[0-4|6|7|9])|3[2-9]|5[5|6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])([0-9]{7})$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(dg.getSdt());
                if (!matcher.matches()) {
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
                    "Số điện thoại không đúng.");
                    return false;
                }
            }
            
            if (dg.getNamSinh().isAfter(now)) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Ngày sinh không đúng.");
                return false;
            }
            
            if (isExsit(dg.getMaDocGia())) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Độc giả đã tồn tại.");
                return false;
            }
            
            
            
            if (DocGiaDAO.getInstance().insert(dg) == -1) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Thẻ thư viện đã được sử dụng cho độc giả khác.");
                return false;
            }
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 
                    "Thêm độc giả thành công.");
            return true;
            
         
        }
        return false;
        
    }    
    
    
    public boolean SuaDocGia(DocGia dg, DocGia current){

        LocalDate now = LocalDate.now();
        theThuVien_BUS = new TheThuVien_BUS();
        
        if (dg != null && current != null) {
                if (!CompareTo(dg, current)) {
                    if (dg.getGioiTinh().equals("")) {
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                        "Giới tính không được để trống.");
                    return false;
                }

                if (dg.getTenDocGia().equals("")) {
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                        "Tên không được để trống.");
                    return false;
                }

                if (!theThuVien_BUS.isExsit(dg.getMaThe())) {
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                        "Thẻ viện không tồn tại.");
                    return false;
                }

                if (dg.getSdt().equals("")) {
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                        "Số điện thoại không được để trống.");
                    return false;
                }else{
                    String regex = "^(0|84)(2(0[3-9]|1[0-6|8|9]|2[0-2|5-9]|3[2-9]|4[0-9]|5[1|2|4-9]|6[0-3|9]|7[0-7]|8[0-9]|9[0-4|6|7|9])|3[2-9]|5[5|6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])([0-9]{7})$";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(dg.getSdt());
                    if (!matcher.matches()) {
                        Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
                        "Số điện thoại không đúng.");
                        return false;
                    }
                }

                if (dg.getNamSinh().isAfter(now)) {
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                        "Ngày sinh không đúng.");
                    return false;
                }             

                if (DocGiaDAO.getInstance().update(dg) == -1) {
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                        "Thẻ thư viện đã được sử dụng.");
                    return false;
                }
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
     
     
    public DocGia getDocGia(int mathe){
        DocGia dg = null;
        
        for(DocGia d : DG_ArrayList){
            if (d.getMaThe() == mathe) {
                dg = SelectedDocGia(d.getMaDocGia());
            }
        }
        return dg;
    }
    
   
            
}
  