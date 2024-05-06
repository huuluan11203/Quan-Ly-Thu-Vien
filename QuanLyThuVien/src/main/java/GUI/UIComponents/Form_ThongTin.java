/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.UIComponents;

import BUS.Account_BUS;
import BUS.NhanVien_BUS;
import DTO.Accounts;
import DTO.NhanVien;
import GUI.swing.HighRE;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import javax.swing.ImageIcon;
import raven.toast.Notifications;

/**
 *
 * @author huuluan
 */

public class Form_ThongTin extends javax.swing.JPanel {

    private static NhanVien nhanvien;
    private static Account_BUS account_BUS;
    private static NhanVien_BUS nhanVien_BUS;
    private static Accounts acc;
    ImageIcon defaultIMG = new FlatSVGIcon("IMG/NhanVien/default.svg");
    
    public Form_ThongTin(Accounts accounts) {
        Form_ThongTin.acc = accounts;
        
        initComponents();
        nhanVien_BUS = new NhanVien_BUS(); 
        account_BUS = new Account_BUS();
        nhanvien = nhanVien_BUS.SelectedNhanVien(acc.getMaTaiKhoan());
        if (nhanvien != null) {
            initEvent();
        }else{
            imageAvatar.setIcon(defaultIMG);
            mk_txt.setText(acc.getMatKhau());
            mk_txt.setEditable(false);

            tdn_txt.setText(acc.getTenDangNhap());
            tdn_txt.setEnabled(false);
            
            tennv_txt.setEditable(false);
        }
        
      
        
    }
    
    private void initEvent(){
        if (nhanvien.getHinhAnh().equals("default.svg")) {
            imageAvatar.setIcon(defaultIMG);
        }else{
            imageAvatar.setIcon(new HighRE().setIconJPG(nhanvien.getHinhAnh(), "NhanVien"));
        }
        
        matk_txt.setText(Integer.toString(nhanvien.getMaNV()));
        matk_txt.setEnabled(false);
        
        mk_txt.setText(acc.getMatKhau());
        mk_txt.setEditable(false);
        
        tdn_txt.setText(acc.getTenDangNhap());
        tdn_txt.setEnabled(false);
        
        tennv_txt.setText(nhanvien.getTenNV());
        tennv_txt.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageAvatar = new GUI.swing.ImageAvatar();
        matk_txt = new GUI.UIComponents.TextField();
        jLabel5 = new javax.swing.JLabel();
        mk_txt = new GUI.UIComponents.TextField();
        tdn_txt = new GUI.UIComponents.TextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tennv_txt = new GUI.UIComponents.TextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ChooseIMG = new GUI.UIComponents.Button();
        Luu_btn = new GUI.UIComponents.Button();

        setBackground(new java.awt.Color(255, 255, 255));

        imageAvatar.setForeground(new java.awt.Color(204, 204, 204));
        imageAvatar.setBorderSize(3);

        matk_txt.setEnabled(false);
        matk_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(150, 150, 150));
        jLabel5.setText("Mã Tài Khoản");

        mk_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N

        tdn_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(150, 150, 150));
        jLabel6.setText("Tên Đăng Nhập");

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(150, 150, 150));
        jLabel7.setText("Mật Khẩu");

        tennv_txt.setEnabled(false);
        tennv_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(150, 150, 150));
        jLabel8.setText("Tên Nhân Viên");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(150, 150, 150));

        ChooseIMG.setBackground(Color.decode("#00abfd")
        );
        ChooseIMG.setForeground(new java.awt.Color(255, 255, 255));
        ChooseIMG.setText("Sửa thông tin");
        ChooseIMG.setShadowColor(new java.awt.Color(3, 155, 216));
        ChooseIMG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChooseIMGActionPerformed(evt);
            }
        });

        Luu_btn.setBackground(Color.decode("#00abfd")
        );
        Luu_btn.setForeground(new java.awt.Color(255, 255, 255));
        Luu_btn.setText("Lưu");
        Luu_btn.setShadowColor(new java.awt.Color(3, 155, 216));
        Luu_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Luu_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tdn_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mk_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tennv_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(119, 119, 119)
                        .addComponent(jLabel9))
                    .addComponent(matk_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imageAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(331, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(ChooseIMG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(Luu_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(imageAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(matk_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tdn_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mk_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tennv_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ChooseIMG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Luu_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ChooseIMGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChooseIMGActionPerformed
       mk_txt.setEditable(true);
        if (nhanvien == null) {
            matk_txt.setEnabled(true);
        }
    }//GEN-LAST:event_ChooseIMGActionPerformed

    private void Luu_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Luu_btnActionPerformed
        String mk = "";
        int matk = -1;
        boolean checked = false;
        try {
            mk = mk_txt.getText();
            if (nhanvien == null) {
                matk = Integer.parseInt(matk_txt.getText());
                acc.setMaTaiKhoan(matk);
            }
            acc.setMatKhau(mk);
            checked = true;
        } catch (Exception e) {
             Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Dữ liệu không đúng định dạng.");
        }
        
        if (checked) {
             if (account_BUS.DoiThongTin(acc)) {
                nhanvien = nhanVien_BUS.SelectedNhanVien(acc.getMaTaiKhoan());
                tennv_txt.setText(nhanvien.getTenNV());
                mk_txt.setEditable(false);
            }
        }
        
    }//GEN-LAST:event_Luu_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.UIComponents.Button ChooseIMG;
    private GUI.UIComponents.Button Luu_btn;
    private GUI.swing.ImageAvatar imageAvatar;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private GUI.UIComponents.TextField matk_txt;
    private GUI.UIComponents.TextField mk_txt;
    private GUI.UIComponents.TextField tdn_txt;
    private GUI.UIComponents.TextField tennv_txt;
    // End of variables declaration//GEN-END:variables
}
