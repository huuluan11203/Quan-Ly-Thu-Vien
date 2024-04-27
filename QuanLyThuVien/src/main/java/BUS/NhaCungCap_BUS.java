
package BUS;

import DAO.NhaCungCapDAO;
import DTO.NhaCungCap;
import GUI.UIComponents.Table.Table;
import java.util.ArrayList;
import raven.toast.Notifications;


public class NhaCungCap_BUS {
    
    private static ArrayList<NhaCungCap> NCC;

    public NhaCungCap_BUS() {
        NCC = NhaCungCapDAO.getInsttance().selectAll();
    }
    
    public String getTenNCC(int ma){
        NhaCungCap ncc = NhaCungCapDAO.getInsttance().selectByID(ma);
        if (ncc != null) {
            return ncc.getTenNCC();
        }
        return "ERR";
    }
    
    public boolean isExsit(int ma){
        NhaCungCap ncc = NhaCungCapDAO.getInsttance().selectByID(ma);
        if (ncc != null) {
            return true;
        }
        return false;
    }
    
    public void RenderNCC(Table table){
         for(NhaCungCap ncc : NCC){
            
            int mancc = ncc.getMaNCC();
            String tenncc = ncc.getTenNCC();
            table.addRow(new Object[] {mancc, tenncc});
            
        }
    }
    
    public NhaCungCap SelectedNCC(int ma){
        NhaCungCap ncc = NhaCungCapDAO.getInsttance().selectByID(ma);
        return ncc;
    }
    
    public boolean XoaNCC(NhaCungCap ncc){
  
        NhaCungCapDAO.getInsttance().delete(ncc);
        Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 
                    "Xóa nhà cung cấp thành công.");
        return true;
    }
    
    public boolean ThemNCC(NhaCungCap ncc){
        
        if (isExsit(ncc.getMaNCC())) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
            "Nhà cung cấp đã tồn tại.");
            return false;
        }
        NhaCungCapDAO.getInsttance().insert(ncc);
        Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 
            "Thêm nhà cung cấp thành công.");
        return true;
    }
    
    public boolean CompareTo(NhaCungCap ncc, NhaCungCap curent){
        if (ncc.getMaNCC() == curent.getMaNCC() &&
            ncc.getTenNCC().equals(curent.getTenNCC())
                ){
            return true;
        }
        return false;
    }
      
    
    public boolean SuaNCC(NhaCungCap ncc, NhaCungCap current){
        if (ncc != null) {
            if (CompareTo(ncc, current)) {
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 
                    "Lưu thành công.");
                return true;
            }else{               
                NhaCungCapDAO.getInsttance().update(ncc);
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 
                    "Lưu thành công.");
                return true;
            }
        }
        return false;
    }
    
}
