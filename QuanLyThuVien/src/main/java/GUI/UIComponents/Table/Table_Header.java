
package GUI.UIComponents.Table;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;


public class Table_Header extends JLabel{

    
    public Table_Header(String txt) {
        super(txt);
        setOpaque(true);
        setBackground(Color.WHITE);
        setFont(new Font("arial", 1, 12));
        setForeground(new Color(102,102,102));
        setBorder(new EmptyBorder(10,5,10,5));
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g); 
        g.setColor(new Color(230, 230, 230));
        g.drawLine(0, getHeight()-1, getWidth(), getHeight()-1);
    }
    
    
}
