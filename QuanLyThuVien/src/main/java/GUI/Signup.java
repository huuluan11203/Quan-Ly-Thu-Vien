

package GUI;


import BUS.Account_BUS;
import java.awt.Color;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import raven.toast.Notifications;


public class Signup extends javax.swing.JFrame {

    private static Account_BUS account_BUS;
    
    public Signup() {
        initComponents();
        account_BUS = new Account_BUS();
        setBackground(new Color(0, 0, 0, 0));
        setVisible(true);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login_Panel1 = new GUI.UIComponents.Panel.Login_Panel();
        exit2 = new GUI.UIComponents.Exit();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        username_txt = new javax.swing.JTextField();
        passwd_txt = new javax.swing.JPasswordField();
        confirm_psswd = new javax.swing.JPasswordField();
        BackToLogin = new javax.swing.JLabel();
        submit = new GUI.UIComponents.Button();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        login_Panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        login_Panel1.add(exit2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 44)); // NOI18N
        jLabel1.setForeground(Color.decode("#1da1f2")
        );
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ĐĂNG KÝ");
        login_Panel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 27, 400, 60));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(80, 80, 80));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Tài khoản");
        login_Panel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 125, 333, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(80, 80, 80));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Mật khẩu");
        login_Panel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 195, 333, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(80, 80, 80));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Nhập lại mật khẩu");
        login_Panel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 265, 333, -1));

        jLabel5.setForeground(new java.awt.Color(80, 80, 80));
        jLabel5.setText("_______________________________________________________________");
        login_Panel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 160, 302, -1));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("_______________________________________________________________");
        login_Panel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 300, 302, -1));

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("_______________________________________________________________");
        login_Panel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 230, 302, -1));

        username_txt.setBackground(new Color(0,0,0,0)
        );
        username_txt.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        username_txt.setForeground(new java.awt.Color(0, 0, 0));
        username_txt.setBorder(null);
        username_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                username_txtFocusGained(evt);
            }
        });
        username_txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                username_txtMouseClicked(evt);
            }
        });
        login_Panel1.add(username_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 140, 302, 40));

        passwd_txt.setBackground(new Color(0,0,0,0));
        passwd_txt.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        passwd_txt.setForeground(new java.awt.Color(0, 0, 0));
        passwd_txt.setBorder(null);
        passwd_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwd_txtFocusGained(evt);
            }
        });
        passwd_txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passwd_txtMouseClicked(evt);
            }
        });
        login_Panel1.add(passwd_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 210, 302, 40));

        confirm_psswd.setBackground(new Color(0,0,0,0));
        confirm_psswd.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        confirm_psswd.setForeground(new java.awt.Color(0, 0, 0));
        confirm_psswd.setBorder(null);
        confirm_psswd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                confirm_psswdFocusGained(evt);
            }
        });
        confirm_psswd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirm_psswdMouseClicked(evt);
            }
        });
        login_Panel1.add(confirm_psswd, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 280, 302, 40));

        BackToLogin.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        BackToLogin.setForeground(Color.decode("#0d2aaf"));
        BackToLogin.setText("Đăng Nhập");
        BackToLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BackToLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackToLoginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BackToLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BackToLoginMouseExited(evt);
            }
        });
        login_Panel1.add(BackToLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 470, -1, 26));

        submit.setBackground(Color.decode("#1da1f2")
        );
        submit.setForeground(new java.awt.Color(255, 255, 255));
        submit.setText("Đăng ký");
        submit.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        login_Panel1.add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 300, -1));

        jCheckBox1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(80, 80, 80));
        jCheckBox1.setText("Hiện mật khẩu");
        jCheckBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        login_Panel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(login_Panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(login_Panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void username_txtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_username_txtFocusGained

    }//GEN-LAST:event_username_txtFocusGained

    private void username_txtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_username_txtMouseClicked

    }//GEN-LAST:event_username_txtMouseClicked

    private void passwd_txtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwd_txtFocusGained

    }//GEN-LAST:event_passwd_txtFocusGained

    private void passwd_txtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwd_txtMouseClicked
 
    }//GEN-LAST:event_passwd_txtMouseClicked

    private void confirm_psswdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_confirm_psswdFocusGained

    }//GEN-LAST:event_confirm_psswdFocusGained

    private void confirm_psswdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirm_psswdMouseClicked
       
    }//GEN-LAST:event_confirm_psswdMouseClicked

    private void BackToLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackToLoginMouseClicked
        if (SwingUtilities.isLeftMouseButton(evt)) {
            this.setVisible(false);
            this.dispose();
            new Login();
        }
    }//GEN-LAST:event_BackToLoginMouseClicked

    private void BackToLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackToLoginMouseEntered
        BackToLogin.setForeground(Color.decode("#6f89ff"));
    }//GEN-LAST:event_BackToLoginMouseEntered

    private void BackToLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackToLoginMouseExited
        BackToLogin.setForeground(Color.decode("#0d2aaf"));
    }//GEN-LAST:event_BackToLoginMouseExited

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
         
        String username = "";
        String psswd = "";
        String confirm = "";
        try {
                username = username_txt.getText();
                psswd = String.valueOf(passwd_txt.getPassword());
                confirm = String.valueOf(confirm_psswd.getPassword());
                
                
            } catch (NullPointerException e) {
               Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
                    "Dữ liệu không đúng định dạng.");
            }
         
        if (account_BUS.Check_Signup(username, psswd, confirm)) {
           dispose();
           setVisible(false);
           new Login().setVisible(true);
        }
    }//GEN-LAST:event_submitActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
       if ( passwd_txt.getEchoChar() != '\u0000' && confirm_psswd.getEchoChar() != '\u0000') {
            passwd_txt.setEchoChar('\u0000');
            passwd_txt.requestFocus();
            confirm_psswd.setEchoChar('\u0000');
            confirm_psswd.requestFocus();
        } else {
            passwd_txt.setEchoChar((Character) UIManager.get("PasswordField.echoChar"));
            passwd_txt.requestFocus();
            confirm_psswd.setEchoChar((Character) UIManager.get("PasswordField.echoChar"));
            confirm_psswd.requestFocus();
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackToLogin;
    private javax.swing.JPasswordField confirm_psswd;
    private GUI.UIComponents.Exit exit2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private GUI.UIComponents.Panel.Login_Panel login_Panel1;
    private javax.swing.JPasswordField passwd_txt;
    private GUI.UIComponents.Button submit;
    private javax.swing.JTextField username_txt;
    // End of variables declaration//GEN-END:variables

}
