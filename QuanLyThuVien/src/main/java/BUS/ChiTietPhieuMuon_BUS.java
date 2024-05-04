
package BUS;

import DAO.ChiTietPhieuMuonDAO;
import DTO.ChiTietPhieuMuon;
import java.util.ArrayList;


public class ChiTietPhieuMuon_BUS {
    private ArrayList<ChiTietPhieuMuon> CTPM;

    public ChiTietPhieuMuon_BUS() {
        CTPM = ChiTietPhieuMuonDAO.getInstance().selectAll();
    }
    
    public ChiTietPhieuMuon SelectedCTPM(int ma){
        ChiTietPhieuMuon ctpm = ChiTietPhieuMuonDAO.getInstance().selectByID(ma);
        return ctpm;
    }
           
}
