
package GUI.UIComponents.Menu;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;


public class Menu extends javax.swing.JPanel {
    
    private EventMenuSelected event;

    public void addEventMenuSelected(EventMenuSelected event) {
        this.event = event;
        listMenu1.addEventMenuSelected(event);
    }

 
    public Menu() {
        initComponents();
        setOpaque(false);
        listMenu1.setOpaque(false);
        init();
        
    }
    private void init(){
//        listMenu1.addItem(new Model_Menu("home", "Trang Chủ", Model_Menu.MenuType.MENU));
        
        listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu1.addItem(new Model_Menu("", "Quản Lý Sách", Model_Menu.MenuType.TITLE));
        listMenu1.addItem(new Model_Menu("book", "Sách", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("theloai", "Thể Loại", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("nxb", "Nhà Xuất Bản", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("tacgia", "Tác Giả", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("addbook", "Nhập Sách", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("borrow", "Mượn Sách", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu1.addItem(new Model_Menu("", "Quản Lý Người Dùng", Model_Menu.MenuType.TITLE));
        listMenu1.addItem(new Model_Menu("docgia", "Độc Giả", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("nv", "Nhân Viên", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("card", "Thẻ Thư Viện", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        
        listMenu1.addItem(new Model_Menu("tt", "Thông Tin", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("setting", "Đăng Xuất", Model_Menu.MenuType.MENU));
        
 
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        movingPanel = new javax.swing.JPanel();
        apl_label = new javax.swing.JLabel();
        listMenu1 = new GUI.UIComponents.Menu.ListMenu<>();

        setBackground(new Color(0,0,0,0)
        );
        setPreferredSize(new java.awt.Dimension(165, 665));

        movingPanel.setBackground(new Color(0,0,0,0)
        );
        movingPanel.setMaximumSize(new java.awt.Dimension(165, 32767));
        movingPanel.setMinimumSize(new java.awt.Dimension(165, 0));

        apl_label.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        apl_label.setForeground(new java.awt.Color(255, 255, 255));
        apl_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        apl_label.setText("Xin Chào");
        apl_label.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout movingPanelLayout = new javax.swing.GroupLayout(movingPanel);
        movingPanel.setLayout(movingPanelLayout);
        movingPanelLayout.setHorizontalGroup(
            movingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(apl_label, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
        );
        movingPanelLayout.setVerticalGroup(
            movingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(movingPanelLayout.createSequentialGroup()
                .addComponent(apl_label, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(movingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(movingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    protected void paintChildren(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp = new GradientPaint(0, 0, Color.decode(/*"#1da1f2"*/"#1cb5e0"), 0, getHeight(), Color.decode(/*"#0072ff"*/"#000046"));
        g2.setPaint(gp);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        super.paintChildren(g); 
    }
    
    private int x;
    private int y;
    
    public void initMoving(JFrame frame){
        movingPanel.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
            }
            
        });
        movingPanel.addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public void mouseDragged(MouseEvent e) {
               frame.setLocation(e.getXOnScreen() - x, e.getYOnScreen() -y);
            }
            
        });
        
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel apl_label;
    private GUI.UIComponents.Menu.ListMenu<String> listMenu1;
    private javax.swing.JPanel movingPanel;
    // End of variables declaration//GEN-END:variables
}
