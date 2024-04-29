
package BUS;

import DAO.LoaiSachDAO;
import DTO.LoaiSach;
import GUI.UIComponents.Combobox;
import GUI.UIComponents.Table.Table;
import java.util.ArrayList;
import raven.toast.Notifications;


public class LoaiSach_BUS {
    
    private static ArrayList<LoaiSach> LS_ArrayList;

    public LoaiSach_BUS() {
        LS_ArrayList = LoaiSachDAO.getInstance().selectAll();
    }
    
    
     public void ChonLoaiSach(Combobox cb){
        for (LoaiSach ls : LS_ArrayList){
            cb.addItem(ls);
        }
    }
    
    public int getMaloaiSach(String tenloaisach){
        for (LoaiSach ls : LS_ArrayList){
            if (tenloaisach.equals(ls.getTenLoaiSach())) {
                return ls.getMaLoaiSach();
            }
        }
        return -1;
    }
    
    public String getTenLoaiSach(int maloai){
        for (LoaiSach ls : LS_ArrayList){
            if (maloai == ls.getMaLoaiSach()) {
                return ls.getTenLoaiSach();
            }
        }
        return "ERR";
    }
     
    public LoaiSach SelectedLoaiSach(int ma){
        LoaiSach ls = LoaiSachDAO.getInstance().selectByID(ma);
        return ls;
    }
    
    public boolean isExsit(int ma){
        LoaiSach ls = LoaiSachDAO.getInstance().selectByID(ma);
        if (ls != null) {
            return true;
        }
        return false;
    }
    
    public void RenderLoaiSach(Table table){
        for (LoaiSach ls : LS_ArrayList){
            int mals = ls.getMaLoaiSach();
            String ten = ls.getTenLoaiSach();
            
            table.addRow(new Object[]{mals, ten});
        }
    }
    
    public boolean ThemLoaiSach(LoaiSach ls){
        if (ls != null) {
            if (isExsit(ls.getMaLoaiSach())) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
                "Thể loại đã tồn tại.");
                return false;
            }
            
            if (ls.getTenLoaiSach().equals("")) {
                 Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
                "Tên không được để trống.");
                return false;
            }
            
            LoaiSachDAO.getInstance().insert(ls);
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT,
                "Thêm thể loại thành công.");
            return true;
        }
        return false;
    }
    
    public boolean CompareTo(LoaiSach ls, LoaiSach current){
        if (ls.getMaLoaiSach() == current.getMaLoaiSach() && 
            ls.getTenLoaiSach().equals(current.getTenLoaiSach())){
            return true;
        }
        return false;
    }
    
    public boolean SuaLoaiSach(LoaiSach ls, LoaiSach current){
        if (ls != null) {
            if (CompareTo(ls, current)) {
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT,
                "Lưu thành công.");
                return true; 
            }else{
                if (ls.getTenLoaiSach().equals("")) {
                     Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
                    "Tên không được để trống.");
                    return false;
                }
                
                LoaiSachDAO.getInstance().update(ls);
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT,
                "Lưu thành công.");
                return true;
                
            }
        }
        return false;
    }
    
    public boolean XoaLoaiSach(LoaiSach ls){
        if (ls != null) {
            LoaiSachDAO.getInstance().delete(ls);
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT,
                "Xóa thể loại thành công.");
            return true;
            
        }
        return false;
    }
}
