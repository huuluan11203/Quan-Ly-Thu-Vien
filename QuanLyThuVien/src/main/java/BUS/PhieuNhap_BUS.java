
package BUS;


import DAO.PhieuNhapDAO;
import DTO.PhieuNhap;
import GUI.UIComponents.Table.Table;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import raven.toast.Notifications;


public class PhieuNhap_BUS {
    
    private static NhanVien_BUS nhanvien;
    private static NhaCungCap_BUS ncc;
    
    
    private static ArrayList<PhieuNhap> phieunhap;
    
    public PhieuNhap_BUS() {
        phieunhap = PhieuNhapDAO.getInstance().selectAll();
        
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
    
    
    public void RenderPhieuNhap(Table table){
         for(PhieuNhap pn : phieunhap){
            
            int mapn = pn.getMaPhieuNhap();
            int manv = pn.getMaNV();
            int mancc = pn.getMaNCC();
            String date = FormatDate(pn.getNgayNhap());
           
            
            table.addRow(new Object[] {mapn, mancc, manv, date});
            
        }
    }
    
    public PhieuNhap SelectedPhieuNhap(int mapn){
        PhieuNhap pn = PhieuNhapDAO.getInstance().selectByID(mapn);
        return pn;
    }
    
    
    public boolean XoaPhieuNhap(PhieuNhap pn){
        if (pn != null) {
            PhieuNhapDAO.getInstance().delete(pn);
            return true;
        }
        return false;
        
    }
    
    public boolean CompareTo(PhieuNhap pn, PhieuNhap curent){
        if (pn.getMaNV() == curent.getMaNV() &&
            pn.getMaNCC() == curent.getMaNCC() &&
            pn.getMaPhieuNhap() == curent.getMaPhieuNhap() &&
            pn.getNgayNhap().equals(curent.getNgayNhap())){
            return true;
        }
        return false;
    }
      
    
    public boolean isExsit(int ma){
        PhieuNhap pn = PhieuNhapDAO.getInstance().selectByID(ma);
        if (pn != null) {
            return true;
        }
        return false;
    }
    
    public boolean ThemPhieuNhap(PhieuNhap pn){
        
        ncc = new NhaCungCap_BUS();
        nhanvien = new NhanVien_BUS();
        
        LocalDate now = LocalDate.now();
        
        
        if (pn != null) {
            if (!nhanvien.isExsit(pn.getMaNV())) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Nhân viên không tồn tại.");
                return false;
            }
            
            if (isExsit(pn.getMaPhieuNhap())) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Phiếu nhập đã tồn tại.");
                return false;
            }
            
            if (pn.getNgayNhap().isAfter(now)) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Ngày nhập không đúng.");
                return false;
            }
            
            if (!ncc.isExsit(pn.getMaNCC())) {
                 Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Nhà cung cấp không tồn tại.");
                return false;
            }
            
            PhieuNhapDAO.getInstance().insert(pn);
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 
                    "Thêm phiếu nhập thành công.");
            return true;
            
         
        }
        return false;
    }
    
    public boolean SuaPhieuNhap(PhieuNhap pn, PhieuNhap current){
        ncc = new NhaCungCap_BUS();
        nhanvien = new NhanVien_BUS();
        LocalDate now = LocalDate.now();
        if (pn != null && current != null) {
            if (!CompareTo(pn, current)) {
                if (pn.getNgayNhap().isAfter(now)) {
                     Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Ngày nhập Không đúng");
                    return false;
                }
                
                if (!nhanvien.isExsit(pn.getMaNV())) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Nhân viên không tồn tại");
                    return false;
                }
                
                if (!ncc.isExsit(pn.getMaNCC())) {
                 Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Nhà cung cấp không tồn tại");
                    return false;
                }

                PhieuNhapDAO.getInstance().update(pn);
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
    
    public int getNewID(){
        return PhieuNhapDAO.getInstance().getMaxID()+1;
    }
    
}
