package astro;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Zombie {

    private int x;
    private int y;
    private int height;
    private int width;
    private boolean visible;
    private Image image;
    private Rectangle collisionBox;
    private int life;
    private boolean vive;

    public Zombie() {
    }

    public Zombie(int x, int y) {
        this.x = x;
        this.y = y;
        this.height = 70;
        this.width = 50;
        this.visible = true;
        this.life = 100;
        ImageIcon icon = new ImageIcon(this.getClass().getResource("zombie.png"));
        this.image = icon.getImage();
        this.collisionBox = new Rectangle(this.x, this.y, this.height, this.width);
        this.vive = true;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Rectangle getCollisionBox() {
        return collisionBox;
    }

    public void setCollisionBox(Rectangle collisionBox) {
        this.collisionBox = collisionBox;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public boolean isVive() {
        return vive;
    }

    public void setVive(boolean vive) {
        this.vive = vive;
    }
    
    
}
