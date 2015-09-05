package astro;

import java.awt.Image;
import java.awt.Rectangle;
import java.io.Serializable;

public class Plant implements Serializable{

    protected int life;
    protected int x;
    protected int y;
    protected Rectangle collisionBox;
    protected boolean visible;
    protected int width;
    protected int height;
    protected Image image;

    public Plant() {
    }

    public Plant(int x, int y) {
        this.x = x;
        this.y = y;
        this.visible = true;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
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

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
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
}
