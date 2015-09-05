package astro;

import javax.swing.JButton;

public class habilitarSol extends Thread {

    private boolean empezar;
    private boolean corriendo;
    private JButton button;

    public habilitarSol() {
    }

    public habilitarSol(JButton button) {
        this.empezar = true;
        this.corriendo = true;
        this.button = button;
    }

    public boolean isEmpezar() {
        return empezar;
    }

    public void setEmpezar(boolean empezar) {
        this.empezar = empezar;
    }

    public boolean isCorriendo() {
        return corriendo;
    }

    public void setCorriendo(boolean corriendo) {
        this.corriendo = corriendo;
    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    @Override
    public void run() {
        while (empezar) {
            if (corriendo) {
                button.setEnabled(true);
            }
            try {
                Thread.sleep(10000);
            } catch (Exception e) {
            }
        }
    }
}
