
package GUI.UIComponents;

import BUS.DocGia_BUS;
import DTO.DocGia;
import GUI.Main;
import GUI.UIComponents.DATE.DateChooser;
import GUI.UIComponents.FileChooser.JnaFileChooser;
import GUI.swing.HighRE;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.time.LocalDate;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import raven.toast.Notifications;


public class Form_DocGia extends javax.swing.JPanel {

    private boolean isChoosed;
    private Main main;
    private int RowSelected = -1;
    JnaFileChooser ch;
    ImageIcon defaultIMG =new FlatSVGIcon("IMG/DocGia/default.svg",150,150);

    private DocGia_BUS docGia_BUS;
    private DocGia docgia;
    
    public Form_DocGia() {
        initComponents();
        
        docGia_BUS = new DocGia_BUS();
        
        docGia_BUS.RenderDocGia(table_DocGia);
        table_DocGia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        ChonGioiTinh.setSelectedIndex(-1);
        
        initEvent();
    }

    private void initEvent(){
          table_DocGia.addMouseListener(new java.awt.event.MouseAdapter() { // row is clicked
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if (SwingUtilities.isLeftMouseButton(evt)) {
                        
                        RowSelected = table_DocGia.getSelectedRow();
                        docgia = docGia_BUS.SelectedDocGia(Integer.parseInt(table_DocGia.getModel().
                                getValueAt(RowSelected, 0).toString()));
                        
                        ChonGioiTinh.setSelectedItem(docgia.getGioiTinh());
                        madocgia_txt.setText(Integer.toString(docgia.getMaDocGia()));
                        madocgia_txt.setEnabled(false);
                        mathe_txt.setText(Integer.toString(docgia.getMaThe()));
                        tendocgia_txt.setText(docgia.getTenDocGia());
                        sdt_txt.setText(docgia.getSdt());
                        ngaysinh_txt.setText(docGia_BUS.FormatDate(docgia.getNamSinh()));
                        if (docgia.getHinhanh().equals("default.svg")) {
                            IMG.setIcon(defaultIMG);
                        }else{
                            IMG.setIcon(new HighRE().setIconJPG(docgia.getHinhanh(), "DocGia"));
                        }
                    }
                    
                }

            });
    }

    private void setToDefault(){
        table_DocGia.clearSelection();
        RowSelected = -1;
        madocgia_txt.setEnabled(true);
        madocgia_txt.setText("");
        tendocgia_txt.setText("");
        sdt_txt.setText("");
        mathe_txt.setText("");
        ngaysinh_txt.setText("");
        ChonGioiTinh.setSelectedIndex(-1);
        docgia = null;
 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_DocGia = new GUI.UIComponents.Table.Table();
        panelBorder1 = new GUI.UIComponents.Panel.PanelBorder();
        save_btn = new GUI.UIComponents.Button();
        add_btn = new GUI.UIComponents.Button();
        delete_btn = new GUI.UIComponents.Button();
        madocgia_txt = new GUI.UIComponents.TextField();
        chooseDate = new GUI.UIComponents.Button();
        IMG = new javax.swing.JLabel();
        ChooseIMG = new GUI.UIComponents.Button();
        tendocgia_txt = new GUI.UIComponents.TextField();
        mathe_txt = new GUI.UIComponents.TextField();
        sdt_txt = new GUI.UIComponents.TextField();
        ngaysinh_txt = new GUI.UIComponents.TextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        ChonGioiTinh = new GUI.UIComponents.Combobox();

        setBackground(new Color(0,0,0,0));

        table_DocGia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Độc Giả", "Tên Độc Giả", "Năm Sinh", "Giới Tính", "Mã Thẻ Thư Viện"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_DocGia.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(table_DocGia);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setForeground(new java.awt.Color(255, 255, 255));
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

        madocgia_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder1.add(madocgia_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 200, 50));

        chooseDate.setBackground(new Color(0,0,0,0));
        chooseDate.setIcon(new FlatSVGIcon("IMG/icon/calendar.svg",30,30));
        chooseDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseDateActionPerformed(evt);
            }
        });
        panelBorder1.add(chooseDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 180, 30, 30));

        IMG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IMG.setIcon(new FlatSVGIcon("IMG/TacGia/default.svg",150,150));
        panelBorder1.add(IMG, new org.netbeans.lib.awtextra.AbsoluteConstraints(646, 6, 150, 180));

        ChooseIMG.setBackground(Color.decode("#00abfd")
        );
        ChooseIMG.setForeground(new java.awt.Color(255, 255, 255));
        ChooseIMG.setText("Chọn ảnh");
        ChooseIMG.setShadowColor(new java.awt.Color(3, 155, 216));
        ChooseIMG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChooseIMGActionPerformed(evt);
            }
        });
        panelBorder1.add(ChooseIMG, new org.netbeans.lib.awtextra.AbsoluteConstraints(652, 192, 140, 30));

        tendocgia_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder1.add(tendocgia_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 200, 50));

        mathe_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder1.add(mathe_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 200, 50));

        sdt_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder1.add(sdt_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 210, 50));

        ngaysinh_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder1.add(ngaysinh_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 180, 50));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(150, 150, 150));
        jLabel12.setText("Tên độc giả");
        panelBorder1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 125, 70, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(150, 150, 150));
        jLabel14.setText("Mã thẻ ");
        panelBorder1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 185, 70, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(150, 150, 150));
        jLabel15.setText("SDT");
        panelBorder1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 125, 70, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(150, 150, 150));
        jLabel16.setText("Ngày sinh");
        panelBorder1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 185, 70, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(150, 150, 150));
        jLabel18.setText("Mã độc giả");
        panelBorder1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 65, 70, -1));

        ChonGioiTinh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nữ", "Nam", "Khác" }));
        ChonGioiTinh.setSelectedIndex(-1);
        ChonGioiTinh.setLabeText("Giới tính");
        panelBorder1.add(ChonGioiTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 280, 40));

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

        int madg = -1;
        int mathe = -1;
        String tendg = "";
        LocalDate ngaysinh = LocalDate.now();
        String hinhanh = "";
        String sdt = "";
        String gt = "";

        try {

            madg = Integer.parseInt(madocgia_txt.getText());
            tendg = tendocgia_txt.getText();
            sdt = sdt_txt.getText();
            ngaysinh = docGia_BUS.FormatDateSQL(ngaysinh_txt.getText());
            mathe = Integer.parseInt(mathe_txt.getText());
            sdt = sdt_txt.getText();
            gt = ChonGioiTinh.getSelectedItem().toString();

            if (isChoosed) {
                String path = ch.getSelectedFile().toString();
                hinhanh = path.substring(path.lastIndexOf("\\"  ) + 1);
                    isChoosed = false;
                }else {
                    if (docgia == null) {
                        hinhanh = "default.svg";
                    }else{
                        hinhanh = docgia.getHinhanh();
                    }
                }

                checked = true;

            } catch (Exception e) {
                checked = false;
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
                    "Dữ liệu không đúng định dạng.");
            }
            if (checked){
                if (RowSelected == -1 && docgia == null) {

                    docgia = new DocGia(madg, tendg, ngaysinh, gt, sdt, hinhanh, mathe);

                    if (docGia_BUS.ThemDocGia(docgia)) {

                        table_DocGia.addRow(new Object[] {madg, tendg, docGia_BUS.FormatDate(ngaysinh), gt, mathe});

                    }
                    docgia = null;

                }else {
                    DocGia dgUpdate = new DocGia(madg, tendg, ngaysinh, gt, sdt, hinhanh, mathe);
                    if (docGia_BUS.SuaDocGia(dgUpdate, docgia)) {

                        if (hinhanh.equals("default.svg")) {
                            IMG.setIcon(defaultIMG);
                        }else{
                            IMG.setIcon(new HighRE().setIconJPG(dgUpdate.getHinhanh(), "DocGia"));
                        }
                        table_DocGia.updateRow(RowSelected, new Object[] {madg, tendg, docGia_BUS.FormatDate(ngaysinh), gt, mathe});
                        docgia = dgUpdate;
                        dgUpdate = null;

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
            int choice = JOptionPane.showOptionDialog(null,"Xóa độc giả \"" + docgia.getMaDocGia()+" - " + docgia.getTenDocGia()+ " ?","Xác Nhận",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, cf ,null);
            if (choice == 0) {

                if (docGia_BUS.XoaDocGia(docgia)) {
                    table_DocGia.deleteRow(RowSelected);
                    setToDefault();
                }
            }
        }else{
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
                "Vui lòng chọn độc giả.");
        }
    }//GEN-LAST:event_delete_btnActionPerformed

    private void chooseDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseDateActionPerformed
        DateChooser date = new DateChooser();
        date.setTextRefernce(ngaysinh_txt);
        date.showPopup(chooseDate, - 186, -130);
    }//GEN-LAST:event_chooseDateActionPerformed

    private void ChooseIMGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChooseIMGActionPerformed
        ch = new JnaFileChooser();
        isChoosed = ch.showOpenDialog(main);
        if (isChoosed) {
            String imagePath = ch.getSelectedFile().toString();
            IMG.setIcon(new HighRE().setIconJPG(imagePath.substring(imagePath.lastIndexOf("\\"  ) + 1), "DocGia"));
        }else {
            IMG.setIcon(defaultIMG);
        }
    }//GEN-LAST:event_ChooseIMGActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.UIComponents.Combobox ChonGioiTinh;
    private GUI.UIComponents.Button ChooseIMG;
    private javax.swing.JLabel IMG;
    private GUI.UIComponents.Button add_btn;
    private GUI.UIComponents.Button chooseDate;
    private GUI.UIComponents.Button delete_btn;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JScrollPane jScrollPane1;
    private GUI.UIComponents.TextField madocgia_txt;
    private GUI.UIComponents.TextField mathe_txt;
    private GUI.UIComponents.TextField ngaysinh_txt;
    private GUI.UIComponents.Panel.PanelBorder panelBorder1;
    private GUI.UIComponents.Button save_btn;
    private GUI.UIComponents.TextField sdt_txt;
    private GUI.UIComponents.Table.Table table_DocGia;
    private GUI.UIComponents.TextField tendocgia_txt;
    // End of variables declaration//GEN-END:variables
}
