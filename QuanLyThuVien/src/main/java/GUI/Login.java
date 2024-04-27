
package GUI;

import BUS.Account_BUS;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;



public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        setVisible(true);
    
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Login_Panel = new GUI.UIComponents.Panel.Login_Panel();
        Tittle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        taotaikhoan = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        username_txt = new javax.swing.JTextField();
        passwd_txt = new javax.swing.JPasswordField();
        err_Message = new javax.swing.JLabel();
        exit1 = new GUI.UIComponents.Exit();
        jLabel5 = new javax.swing.JLabel();
        submit = new GUI.UIComponents.Button();
        toggle_pws = new GUI.UIComponents.CheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        Login_Panel.setForeground(new java.awt.Color(255, 153, 153));
        Login_Panel.setMaximumSize(new java.awt.Dimension(400, 500));
        Login_Panel.setMinimumSize(new java.awt.Dimension(400, 500));
        Login_Panel.setPreferredSize(new java.awt.Dimension(400, 500));
        Login_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tittle.setFont(new java.awt.Font("Arial", 1, 44)); // NOI18N
        Tittle.setForeground(Color.decode("#1da1f2")
        );
        Tittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tittle.setText("ĐĂNG NHẬP");
        Login_Panel.add(Tittle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 390, 60));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Tài khoản");
        Login_Panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 168, 333, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Mật khẩu");
        Login_Panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 233, 240, -1));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("_______________________________________________________________");
        Login_Panel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 201, 302, -1));

        taotaikhoan.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        taotaikhoan.setForeground(Color.decode("#0d2aaf"));
        taotaikhoan.setText("Tạo Tài Khoản");
        taotaikhoan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        taotaikhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                taotaikhoanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                taotaikhoanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                taotaikhoanMouseExited(evt);
            }
        });
        Login_Panel.add(taotaikhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 470, -1, 26));

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("_______________________________________________________________");
        Login_Panel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 269, 302, -1));

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
        Login_Panel.add(username_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 182, 302, 40));

        passwd_txt.setBackground(new Color(0,0,0,0));
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
        Login_Panel.add(passwd_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 249, 302, 40));

        err_Message.setBackground(new Color(0,0,0,0)
        );
        err_Message.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        err_Message.setForeground(Color.decode("#ff0000")
        );
        err_Message.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Login_Panel.add(err_Message, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 400, -1));

        exit1.setForeground(new java.awt.Color(255, 255, 255));
        Login_Panel.add(exit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setForeground(Color.decode("#1da1f2")
        );
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("  LiSM xin chào");
        jLabel5.setToolTipText("");
        Login_Panel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 400, 30));

        submit.setBackground(Color.decode("#1da1f2")
        );
        submit.setForeground(new java.awt.Color(255, 255, 255));
        submit.setText("Đăng nhập");
        submit.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        Login_Panel.add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 300, 60));

        toggle_pws.setForeground(new java.awt.Color(0, 0, 0));
        toggle_pws.setText("Hiện mât khẩu");
        toggle_pws.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        toggle_pws.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggle_pwsActionPerformed(evt);
            }
        });
        Login_Panel.add(toggle_pws, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Login_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Login_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getAccessibleContext().setAccessibleName("LOGIN");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void passwd_txtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwd_txtMouseClicked
        err_Message.setText("");
    }//GEN-LAST:event_passwd_txtMouseClicked

    private void passwd_txtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwd_txtFocusGained
        err_Message.setText("");
    }//GEN-LAST:event_passwd_txtFocusGained

    private void username_txtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_username_txtMouseClicked
        err_Message.setText("");
    }//GEN-LAST:event_username_txtMouseClicked

    private void username_txtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_username_txtFocusGained
        err_Message.setText("");
    }//GEN-LAST:event_username_txtFocusGained

    private void taotaikhoanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taotaikhoanMouseExited
        taotaikhoan.setForeground(Color.decode("#0d2aaf"));
    }//GEN-LAST:event_taotaikhoanMouseExited

    private void taotaikhoanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taotaikhoanMouseEntered
        taotaikhoan.setForeground(Color.decode("#6f89ff"));
    }//GEN-LAST:event_taotaikhoanMouseEntered

    private void taotaikhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taotaikhoanMouseClicked
        if (SwingUtilities.isLeftMouseButton(evt)) {
            this.setVisible(false);
            this.dispose();
            new Signup();
        }
    }//GEN-LAST:event_taotaikhoanMouseClicked

   
    
    
    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
     
            try {
                String username = username_txt.getText();
                String psswd = String.valueOf(passwd_txt.getPassword());

                if (username.equals("") || psswd.equals("")) {
                    err_Message.setText("Không được để trống.");
                }else{
                    if (new Account_BUS().Check_Login(username, psswd)) {

                        err_Message.setForeground(Color.GREEN);
                        err_Message.setText("Đăng nhập thành công.");
                        this.setVisible(false);
                        this.dispose();
                        new Main();

                    }else{

                        err_Message.setText("Sai thông tin");

                    }
                }

            } catch (NullPointerException e) {
                System.out.println(e);
            }

      
    }//GEN-LAST:event_submitActionPerformed

    private void toggle_pwsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggle_pwsActionPerformed
         
    if ( passwd_txt.getEchoChar() != '\u0000' ) {
            passwd_txt.setEchoChar('\u0000');
            passwd_txt.requestFocus();
        } else {
            passwd_txt.setEchoChar((Character) UIManager.get("PasswordField.echoChar"));
            passwd_txt.requestFocus();
        }
    }//GEN-LAST:event_toggle_pwsActionPerformed
    
   
    
    
   
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.UIComponents.Panel.Login_Panel Login_Panel;
    private javax.swing.JLabel Tittle;
    private javax.swing.JLabel err_Message;
    private GUI.UIComponents.Exit exit1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField passwd_txt;
    private GUI.UIComponents.Button submit;
    private javax.swing.JLabel taotaikhoan;
    private GUI.UIComponents.CheckBox toggle_pws;
    private javax.swing.JTextField username_txt;
    // End of variables declaration//GEN-END:variables
}
