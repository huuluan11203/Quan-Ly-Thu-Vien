
package BUS;

import java.util.ArrayList;
import DTO.NhaXuatBan;
import DAO.NhaXuatBanDAO;
import GUI.UIComponents.*;
import GUI.UIComponents.Table.Table;
import java.util.regex.Pattern;
import raven.toast.Notifications;
import java.util.regex.Matcher;


public class NhaXuatBan_BUS {
    
    private static ArrayList<NhaXuatBan> nhaxuatban;

    public NhaXuatBan_BUS() {
        nhaxuatban = NhaXuatBanDAO.getInstance().selectAll();
    }

    public ArrayList<NhaXuatBan> getNhaxuatban() {
        return nhaxuatban;
    }
    
    public void ChonNXB(Combobox cb){
        for (NhaXuatBan nxb : nhaxuatban){
            cb.addItem(nxb);
        }
    }
    
    public int getManhaxuatban(String tennxb){
        for (NhaXuatBan nxb : nhaxuatban){
            if (tennxb.equals(nxb.getTenNXB())) {
                return nxb.getMaNXB();
            }
        }
        return -1;
    }
    
    public void RenderLoaiSach(Table table){
        for (NhaXuatBan nxb : nhaxuatban){
            int manxb = nxb.getMaNXB();
            String ten = nxb.getTenNXB();
            String dc = nxb.getDiaChi();
            String sdt = nxb.getSdt();

            table.addRow(new Object[]{manxb, ten, dc, sdt});
        }
    }
    
    public NhaXuatBan SelectedNXB(int ma){
        NhaXuatBan nxb = NhaXuatBanDAO.getInstance().selectByID(ma);
        return nxb;
    }
    
    public boolean isExsit(int ma){
        NhaXuatBan nxb = NhaXuatBanDAO.getInstance().selectByID(ma);
        if (nxb != null) {
            return true;
        }
        return false;
    }

    public boolean ThemNXB(NhaXuatBan nxb){
        if (nxb != null) {
            if (isExsit(nxb.getMaNXB())) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
                "Nhà xuất bản đã tồn tại.");
                return false;
            }
            
            if (nxb.getTenNXB().equals("")) {
                 Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
                "Tên không được để trống.");
                return false;
            }
            
            if (nxb.getDiaChi().equals("")) {
                 Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
                "Địa chỉ không được để trống.");
                return false;
            }
            
            if (nxb.getSdt().equals("")) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
                "Số điện thoại không được để trống.");
                return false;
            }else{
                String regex = "^(0|84)(2(0[3-9]|1[0-6|8|9]|2[0-2|5-9]|3[2-9]|4[0-9]|5[1|2|4-9]|6[0-3|9]|7[0-7]|8[0-9]|9[0-4|6|7|9])|3[2-9]|5[5|6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])([0-9]{7})$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(nxb.getSdt());
                if (!matcher.matches()) {
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
                    "Số điện thoại không đúng.");
                    return false;
                }
            }
            
            
            NhaXuatBanDAO.getInstance().insert(nxb);
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT,
                "Thêm nhà xuất bản thành công.");
            return true;
        }
        return false;
    }
    
     public boolean CompareTo(NhaXuatBan nxb, NhaXuatBan current){
        if (nxb.getMaNXB()== current.getMaNXB() && 
            nxb.getSdt().equals(current.getSdt()) &&
            nxb.getDiaChi().equals(current.getDiaChi()) &&
            nxb.getTenNXB().equals(current.getTenNXB()) 
                ){
            return true;
        }
        return false;
    }
    
    public boolean SuaNXB(NhaXuatBan nxb, NhaXuatBan current){
        if (nxb != null) {
            if (CompareTo(nxb, current)) {
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT,
                "Lưu thành công.");
                return true; 
            }else{
                if (nxb.getTenNXB().equals("")) {
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
                    "Tên không được để trống.");
                    return false;
                }
            
                if (nxb.getDiaChi().equals("")) {
                     Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
                    "Địa chỉ không được để trống.");
                    return false;
                }
                
                if (nxb.getSdt().equals("")) {
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
                    "Số điện thoại không được để trống.");
                    return false;
                }else{
                    String regex = "^(0|84)(2(0[3-9]|1[0-6|8|9]|2[0-2|5-9]|3[2-9]|4[0-9]|5[1|2|4-9]|6[0-3|9]|7[0-7]|8[0-9]|9[0-4|6|7|9])|3[2-9]|5[5|6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])([0-9]{7})$";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(nxb.getSdt());
                    if (!matcher.matches()) {
                        Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
                        "Số điện thoại không đúng.");
                        return false;
                    }
                }
                
                NhaXuatBanDAO.getInstance().update(nxb);
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT,
                "Lưu thành công.");
                return true;
                
            }
        }
        return false;
    }
    
    public boolean XoaNXB(NhaXuatBan nxb){
        if (nxb != null) {
            NhaXuatBanDAO.getInstance().delete(nxb);
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT,
                "Xóa nhà xuất bản thành công.");
            return true;
            
        }
        return false;
    }
    
}
