/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.UIComponents;

import BUS.Account_BUS;
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
    private static Accounts acc;
    ImageIcon defaultIMG = new FlatSVGIcon("IMG/NhanVien/default.svg");
    
    public Form_ThongTin(NhanVien nhanvien) {
        
        Form_ThongTin.nhanvien = nhanvien;
        account_BUS = new Account_BUS();
        acc = account_BUS.SelectedAcc(nhanvien.getMaNV());
        initComponents();
        initEvent();
    }
    
    private void initEvent(){
        if (nhanvien.getHinhAnh().equals("default.svg")) {
            imageAvatar.setIcon(defaultIMG);
        }else{
            imageAvatar.setIcon(new HighRE().setIconJPG(nhanvien.getHinhAnh(), "NhanVien"));
        }
        
        matk_txt.setText(Integer.toString(nhanvien.getMaNV()));
        matk_txt.setEditable(false);
        
        mk_txt.setText(acc.getMatKhau());
        mk_txt.setEditable(false);
        
        tdn_txt.setText(acc.getTenDangNhap());
        tdn_txt.setEditable(false);
        
        tennv_txt.setText(nhanvien.getTenNV());
        tennv_txt.setEditable(false);
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
        ChooseIMG1 = new GUI.UIComponents.Button();

        setBackground(new java.awt.Color(255, 255, 255));

        imageAvatar.setForeground(new java.awt.Color(204, 204, 204));
        imageAvatar.setBorderSize(3);

        matk_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(150, 150, 150));
        jLabel5.setText("Mã Tài Khoản");

        mk_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N

        tdn_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(150, 150, 150));
        jLabel6.setText("Tên Đăng Nhập");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(150, 150, 150));
        jLabel7.setText("Mật Khẩu");

        tennv_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(150, 150, 150));
        jLabel8.setText("Tên Nhân Viên");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(150, 150, 150));

        ChooseIMG.setBackground(Color.decode("#00abfd")
        );
        ChooseIMG.setForeground(new java.awt.Color(255, 255, 255));
        ChooseIMG.setText("Đổi Mật Khẩu");
        ChooseIMG.setShadowColor(new java.awt.Color(3, 155, 216));
        ChooseIMG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChooseIMGActionPerformed(evt);
            }
        });

        ChooseIMG1.setBackground(Color.decode("#00abfd")
        );
        ChooseIMG1.setForeground(new java.awt.Color(255, 255, 255));
        ChooseIMG1.setText("Lưu");
        ChooseIMG1.setShadowColor(new java.awt.Color(3, 155, 216));
        ChooseIMG1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChooseIMG1ActionPerformed(evt);
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tdn_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mk_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tennv_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(119, 119, 119)
                        .addComponent(jLabel9)
                        .addContainerGap(332, Short.MAX_VALUE))
                    .addComponent(matk_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(ChooseIMG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(ChooseIMG1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ChooseIMG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChooseIMG1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ChooseIMGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChooseIMGActionPerformed
       mk_txt.setEditable(true);
    }//GEN-LAST:event_ChooseIMGActionPerformed

    private void ChooseIMG1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChooseIMG1ActionPerformed
        String mk = "";
        
        try {
            mk = mk_txt.getText();
            acc.setMatKhau(mk);
            if (mk.equals("")) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Mật khẩu không được rỗng.");
            }else{
                if (account_BUS.DoiMatKhau(acc)) {
                    Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 
                    "Đổi mật khẩu thành công.");
                }
            }
        } catch (Exception e) {
             Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Dữ liệu không đúng định dạng.");
        }
        
    }//GEN-LAST:event_ChooseIMG1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.UIComponents.Button ChooseIMG;
    private GUI.UIComponents.Button ChooseIMG1;
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
