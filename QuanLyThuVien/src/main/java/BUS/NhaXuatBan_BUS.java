
package BUS;

import java.util.ArrayList;
import DTO.NhaXuatBan;
import DAO.NhaXuatBanDAO;
import GUI.UIComponents.*;


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
    
}
