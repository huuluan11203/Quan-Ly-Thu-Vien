
package GUI.swing;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;


public class HighRE {

    public HighRE() {
    }
        
    public ImageIcon setHighRE(ImageIcon originalIcon){
        Image originalImage = originalIcon.getImage();
        int targetWidth = 160; // Set the desired JLabel width
        int targetHeight = 200; // Set the desired JLabel height
        Image scaledImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        return  scaledIcon;
    }
    
    public ImageIcon setIconJPG(String path, String dir){
        URL urlIcon = getClass().getResource("/IMG/"+ dir + "/" + path);
        Image originalImage = new ImageIcon(urlIcon).getImage();
        int targetWidth = 150; // Set the desired JLabel width
        int targetHeight = 180; // Set the desired JLabel height
        Image scaledImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(scaledImage);
        return icon;
        
    }
    
    
    public String getPath(ImageIcon icon){
        return "";
    }
}
