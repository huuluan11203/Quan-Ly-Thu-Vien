
package GUI.UIComponents;

import BUS.LoaiSach_BUS;
import BUS.NhaXuatBan_BUS;
import BUS.Sach_BUS;
import BUS.TacGia_BUS;
import DTO.Sach;
import GUI.Main;
import GUI.UIComponents.DATE.DateChooser;
import GUI.UIComponents.FileChooser.JnaFileChooser;
import GUI.UIComponents.Table.Table;
import GUI.swing.HighRE;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import raven.toast.Notifications;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.time.LocalDate;
import javax.swing.JOptionPane;


public class Form_Sach extends javax.swing.JPanel {

    private Main main;
    private static Sach sach;
    private Sach_BUS sach_BUS;
    private NhaXuatBan_BUS nhaXuatBan_BUS;
    private LoaiSach_BUS loaiSach_BUS;
    private TacGia_BUS tacGia_BUS;
    
    private boolean isChoosed;
    private int RowSelected = -1;
    
    JnaFileChooser ch;
    ImageIcon defaultIMG =new FlatSVGIcon("IMG/sach/default.svg",150,180);

    
    
    public Form_Sach() {
        initComponents();
        
        sach_BUS = new Sach_BUS();
        tacGia_BUS = new TacGia_BUS();
        nhaXuatBan_BUS = new NhaXuatBan_BUS();
        loaiSach_BUS = new LoaiSach_BUS();
        
        jScrollPane.setVerticalScrollBar(new ScrollBar());
        jScrollPane.getVerticalScrollBar().setBackground(Color.WHITE);
        
        sach_BUS.RenderSach(table_Sach);
        nhaXuatBan_BUS.ChonNXB(ChonNXB);
        tacGia_BUS.ChonTG(ChonTG);
        loaiSach_BUS.ChonLoaiSach(ChonTheLoai);
        
        ChonNXB.setSelectedIndex(-1);
        ChonTG.setSelectedIndex(-1);
        ChonTheLoai.setSelectedIndex(-1);
        
        initEvent();
        
        
        
        
    }
    
    public Table getTable(){
        return table_Sach;
    }

    private void initEvent(){

        table_Sach.addMouseListener(new java.awt.event.MouseAdapter() { // row is clicked
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if (SwingUtilities.isLeftMouseButton(evt)) {
                        
                        RowSelected = table_Sach.getSelectedRow();
                        
                        sach = sach_BUS.SelectedSach(Integer.parseInt(table_Sach.getModel().
                                getValueAt(RowSelected, 0).toString()));
                        
                        masach_txt.setEnabled(false);
                        tensach_txt.setText(sach.getTenSach());
                        ChonNXB.setItemCombobox(sach_BUS.getTenNXB(sach.getMaNXB()));
                        ChonTG.setItemCombobox(tacGia_BUS.getTTG(sach.getMaTacGia()));
                        ChonTheLoai.setItemCombobox(loaiSach_BUS.getTenLoaiSach(sach.getMaLoaiSach()));
                        masach_txt.setText(Integer.toString(sach.getMaSach()));
                        soluong_txt.setText(Integer.toString(sach.getSoLuong()));
                        namxuatban_txt.setText(sach_BUS.FormatDate(sach.getNamXuatBan()));
                        if (!sach.getImgSach().equals("default.svg")) {
                            IMG.setIcon(new HighRE().setIconJPG(sach.getImgSach(), "Sach"));
                            
                        }else {
                            IMG.setIcon(defaultIMG);
                        }
                        
                    }
                    
                }

            });
    }
      
      
    private void setToDefault(){
        RowSelected = -1;
        table_Sach.clearSelection();
        tensach_txt.setText("");
        ChonNXB.setSelectedIndex(-1);
        ChonTG.setSelectedIndex(-1);
        ChonTheLoai.setSelectedIndex(-1);
        masach_txt.setText("");
        soluong_txt.setText("");
        namxuatban_txt.setText("");
        IMG.setIcon(defaultIMG);
        masach_txt.setEnabled(true);
        sach = null;
    }
    
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane = new javax.swing.JScrollPane();
        table_Sach = new GUI.UIComponents.Table.Table();
        panelBorder1 = new GUI.UIComponents.Panel.PanelBorder();
        IMG = new javax.swing.JLabel();
        ChooseIMG = new GUI.UIComponents.Button();
        delete_btn = new GUI.UIComponents.Button();
        save_btn = new GUI.UIComponents.Button();
        add_btn = new GUI.UIComponents.Button();
        tensach_txt = new GUI.UIComponents.TextField();
        jlabell1 = new javax.swing.JLabel();
        soluong_txt = new GUI.UIComponents.TextField();
        masach_txt = new GUI.UIComponents.TextField();
        jlabel = new javax.swing.JLabel();
        ChonTG = new GUI.UIComponents.Combobox();
        ChonTheLoai = new GUI.UIComponents.Combobox();
        jLabel2 = new javax.swing.JLabel();
        ChonNXB = new GUI.UIComponents.Combobox();
        jLabel3 = new javax.swing.JLabel();
        namxuatban_txt = new GUI.UIComponents.TextField();
        chooseDate = new GUI.UIComponents.Button();

        setBackground(new Color(0,0,0,0)
        );

        table_Sach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sách", "Tên sách", "Nhà xuất bản", "Năm xuất bản", "Tác giả", "SL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_Sach.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jScrollPane.setViewportView(table_Sach);
        if (table_Sach.getColumnModel().getColumnCount() > 0) {
            table_Sach.getColumnModel().getColumn(0).setMaxWidth(60);
            table_Sach.getColumnModel().getColumn(2).setMinWidth(220);
            table_Sach.getColumnModel().getColumn(3).setMinWidth(90);
            table_Sach.getColumnModel().getColumn(3).setMaxWidth(90);
            table_Sach.getColumnModel().getColumn(5).setMinWidth(40);
            table_Sach.getColumnModel().getColumn(5).setMaxWidth(40);
        }

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        IMG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IMG.setIcon(new FlatSVGIcon("IMG/sach/default.svg",150,180));
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

        add_btn.setIcon(new FlatSVGIcon("IMG/icon/add.svg",30,30));
        add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btnActionPerformed(evt);
            }
        });
        panelBorder1.add(add_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 6, 41, 42));

        tensach_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder1.add(tensach_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 58, 290, 50));

        jlabell1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jlabell1.setForeground(new java.awt.Color(150, 150, 150));
        jlabell1.setText("Số lượng");
        panelBorder1.add(jlabell1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, -1, -1));

        soluong_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder1.add(soluong_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 116, 160, 50));

        masach_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder1.add(masach_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 8, 130, 50));

        jlabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jlabel.setForeground(new java.awt.Color(150, 150, 150));
        jlabel.setText("Năm xuất bản");
        panelBorder1.add(jlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 72, -1, -1));

        ChonTG.setLabeText("Tác giả");
        panelBorder1.add(ChonTG, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 116, 340, 40));

        ChonTheLoai.setLabeText("Loại sách");
        panelBorder1.add(ChonTheLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 170, 234, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(150, 150, 150));
        jLabel2.setText("Mã sách");
        panelBorder1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 22, 60, -1));

        ChonNXB.setLabeText("Nhà xuất bản");
        panelBorder1.add(ChonNXB, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 170, 340, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(150, 150, 150));
        jLabel3.setText("Tên sách");
        panelBorder1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 72, 60, -1));

        namxuatban_txt.setDisabledTextColor(new java.awt.Color(80, 80, 80));
        namxuatban_txt.setEnabled(false);
        namxuatban_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder1.add(namxuatban_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 58, 130, 50));

        chooseDate.setBackground(new Color(0,0,0,0));
        chooseDate.setIcon(new FlatSVGIcon("IMG/icon/calendar.svg",30,30));
        chooseDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseDateActionPerformed(evt);
            }
        });
        panelBorder1.add(chooseDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 67, 30, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void ChooseIMGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChooseIMGActionPerformed
        ch = new JnaFileChooser();
        isChoosed = ch.showOpenDialog(main);
        if (isChoosed) {
            String imagePath = ch.getSelectedFile().toString();
            String path = imagePath.substring(imagePath.lastIndexOf("\\"  ) + 1);
            if (path.equals("default.svg")) {
                IMG.setIcon(defaultIMG);
            }else{
                IMG.setIcon(new HighRE().setIconJPG(path, "Sach"));
            }
        }
    }//GEN-LAST:event_ChooseIMGActionPerformed

    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed
        
        //remove data selected
        setToDefault();
        
    }//GEN-LAST:event_add_btnActionPerformed

    private void chooseDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseDateActionPerformed
        DateChooser date = new DateChooser();
        date.setTextRefernce(namxuatban_txt);
        date.showPopup(chooseDate, - 186, -6);
        
    }//GEN-LAST:event_chooseDateActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
//        Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, "Hello");
        if (RowSelected != -1) {
            ImageIcon icon = new FlatSVGIcon("IMG/icon/warning.svg",30,30);
            String[] cf = {"Đồng ý", "Hủy"};
            int choice = JOptionPane.showOptionDialog(null,"Xóa sách \"" + sach.getTenSach()+"\" ?","Xác Nhận",
                     JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, cf ,null);
            if (choice == 0) {
                
                if (sach_BUS.XoaSach(sach)) {
                    table_Sach.deleteRow(RowSelected);
                    Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 
                    "Xóa sách thành công.");
                    setToDefault();
                    
                }
            }
        }else{
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Vui lòng chọn sách.");
        }
       
    }//GEN-LAST:event_delete_btnActionPerformed

    private void save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btnActionPerformed
        
        boolean checked = false;
        
        int soluong = -1;
        int masach = -1;
        int maloaisach = -1;
        int manxb = -1;
        int matacgia = -1;
        String tensach = "";
        LocalDate date = LocalDate.now();
        String ghichu = "";
        String hinhanh = "";
        
            try {

                soluong = Integer.parseInt(soluong_txt.getText());
                masach = Integer.parseInt(masach_txt.getText());
                maloaisach = loaiSach_BUS.getMaloaiSach(ChonTheLoai.getSelectedItem().toString());
                manxb = nhaXuatBan_BUS.getManhaxuatban(ChonNXB.getSelectedItem().toString());
                matacgia = tacGia_BUS.getMatacgia(ChonTG.getSelectedItem().toString());
                tensach = tensach_txt.getText();
                date = sach_BUS.FormatDateSQL(namxuatban_txt.getText());
                ghichu = "";
                if (isChoosed) {
                    String path = ch.getSelectedFile().toString();
                    hinhanh = path.substring(path.lastIndexOf("\\"  ) + 1);
                    isChoosed = false;
                }else {
                    if (sach == null) {
                        hinhanh = "default.svg";
                    }else{
                        hinhanh = sach.getImgSach();
                    }
                }
                
                checked = true;
                
                } catch (Exception e) {
                    checked = false;
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Dữ liệu không đúng định dạng.");
                }
        if (checked){  
            if (RowSelected == -1 && sach == null) {
                
                sach = new Sach(masach, tensach, hinhanh, maloaisach, manxb, matacgia, date, soluong, ghichu);

                if (sach_BUS.ThemSach(sach)) {

                    Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 
                    "Thêm sách thành công.");
                    table_Sach.addRow(new Object[] {masach, tensach, ChonNXB.getSelectedItem().toString(), 
                        namxuatban_txt.getText(), ChonTG.getSelectedItem().toString(), soluong});

                }else {
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Sách đã tồn tại.");
                } 

            sach = null;

        }else { 

            Sach sachUpdate = new Sach(masach, tensach, hinhanh, maloaisach, manxb, matacgia, date, soluong, ghichu);

            if (sach_BUS.SuaSach(sachUpdate,sach)) {

                table_Sach.updateRow(RowSelected, new Object[]{masach, tensach, ChonNXB.getSelectedItem().toString(), 
                    namxuatban_txt.getText(), ChonTG.getSelectedItem().toString(), soluong});
                if (hinhanh.equals("default.svg")) {
                    IMG.setIcon(defaultIMG);
                }else{
                    IMG.setIcon(new HighRE().setIconJPG(sachUpdate.getImgSach(), "Sach"));
                }
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 
                    "Lưu thành công.");
                sach = sachUpdate;
                sachUpdate = null;
            }else {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Lưu không thành công.");
            }

        }
        }
        
    }//GEN-LAST:event_save_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.UIComponents.Combobox ChonNXB;
    private GUI.UIComponents.Combobox ChonTG;
    private GUI.UIComponents.Combobox ChonTheLoai;
    private GUI.UIComponents.Button ChooseIMG;
    private javax.swing.JLabel IMG;
    private GUI.UIComponents.Button add_btn;
    private GUI.UIComponents.Button chooseDate;
    private GUI.UIComponents.Button delete_btn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel jlabel;
    private javax.swing.JLabel jlabell1;
    private GUI.UIComponents.TextField masach_txt;
    private GUI.UIComponents.TextField namxuatban_txt;
    private GUI.UIComponents.Panel.PanelBorder panelBorder1;
    private GUI.UIComponents.Button save_btn;
    private GUI.UIComponents.TextField soluong_txt;
    private GUI.UIComponents.Table.Table table_Sach;
    private GUI.UIComponents.TextField tensach_txt;
    // End of variables declaration//GEN-END:variables
}
