package astro;

import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class PeaShooter extends Plant implements Runnable, Serializable {

    private ArrayList<Bullet> bullets;
    private ArrayList<Zombie> zombies;
    private JFrame frame1;
    private boolean vive;
    private boolean avanzar;
    int count;

    public PeaShooter(int x, int y, JFrame frame1, ArrayList<Zombie> zombies) {
        super(x, y);
        this.x = x;
        this.y = y;
        this.life = 250000;
        this.frame1 = frame1;
        this.zombies = zombies;
        ImageIcon icon = new ImageIcon(this.getClass().getResource("peashooter.png"));
        this.image = icon.getImage();
        this.width = 50;
        this.height = 50;
        this.collisionBox = new Rectangle(this.x, this.y, this.height, this.width);
        this.bullets = new ArrayList();
        this.vive = true;
        this.avanzar = true;
        this.count = 0;
    }

    public ArrayList<Zombie> getZombies() {
        return zombies;
    }

    public void setZombies(ArrayList<Zombie> zombies) {
        this.zombies = zombies;
    }

    public JFrame getFrame1() {
        return frame1;
    }

    public void setFrame1(JFrame frame1) {
        this.frame1 = frame1;
    }

    public PeaShooter() {
        super();
    }

    public ArrayList<Bullet> getBullets() {
        return bullets;
    }

    public void setBullets(ArrayList<Bullet> bullets) {
        this.bullets = bullets;
    }

    public void fire() {
        bullets.add(new Bullet(this.x + 30, this.y + 10, zombies));
        bullets.get(count).start();
        count += 1;
    }

    @Override
    public String toString() {
        return "PeaShooter";
    }

    public boolean isVive() {
        return vive;
    }

    public void setVive(boolean vive) {
        this.vive = vive;
    }

    public boolean isAvanzar() {
        return avanzar;
    }

    public void setAvanzar(boolean avanzar) {
        this.avanzar = avanzar;
    }
    
    

    public void run() {
        while (vive) {
            if (avanzar) {
                for (int i = 0; i < zombies.size(); i++) {
                    if (zombies.get(i).getX() < 620 && (zombies.get(i).getY() == this.y - 20 || zombies.get(i).getY() == this.y - 10)) {
                        fire();
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }
                }
            }
        }
    }
}
