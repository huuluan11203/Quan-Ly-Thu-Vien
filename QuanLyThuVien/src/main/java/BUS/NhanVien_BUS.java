
package BUS;

import DAO.NhanvienDAO;
import DTO.NhanVien;
import java.util.ArrayList;

public class NhanVien_BUS {
    private static ArrayList<NhanVien> nhanvien;

    public NhanVien_BUS() {
        nhanvien = NhanvienDAO.getInstance().selectAll();
    }
    
    public String getTenNV(int ma){
        NhanVien nv = NhanvienDAO.getInstance().selectByID(ma);
        if (nv != null) {
            return nv.getTenNV();
        }
        return "ERR";
    }
    
    public boolean isExsit(int ma){
        NhanVien nv = NhanvienDAO.getInstance().selectByID(ma);
        if (nv != null) {
            return true;
        }
        return false;
    }
}
