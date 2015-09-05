package astro;

import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class administrarJuego extends Thread{
    
    private ArrayList<Zombie> zombies;
    private JDialog endgame;
    private boolean avanzar;
    private boolean vive;
    private JFrame frame;

    public administrarJuego(ArrayList<Zombie> zombies,JDialog endgame,JFrame frame) {
        this.zombies = zombies;
        this.endgame = endgame;
        this.avanzar = true;
        this.vive = true;
        this.frame = frame;
    }

    public administrarJuego() {
    }

    public ArrayList<Zombie> getZombies() {
        return zombies;
    }

    public void setZombies(ArrayList<Zombie> zombies) {
        this.zombies = zombies;
    }

    public boolean isAvanzar() {
        return avanzar;
    }

    public void setAvanzar(boolean avanzar) {
        this.avanzar = avanzar;
    }

    public boolean isVive() {
        return vive;
    }

    public void setVive(boolean vive) {
        this.vive = vive;
    }

    public JDialog getEndgame() {
        return endgame;
    }

    public void setEndgame(JDialog endgame) {
        this.endgame = endgame;
    }
    
    
    
    public void run(){
        while(vive){
            if(avanzar){
                if(zombies.isEmpty()){
                    this.frame.setVisible(false);
                    this.endgame.setModal(true);
                    this.endgame.pack();
                    this.endgame.setVisible(true);
                    this.vive = false;
                }
                try{
                    Thread.sleep(1000);
                } catch (Exception e){
                    
                }
            }
        }
    }
    
}
