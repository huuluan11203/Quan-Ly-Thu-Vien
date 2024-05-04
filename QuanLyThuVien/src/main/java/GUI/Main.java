
package GUI;



import DTO.NhanVien;
import GUI.UIComponents.Form_DocGia;
import GUI.UIComponents.Form_MuonSach;
import GUI.UIComponents.Form_NXB;
import GUI.UIComponents.Form_NhanVien;
import GUI.UIComponents.Form_NhapSach;
import GUI.UIComponents.Form_Sach;
import GUI.UIComponents.Form_TacGia;
import GUI.UIComponents.Form_TheLoai;
import GUI.UIComponents.Form_TheThuVien;
import GUI.UIComponents.Form_ThongTin;
import GUI.UIComponents.Form_TrangChu;
import GUI.UIComponents.Menu.EventMenuSelected;
import GUI.UIComponents.Table.Table;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import raven.toast.Notifications;
import raven.toast.ToastClientProperties;



public class Main extends javax.swing.JFrame {
    
    private static NhanVien nv;
    
    private static Form_TrangChu trangchu;
    private static Form_Sach sach;
    private static Form_TheLoai theloai;
    private static Form_NXB nhaxuatban;
    private static Form_TacGia tacgia;
    private static Form_NhapSach nhapsach;
    private static Form_MuonSach muonsach;
    private static Form_DocGia docgia;
    private static Form_NhanVien nhanvien;
    private static Form_TheThuVien thethuvien;
    private static Form_ThongTin thongtin;
  
    public Main(NhanVien nhanvien) {
        Main.nv = nhanvien;
        initComponents();
        setBackground(new Color(0,0,0,0));
        
        trangchu = new Form_TrangChu();
        sach = new Form_Sach();
        theloai = new Form_TheLoai();
        nhaxuatban = new Form_NXB();
        tacgia = new Form_TacGia();
        nhapsach = new Form_NhapSach();
        muonsach = new Form_MuonSach();
        docgia = new Form_DocGia();
        Main.nhanvien = new Form_NhanVien();
        thethuvien = new Form_TheThuVien();
        thongtin = new Form_ThongTin(Main.nv);

        
  
        setForm(trangchu);
        
        Notifications.getInstance().setJFrame(this);
        
        // Di chuyen ung dung
        menu1.initMoving(Main.this);
        menu1.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                if (index == 0) {
                    setForm(trangchu);
                    
                }else if (index == 3) {
                    setForm(sach);
                    
                }else if (index == 4) {
                    setForm(theloai);
                    
                }else if (index == 5) {
                    setForm(nhaxuatban);
                    
                }else if (index == 6) {
                    setForm(tacgia);
                    
                }else if (index == 7) {
                    setForm(nhapsach);
                    
                }else if (index == 8) {
                    setForm(muonsach);
                    
                }else if (index == 11) {
                    setForm(docgia);
                    
                }else if (index == 12) {
                    setForm(Main.nhanvien);
                    
                }else if (index == 13) {
                    setForm(thethuvien);
                    
                }else if (index == 15) {
                    setForm(thongtin);
                    
                }else if (index == 16) {
                    DangXuat();
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
    
    private void TimKiem(Table table){
        
    }

    
    private void DangXuat(){
        ImageIcon icon = new FlatSVGIcon("IMG/icon/warning.svg",30,30);
            String[] cf = {"Đồng ý", "Hủy"};
            int choice = JOptionPane.showOptionDialog(null,"Đăng Xuất ?","Xác Nhận",
                     JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, cf ,null);
            if (choice == 0) {
                setVisible(false);
                dispose();
                new Login();
            }
        
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
            new Main(nv).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainPanel;
    private GUI.UIComponents.Menu.Menu menu1;
    private GUI.UIComponents.Panel.PanelBorder panelBorder2;
    private GUI.UIComponents.Screach screach1;
    // End of variables declaration//GEN-END:variables
}
