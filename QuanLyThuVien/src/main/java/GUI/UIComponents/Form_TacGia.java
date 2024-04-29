
package GUI.UIComponents;

import BUS.TacGia_BUS;
import DTO.TacGia;
import GUI.Main;
import GUI.UIComponents.DATE.DateChooser;
import GUI.UIComponents.FileChooser.JnaFileChooser;
import GUI.swing.HighRE;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import raven.toast.Notifications;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;





public class Form_TacGia extends javax.swing.JPanel {
    
    private Main main;
    private static TacGia tacgia;
    private TacGia_BUS tacGia_BUS;
    
    private boolean isChoosed;
    private int RowSelected = -1;
    

    JnaFileChooser ch;
    ImageIcon defaultIMG = new FlatSVGIcon("IMG/TacGia/default.svg",150,150);
    
    
    public Form_TacGia() {
        initComponents();
        
        tacGia_BUS = new TacGia_BUS();
        
        jScrollPane2.setVerticalScrollBar(new ScrollBar());
        jScrollPane2.getVerticalScrollBar().setBackground(Color.WHITE);
        jScrollPane1.setVerticalScrollBar(new ScrollBar());
        jScrollPane1.getVerticalScrollBar().setBackground(Color.WHITE);
        
        
        tacGia_BUS.RenderTacGia(table_TacGia);
        table_TacGia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        
        initEvent();
        
    }
    
    private void initEvent(){
        table_TacGia.addMouseListener(new java.awt.event.MouseAdapter() { // row is clicked
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if (SwingUtilities.isLeftMouseButton(evt)) {
                        
                        RowSelected = table_TacGia.getSelectedRow();
                        
                        tacgia = tacGia_BUS.SelectedTacGia(Integer.parseInt(table_TacGia.getModel().
                                getValueAt(RowSelected, 0).toString()));
                        
                        matacgia_txt.setText(Integer.toString(tacgia.getMaTacGia()));
                        matacgia_txt.setEnabled(false);
                        tentacgia_txt.setText(tacgia.getTenTacGia());
                        namsinh_txt.setText(tacGia_BUS.FormatDate(tacgia.getNamSinh()));
                        diachi_txt.setText(tacgia.getDiachi());
                        gioithieu_txt.setText(tacgia.getGioiThieu());
                        if (!tacgia.getHinhanh().equals("default.svg")) {
                            IMG.setIcon(new HighRE().setIconJPG(tacgia.getHinhanh(), "TacGia"));

                        }else{
                            IMG.setIcon(defaultIMG);
                        }
                         
                    }
                    
                }

            });
    }
    
    
    public void setToDefault(){
        table_TacGia.clearSelection();
        RowSelected = -1;
        matacgia_txt.setText("");
        tentacgia_txt.setText("");
        namsinh_txt.setText("");
        diachi_txt.setText("");
        gioithieu_txt.setText("");
        IMG.setIcon(defaultIMG);
        tacgia = null;
        matacgia_txt.setEnabled(true);
        
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_TacGia = new GUI.UIComponents.Table.Table();
        panelBorder1 = new GUI.UIComponents.Panel.PanelBorder();
        namsinh_txt = new GUI.UIComponents.TextField();
        jLabel3 = new javax.swing.JLabel();
        chooseDate = new GUI.UIComponents.Button();
        add_btn = new GUI.UIComponents.Button();
        ChooseIMG = new GUI.UIComponents.Button();
        IMG = new javax.swing.JLabel();
        tentacgia_txt = new GUI.UIComponents.TextField();
        diachi_txt = new GUI.UIComponents.TextField();
        matacgia_txt = new GUI.UIComponents.TextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        delete_btn = new GUI.UIComponents.Button();
        save_btn = new GUI.UIComponents.Button();
        jScrollPane2 = new javax.swing.JScrollPane();
        gioithieu_txt = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new Color(0,0,0,0));
        setPreferredSize(new java.awt.Dimension(802, 645));

        table_TacGia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã tác giả", "Tên tác giả", "Năm sinh", "Dịa chỉ", "Giới thiệu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_TacGia.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        table_TacGia.setMinimumSize(new java.awt.Dimension(75, 417));
        jScrollPane1.setViewportView(table_TacGia);
        if (table_TacGia.getColumnModel().getColumnCount() > 0) {
            table_TacGia.getColumnModel().getColumn(0).setMaxWidth(80);
            table_TacGia.getColumnModel().getColumn(4).setMinWidth(200);
            table_TacGia.getColumnModel().getColumn(4).setMaxWidth(250);
        }
        table_TacGia.getAccessibleContext().setAccessibleName("");

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        namsinh_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder1.add(namsinh_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 130, 50));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(150, 150, 150));
        jLabel3.setText("Địa chỉ");
        panelBorder1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 175, 60, -1));

        chooseDate.setBackground(new Color(0,0,0,0));
        chooseDate.setIcon(new FlatSVGIcon("IMG/icon/calendar.svg",30,30));
        chooseDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseDateActionPerformed(evt);
            }
        });
        panelBorder1.add(chooseDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 30, 30));

        add_btn.setIcon(new FlatSVGIcon("IMG/icon/add.svg",30,30));
        add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btnActionPerformed(evt);
            }
        });
        panelBorder1.add(add_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 6, 41, 42));

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

        IMG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IMG.setIcon(new FlatSVGIcon("IMG/TacGia/default.svg",150,150));
        panelBorder1.add(IMG, new org.netbeans.lib.awtextra.AbsoluteConstraints(646, 6, 150, 180));

        tentacgia_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder1.add(tentacgia_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 160, 50));

        diachi_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder1.add(diachi_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 160, 50));

        matacgia_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder1.add(matacgia_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 160, 50));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(150, 150, 150));
        jLabel4.setText("Mã tác giả");
        panelBorder1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 24, 60, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(150, 150, 150));
        jLabel5.setText("Tên tác giả");
        panelBorder1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 75, 70, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(150, 150, 150));
        jLabel6.setText("Giới thiệu");
        panelBorder1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 60, -1));

        delete_btn.setIcon(new FlatSVGIcon("IMG/icon/delete.svg",30,30));
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });
        panelBorder1.add(delete_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(458, 6, 41, 42));

        save_btn.setIcon(new FlatSVGIcon("IMG/icon/save.svg",30,30));
        save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btnActionPerformed(evt);
            }
        });
        panelBorder1.add(save_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 6, 41, 42));

        gioithieu_txt.setBackground(new java.awt.Color(255, 255, 255));
        gioithieu_txt.setColumns(20);
        gioithieu_txt.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        gioithieu_txt.setForeground(new java.awt.Color(80, 80, 80));
        gioithieu_txt.setLineWrap(true);
        gioithieu_txt.setRows(5);
        gioithieu_txt.setWrapStyleWord(true);
        jScrollPane2.setViewportView(gioithieu_txt);

        panelBorder1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 350, 140));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(150, 150, 150));
        jLabel7.setText("Năm sinh");
        panelBorder1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 124, 60, -1));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chooseDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseDateActionPerformed
        DateChooser date = new DateChooser();
        date.setTextRefernce(namsinh_txt);
        date.showPopup(chooseDate, - 186, -50);

    }//GEN-LAST:event_chooseDateActionPerformed

    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed
        setToDefault();
    }//GEN-LAST:event_add_btnActionPerformed

    private void ChooseIMGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChooseIMGActionPerformed
        ch = new JnaFileChooser();
        isChoosed = ch.showOpenDialog(main);
        if (isChoosed) {
            String imagePath = ch.getSelectedFile().toString();
            IMG.setIcon(new HighRE().setIconJPG(imagePath.substring(imagePath.lastIndexOf("\\"  ) + 1), "TacGia"));
        }else {
            IMG.setIcon(defaultIMG);
        }
    }//GEN-LAST:event_ChooseIMGActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        if (RowSelected != -1) {
            ImageIcon icon = new FlatSVGIcon("IMG/icon/warning.svg",30,30);
            String[] cf = {"Đồng ý", "Hủy"};
            int choice = JOptionPane.showOptionDialog(null,"Xóa tác giả \"" + tacgia.getTenTacGia()+"\" ? \n Tất cả sách của tác giả cũng sẽ bị xóa.","Xác Nhận",
                     JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, cf ,null);
            if (choice == 0) {
                
                if (tacGia_BUS.XoaTacGia(tacgia)) {
                    table_TacGia.deleteRow(RowSelected);
                    setToDefault();                   
                }
            }
        }else{
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Vui lòng chọn tác giả.");
        }
       
    }//GEN-LAST:event_delete_btnActionPerformed

    private void save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btnActionPerformed
        
         boolean checked = false;
        
        int matacgia = -1;
        String tentacgia = "";
        LocalDate date = LocalDate.now();
        String gioithieu = "";
        String hinhanh = "";
        String diachi = "";
        
            try {

                matacgia = Integer.parseInt(matacgia_txt.getText());
                tentacgia = tentacgia_txt.getText();
                date = tacGia_BUS.FormatDateSQL(namsinh_txt.getText());
                gioithieu = gioithieu_txt.getText();
                diachi = diachi_txt.getText();
                
                if (isChoosed) {
                    String path = ch.getSelectedFile().toString();
                    hinhanh = path.substring(path.lastIndexOf("\\"  ) + 1);
                    isChoosed = false;
                }else {
                    if (tacgia == null) {
                        hinhanh = "default.svg";
                    }else{
                        hinhanh = tacgia.getHinhanh();
                    }
                }
                
                checked = true;
                
                } catch (Exception e) {
                    checked = false;
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Dữ liệu không đúng định dạng.");
                }
        if (checked){  
            if (RowSelected == -1 && tacgia == null) {
                
                tacgia = new TacGia(matacgia, tentacgia, date, diachi, hinhanh, gioithieu);

                if (tacGia_BUS.ThemTacGia(tacgia)) {

                    table_TacGia.addRow(new Object[] {matacgia, tentacgia, tacGia_BUS.FormatDate(date), diachi, gioithieu});
                    
                }
                tacgia = null;

            }else { 
                TacGia tg = new TacGia(matacgia, tentacgia, date, diachi, hinhanh, gioithieu);
                if (tacGia_BUS.SuaTacGia(tg, tacgia)) {

                    if (hinhanh.equals("default.svg")) {
                        IMG.setIcon(defaultIMG);
                    }else{
                        IMG.setIcon(new HighRE().setIconJPG(tg.getHinhanh(), "TacGia"));
                    }
                    table_TacGia.updateRow(RowSelected, new Object[] {matacgia, tentacgia, tacGia_BUS.FormatDate(date), diachi, gioithieu});                   
                    tacgia = tg;
                    tg = null;

                }
            }
        }
        
        
        
    }//GEN-LAST:event_save_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.UIComponents.Button ChooseIMG;
    private javax.swing.JLabel IMG;
    private GUI.UIComponents.Button add_btn;
    private GUI.UIComponents.Button chooseDate;
    private GUI.UIComponents.Button delete_btn;
    private GUI.UIComponents.TextField diachi_txt;
    private javax.swing.JTextArea gioithieu_txt;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private GUI.UIComponents.TextField matacgia_txt;
    private GUI.UIComponents.TextField namsinh_txt;
    private GUI.UIComponents.Panel.PanelBorder panelBorder1;
    private GUI.UIComponents.Button save_btn;
    private GUI.UIComponents.Table.Table table_TacGia;
    private GUI.UIComponents.TextField tentacgia_txt;
    // End of variables declaration//GEN-END:variables
}
