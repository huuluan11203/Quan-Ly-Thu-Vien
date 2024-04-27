
package GUI.UIComponents.Menu;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class Model_Menu {
    
    
    private String icon;
    private String name;
    private MenuType type;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MenuType getType() {
        return type;
    }

    public void setType(MenuType type) {
        this.type = type;
    }
    
    public static enum MenuType{
        TITLE, MENU, EMPTY
    }

    public Model_Menu(String icon, String name, MenuType type) {
        this.icon = icon;
        this.name = name;
        this.type = type;
    }

    public Model_Menu() {
    }
    

    public FlatSVGIcon toIcon(){
//        ImageIcon ii = new ImageIcon(getClass().getResource("/IMG/icon/" + icon + ".png"));
//        return new HighRE().setHighRE(ii);
        return new FlatSVGIcon("IMG/icon/" + icon + ".svg", 25, 25);
    }
    
   
    
}
