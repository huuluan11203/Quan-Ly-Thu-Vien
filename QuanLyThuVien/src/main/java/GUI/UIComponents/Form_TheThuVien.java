
package GUI.UIComponents;

import BUS.DocGia_BUS;
import BUS.TheThuVien_BUS;
import DTO.DocGia;
import DTO.TheThuVien;
import GUI.UIComponents.DATE.DateChooser;
import GUI.UIComponents.Table.Table;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.time.LocalDate;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import raven.toast.Notifications;


public class Form_TheThuVien extends javax.swing.JPanel {
    
    private int RowSelected = -1;
    
    private static TheThuVien thethuvien;
    private static TheThuVien_BUS theThuVien_BUS;
    private static DocGia_BUS docGia_BUS;
    private static DocGia docgia;
    
    public Form_TheThuVien() {
        
        
        initComponents();
        theThuVien_BUS = new TheThuVien_BUS();
        docGia_BUS = new DocGia_BUS();
        
        theThuVien_BUS.RenderTheThuVien(table_TTV);
        table_TTV.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        madg_txt.setEnabled(false);
        tendg_txt.setEnabled(false);
        
        initEvent();
    }

    
    private void initEvent(){
        
        table_TTV.addMouseListener(new java.awt.event.MouseAdapter() { // row is clicked
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if (SwingUtilities.isLeftMouseButton(evt)) {
                        
                        RowSelected = table_TTV.getSelectedRow();
                        thethuvien = theThuVien_BUS.SelectedTheThuVien(Integer.parseInt(table_TTV.getModel().
                                getValueAt(RowSelected, 0).toString()));
                        mathe_txt.setText(Integer.toString(thethuvien.getMaThe()));
                        mathe_txt.setEnabled(false);
                        ngaybd_txt.setText(theThuVien_BUS.FormatDate(thethuvien.getNgayBatDau()));
                        ngaykt_txt.setText(theThuVien_BUS.FormatDate(thethuvien.getNgayKetthuc()));
                        
                        docgia = docGia_BUS.getDocGia(thethuvien.getMaThe());
                        if (docgia != null) {
                            madg_txt.setText(Integer.toString(docgia.getMaDocGia()));
                            tendg_txt.setText(docgia.getTenDocGia());
                        }else{
                            madg_txt.setText("Unknown");
                            tendg_txt.setText("Unknown");
                        }
                    }
                    
                }

            });
    }
    
    private void setToDefault(){
        madg_txt.setText("");
        tendg_txt.setText("");
        mathe_txt.setText("");
        ngaybd_txt.setText("");
        ngaykt_txt.setText("");
        mathe_txt.setEnabled(true);
        RowSelected = -1;
        thethuvien = null;
        table_TTV.clearSelection();
    }
    
    public Table getTable(){
        return table_TTV;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_TTV = new GUI.UIComponents.Table.Table();
        panelBorder1 = new GUI.UIComponents.Panel.PanelBorder();
        save_btn = new GUI.UIComponents.Button();
        add_btn = new GUI.UIComponents.Button();
        delete_btn = new GUI.UIComponents.Button();
        ngaykt_txt = new GUI.UIComponents.TextField();
        jLabel5 = new javax.swing.JLabel();
        ngaybd_txt = new GUI.UIComponents.TextField();
        madg_txt = new GUI.UIComponents.TextField();
        tendg_txt = new GUI.UIComponents.TextField();
        mathe_txt = new GUI.UIComponents.TextField();
        chooseDate = new GUI.UIComponents.Button();
        chooseDate3 = new GUI.UIComponents.Button();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new Color(0,0,0,0));

        table_TTV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Thẻ", "Ngày Bắt Đầu", "Ngày Kết Thúc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_TTV.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(table_TTV);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        save_btn.setIcon(new FlatSVGIcon("IMG/icon/save.svg",30,30));
        save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btnActionPerformed(evt);
            }
        });
        panelBorder1.add(save_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 6, 41, 42));

        add_btn.setIcon(new FlatSVGIcon("IMG/icon/add.svg",30,30));
        add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btnActionPerformed(evt);
            }
        });
        panelBorder1.add(add_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 6, 41, 42));

        delete_btn.setIcon(new FlatSVGIcon("IMG/icon/delete.svg",30,30));
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });
        panelBorder1.add(delete_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(458, 6, 41, 42));

        ngaykt_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder1.add(ngaykt_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 240, 50));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(150, 150, 150));
        jLabel5.setText("Ngày bắt đầu");
        panelBorder1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 114, 80, -1));

        ngaybd_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder1.add(ngaybd_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 240, 50));

        madg_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder1.add(madg_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 240, 50));

        tendg_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder1.add(tendg_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, 240, 50));

        mathe_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder1.add(mathe_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 270, 50));

        chooseDate.setBackground(new Color(0,0,0,0));
        chooseDate.setIcon(new FlatSVGIcon("IMG/icon/calendar.svg",30,30));
        chooseDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseDateActionPerformed(evt);
            }
        });
        panelBorder1.add(chooseDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 30, 30));

        chooseDate3.setBackground(new Color(0,0,0,0));
        chooseDate3.setIcon(new FlatSVGIcon("IMG/icon/calendar.svg",30,30));
        chooseDate3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseDate3ActionPerformed(evt);
            }
        });
        panelBorder1.add(chooseDate3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 30, 30));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(150, 150, 150));
        jLabel6.setText("Mã độc giả");
        panelBorder1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 114, 80, -1));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(150, 150, 150));
        jLabel7.setText("Mã Thẻ");
        panelBorder1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 65, 80, -1));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(150, 150, 150));
        jLabel8.setText("Tên độc giả");
        panelBorder1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 165, 80, -1));

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(150, 150, 150));
        jLabel9.setText("Ngày kết thúc");
        panelBorder1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 165, 80, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btnActionPerformed

        boolean checked = false;

        int mathe = -1;
        LocalDate ngaybd = LocalDate.now();
        LocalDate ngaykt = LocalDate.now();

        try {

            mathe = Integer.parseInt(mathe_txt.getText());
            ngaybd = theThuVien_BUS.FormatDateSQL(ngaybd_txt.getText());
            ngaykt = theThuVien_BUS.FormatDateSQL(ngaykt_txt.getText());            
            
            checked = true;

        } catch (Exception e) {
            checked = false;
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
                "Dữ liệu không đúng định dạng.");
        }

        if (checked){
            if (RowSelected == -1 && thethuvien == null) {

                thethuvien = new TheThuVien(mathe, ngaybd, ngaykt);

                if (theThuVien_BUS.ThemTheThuVien(thethuvien)) {

                    table_TTV.addRow(new Object[] {mathe, theThuVien_BUS.FormatDate(ngaybd), theThuVien_BUS.FormatDate(ngaykt)});

                }
                thethuvien = null;

            }else {
                TheThuVien lsUpdate = new TheThuVien(mathe, ngaybd, ngaykt);
                if (theThuVien_BUS.SuaTheThuVien(lsUpdate, thethuvien)) {

                    table_TTV.updateRow(RowSelected, new Object[] {mathe, theThuVien_BUS.FormatDate(ngaybd), theThuVien_BUS.FormatDate(ngaykt)});
                    thethuvien= lsUpdate;
                    lsUpdate = null;

                }
            }
        }
    }//GEN-LAST:event_save_btnActionPerformed

    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed
        setToDefault();
    }//GEN-LAST:event_add_btnActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        if (RowSelected != -1) {
            ImageIcon icon = new FlatSVGIcon("IMG/icon/warning.svg",30,30);
            String[] cf = {"Đồng ý", "Hủy"};
            int choice = JOptionPane.showOptionDialog(null,"Xóa thẻ \"" + thethuvien.getMaThe()+"\" ?","Xác Nhận",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, cf ,null);
            if (choice == 0) {

                if (theThuVien_BUS.XoaTheThuVien(thethuvien)) {
                    table_TTV.deleteRow(RowSelected);
                    setToDefault();
                }
            }
        }else{
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
                "Vui lòng chọn thẻ.");
        }
    }//GEN-LAST:event_delete_btnActionPerformed

    private void chooseDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseDateActionPerformed
        DateChooser date = new DateChooser();
        date.setTextRefernce(ngaybd_txt);
        date.showPopup(chooseDate, - 186, -130);
    }//GEN-LAST:event_chooseDateActionPerformed

    private void chooseDate3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseDate3ActionPerformed
        DateChooser date = new DateChooser();
        date.setTextRefernce(ngaykt_txt);
        date.showPopup(chooseDate3, - 186, -130);
    }//GEN-LAST:event_chooseDate3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.UIComponents.Button add_btn;
    private GUI.UIComponents.Button chooseDate;
    private GUI.UIComponents.Button chooseDate3;
    private GUI.UIComponents.Button delete_btn;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private GUI.UIComponents.TextField madg_txt;
    private GUI.UIComponents.TextField mathe_txt;
    private GUI.UIComponents.TextField ngaybd_txt;
    private GUI.UIComponents.TextField ngaykt_txt;
    private GUI.UIComponents.Panel.PanelBorder panelBorder1;
    private GUI.UIComponents.Button save_btn;
    private GUI.UIComponents.Table.Table table_TTV;
    private GUI.UIComponents.TextField tendg_txt;
    // End of variables declaration//GEN-END:variables
}
