package astro;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

/* Este es el hilo que nos controla a un zombie y verifica si intersecta con una planta
 * y realiza una accion diferente para cada tipo de planta que interseca */

public class administrarZombie extends Thread {

    private static javax.sound.sampled.Clip clip;
    private Zombie zombie;
    private JFrame frame;
    private boolean vive;
    private boolean avanzar;
    private ArrayList<Plant> plants;
    private ArrayList<Zombie> zombies;

    public administrarZombie() {
    }

    public administrarZombie(Zombie zombie, JFrame frame, ArrayList<Plant> plants,ArrayList<Zombie> zombies) {
        this.zombie = zombie;
        this.vive = true;
        this.avanzar = true;
        this.frame = frame;
        this.plants = plants;
        this.zombies = zombies;
    }

    public Zombie getZombie() {
        return zombie;
    }

    public void setZombie(Zombie zombie) {
        this.zombie = zombie;
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

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public static Clip getClip() {
        return clip;
    }

    public static void setClip(Clip clip) {
        administrarZombie.clip = clip;
    }

    public ArrayList<Plant> getPlants() {
        return plants;
    }

    public void setPlants(ArrayList<Plant> plants) {
        this.plants = plants;
    }

    public ArrayList<Zombie> getZombies() {
        return zombies;
    }

    public void setZombies(ArrayList<Zombie> zombies) {
        this.zombies = zombies;
    }
    
    public void eatPlant() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File soundFile = new File("./eat.wav"); //Se encuentra el archivo de musica y se instancia
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile); //Se consigue el InputStream para el archivo de musica
        clip = AudioSystem.getClip(); //Conseguimos un clip para reproducir
        clip.open(audioInputStream); //El compilador abre el clip de musica
        clip.start(); //This plays the audio 
    }

    public void explosion() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        File soundFile = new File("./bomb.wav"); //Se encuentra el archivo de musica y se instancia
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile); //Se consigue el InputStream para el archivo de musica
        clip = AudioSystem.getClip(); //Conseguimos un clip para reproducir
        clip.open(audioInputStream); //El compilador abre el clip de musica
        clip.start(); //This plays the audio 
    }

    /* Metodo Hilo */
    public void run() {
        while (this.zombie.isVive()) {
            if (avanzar) {
                this.zombie.setX(this.zombie.getX() - 5);
                this.zombie.getCollisionBox().setLocation(this.zombie.getX(), this.zombie.getY());
                frame.repaint();
                //Para que se coma las bombas
                for (int i = 0; i < plants.size(); i++) { //recorremos el arrayList de plantas
                    if (this.zombie.getCollisionBox().intersects(plants.get(i).getCollisionBox())) { //Agarramos los rectangulos del zombie y vemos si intersecta con el rectangulo de la planta
                        if (plants.get(i) instanceof bomb) { //Si intersecta con una bomba
                            //this.zombie.setX(1000); //mandamos al zombie a una posicion 1000 en x
                            //this.zombie.setY(1000); //mandamos al zombie a una posicion 1000 en y
                            zombies.remove(this.zombie);
                            plants.remove(i); //quitamos la bomba, la bomba ya exploto 
                            this.vive = false; //le quitamos la vida a este Zombie, la bomba ya lo "mato"
                        }
                    }
                }
                // Para que se coma los girasoles
                for (int i = 0; i < plants.size(); i++) {
                    if (this.zombie.getCollisionBox().intersects(plants.get(i).getCollisionBox())) {
                        if (plants.get(i) instanceof SunFlower) {
                            try {
                                eatPlant();
                            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                                Logger.getLogger(administrarZombie.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            while (plants.get(i).getLife() != 0) { //Mientras que la vida del girasol no sea 0
                                plants.get(i).setLife(plants.get(i).getLife() - 2); //Le ponemos una nueva vida al girasol, por cada vuelta del while, le restamos 10 puntos de vida
                                try {
                                    if (plants.get(i).getLife() % 50000 == 0) {
                                        eatPlant();// tira el sonido de que el zombie se esta comiendo una planta
                                    }
                                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                                    Logger.getLogger(administrarZombie.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                System.out.println(plants.get(i).getLife()); //nos imprime la vida que lleva el girasol en la vuelta actual
                            }
                            if (plants.get(i).getLife() == 0) { //si la vida del girasol es igual a 0
                                ((SunFlower) plants.get(i)).setVive(false); //le pone false al vive del hilo del girasol
                                plants.remove(i); //como el girasol ya fue "comido", entonces lo quitamos del arrayList
                            }
                        }
                    }
                }
                
                //Para que se coma las papas
                for (int i = 0; i < plants.size(); i++) {
                    if (this.zombie.getCollisionBox().intersects(plants.get(i).getCollisionBox())) {
                        if (plants.get(i) instanceof potato) {
                            try {
                                eatPlant();
                            } catch (                    UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                                Logger.getLogger(administrarZombie.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            while (plants.get(i).getLife() != 0) {
                                plants.get(i).setLife(plants.get(i).getLife() - 2);
                                System.out.println(plants.get(i).getLife());
                                if (plants.get(i).getLife() % 25000 == 0) {
                                    try {
                                        eatPlant();
                                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                                        Logger.getLogger(administrarZombie.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            }
                            if (plants.get(i).getLife() == 0) {
                                plants.remove(i);
                            }
                        }
                    }
                }
                
                //Para que se coma las plantas disparadoras
                for(int i = 0; i < plants.size(); i++){
                    if(this.zombie.getCollisionBox().intersects(plants.get(i).getCollisionBox())){
                        if(plants.get(i) instanceof PeaShooter){
                            try {
                                eatPlant();
                            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                                Logger.getLogger(administrarZombie.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            while(plants.get(i).getLife() != 0){
                                System.out.println(plants.get(i).getLife());
                                plants.get(i).setLife(plants.get(i).getLife() - 2);
                                if(plants.get(i).getLife() % 25000 == 0){
                                    try {
                                        eatPlant();
                                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                                        Logger.getLogger(administrarZombie.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            }
                            if(plants.get(i).getLife() == 0){
                                ((PeaShooter)plants.get(i)).setVive(false);
                                plants.remove(i);
                            }
                        }
                    }
                }
                
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }
        }
    }
}
