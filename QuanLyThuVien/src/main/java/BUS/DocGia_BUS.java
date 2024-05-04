
package BUS;

import DAO.DocGiaDAO;
import DTO.DocGia;
import java.util.ArrayList;


public class DocGia_BUS {
    private static ArrayList<DocGia> DG_ArrayList;

    public DocGia_BUS() {
        DG_ArrayList = DocGiaDAO.getInstance().selectAll();
    }
    
    public boolean isExsit(int ma){
        DocGia pn = DocGiaDAO.getInstance().selectByID(ma);
        if (pn != null) {
            return true;
        }
        return false;
    }
}
  