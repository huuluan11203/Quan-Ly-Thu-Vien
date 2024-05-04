
package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVien;
import GUI.UIComponents.Table.Table;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import raven.toast.Notifications;

public class NhanVien_BUS {
    private static ArrayList<NhanVien> NV_ArrayList;

    public NhanVien_BUS() {
        NV_ArrayList = NhanVienDAO.getInstance().selectAll();
    }
    
    public String getTenNV(int ma){
        NhanVien nv = NhanVienDAO.getInstance().selectByID(ma);
        if (nv != null) {
            return nv.getTenNV();
        }
        return "ERR";
    }
    
    public boolean isExsit(int ma){
        NhanVien nv = NhanVienDAO.getInstance().selectByID(ma);
        if (nv != null) {
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
    
     public NhanVien SelectedNhanVien(int ma){
        NhanVien pm = NhanVienDAO.getInstance().selectByID(ma);
        return pm;
    }
    
    public void RenderNhanVien(Table table){
        
        
        for(NhanVien s : NV_ArrayList){
            
            int manv = s.getMaNV();
            String tennv = s.getTenNV();
            String namsinh = FormatDate(s.getNamsinh());
            String gt = s.getGioiTinh();


            table.addRow(new Object[] {manv, tennv, namsinh, gt});
            
        }
    }
    
    public boolean CompareTo(NhanVien pn, NhanVien curent){
        if (pn.getMaNV() == curent.getMaNV() &&
            pn.getLuong()== curent.getLuong()&&
            pn.getDiaChi().equals(curent.getDiaChi())&&
            pn.getGioiTinh().equals(curent.getGioiTinh()) &&
            pn.getNamsinh().isEqual(curent.getNamsinh()) &&
            pn.getNgayBatDau().isEqual(curent.getNgayBatDau()) &&    
            pn.getHinhAnh().equals(curent.getHinhAnh())&&  
            pn.getTenNV().equals(curent.getTenNV())&&
            pn.getSDT().equals(curent.getSDT())    ){
            return true;
        }
        return false;
    }
    
    public boolean XoaNhanVien(NhanVien pn){
        if (pn != null) {
            NhanVienDAO.getInstance().delete(pn);
             Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 
                    "Xóa nhân viên thành công.");
            return true;
        }
        return false;
        
    }
    
    public boolean ThemNhanVien(NhanVien pn){

        LocalDate now = LocalDate.now();

        if (pn != null) {
            if (pn.getDiaChi().equals("")) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Địa chỉ không được để trống.");
                return false;
            }
            
            if (pn.getTenNV().equals("")) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Tên không được để trống.");
                return false;
            }
            
            if (pn.getGioiTinh().equals("")) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Giới tính không được để trống.");
                return false;
            }
            
            if (pn.getLuong() <= 0) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Lương không đúng.");
                return false;
            }
            
            if (pn.getNamsinh().isAfter(now)) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Ngày sinh không đúng.");
                return false;
            }
            
             if (pn.getNgayBatDau().isAfter(now)) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Ngày bắt đầu không đúng.");
                return false;
            }
            
            if (isExsit(pn.getMaNV())) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Nhân viên đã tồn tại.");
                return false;
            }
            
            
            NhanVienDAO.getInstance().insert(pn);
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 
                    "Thêm nhân viên thành công.");
            return true;
            
         
        }
        return false;
        
    }    
    
    
    public boolean SuaNhanVien(NhanVien pn, NhanVien current){

        LocalDate now = LocalDate.now();
        
        if (pn != null && current != null) {
            if (!CompareTo(pn, current)) {
                if (pn.getDiaChi().equals("")) {
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                        "Địa chỉ không được để trống.");
                    return false;
                }

                if (pn.getTenNV().equals("")) {
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                        "Tên không được để trống.");
                    return false;
                }

                if (pn.getGioiTinh().equals("")) {
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                        "Giới tính không được để trống.");
                    return false;
                }

                if (pn.getLuong() <= 0) {
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                        "Lương không đúng.");
                    return false;
                }

                if (pn.getNamsinh().isAfter(now)) {
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                        "Ngày sinh không đúng.");
                    return false;
                }

                 if (pn.getNgayBatDau().isAfter(now)) {
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                        "Ngày bắt đầu không đúng.");
                    return false;
                }              

                NhanVienDAO.getInstance().update(pn);
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
