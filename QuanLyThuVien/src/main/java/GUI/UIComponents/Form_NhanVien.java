
package GUI.UIComponents;

import BUS.NhanVien_BUS;
import DTO.NhanVien;
import GUI.Main;
import GUI.UIComponents.DATE.DateChooser;
import GUI.UIComponents.FileChooser.JnaFileChooser;
import GUI.UIComponents.Table.Table;
import GUI.swing.HighRE;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.time.LocalDate;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import raven.toast.Notifications;



public class Form_NhanVien extends javax.swing.JPanel {
    
    private boolean isChoosed;
    private Main main;
    private static NhanVien nhanvien;
    private static NhanVien_BUS nhanVien_BUS;
    
    private int RowSelected = -1;
    JnaFileChooser ch;
    ImageIcon defaultIMG =new FlatSVGIcon("IMG/NhanVien/default.svg",150,150);
    
    public Form_NhanVien() {
        
        nhanVien_BUS = new NhanVien_BUS();
        
        initComponents();
        
        nhanVien_BUS.RenderNhanVien(table_NhanVien);
        table_NhanVien.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        ChonGioiTinh.setSelectedIndex(-1);
        
        initEvent();
        
    }

    private void initEvent(){
        
        table_NhanVien.addMouseListener(new java.awt.event.MouseAdapter() { // row is clicked
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if (SwingUtilities.isLeftMouseButton(evt)) {
                        
                        RowSelected = table_NhanVien.getSelectedRow();
                        nhanvien = nhanVien_BUS.SelectedNhanVien(Integer.parseInt(table_NhanVien.getModel().
                                getValueAt(RowSelected, 0).toString()));
                        
                        ChonGioiTinh.setSelectedItem(nhanvien.getGioiTinh());
                        manv_txt.setText(Integer.toString(nhanvien.getMaNV()));
                        manv_txt.setEnabled(false);
                        tennv_txt.setText(nhanvien.getTenNV());
                        diachi_txt.setText(nhanvien.getDiaChi());
                        sdt_txt.setText(nhanvien.getSDT());
                        ngaybatdau_txt.setText(nhanVien_BUS.FormatDate(nhanvien.getNgayBatDau()));
                        namsinh_txt.setText(nhanVien_BUS.FormatDate(nhanvien.getNamsinh()));
                        luong_txt.setText(Integer.toString(nhanvien.getLuong()));
                        if (nhanvien.getHinhAnh().equals("default.svg")) {
                            IMG.setIcon(defaultIMG);
                        }else{
                            IMG.setIcon(new HighRE().setIconJPG(nhanvien.getHinhAnh(), "NhanVien"));
                        }
                    }
                    
                }

            });
    }
    
    public Table getTable(){
        return table_NhanVien;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_NhanVien = new GUI.UIComponents.Table.Table();
        panelBorder1 = new GUI.UIComponents.Panel.PanelBorder();
        save_btn = new GUI.UIComponents.Button();
        add_btn = new GUI.UIComponents.Button();
        delete_btn = new GUI.UIComponents.Button();
        tennv_txt = new GUI.UIComponents.TextField();
        jLabel4 = new javax.swing.JLabel();
        IMG = new javax.swing.JLabel();
        ChooseIMG = new GUI.UIComponents.Button();
        sdt_txt = new GUI.UIComponents.TextField();
        diachi_txt = new GUI.UIComponents.TextField();
        luong_txt = new GUI.UIComponents.TextField();
        manv_txt = new GUI.UIComponents.TextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        ChonGioiTinh = new GUI.UIComponents.Combobox();
        namsinh_txt = new GUI.UIComponents.TextField();
        ngaybatdau_txt = new GUI.UIComponents.TextField();
        chooseDate = new GUI.UIComponents.Button();
        chooseDate1 = new GUI.UIComponents.Button();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setBackground(new Color(0,0,0,0));

        table_NhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NV", "Tên NV", "Năm Sinh", "Giới Tính"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_NhanVien.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(table_NhanVien);

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

        tennv_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        tennv_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tennv_txtActionPerformed(evt);
            }
        });
        panelBorder1.add(tennv_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 160, 50));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(150, 150, 150));
        jLabel4.setText("Tên NV");
        panelBorder1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 83, 60, -1));

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

        sdt_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder1.add(sdt_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 160, 50));

        diachi_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder1.add(diachi_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 160, 50));

        luong_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        luong_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                luong_txtActionPerformed(evt);
            }
        });
        panelBorder1.add(luong_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 170, 50));

        manv_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder1.add(manv_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 160, 50));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(150, 150, 150));
        jLabel5.setText("SDT");
        panelBorder1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 135, 60, -1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(150, 150, 150));
        jLabel6.setText("Địa chỉ");
        panelBorder1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 183, 60, -1));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(150, 150, 150));
        jLabel8.setText("Ngày sinh");
        panelBorder1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 185, 60, -1));

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(150, 150, 150));
        jLabel10.setText("Ngày bắt đầu");
        panelBorder1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 80, -1));

        ChonGioiTinh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nữ", "Nam", "Khác" }));
        ChonGioiTinh.setSelectedIndex(-1);
        ChonGioiTinh.setLabeText("Giới tính");
        panelBorder1.add(ChonGioiTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 200, 40));

        namsinh_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder1.add(namsinh_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, 120, 50));

        ngaybatdau_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder1.add(ngaybatdau_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 120, 50));

        chooseDate.setBackground(new Color(0,0,0,0));
        chooseDate.setIcon(new FlatSVGIcon("IMG/icon/calendar.svg",30,30));
        chooseDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseDateActionPerformed(evt);
            }
        });
        panelBorder1.add(chooseDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, 30, 30));

        chooseDate1.setBackground(new Color(0,0,0,0));
        chooseDate1.setIcon(new FlatSVGIcon("IMG/icon/calendar.svg",30,30));
        chooseDate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseDate1ActionPerformed(evt);
            }
        });
        panelBorder1.add(chooseDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 180, 30, 30));

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(150, 150, 150));
        jLabel11.setText("Mã NV");
        panelBorder1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 35, 60, -1));

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(150, 150, 150));
        jLabel12.setText("Lương");
        panelBorder1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 135, 40, -1));

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

        int manv = -1;
        String tennv = "";
        LocalDate ngaysinh = LocalDate.now();
        String gt = "";
        String hinhanh = "";
        String diachi = "";
        int luong = -1;
        String sdt = "";
        LocalDate ngaybatdau = LocalDate.now();

        try {

            manv = Integer.parseInt(manv_txt.getText());
            tennv = tennv_txt.getText();
            sdt = sdt_txt.getText();
            ngaysinh = nhanVien_BUS.FormatDateSQL(namsinh_txt.getText());
            ngaybatdau = nhanVien_BUS.FormatDateSQL(ngaybatdau_txt.getText());
            luong = Integer.parseInt(luong_txt.getText());
            diachi = diachi_txt.getText();
            gt = ChonGioiTinh.getSelectedItem().toString();
            
            if (isChoosed) {
                String path = ch.getSelectedFile().toString();
                hinhanh = path.substring(path.lastIndexOf("\\"  ) + 1);
                isChoosed = false;
            }else {
                if (nhanvien == null) {
                    hinhanh = "default.svg";
                }else{
                    hinhanh = nhanvien.getHinhAnh();
                }
            }

            checked = true;

            } catch (Exception e) {
                checked = false;
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
                    "Dữ liệu không đúng định dạng.");
            }
            if (checked){
                if (RowSelected == -1 && nhanvien == null) {

                    nhanvien = new NhanVien(manv, tennv, ngaysinh, gt, sdt, diachi, ngaybatdau, hinhanh, luong);

                    if (nhanVien_BUS.ThemNhanVien(nhanvien)) {

                        table_NhanVien.addRow(new Object[] {manv, tennv, nhanVien_BUS.FormatDate(ngaysinh), gt});

                    }
                    nhanvien = null;

                }else {
                    NhanVien nv = new NhanVien(manv, tennv, ngaysinh, gt, sdt, diachi, ngaybatdau, hinhanh, luong);
                    if (nhanVien_BUS.SuaNhanVien(nv, nhanvien)) {

                        if (hinhanh.equals("default.svg")) {
                            IMG.setIcon(defaultIMG);
                        }else{
                            IMG.setIcon(new HighRE().setIconJPG(nv.getHinhAnh(), "NhanVien"));
                        }
                        table_NhanVien.updateRow(RowSelected, new Object[] {manv, tennv, nhanVien_BUS.FormatDate(ngaysinh), gt});
                        nhanvien = nv;
                        nv = null;

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
            int choice = JOptionPane.showOptionDialog(null,"Xóa nhân viên \"" + nhanvien.getMaNV()+" - " + nhanvien.getTenNV() + " ?","Xác Nhận",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, cf ,null);
            if (choice == 0) {

                if (nhanVien_BUS.XoaNhanVien(nhanvien)) {
                    table_NhanVien.deleteRow(RowSelected);
                    setToDefault();
                }
            }
        }else{
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
                "Vui lòng chọn nhân viên.");
        }

    }//GEN-LAST:event_delete_btnActionPerformed

    private void ChooseIMGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChooseIMGActionPerformed
        ch = new JnaFileChooser();
        isChoosed = ch.showOpenDialog(main);
        if (isChoosed) {
            String imagePath = ch.getSelectedFile().toString();
            IMG.setIcon(new HighRE().setIconJPG(imagePath.substring(imagePath.lastIndexOf("\\"  ) + 1), "NhanVien"));
            }else {
                IMG.setIcon(defaultIMG);
            }
    }//GEN-LAST:event_ChooseIMGActionPerformed

    private void tennv_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tennv_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tennv_txtActionPerformed

    private void luong_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_luong_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_luong_txtActionPerformed

    private void chooseDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseDateActionPerformed
        DateChooser date = new DateChooser();
        date.setTextRefernce(namsinh_txt);
        date.showPopup(chooseDate, - 186, -130);
    }//GEN-LAST:event_chooseDateActionPerformed

    private void chooseDate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseDate1ActionPerformed
        DateChooser date = new DateChooser();
        date.setTextRefernce(ngaybatdau_txt);
        date.showPopup(chooseDate1, - 186, -130);
    }//GEN-LAST:event_chooseDate1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.UIComponents.Combobox ChonGioiTinh;
    private GUI.UIComponents.Button ChooseIMG;
    private javax.swing.JLabel IMG;
    private GUI.UIComponents.Button add_btn;
    private GUI.UIComponents.Button chooseDate;
    private GUI.UIComponents.Button chooseDate1;
    private GUI.UIComponents.Button delete_btn;
    private GUI.UIComponents.TextField diachi_txt;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private GUI.UIComponents.TextField luong_txt;
    private GUI.UIComponents.TextField manv_txt;
    private GUI.UIComponents.TextField namsinh_txt;
    private GUI.UIComponents.TextField ngaybatdau_txt;
    private GUI.UIComponents.Panel.PanelBorder panelBorder1;
    private GUI.UIComponents.Button save_btn;
    private GUI.UIComponents.TextField sdt_txt;
    private GUI.UIComponents.Table.Table table_NhanVien;
    private GUI.UIComponents.TextField tennv_txt;
    // End of variables declaration//GEN-END:variables

    private void setToDefault() {
 
        nhanvien = null;
        table_NhanVien.clearSelection();
        RowSelected = -1;
        
        manv_txt.setText("");
        tennv_txt.setText("");
        sdt_txt.setText("");
        ngaybatdau_txt.setText("");
        namsinh_txt.setText("");
        diachi_txt.setText("");
        luong_txt.setText("");
        ChonGioiTinh.setSelectedIndex(-1);
        
    }
}
