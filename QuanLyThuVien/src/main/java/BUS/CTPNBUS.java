/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ChiTietPhieuNhapDAO;
import DTO.CTPNDTO;
import GUI.UIComponents.Table.Table;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author X
 */
public class CTPNBUS {
    private  ArrayList<CTPNDTO> dsCTPN;

    public CTPNBUS(int mapn) {
        dsCTPN = ChiTietPhieuNhapDAO.getInstance().selectByPN(mapn);
    }

    public CTPNBUS() {
    }
     public void RenderCTPN(Table table){
        for (CTPNDTO ct : dsCTPN){
            int mactpn = ct.getMaCTPN();
            int soluong = ct.getSoLuong();
            int ms = ct.getMaSach();
            double gia = ct.getGia();
            
            table.addRow(new Object[] {mactpn, ms, gia, soluong});
        }
    }
     
      public CTPNDTO SelectedCTPN(int ma){
        CTPNDTO ctpn = ChiTietPhieuNhapDAO.getInstance().selectOne(ma);
        return ctpn;
    }
    
     public void ReRenderCTPN(Table table){
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        
        for (CTPNDTO ct : dsCTPN){
            int mactpn = ct.getMaCTPN();
            int soluong = ct.getSoLuong();
            int ms = ct.getMaSach();
            double gia = ct.getGia();
            
            table.addRow(new Object[] {mactpn, ms, gia, soluong});
        }
    }

    public ArrayList<CTPNDTO> getDsCTPN() {
        return dsCTPN;
    }

    public void setDsCTPN(ArrayList<CTPNDTO> dsCTPN) {
        this.dsCTPN = dsCTPN;
    }
     
     
    
}
