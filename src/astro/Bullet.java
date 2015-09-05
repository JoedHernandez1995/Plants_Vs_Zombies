package astro;

import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

public class Bullet extends Thread implements Serializable {

    private static javax.sound.sampled.Clip clip; //Clip para reprdoucir
    private int x; //posicion X de la bala
    private int y; // posicion Y de la bala
    private int height; // altura de la bala
    private int width; // anchura de la bala
    private Rectangle collisionBox; //rectangulo para detectar colisiones
    private boolean visible; //visibilidad de la bala
    private Image image; //imagen para representar la bala
    private boolean vive; //booleano para controlar el hilo
    private boolean avanzar; // booleano para controlar el hilo
    private ArrayList<Zombie> zombies; // arraylist que contiene todos los zombies puestos en juego

    public Bullet() {
    }

    public Bullet(int x, int y, ArrayList<Zombie> zombies) {
        this.x = x;
        this.y = y;
        this.height = 20; //se le asignan 20 pixeles de alto a la bala
        this.width = 20; // se le asignan 20 pixeles de ancho a la bala
        this.collisionBox = new Rectangle(this.x, this.y, this.height, this.width); //rectangulo que contiene la altura, anchura, posicion en X y posicion en Y de la bala
        this.visible = true; //se le asigna true a la visibilidad ya que la queremos ver en pantalla
        ImageIcon icon = new ImageIcon(this.getClass().getResource("bullet.png"));
        this.image = icon.getImage();
        this.vive = true; //se le asigna true a la boolean del hilo para que corra
        this.avanzar = true; //se le asigna true al boolean del hilo para que corra
        this.zombies = zombies;
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

    public Rectangle getCollisionBox() {
        return collisionBox;
    }

    public void setCollisionBox(Rectangle collisionBox) {
        this.collisionBox = collisionBox;
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

    public void move() {
        this.x += 20;
    }

    //Metodo para reproducir la musica
    public static void choque() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File soundFile = new File("./Bonk.wav"); //Se encuentra el archivo de musica y se instancia
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile); //Se consigue el InputStream para el archivo de musica
        clip = AudioSystem.getClip(); //Conseguimos un clip para reproducir
        clip.open(audioInputStream); //El compilador abre el clip de musica
        clip.start(); //Esto corre el audio

    }

    //Metodo Hilo
    public void run() {
        while (vive) { //Mientras el hilo esta vivo
            if (avanzar) { //Si el hilo esta corriendo
                this.setX(this.x + 20);  //Le sumamos 20 pixeles a la posicion en X cada vez que el hilo corre
                this.setCollisionBox(new Rectangle(this.getX(), this.getY(), 20, 20)); //Movemos el rectangulo de posicion
                for (int i = 0; i < zombies.size(); i++) { //recorremos todo el arraylist de zombies en cada vuelta del hilo
                    if (this.collisionBox.intersects(zombies.get(i).getCollisionBox())) { //Si el rectangulo de la bala intersecta con el rectangulo de un zombie del arraylist
                        try {
                            choque(); //ejecuta el metodo de choque, para reproducir un efecto de sonido
                        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                            Logger.getLogger(Bullet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        zombies.get(i).setLife(zombies.get(i).getLife() - 10); //cada vez que una bala choca, le baja 10 puntos de vida al zombie
                        this.setX(2000); //manda la bala a una posicion X muy alta
                        this.setY(2000); //Manda la bala a una posicion Y muy alta
                        System.out.println(zombies.get(i).getLife()); //Imprime en pantalla la vida que lleva el zombie
                        if (zombies.get(i).getLife() == 0) { //Si la vida del zombie que intersecta la bala llega a cero
                            zombies.get(i).setVive(false);
                            zombies.remove(i); //quita al zombie muerto del arrayList
                        }
                        this.vive = false; //Mata este hilo                        
                    }
                }
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
