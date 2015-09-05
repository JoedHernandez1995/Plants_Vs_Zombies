package astro;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class moverZombie extends Thread {

    JLabel zombie;
    JLabel plant;
    private boolean corriendo;
    private boolean empezar;
    private static javax.sound.sampled.Clip clip;

    public moverZombie() {
        super();
    }

    public void eatPlant() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File soundFile = new File("./eat.wav"); //Se encuentra el archivo de musica y se instancia
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile); //Se consigue el InputStream para el archivo de musica
        clip = AudioSystem.getClip(); //Conseguimos un clip para reproducir
        clip.open(audioInputStream); //El compilador abre el clip de musica
        clip.start(); //This plays the audio 
    }

    public moverZombie(JLabel zombie, JLabel plant) {
        this.zombie = zombie;
        this.plant = plant;
        corriendo = true;
        empezar = true;
    }

    public JLabel getZombie() {
        return zombie;
    }

    public void setZombie(JLabel zombie) {
        this.zombie = zombie;
    }

    @Override
    public void run() {
        while (empezar) {
            if (corriendo) {
                this.zombie.setLocation(this.zombie.getX() - 10, this.zombie.getY());
                if (this.zombie.getX() == this.plant.getX() + 30) {
                    this.plant.setVisible(false);
                    JOptionPane.showMessageDialog(null, "The zombie ate the plant");
                }
                System.out.println("Thread woke up");
            }
            try {
                Thread.sleep(999);
            } catch (InterruptedException ex) {
                Logger.getLogger(moverZombie.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
