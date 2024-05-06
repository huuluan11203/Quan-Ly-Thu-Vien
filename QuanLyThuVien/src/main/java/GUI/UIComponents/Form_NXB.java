
package GUI.UIComponents;

import BUS.NhaXuatBan_BUS;
import DTO.NhaXuatBan;
import GUI.UIComponents.Table.Table;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import raven.toast.Notifications;


public class Form_NXB extends javax.swing.JPanel {

    private int RowSelected = -1;
    private NhaXuatBan_BUS nhaXuatBan_BUS;
    private NhaXuatBan nhaxuatban;

    public Form_NXB() {
        initComponents();
        
        nhaXuatBan_BUS = new NhaXuatBan_BUS();
        
        nhaXuatBan_BUS.RenderLoaiSach(table_NXB);
        table_NXB.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        initEvent();
    }

    private void initEvent(){
        table_NXB.addMouseListener(new java.awt.event.MouseAdapter() { // row is clicked
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if (SwingUtilities.isLeftMouseButton(evt)) {
                        
                        RowSelected = table_NXB.getSelectedRow();
                        
                        nhaxuatban = nhaXuatBan_BUS.SelectedNXB(Integer.parseInt(table_NXB.getModel().
                                getValueAt(RowSelected, 0).toString()));
                       
                        manxb_txt.setEnabled(false);
                        manxb_txt.setText(Integer.toString(nhaxuatban.getMaNXB()));
                        tennxb_txt.setText(nhaxuatban.getTenNXB());
                        sdt_txt.setText(nhaxuatban.getSdt());
                        diachi_txt.setText(nhaxuatban.getDiaChi());
                    }
                    
                }

            });
    }
    
    
    public void setToDefault(){
        table_NXB.clearSelection();
        manxb_txt.setEnabled(true);
        RowSelected = -1;
        nhaxuatban = null;
        manxb_txt.setText("");
        tennxb_txt.setText("");
        sdt_txt.setText("");
        diachi_txt.setText("");
    }
    
    public Table getTable(){
        return table_NXB;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_NXB = new GUI.UIComponents.Table.Table();
        panelBorder1 = new GUI.UIComponents.Panel.PanelBorder();
        save_btn = new GUI.UIComponents.Button();
        add_btn = new GUI.UIComponents.Button();
        delete_btn = new GUI.UIComponents.Button();
        diachi_txt = new GUI.UIComponents.TextField();
        manxb_txt = new GUI.UIComponents.TextField();
        sdt_txt = new GUI.UIComponents.TextField();
        tennxb_txt = new GUI.UIComponents.TextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new Color(0,0,0,0));
        setMaximumSize(new java.awt.Dimension(802, 645));

        table_NXB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhà Xuất Bản", "Tên Nhà Xuất Bản", "Dịa Chỉ", "Số Điện Thoại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_NXB.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(table_NXB);
        if (table_NXB.getColumnModel().getColumnCount() > 0) {
            table_NXB.getColumnModel().getColumn(0).setPreferredWidth(130);
            table_NXB.getColumnModel().getColumn(0).setMaxWidth(130);
        }

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

        diachi_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        diachi_txt.setHint("");
        panelBorder1.add(diachi_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 650, 50));

        manxb_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder1.add(manxb_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 270, 50));

        sdt_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder1.add(sdt_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, 280, 50));

        tennxb_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder1.add(tennxb_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 650, 50));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(150, 150, 150));
        jLabel5.setText("Địa chỉ");
        panelBorder1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 173, 100, -1));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(150, 150, 150));
        jLabel7.setText("Mã nhà xuất bản");
        panelBorder1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 63, 100, -1));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(150, 150, 150));
        jLabel8.setText("Số điện thoại");
        panelBorder1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 63, 80, -1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(150, 150, 150));
        jLabel6.setText("Tên nhà xuất bản");
        panelBorder1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 123, 100, -1));

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

        int manxb = -1;
        String tennxb = "";
        String sdt = "";
        String dc = "";

        try {

            manxb = Integer.parseInt(manxb_txt.getText());
            tennxb = tennxb_txt.getText();
            sdt = sdt_txt.getText();
            dc = diachi_txt.getText();
            checked = true;

        } catch (Exception e) {
            checked = false;
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
                "Dữ liệu không đúng định dạng.");
        }

        if (checked){
            if (RowSelected == -1 && nhaxuatban == null) {

                nhaxuatban = new NhaXuatBan(manxb, tennxb, dc, sdt);

                if (nhaXuatBan_BUS.ThemNXB(nhaxuatban)) {

                    table_NXB.addRow(new Object[] {manxb, tennxb, dc, sdt});

                }
                nhaxuatban = null;

            }else {
                NhaXuatBan nxbUpdate = new NhaXuatBan(manxb, tennxb, dc, sdt);
                if (nhaXuatBan_BUS.SuaNXB(nxbUpdate, nhaxuatban)) {

                    table_NXB.updateRow(RowSelected, new Object[] {manxb, tennxb, dc, sdt});
                    nhaxuatban= nxbUpdate;
                    nxbUpdate = null;

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
            int choice = JOptionPane.showOptionDialog(null,"Xóa nhà xuất bản \"" + nhaxuatban.getTenNXB() +"\" ? \n Tất cả sách cũng sẽ bị xóa.","Xác Nhận",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, cf ,null);
            if (choice == 0) {

                if (nhaXuatBan_BUS.XoaNXB(nhaxuatban)) {
                    table_NXB.deleteRow(RowSelected);
                    setToDefault();
                }
            }
        }else{
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
                "Vui lòng chọn nhà xuất bản.");
        }
    }//GEN-LAST:event_delete_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.UIComponents.Button add_btn;
    private GUI.UIComponents.Button delete_btn;
    private GUI.UIComponents.TextField diachi_txt;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private GUI.UIComponents.TextField manxb_txt;
    private GUI.UIComponents.Panel.PanelBorder panelBorder1;
    private GUI.UIComponents.Button save_btn;
    private GUI.UIComponents.TextField sdt_txt;
    private GUI.UIComponents.Table.Table table_NXB;
    private GUI.UIComponents.TextField tennxb_txt;
    // End of variables declaration//GEN-END:variables
}
