
package GUI.UIComponents.Table;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;


public class TableStatus extends JLabel{
    
    private StatusType type;
    
    public StatusType getType(){
        return type;
    }

    public TableStatus() {
        setForeground(Color.WHITE);
    }
    
    public void setType(StatusType type){
        this.type = type;
        setText(type.toString());
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (type != null) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            GradientPaint gp;
        
            if (type == StatusType.ĐangMượn) {
                gp = new GradientPaint(0, 0, new Color(186,123,247), 0, getHeight(), new Color(167,94,236));
            }else if (type == StatusType.ĐãTrả) {
                gp = new GradientPaint(0, 0, new Color(142, 142, 250), 0, getHeight(), new Color(123, 123, 247));
            }else {
                gp = new GradientPaint(0, 0, new Color(255, 0, 0 ), 0, getHeight(), new Color(239, 30, 30));
            }
            g2.setPaint(gp);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 1, 1);
            }
        super.paintComponent(g); 
    }
    
    
}
