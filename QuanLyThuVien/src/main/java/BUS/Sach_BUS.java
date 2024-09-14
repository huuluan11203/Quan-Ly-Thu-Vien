
package BUS;

import DAO.NhaXuatBanDAO;
import java.util.ArrayList;
import DTO.Sach;
import DTO.NhaXuatBan;
import DAO.SachDAO;

import GUI.UIComponents.Table.Table;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Sach_BUS {
    
    private static ArrayList<Sach> sach = new ArrayList<Sach>();
    
    public Sach_BUS() {
        sach = SachDAO.getInstance().selectAll();
    }
    
    
    public ArrayList<Sach> getSach(){
        return sach;
    }

    public static void setSach(ArrayList<Sach> sach) {
        Sach_BUS.sach = sach;
    }
    
    
        
    public String getTenNXB(int maNxb){
        NhaXuatBan nxb = NhaXuatBanDAO.getInstance().selectByID(maNxb);
        if (nxb != null) {
            return nxb.getTenNXB();
        }
        return "ERR";
    }
     
    public String getTenSach(int ma){
        Sach s = SachDAO.getInstance().selectByID(ma);
        if (s != null) {
            return s.getTenSach();
        }
        return "ERR";
    }

    
    public Sach SelectedSach(int masach){
        Sach s = SachDAO.getInstance().selectByID(masach);
        return s;
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
    
    public boolean isExsit(int ma){
        Sach s = SachDAO.getInstance().selectByID(ma);
        if (s != null) {
            return true;
        }
        return false;
    }
    
    public ArrayList<Sach> getSachWithPaginate(int page, int items){
        ArrayList<Sach> ds = SachDAO.getInstance().selectWithPaginate(page, items);
        for (Sach d : ds) {
            sach.add(d);
        }
        return SachDAO.getInstance().selectWithPaginate(page, items);
    }
    
    public void RenderSach(Table table){
        
        for(Sach s : sach){
            
            int masach = s.getMaSach();
            String tensach = s.getTenSach();
            String tacgia = new TacGia_BUS().getTTG(s.getMaTacGia());
            String NXB = getTenNXB(s.getMaNXB());
            String namXB = FormatDate(s.getNamXuatBan());
            int sl = s.getSoLuong();
            table.addRow(new Object[] {masach, tensach, NXB, namXB, tacgia, sl});
            
        }
    }

    public boolean ThemSach(Sach s){
        
        if (s != null) {
           Sach sach = SachDAO.getInstance().selectByID(s);
            if (sach == null) {
                SachDAO.getInstance().insert(s);
                return true;
            }
        }
        return false;
    }
    
    
    public boolean XoaSach(Sach s){
        if (s != null) {
            SachDAO.getInstance().delete(s);
            return true;
        }
        return false;
    }
    
    public boolean CompareTo(Sach s, Sach current){
        if (
            s.getTenSach().equals(current.getTenSach()) &&
            s.getMaLoaiSach() == current.getMaLoaiSach() &&
            s.getGhiChu().equals(current.getGhiChu()) &&
            s.getImgSach().equals(current.getImgSach()) &&
            s.getMaNXB() == current.getMaNXB() &&
            s.getMaSach() == current.getMaSach() &&
            s.getMaTacGia() == current.getMaTacGia() &&
            s.getNamXuatBan() == current.getNamXuatBan() &&
            s.getSoLuong() == current.getSoLuong()
            ) {
           
            return true;
        }else{
            return false;
        }
    }
    
    public boolean SuaSach(Sach s, Sach curent){
        if (s != null && curent != null){
            if (CompareTo(s, curent)) {
                return true;
            }else{
                SachDAO.getInstance().update(s);
                return true;
            }
        }
        return false;
    }
    
    
    public int getNewID() {
        return SachDAO.getInstance().getMaxIDBook()+1;
    }

}
