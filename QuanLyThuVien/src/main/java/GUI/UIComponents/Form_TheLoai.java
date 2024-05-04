
package GUI.UIComponents;

import BUS.LoaiSach_BUS;
import DTO.LoaiSach;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import raven.toast.Notifications;


public class Form_TheLoai extends javax.swing.JPanel {

    private int RowSelected = -1;
    private static LoaiSach loaisach;
    private LoaiSach_BUS loaiSach_BUS;
    
    
    public Form_TheLoai() {
        
        loaiSach_BUS = new LoaiSach_BUS();
        initComponents();
        
        loaiSach_BUS.RenderLoaiSach(table_TheLoai);
        initEvent();
    }

   
    private void initEvent(){
        table_TheLoai.addMouseListener(new java.awt.event.MouseAdapter() { // row is clicked
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if (SwingUtilities.isLeftMouseButton(evt)) {
                        
                        RowSelected = table_TheLoai.getSelectedRow();
                        
                        loaisach = loaiSach_BUS.SelectedLoaiSach(Integer.parseInt(table_TheLoai.getModel().
                                getValueAt(RowSelected, 0).toString()));
                        maloaisach_txt.setText(Integer.toString(loaisach.getMaLoaiSach()));
                        tenloaisach_txt.setText(loaisach.getTenLoaiSach());
                        maloaisach_txt.setEnabled(false);

                    }
                    
                }

            });
    }
    
    
    public void setToDefault(){
        table_TheLoai.clearSelection();
        maloaisach_txt.setEnabled(true);
        RowSelected = -1;
        loaisach = null;
        maloaisach_txt.setText("");
        tenloaisach_txt.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_TheLoai = new GUI.UIComponents.Table.Table();
        panelBorder1 = new GUI.UIComponents.Panel.PanelBorder();
        save_btn = new GUI.UIComponents.Button();
        add_btn = new GUI.UIComponents.Button();
        delete_btn = new GUI.UIComponents.Button();
        maloaisach_txt = new GUI.UIComponents.TextField();
        tenloaisach_txt = new GUI.UIComponents.TextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new Color(0,0,0,0));
        setMaximumSize(new java.awt.Dimension(802, 645));
        setPreferredSize(new java.awt.Dimension(802, 645));

        table_TheLoai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Loại Sách", "Tên Loại Sách"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_TheLoai.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(table_TheLoai);
        if (table_TheLoai.getColumnModel().getColumnCount() > 0) {
            table_TheLoai.getColumnModel().getColumn(0).setPreferredWidth(150);
            table_TheLoai.getColumnModel().getColumn(0).setMaxWidth(190);
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

        maloaisach_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder1.add(maloaisach_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 450, 50));

        tenloaisach_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        tenloaisach_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenloaisach_txtActionPerformed(evt);
            }
        });
        panelBorder1.add(tenloaisach_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 450, 50));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(150, 150, 150));
        jLabel4.setText("Tên loại sách");
        panelBorder1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 153, 80, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(150, 150, 150));
        jLabel5.setText("Mã loại sách");
        panelBorder1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 84, 80, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        int mals = -1;
        String tenls = "";


        try {

            mals = Integer.parseInt(maloaisach_txt.getText());
            tenls = tenloaisach_txt.getText();
            checked = true;

        } catch (Exception e) {
            checked = false;
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
                "Dữ liệu không đúng định dạng.");
        }
        
        if (checked){
            if (RowSelected == -1 && loaisach == null) {

                loaisach = new LoaiSach(mals, tenls);

                if (loaiSach_BUS.ThemLoaiSach(loaisach)) {

                    table_TheLoai.addRow(new Object[] {mals, tenls});

                }
                loaisach = null;

            }else {
                LoaiSach lsUpdate = new LoaiSach(mals, tenls);
                if (loaiSach_BUS.SuaLoaiSach(lsUpdate, loaisach)) {
                    
                    table_TheLoai.updateRow(RowSelected, new Object[] {mals, tenls});
                    loaisach= lsUpdate;
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
            int choice = JOptionPane.showOptionDialog(null,"Xóa thể loại \"" + loaisach.getTenLoaiSach() +"\" ? \n Tất cả sách cũng sẽ bị xóa.","Xác Nhận",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, cf ,null);
            if (choice == 0) {

                if (loaiSach_BUS.XoaLoaiSach(loaisach)) {
                    table_TheLoai.deleteRow(RowSelected);
                    setToDefault();
                }
            }
        }else{
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
                "Vui lòng chọn thể loại.");
        }

    }//GEN-LAST:event_delete_btnActionPerformed

    private void tenloaisach_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenloaisach_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tenloaisach_txtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.UIComponents.Button add_btn;
    private GUI.UIComponents.Button delete_btn;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private GUI.UIComponents.TextField maloaisach_txt;
    private GUI.UIComponents.Panel.PanelBorder panelBorder1;
    private GUI.UIComponents.Button save_btn;
    private GUI.UIComponents.Table.Table table_TheLoai;
    private GUI.UIComponents.TextField tenloaisach_txt;
    // End of variables declaration//GEN-END:variables
}
