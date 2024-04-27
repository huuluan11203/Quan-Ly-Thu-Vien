
package BUS;


import DTO.TacGia;
import java.util.ArrayList;
import DAO.TacGiaDAO;
import GUI.UIComponents.Combobox;
import GUI.UIComponents.Table.Table;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class TacGia_BUS {

    
    private static ArrayList<TacGia> tacgia_ArrayList;

    public TacGia_BUS() {
        tacgia_ArrayList = TacGiaDAO.getInstance().selectAll();
    }

    public ArrayList<TacGia> getTacgia() {
        return tacgia_ArrayList;
    }
    
    public void ChonTG(Combobox cb){
        for (TacGia tg : tacgia_ArrayList){
            cb.addItem(tg);
        }
    }
    
    public String getTTG(int matacgia){
        for (TacGia tacgia : tacgia_ArrayList ){
            if (tacgia.getMaTacGia() == matacgia) {
                return tacgia.getTenTacGia();
            }
        }
        return "ERR";
    }
    
    public int getMatacgia(String tentg){
        for (TacGia tg : tacgia_ArrayList){
            if (tentg.equals(tg.getTenTacGia())) {
                return tg.getMaTacGia();
            }
        }
        return -1;
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
     
    public void RenderTacGia(Table table){
        for (TacGia tg : tacgia_ArrayList){
             int matacgia = tg.getMaTacGia();
             String tentacgia = tg.getTenTacGia();
             String namsinh = FormatDate(tg.getNamSinh());
             String diachi = tg.getDiachi();
             String gioithieu = tg.getGioiThieu();
             table.addRow(new Object[]{matacgia, tentacgia, namsinh, diachi, gioithieu});
        }
    }
    
    public TacGia SelectedTacGia(int matacgia){
        TacGia tg = TacGiaDAO.getInstance().selectByID(matacgia);
        return tg;
    }
    
    public boolean XoaTacGia(TacGia tg){
        if (tg != null) {
            TacGiaDAO.getInstance().delete(tg);
            return true;
        }
        return false;
    }
    
    public boolean ThemTacGia(TacGia tg){
        if (tg != null) {
           TacGia checkExist_TG= TacGiaDAO.getInstance().selectByID(tg);
            if (checkExist_TG == null) {
                TacGiaDAO.getInstance().insert(tg);
                return true;
            }
        }
        return false;
    }
    
    public boolean CompareTo(TacGia tg, TacGia current){
        if (tg.getMaTacGia() == current.getMaTacGia() && 
            tg.getDiachi().equals(current.getDiachi()) &&
            tg.getGioiThieu().equals(current.getGioiThieu()) &&
            tg.getHinhanh().equals(current.getHinhanh()) &&
            tg.getNamSinh().equals(current.getNamSinh()) &&
            tg.getTenTacGia().equals(current.getTenTacGia())
            ){
            return true;
        }
        return false;
    }
    
    public boolean SuaTacGia(TacGia tg, TacGia current){
        if (tg != null && current != null) {
            if (!CompareTo(tg, current)) {
                TacGiaDAO.getInstance().update(tg);
                return true;
            }else{
                return true;
            }
        }
        return false;
    }
    
    
}
