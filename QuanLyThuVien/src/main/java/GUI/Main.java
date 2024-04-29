
package GUI;



import GUI.UIComponents.Form_MuonSach;
import GUI.UIComponents.Form_NXB;
import GUI.UIComponents.Form_NhapSach;
import GUI.UIComponents.Form_Sach;
import GUI.UIComponents.Form_TacGia;
import GUI.UIComponents.Form_TheLoai;
import GUI.UIComponents.Form_TrangChu;
import GUI.UIComponents.Menu.EventMenuSelected;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.UIManager;
import raven.toast.Notifications;
import raven.toast.ToastClientProperties;



public class Main extends javax.swing.JFrame {

  
    public Main() {
        
        initComponents();
        setBackground(new Color(0,0,0,0));
        
        Notifications.getInstance().setJFrame(this);
        
        // Di chuyen ung dung
        menu1.initMoving(Main.this);
        menu1.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                if (index == 0) {
                    setForm(new Form_TrangChu());
                }else if (index == 3) {
                    setForm(new Form_Sach());
                }else if (index == 4) {
                    setForm(new Form_TheLoai());
                }else if (index == 5) {
                    setForm(new Form_NXB());
                }else if (index == 6) {
                    setForm(new Form_TacGia());
                }else if (index == 7) {
                    setForm(new Form_NhapSach());
                }else if (index == 8) {
                    setForm(new Form_MuonSach());
                }else if (index == 6) {
                    setForm(new Form_TacGia());
                }else if (index == 7) {
                    setForm(new Form_NhapSach());
                }
            }
        });
        
    }

       private void setForm(JComponent com) {
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder2 = new GUI.UIComponents.Panel.PanelBorder();
        menu1 = new GUI.UIComponents.Menu.Menu();
        screach1 = new GUI.UIComponents.Screach();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setUndecorated(true);
        setResizable(false);

        panelBorder2.setBackground(new java.awt.Color(234, 234, 234));

        mainPanel.setOpaque(false);
        mainPanel.setPreferredSize(new java.awt.Dimension(802, 645));
        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(screach1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addComponent(screach1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    
   
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        FlatLaf.registerCustomDefaultsSource("raven.toast");
        FlatLightLaf.setup();
        UIManager.put(ToastClientProperties.TOAST_ERROR_ICON, new FlatSVGIcon("raven/toast/svg/error.svg"));
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainPanel;
    private GUI.UIComponents.Menu.Menu menu1;
    private GUI.UIComponents.Panel.PanelBorder panelBorder2;
    private GUI.UIComponents.Screach screach1;
    // End of variables declaration//GEN-END:variables
}
