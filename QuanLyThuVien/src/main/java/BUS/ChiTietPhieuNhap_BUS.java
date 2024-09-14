
package BUS;

import DAO.ChiTietPhieuNhapDAO;
import DTO.ChiTietPhieuNhap;
import GUI.UIComponents.Table.Table;
import java.util.ArrayList;
import raven.toast.Notifications;


public class ChiTietPhieuNhap_BUS {
    private ArrayList<ChiTietPhieuNhap> ctpn_ArrayList;
    
    private static PhieuNhap_BUS phieuNhap_BUS; 
    private static Sach_BUS sach_BUS;

    public ChiTietPhieuNhap_BUS() {
        ctpn_ArrayList = ChiTietPhieuNhapDAO.getInstance().selectAll();
    }
    
    
    public boolean XoaCTPN(ChiTietPhieuNhap ctpn){
        if (ctpn != null) {
            ChiTietPhieuNhapDAO.getInstance().delete(ctpn);
            return true;
        }
        return false;
    }
    
    public void RenderCTPN(Table table){
        for (ChiTietPhieuNhap ct : ctpn_ArrayList){
            int mactpn = ct.getMaCTPN();
            int mapn = ct.getMaPhieuNhap();
            int soluong = ct.getSoLuong();
            int ms = ct.getMaSach();
            int gia = ct.getGia();
            
            table.addRow(new Object[] {mactpn, mapn, ms, gia, soluong});
        }
    }
    
    
    public boolean isExsit(int ma){
         ChiTietPhieuNhap ctpn = ChiTietPhieuNhapDAO.getInstance().selectByID(ma);
         if (ctpn != null) {
            return true;
        }
        return false;
    }
    
    public ChiTietPhieuNhap SelectedCTPN(int ma){
        ChiTietPhieuNhap ctpn = ChiTietPhieuNhapDAO.getInstance().selectByID(ma);
        return ctpn;
    }
    
    public boolean ThemCTPN(ChiTietPhieuNhap ctpn){
        
        phieuNhap_BUS = new PhieuNhap_BUS();
        sach_BUS = new Sach_BUS();
        
        if (ctpn != null) {
          
            if (isExsit(ctpn.getMaCTPN()) || !phieuNhap_BUS.isExsit(ctpn.getMaPhieuNhap())) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Chi tiết phiếu nhập đã tồn tại.");
                return false;
            }
            
            if (ctpn.getGia() <= 0 || ctpn.getSoLuong() <= 0) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Dữ liệu không đúng định dạng.");
                return false;
            }
            
            if (!sach_BUS.isExsit(ctpn.getMaSach())) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Sách không tồn tại.");
                return false;
            }
            
            ChiTietPhieuNhapDAO.getInstance().insert(ctpn);
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 
                    "Thêm phiếu chi tiết phiếu nhập thành công.");
            return true;
        }
        return false;
    }
    
    public boolean CompareTo(ChiTietPhieuNhap ctpn, ChiTietPhieuNhap current){
        if (
            ctpn.getMaCTPN() == current.getMaCTPN() &&
            ctpn.getMaPhieuNhap()== current.getMaPhieuNhap()&&
            ctpn.getGia()== current.getGia()&&
            ctpn.getMaSach()== current.getMaSach()&&
            ctpn.getSoLuong()== current.getSoLuong()
            ) {
           
            return true;
        }else{
            return false;
        }
    }
       
    public boolean SuaCTPN(ChiTietPhieuNhap ctpn, ChiTietPhieuNhap curent){
        
        phieuNhap_BUS = new PhieuNhap_BUS();
        sach_BUS = new Sach_BUS();
        
        if (ctpn != null && curent != null){
            if (CompareTo(ctpn, curent)) {
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 
                        "Lưu thành công.");
                return true;
            }else{
                if (phieuNhap_BUS.isExsit(ctpn.getMaPhieuNhap())) {
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Chi tiết phiếu nhập đã tồn tại.");
                return false;
                }
                
                if (ctpn.getGia() <= 0 || ctpn.getSoLuong() <= 0) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Dữ liệu không đúng định dạng.");
                return false;
                }
            
                if (!sach_BUS.isExsit(ctpn.getMaSach())) {
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                        "Sách không tồn tại.");
                    return false;
                }

                ChiTietPhieuNhapDAO.getInstance().update(ctpn);
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 
                        "Lưu thành công.");
                return true;
            }
        }
        return false;
    }
    
    
    public int getNewID(){
        return ChiTietPhieuNhapDAO.getInstance().getMaxID_CTPN()+1;
    }
     
}
