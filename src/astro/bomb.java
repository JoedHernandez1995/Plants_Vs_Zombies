package astro;

import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class bomb extends Plant {

    public bomb() {
        super();
    }

    public bomb(int x, int y) {
        super(x, y);
        this.x = x;
        this.y = y;
        this.visible = true;
        this.life = 100;
        ImageIcon icon = new ImageIcon(this.getClass().getResource("bomb.png"));
        this.image = icon.getImage();
        this.width = 50;
        this.height = 50;
        this.collisionBox = new Rectangle(this.x, this.y, this.height, this.width);
    }

    @Override
    public String toString() {
        return "Bomba";
    }
    
    
}
