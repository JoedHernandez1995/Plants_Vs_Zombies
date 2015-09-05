package astro;

import java.awt.Rectangle;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SunFlower extends Plant implements Runnable,Serializable {
    
    private boolean vive;
    private boolean avanzar;
    private JLabel sun;
    private JFrame frame1;

    public SunFlower() {
        super();
    }

    public SunFlower(int x, int y,JLabel sun,JFrame frame1) {
        super(x, y);
        this.x = x;
        this.y = y;
        this.sun = sun;
        this.frame1 = frame1;
        this.life = 250000;
        this.visible = true;
        this.vive = true;
        this.avanzar = true;
        ImageIcon icon = new ImageIcon(this.getClass().getResource("sunflower.png"));
        this.image = icon.getImage();
        this.width = 50;
        this.height = 50;
        this.collisionBox = new Rectangle(this.x, this.y, this.height, this.width);
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

    @Override
    public String toString() {
        return "Girasol";
    }
    
    
    
    /* Metodo Hilo */
    public void run() {
        while(vive){
            if(avanzar){
                sun.setLocation(this.x, this.y); //Agarra el label del sol y lo coloca en las mismas coordenadas que la planta girasol
                sun.setVisible(true); // pone la visibilidad en true del label
                sun.setEnabled(true); // pone el label enabled
                frame1.repaint(); //vuelve a pintar todo en el frame
                if(this.visible == false){
                    vive = false;
                }
                try {
                    Thread.sleep(10000);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
