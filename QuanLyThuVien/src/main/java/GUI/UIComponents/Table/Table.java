
package GUI.UIComponents.Table;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class Table extends JTable{

    public Table() {
        
        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        setRowHeight(30);
        getTableHeader().setReorderingAllowed(false);
        new DefaultTableCellRenderer().setHorizontalAlignment(JLabel.CENTER);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object o, boolean isSelected, boolean hasFocus, int row, int column) {
                Table_Header header = new Table_Header(o + "");
                
                return header;
            }

            
        });
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object o, boolean isSelected, boolean hasFocus, int row, int column) {

                    Component com = super.getTableCellRendererComponent(table, o, isSelected, hasFocus, row, column);
                    com.setBackground(Color.WHITE);
                    setBorder(noFocusBorder);
                    if (isSelected) {
                        com.setForeground(new Color(15, 89, 140));
                        com.setFont(new Font("arial", 1, 12));
                    }else{
                        com.setForeground(new Color(102, 102, 102));
                    }
                    return com;
               
                
            }
            
        });
    }
    
    public void addRow(Object[] row){
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row);
    }
    
    public void deleteRow(int RowSelected){
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.removeRow(RowSelected);
    }
    
    public void updateRow(int RowSelected, Object[] row){
        DefaultTableModel model = (DefaultTableModel) getModel();
        for (int i = 0; i < model.getColumnCount(); i++) {
            model.setValueAt(row[i], RowSelected, i);
        }
    }
    
    public int find(int value, int idx){
        DefaultTableModel model = (DefaultTableModel) getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            
            if (model.getValueAt(i, idx).equals(value)) {
                return i;
            }
        }
        return -2;
    }
    
    

}
