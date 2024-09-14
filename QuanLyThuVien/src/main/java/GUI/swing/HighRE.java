
package GUI.swing;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
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
        URL urlIcon = getClass().getClassLoader().getResource("IMG/"+ dir + "/" + path);
        System.out.println("hceck:" + urlIcon);
        Image originalImage = new ImageIcon(urlIcon).getImage();
        int targetWidth = 190; // Set the desired JLabel width
        int targetHeight = 250; // Set the desired JLabel height
        Image scaledImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(scaledImage);
        return icon;
        
      
        
    }
    
    
    public String getPath(ImageIcon icon){
        return "";
    }
}
