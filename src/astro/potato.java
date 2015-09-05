package astro;

import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class potato extends Plant {

    public potato() {
        super();
    }

    public potato(int x, int y) {
        super(x, y);
        this.x = x;
        this.y = y;
        this.visible = true;
        this.life = 1000000;
        ImageIcon icon = new ImageIcon(this.getClass().getResource("potato.png"));
        this.image = icon.getImage();
        this.width = 50;
        this.height = 50;
        this.collisionBox = new Rectangle(this.x, this.y, this.height, this.width);
    }

    @Override
    public String toString() {
        return "Walnut";
    }
    
    
}
