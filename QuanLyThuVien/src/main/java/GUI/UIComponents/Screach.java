
package GUI.UIComponents;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;


public class Screach extends javax.swing.JPanel {

   
    public Screach() {
        initComponents();
        setOpaque(false);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exit1 = new GUI.UIComponents.Exit();
        Screach_button = new javax.swing.JLabel();
        screachText2 = new GUI.UIComponents.ScreachText();

        setBackground(new java.awt.Color(255, 255, 255));

        Screach_button.setForeground(new java.awt.Color(0, 0, 0));
        Screach_button.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Screach_button.setIcon(new FlatSVGIcon("IMG/icon/search.svg",25,25)
        );
        Screach_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        screachText2.setForeground(new java.awt.Color(0, 0, 0));
        screachText2.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Screach_button, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(screachText2, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(exit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
            .addComponent(Screach_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(screachText2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    @Override
    protected void paintComponent(Graphics g) {
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(0, 0, 25, getHeight());
        g2.fillRect(getWidth()-25, getHeight()-25, getWidth(), getHeight());
        super.paintComponent(g);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Screach_button;
    private GUI.UIComponents.Exit exit1;
    private GUI.UIComponents.ScreachText screachText2;
    // End of variables declaration//GEN-END:variables
}
