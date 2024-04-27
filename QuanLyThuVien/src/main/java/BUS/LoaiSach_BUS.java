
package BUS;

import DAO.LoaiSachDAO;
import DTO.LoaiSach;
import GUI.UIComponents.Combobox;
import java.util.ArrayList;


public class LoaiSach_BUS {
    
    private static ArrayList<LoaiSach> LS_ArrayList;

    public LoaiSach_BUS() {
        LS_ArrayList = LoaiSachDAO.getInstance().selectAll();
    }
    
    public ArrayList<LoaiSach> getLoaisach(){
        return LS_ArrayList;
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
     
}
