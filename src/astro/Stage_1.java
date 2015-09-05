package astro;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

public class Stage_1 extends javax.swing.JFrame {

    private class TAdapter extends KeyAdapter {
    }
    private ArrayList<Plant> plant_list = new ArrayList(); //ArrayList que contiene las plantas
    private ArrayList<Zombie> zombie_list = new ArrayList(); //ArrayList que contiene a los zombies
    private ArrayList<Jugador> jugadores = new ArrayList(); //ArrayList que contiene los jugadores
    private int sunCounter; // contador de valores de sol
    private int Score; // contador de puntaje total
    private int shooterCounter; // contador de plantas puestas de tipo disparadoras
    private int bombCounter; // contador de bombas puestas
    private int sunFlowerCounter; // contador de girasoles puestos
    private int potatoCounter; // contador de papas puestas
    private int totalPlants; // conador de plantas totales puestas
    private String row = ""; //String generado por el Spinner para calcular la fila de la planta
    private int column = 0; //Entero generado por el Spinner para calcular la columna de la planta

    public Stage_1() {
        initComponents();
        repaint();
        Score = 0;
        shooterCounter = 0;
        bombCounter = 0;
        sunFlowerCounter = 0;
        potatoCounter = 0;
        totalPlants = 0;
        gameLoop();
        label_bomb.setVisible(false);
        label_potato.setVisible(false);
        label_sunflower.setVisible(false);
        label_peashooter.setVisible(false);
        sun.setVisible(false);
        habilitarSol s = new habilitarSol(addSun);
        administrarJuego game = new administrarJuego(zombie_list, endGame, this);
        s.start();
        game.start();
    }

    //Metodo paint, nos pinta las imagenes de los objetos en pantalla
    public void paint(Graphics g) {
        super.paint(g);
        if (zombie_list.size() > 0) {
            for (int i = 0; i < zombie_list.size(); i++) {
                Graphics2D g2 = (Graphics2D) g;
                if (zombie_list.get(i).isVisible()) {
                    g2.drawImage(zombie_list.get(i).getImage(), zombie_list.get(i).getX(), zombie_list.get(i).getY(), this);
                }
            }
        }
        if (plant_list.size() > 0) {
            for (int i = 0; i < plant_list.size(); i++) {
                if (plant_list.get(i).isVisible()) {
                    Graphics2D g2 = (Graphics2D) g;
                    g2.drawImage(plant_list.get(i).getImage(), plant_list.get(i).getX(), plant_list.get(i).getY(), this);
                    ArrayList<Bullet> bullets;
                    if (plant_list.get(i) instanceof PeaShooter) {
                        bullets = ((PeaShooter) plant_list.get(i)).getBullets();
                        for (int j = 0; j < bullets.size(); j++) {
                            Bullet b = bullets.get(j);
                            g2.drawImage(b.getImage(), b.getX(), b.getY(), this);
                        }
                    }
                }
            }
        }

        Toolkit.getDefaultToolkit().sync();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Coordenadas = new javax.swing.JDialog();
        sp_row = new javax.swing.JSpinner();
        sp_column = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        endGame = new javax.swing.JDialog();
        tf_name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        label_shooter = new javax.swing.JLabel();
        label_Sunflower = new javax.swing.JLabel();
        label_walnut = new javax.swing.JLabel();
        label_Bomb = new javax.swing.JLabel();
        label_TotalPlants = new javax.swing.JLabel();
        label_TotalScore = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        label_peashooter = new javax.swing.JLabel();
        label_sunflower = new javax.swing.JLabel();
        label_potato = new javax.swing.JLabel();
        label_bomb = new javax.swing.JLabel();
        addPlant = new javax.swing.JButton();
        addSunflower = new javax.swing.JButton();
        addPotato = new javax.swing.JButton();
        addBomb = new javax.swing.JButton();
        buttonholder = new javax.swing.JLabel();
        sun_counter = new javax.swing.JLabel();
        addSun = new javax.swing.JButton();
        Sunholder = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        sun = new javax.swing.JLabel();
        score_label = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        garden = new javax.swing.JLabel();

        Coordenadas.setMaximumSize(new java.awt.Dimension(302, 270));
        Coordenadas.setMinimumSize(new java.awt.Dimension(302, 270));
        Coordenadas.setResizable(false);
        Coordenadas.getContentPane().setLayout(null);

        sp_row.setModel(new javax.swing.SpinnerListModel(new String[] {"A", "B", "C", "D", "E"}));
        Coordenadas.getContentPane().add(sp_row);
        sp_row.setBounds(130, 60, 80, 28);

        sp_column.setModel(new javax.swing.SpinnerNumberModel(1, 1, 9, 1));
        Coordenadas.getContentPane().add(sp_column);
        sp_column.setBounds(130, 100, 80, 28);

        jLabel3.setFont(new java.awt.Font("Chalkboard", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 0));
        jLabel3.setText("Seleccion Coordenadas");
        Coordenadas.getContentPane().add(jLabel3);
        jLabel3.setBounds(80, 0, 150, 40);

        jLabel1.setFont(new java.awt.Font("Chalkboard", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Fila:");
        Coordenadas.getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 70, 40, 17);

        jLabel4.setFont(new java.awt.Font("Chalkboard", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("Columna:");
        Coordenadas.getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 110, 70, 17);

        jButton2.setText("Aceptar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        Coordenadas.getContentPane().add(jButton2);
        jButton2.setBounds(100, 170, 97, 29);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/astro/panel.png"))); // NOI18N
        Coordenadas.getContentPane().add(jLabel2);
        jLabel2.setBounds(0, -60, 360, 380);

        endGame.setMinimumSize(new java.awt.Dimension(429, 360));
        endGame.getContentPane().setLayout(null);
        endGame.getContentPane().add(tf_name);
        tf_name.setBounds(100, 80, 220, 28);

        jLabel5.setText("Fin del Juego!");
        endGame.getContentPane().add(jLabel5);
        jLabel5.setBounds(170, 10, 90, 16);

        jLabel7.setText("Ingrese su Nombre:");
        endGame.getContentPane().add(jLabel7);
        jLabel7.setBounds(150, 60, 130, 16);

        jLabel9.setText("Puntaje Final");
        endGame.getContentPane().add(jLabel9);
        jLabel9.setBounds(170, 150, 90, 16);

        jLabel10.setText("Puntaje Total:");
        endGame.getContentPane().add(jLabel10);
        jLabel10.setBounds(30, 290, 90, 16);

        jLabel11.setText("Disparadoras Puestas:");
        endGame.getContentPane().add(jLabel11);
        jLabel11.setBounds(30, 190, 150, 16);

        jLabel12.setText("Girasoles Puestos:");
        endGame.getContentPane().add(jLabel12);
        jLabel12.setBounds(30, 210, 130, 16);

        jLabel13.setText("Papas Puestas:");
        endGame.getContentPane().add(jLabel13);
        jLabel13.setBounds(30, 230, 100, 16);

        jLabel59.setText("Bombas Puestas: ");
        endGame.getContentPane().add(jLabel59);
        jLabel59.setBounds(30, 250, 120, 16);

        jLabel60.setText("Plantas Totales: ");
        endGame.getContentPane().add(jLabel60);
        jLabel60.setBounds(30, 270, 110, 16);

        jButton1.setText("Ingresar Puntaje");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        endGame.getContentPane().add(jButton1);
        jButton1.setBounds(290, 320, 130, 29);

        label_shooter.setText("0");
        endGame.getContentPane().add(label_shooter);
        label_shooter.setBounds(186, 190, 30, 16);

        label_Sunflower.setText("0");
        endGame.getContentPane().add(label_Sunflower);
        label_Sunflower.setBounds(186, 210, 30, 16);

        label_walnut.setText("0");
        endGame.getContentPane().add(label_walnut);
        label_walnut.setBounds(186, 228, 30, 16);

        label_Bomb.setText("0");
        endGame.getContentPane().add(label_Bomb);
        label_Bomb.setBounds(186, 250, 30, 16);

        label_TotalPlants.setText("0");
        endGame.getContentPane().add(label_TotalPlants);
        label_TotalPlants.setBounds(186, 270, 30, 16);

        label_TotalScore.setText("0");
        endGame.getContentPane().add(label_TotalScore);
        label_TotalScore.setBounds(186, 290, 130, 16);

        jLabel8.setText("jLabel8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Plants VS Zombies");
        setMinimumSize(new java.awt.Dimension(640, 500));
        getContentPane().setLayout(null);

        label_peashooter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/astro/peashooter.png"))); // NOI18N
        getContentPane().add(label_peashooter);
        label_peashooter.setBounds(20, 40, 50, 60);

        label_sunflower.setIcon(new javax.swing.ImageIcon(getClass().getResource("/astro/sunflower.png"))); // NOI18N
        getContentPane().add(label_sunflower);
        label_sunflower.setBounds(30, 120, 50, 50);

        label_potato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/astro/potato.png"))); // NOI18N
        getContentPane().add(label_potato);
        label_potato.setBounds(30, 180, 50, 60);

        label_bomb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/astro/bomb.png"))); // NOI18N
        label_bomb.setFocusable(false);
        getContentPane().add(label_bomb);
        label_bomb.setBounds(30, 250, 50, 50);

        addPlant.setIcon(new javax.swing.ImageIcon(getClass().getResource("/astro/PlantButton.png"))); // NOI18N
        addPlant.setBorderPainted(false);
        addPlant.setEnabled(false);
        addPlant.setFocusable(false);
        addPlant.setSize(70,50);
        addPlant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addPlantMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addPlantMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addPlantMouseEntered(evt);
            }
        });
        addPlant.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                drag(evt);
            }
        });
        getContentPane().add(addPlant);
        addPlant.setBounds(20, 30, 60, 80);

        addSunflower.setIcon(new javax.swing.ImageIcon(getClass().getResource("/astro/SunFlowerButton.png"))); // NOI18N
        addSunflower.setBorderPainted(false);
        addSunflower.setEnabled(false);
        addSunflower.setFocusable(false);
        addSunflower.setSize(70,50);
        addSunflower.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addSunflowerMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addSunflowerMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addSunflowerMouseEntered(evt);
            }
        });
        getContentPane().add(addSunflower);
        addSunflower.setBounds(20, 100, 60, 80);

        addPotato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/astro/PotatoButton.png"))); // NOI18N
        addPotato.setBorderPainted(false);
        addPotato.setEnabled(false);
        addPotato.setFocusable(false);
        addPotato.setSize(70,50);
        addPotato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addPotatoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addPotatoMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addPotatoMouseEntered(evt);
            }
        });
        addPotato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPotatoActionPerformed(evt);
            }
        });
        getContentPane().add(addPotato);
        addPotato.setBounds(20, 170, 60, 80);

        addBomb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/astro/BombButton.png"))); // NOI18N
        addBomb.setBorderPainted(false);
        addBomb.setEnabled(false);
        addBomb.setFocusable(false);
        addBomb.setSize(70,50);
        addBomb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addBombMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                removeImage(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                removeImage(evt);
                displayImage(evt);
            }
        });
        getContentPane().add(addBomb);
        addBomb.setBounds(20, 240, 60, 80);

        buttonholder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/astro/buttonHolder.png"))); // NOI18N
        getContentPane().add(buttonholder);
        buttonholder.setBounds(10, 20, 80, 310);

        sun_counter.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        sun_counter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sun_counter.setText("0");
        getContentPane().add(sun_counter);
        sun_counter.setBounds(30, 390, 45, 20);

        addSun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/astro/SunButton.png"))); // NOI18N
        addSun.setBorderPainted(false);
        addSun.setEnabled(false);
        addSun.setFocusable(false);
        addSun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addSunMouseClicked(evt);
            }
        });
        addSun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSunActionPerformed(evt);
            }
        });
        getContentPane().add(addSun);
        addSun.setBounds(20, 330, 60, 90);

        Sunholder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/astro/sunbuttonholder.png"))); // NOI18N
        getContentPane().add(Sunholder);
        Sunholder.setBounds(10, 320, 80, 110);

        jLabel14.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("A,1");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(170, 120, 30, 19);

        jLabel15.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("A,2");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(220, 120, 30, 19);

        jLabel16.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("A,3");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(270, 120, 30, 19);

        jLabel17.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("A,4");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(320, 120, 30, 19);

        jLabel18.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("A,5");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(370, 120, 30, 19);

        jLabel19.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("A,6");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(421, 120, 30, 19);

        jLabel20.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("A,7");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(470, 120, 30, 19);

        jLabel21.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("A,8");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(517, 120, 30, 19);

        jLabel22.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("A,9");
        getContentPane().add(jLabel22);
        jLabel22.setBounds(570, 120, 30, 19);

        jLabel23.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("B,1");
        getContentPane().add(jLabel23);
        jLabel23.setBounds(170, 200, 30, 19);

        jLabel24.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("B,2");
        getContentPane().add(jLabel24);
        jLabel24.setBounds(220, 200, 30, 19);

        jLabel25.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("B,3");
        getContentPane().add(jLabel25);
        jLabel25.setBounds(270, 200, 30, 19);

        jLabel26.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("B,4");
        getContentPane().add(jLabel26);
        jLabel26.setBounds(320, 200, 30, 19);

        jLabel27.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("B,5");
        getContentPane().add(jLabel27);
        jLabel27.setBounds(370, 200, 30, 19);

        jLabel28.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("B,6");
        getContentPane().add(jLabel28);
        jLabel28.setBounds(420, 200, 30, 19);

        jLabel29.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("B,7");
        getContentPane().add(jLabel29);
        jLabel29.setBounds(470, 200, 30, 19);

        jLabel30.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("B,8");
        getContentPane().add(jLabel30);
        jLabel30.setBounds(520, 200, 30, 19);

        jLabel31.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("B,9");
        getContentPane().add(jLabel31);
        jLabel31.setBounds(570, 200, 30, 19);

        jLabel32.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("C,1");
        getContentPane().add(jLabel32);
        jLabel32.setBounds(170, 280, 30, 19);

        jLabel33.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("C,2");
        getContentPane().add(jLabel33);
        jLabel33.setBounds(220, 280, 30, 19);

        jLabel34.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("C,3");
        getContentPane().add(jLabel34);
        jLabel34.setBounds(270, 280, 30, 19);

        jLabel35.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("C,4");
        getContentPane().add(jLabel35);
        jLabel35.setBounds(320, 280, 30, 19);

        jLabel36.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("C,5");
        getContentPane().add(jLabel36);
        jLabel36.setBounds(370, 280, 30, 19);

        jLabel37.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("C,6");
        getContentPane().add(jLabel37);
        jLabel37.setBounds(426, 280, 30, 19);

        jLabel38.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("C,7");
        getContentPane().add(jLabel38);
        jLabel38.setBounds(465, 280, 30, 19);

        jLabel39.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("C,8");
        getContentPane().add(jLabel39);
        jLabel39.setBounds(520, 280, 30, 19);

        jLabel40.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("C,9");
        getContentPane().add(jLabel40);
        jLabel40.setBounds(570, 280, 30, 19);

        jLabel41.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("D,1");
        getContentPane().add(jLabel41);
        jLabel41.setBounds(170, 350, 30, 19);

        jLabel42.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("D,2");
        getContentPane().add(jLabel42);
        jLabel42.setBounds(220, 350, 30, 19);

        jLabel43.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("D,3");
        getContentPane().add(jLabel43);
        jLabel43.setBounds(270, 350, 30, 19);

        jLabel44.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("D,4");
        getContentPane().add(jLabel44);
        jLabel44.setBounds(320, 350, 30, 19);

        jLabel45.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("D,5");
        getContentPane().add(jLabel45);
        jLabel45.setBounds(370, 350, 30, 19);

        jLabel46.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("D,6");
        getContentPane().add(jLabel46);
        jLabel46.setBounds(420, 350, 30, 19);

        jLabel47.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("D,7");
        getContentPane().add(jLabel47);
        jLabel47.setBounds(470, 350, 30, 19);

        jLabel48.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("D,8");
        getContentPane().add(jLabel48);
        jLabel48.setBounds(520, 350, 30, 19);

        jLabel49.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("D,9");
        getContentPane().add(jLabel49);
        jLabel49.setBounds(570, 350, 30, 19);

        jLabel50.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("E,1");
        getContentPane().add(jLabel50);
        jLabel50.setBounds(170, 430, 30, 19);

        jLabel51.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("E,2");
        getContentPane().add(jLabel51);
        jLabel51.setBounds(220, 430, 30, 19);

        jLabel52.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("E,3");
        getContentPane().add(jLabel52);
        jLabel52.setBounds(270, 430, 30, 19);

        jLabel53.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("E,4");
        getContentPane().add(jLabel53);
        jLabel53.setBounds(320, 430, 30, 19);

        jLabel54.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("E,5");
        getContentPane().add(jLabel54);
        jLabel54.setBounds(370, 430, 30, 19);

        jLabel55.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("E,6");
        getContentPane().add(jLabel55);
        jLabel55.setBounds(425, 430, 30, 19);

        jLabel56.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("E,7");
        getContentPane().add(jLabel56);
        jLabel56.setBounds(476, 430, 30, 19);

        jLabel57.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("E,8");
        getContentPane().add(jLabel57);
        jLabel57.setBounds(520, 430, 30, 19);

        jLabel58.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("E,9");
        getContentPane().add(jLabel58);
        jLabel58.setBounds(570, 430, 30, 19);

        sun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/astro/sun.png"))); // NOI18N
        sun.setEnabled(false);
        sun.setFocusable(false);
        sun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sunMouseClicked(evt);
            }
        });
        getContentPane().add(sun);
        sun.setBounds(570, 30, 50, 50);

        score_label.setFont(new java.awt.Font("Chalkboard", 1, 13)); // NOI18N
        score_label.setForeground(new java.awt.Color(255, 255, 255));
        score_label.setText("0");
        getContentPane().add(score_label);
        score_label.setBounds(50, 430, 50, 30);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/astro/score.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 430, 100, 30);

        garden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/astro/yard.png"))); // NOI18N
        getContentPane().add(garden);
        garden.setBounds(0, 0, 640, 480);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addPotatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPotatoActionPerformed
    }//GEN-LAST:event_addPotatoActionPerformed

    private void addSunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addSunMouseClicked
        if (addSun.isEnabled()) {
            sunCounter += 25;
            Score += 200;
            score_label.setText(Integer.toString(Score));
            label_TotalScore.setText(Integer.toString(Score));
            sun_counter.setText(Integer.toString(sunCounter));
            if (sunCounter >= 25) {
                addBomb.setEnabled(true);
            }
            if (sunCounter >= 50) {
                addSunflower.setEnabled(true);
                addPotato.setEnabled(true);
            }
            if (sunCounter >= 100) {
                addPlant.setEnabled(true);
            }
            addSun.setEnabled(false);
        }

    }//GEN-LAST:event_addSunMouseClicked

    private void addPlantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addPlantMouseClicked
        if (addPlant.isEnabled()) {
            Coordenadas.setModal(true);
            Coordenadas.pack();
            Coordenadas.setVisible(true);
            sunCounter -= 25;
            sun_counter.setText(Integer.toString(sunCounter));
            int x = columnas(column);
            int y = filas(row);
            for (int i = 0; i < plant_list.size(); i++) {
                while (plant_list.get(i).getX() == x && plant_list.get(i).getY() == y) {
                    JOptionPane.showMessageDialog(Stage_1.getFrames()[2], "Ya hay planta ahi! Vuelva a Ingresar!");
                    Coordenadas.setModal(true);
                    Coordenadas.pack();
                    Coordenadas.setVisible(true);
                    x = columnas(column);
                    y = filas(row);
                }
            }
            Score += 100;
            label_TotalScore.setText(Integer.toString(Score));
            score_label.setText(Integer.toString(Score));
            shooterCounter += 1;
            label_shooter.setText(Integer.toString(shooterCounter));
            totalPlants += 1;
            label_TotalPlants.setText(Integer.toString(totalPlants));
            PeaShooter shooter = new PeaShooter(x, y, this, zombie_list);
            Thread hiloPlanta = new Thread(shooter);
            plant_list.add(shooter);
            hiloPlanta.start();
            repaint();
            if (sunCounter >= 25) {
                addBomb.setEnabled(true);
            } else {
                addBomb.setEnabled(false);
            }
            if (sunCounter >= 50) {
                addSunflower.setEnabled(true);
                addPotato.setEnabled(true);
            } else {
                addSunflower.setEnabled(false);
                addPotato.setEnabled(false);
            }
            if (sunCounter >= 100) {
                addPlant.setEnabled(true);
            } else {
                addPlant.setEnabled(false);
            }
        }
        label_peashooter.setVisible(false);
    }//GEN-LAST:event_addPlantMouseClicked

    private void addSunflowerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addSunflowerMouseClicked
        if (addSunflower.isEnabled()) {
            Coordenadas.setModal(true);
            Coordenadas.pack();
            Coordenadas.setVisible(true);
            sunCounter -= 25;
            sun_counter.setText(Integer.toString(sunCounter));
            int x = columnas(column);
            int y = filas(row);
            for (int i = 0; i < plant_list.size(); i++) {
                while (plant_list.get(i).getX() == x && plant_list.get(i).getY() == y) {
                    JOptionPane.showMessageDialog(Stage_1.getFrames()[2], "Ya hay planta ahi! Vuelva a Ingresar!");
                    Coordenadas.setModal(true);
                    Coordenadas.pack();
                    Coordenadas.setVisible(true);
                    x = columnas(column);
                    y = filas(row);
                }
            }
            Score += 100;
            label_TotalScore.setText(Integer.toString(Score));
            score_label.setText(Integer.toString(Score));
            sunFlowerCounter += 1;
            label_Sunflower.setText(Integer.toString(sunFlowerCounter));
            totalPlants += 1;
            label_TotalPlants.setText(Integer.toString(totalPlants));
            SunFlower flower = new SunFlower(x, y, sun, this);
            plant_list.add(flower);
            Thread hiloSol = new Thread(flower);
            hiloSol.start();
            if (sunCounter >= 25) {
                addBomb.setEnabled(true);
            } else {
                addBomb.setEnabled(false);
            }
            if (sunCounter >= 50) {
                addSunflower.setEnabled(true);
                addPotato.setEnabled(true);
            } else {
                addSunflower.setEnabled(false);
                addPotato.setEnabled(false);
            }
            if (sunCounter >= 100) {
                addPlant.setEnabled(true);
            } else {
                addPlant.setEnabled(false);
            }
        }
        label_sunflower.setVisible(false);
    }//GEN-LAST:event_addSunflowerMouseClicked

    private void addPotatoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addPotatoMouseClicked
        if (addPotato.isEnabled()) {
            Coordenadas.setModal(true);
            Coordenadas.pack();
            Coordenadas.setVisible(true);
            sunCounter -= 25;
            sun_counter.setText(Integer.toString(sunCounter));
            int x = columnas(column);
            int y = filas(row);
            for (int i = 0; i < plant_list.size(); i++) {
                while (plant_list.get(i).getX() == x && plant_list.get(i).getY() == y) {
                    JOptionPane.showMessageDialog(Stage_1.getFrames()[2], "Ya hay planta ahi! Vuelva a Ingresar!");
                    Coordenadas.setModal(true);
                    Coordenadas.pack();
                    Coordenadas.setVisible(true);
                    x = columnas(column);
                    y = filas(row);
                }
            }
            Score += 100;
            label_TotalScore.setText(Integer.toString(Score));
            score_label.setText(Integer.toString(Score));
            potatoCounter += 1;
            label_walnut.setText(Integer.toString(potatoCounter));
            totalPlants += 1;
            label_TotalPlants.setText(Integer.toString(totalPlants));
            potato walnut = new potato(x, y);
            plant_list.add(walnut);
            repaint();
            if (sunCounter >= 25) {
                addBomb.setEnabled(true);
            } else {
                addBomb.setEnabled(false);
            }
            if (sunCounter >= 50) {
                addSunflower.setEnabled(true);
                addPotato.setEnabled(true);
            } else {
                addSunflower.setEnabled(false);
                addPotato.setEnabled(false);
            }
            if (sunCounter >= 100) {
                addPlant.setEnabled(true);
            } else {
                addPlant.setEnabled(false);
            }
        }
        label_potato.setVisible(false);
    }//GEN-LAST:event_addPotatoMouseClicked

    /* Evento Mouse Click para el boton que nos pone las plantas tipo bomba 
     * en el juego principal.
     */
    private void addBombMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBombMouseClicked
        if (addBomb.isEnabled()) {
            Coordenadas.setModal(true);
            Coordenadas.pack();
            Coordenadas.setVisible(true);
            sunCounter -= 25;
            sun_counter.setText(Integer.toString(sunCounter));
            int x = columnas(column);
            int y = filas(row);
            for (int i = 0; i < plant_list.size(); i++) {
                while (plant_list.get(i).getX() == x && plant_list.get(i).getY() == y) {
                    JOptionPane.showMessageDialog(Stage_1.getFrames()[2], "Ya hay planta ahi! Vuelva a Ingresar!");
                    Coordenadas.setModal(true);
                    Coordenadas.pack();
                    Coordenadas.setVisible(true);
                    x = columnas(column);
                    y = filas(row);
                }
            }
            Score += 100;
            label_TotalScore.setText(Integer.toString(Score));
            score_label.setText(Integer.toString(Score));
            bombCounter += 1;
            label_Bomb.setText(Integer.toString(bombCounter));
            totalPlants += 1;
            label_TotalPlants.setText(Integer.toString(totalPlants));
            bomb mine = new bomb(x, y);
            plant_list.add(mine);
            repaint();
            if (sunCounter >= 25) {
                addBomb.setEnabled(true);
            } else {
                addBomb.setEnabled(false);
            }
            if (sunCounter >= 50) {
                addSunflower.setEnabled(true);
                addPotato.setEnabled(true);
            } else {
                addSunflower.setEnabled(false);
                addPotato.setEnabled(false);
            }
            if (sunCounter >= 100) {
                addPlant.setEnabled(true);
            } else {
                addPlant.setEnabled(false);
            }
        }

        label_bomb.setVisible(false);
    }//GEN-LAST:event_addBombMouseClicked

    private void addSunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addSunActionPerformed

    private void drag(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drag
    }//GEN-LAST:event_drag

    private void removeImage(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeImage
        if (addBomb.isEnabled()) {
            label_bomb.setVisible(false);
        }
    }//GEN-LAST:event_removeImage

    private void displayImage(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayImage
        if (addBomb.isEnabled()) {
            label_bomb.setVisible(true);
        }
    }//GEN-LAST:event_displayImage

    private void addPotatoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addPotatoMouseEntered
        if (addPotato.isEnabled()) {
            label_potato.setVisible(true);
        }
    }//GEN-LAST:event_addPotatoMouseEntered

    private void addPotatoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addPotatoMouseExited
        if (addPotato.isEnabled()) {
            label_potato.setVisible(false);
        }
    }//GEN-LAST:event_addPotatoMouseExited

    private void addSunflowerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addSunflowerMouseEntered
        if (addSunflower.isEnabled()) {
            label_sunflower.setVisible(true);
        }
    }//GEN-LAST:event_addSunflowerMouseEntered

    private void addSunflowerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addSunflowerMouseExited
        if (addSunflower.isEnabled()) {
            label_sunflower.setVisible(false);
        }
    }//GEN-LAST:event_addSunflowerMouseExited

    private void addPlantMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addPlantMouseEntered
        if (addPlant.isEnabled()) {
            label_peashooter.setVisible(true);
        }
    }//GEN-LAST:event_addPlantMouseEntered

    private void addPlantMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addPlantMouseExited
        if (addPlant.isEnabled()) {
            label_peashooter.setVisible(false);
        }
    }//GEN-LAST:event_addPlantMouseExited

    private void sunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sunMouseClicked
        if (sun.isEnabled() && sun.isVisible()) {
            sunCounter += 25;
            sun_counter.setText(Integer.toString(sunCounter));
            Score += 300;
            score_label.setText(Integer.toString(Score));
            if (sunCounter >= 25) {
                addBomb.setEnabled(true);
            }
            if (sunCounter >= 50) {
                addSunflower.setEnabled(true);
                addPotato.setEnabled(true);
            }
            if (sunCounter >= 100) {
                addPlant.setEnabled(true);
            }
            sun.setEnabled(false);
            sun.setVisible(false);
        }

    }//GEN-LAST:event_sunMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        row = (String) sp_row.getValue();
        column = (int) sp_column.getValue();
        Coordenadas.setVisible(false);
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        Jugador jugador = new Jugador(tf_name.getText(), Score, shooterCounter, bombCounter, sunFlowerCounter, potatoCounter, totalPlants);
        jugadores.add(jugador);
        try {
            FileWriter salida = new FileWriter("./Jugadores.txt", true);
            BufferedWriter bw = new BufferedWriter(salida);
            bw.write(jugador.toString());
            bw.newLine();
            bw.flush();
            salida.close();
        } catch (IOException | HeadlessException e) {
            System.out.println("File not found");
        }
    }//GEN-LAST:event_jButton1MouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Stage_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Stage_1().setVisible(true);

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog Coordenadas;
    private javax.swing.JLabel Sunholder;
    private javax.swing.JButton addBomb;
    private javax.swing.JButton addPlant;
    private javax.swing.JButton addPotato;
    private javax.swing.JButton addSun;
    private javax.swing.JButton addSunflower;
    private javax.swing.JLabel buttonholder;
    private javax.swing.JDialog endGame;
    private javax.swing.JLabel garden;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel label_Bomb;
    private javax.swing.JLabel label_Sunflower;
    private javax.swing.JLabel label_TotalPlants;
    private javax.swing.JLabel label_TotalScore;
    private javax.swing.JLabel label_bomb;
    private javax.swing.JLabel label_peashooter;
    private javax.swing.JLabel label_potato;
    private javax.swing.JLabel label_shooter;
    private javax.swing.JLabel label_sunflower;
    private javax.swing.JLabel label_walnut;
    private javax.swing.JLabel score_label;
    private javax.swing.JSpinner sp_column;
    private javax.swing.JSpinner sp_row;
    private javax.swing.JLabel sun;
    private javax.swing.JLabel sun_counter;
    private javax.swing.JTextField tf_name;
    // End of variables declaration//GEN-END:variables

    /* Metodo para poner Zombies, se declaran tres enteros, dos para las posiciones en X y Y
     * y uno que se genera de forma aleatoria para determinar la cantidad de zombies que se van
     * a agregar al ArrayList de tipo Zombie. Se declara un for que tiene de longitud el número
     * aleatorio generado, en cada vuelta se crea un nuevo objeto Zombie y lo agregar a un 
     * arraylist, la clase Zombie recibe un valor para X y otro para Y. Como los Zombies aparecen 
     * del lado derecho del frame, entonces el valor para X siempre es el mismo, el unico que va 
     * a variar va a ser la posicion en Y, que se genera una posicion en un rango entre 100 y 400, 
     * estos siendo los pixeles, para que no aparezcan ni tan abajo ni tan arriba.
     */
    public void ponerZombies() {
        int x, y = 0, num_zombies, a;
        Random r = new Random();
        num_zombies = r.nextInt(15); //genera un numero random de zombies al momento de iniciar el juego
        for (int i = 0; i <= num_zombies; i++) {
            a = r.nextInt(5);
            x = 640 + r.nextInt(700); // Posicion Horizontal Inicial de los Zombies
            /* Dependiendo del valor asignado a a, el compilador va a determinar
             * la posicion vertical de los zombies. Esto es para que los zombies
             * aparezcan dentro de las filas, y no fuera de lugar.
             */
            if (a == 0) {
                y = 70;
            }
            if (a == 1) {
                y = 150;
            }
            if (a == 2) {
                y = 230;
            }
            if (a == 3) {
                y = 310;
            }
            if (a == 4) {
                y = 390;
            }
            Zombie zombie = new Zombie(x, y); // Crear nuevo objeto zombie
            zombie_list.add(zombie); // agregar zombie al arraylist de zombies.
        }
    }

    /* Metodo que mueve los zombies. Este metodo al iniciarce crea un arreglo de tipo
     * administrarZombie, que es nuestra clase hilo que controla el movimiento de los 
     * Zombies. El tamaño del arreglo es del mismo tamaño del arrayList de zombies. Luego 
     * de crear el arreglo, se declara un for con la longitud del arrayList. Como ambos el 
     * arreglo y el arrayList tienen la misma logitud, entonces a cada posicion i del arreglo
     * se le esta asignando un nuevo objeto o hilo administrarZombie, que esta clase hilo recibe
     * como parametro un zombie, entonces le mandamos la posicion i del arrayList de zombies a la
     * clase hilo y asi se le va asignando un hilo a cada posicion del arreglo de hilos. Al finalizar
     * ese for de asignacion, se declara un segundo for tiene de longitud el tamaño del arreglo de hilos.
     * Este for recorre el arreglo de hilos, y a cada posicion se llama el metodo start de la clase hilo
     * y los hilos empiezan a trabajar.
     */
    public void moverZombies() {
        administrarZombie[] zombies = new administrarZombie[zombie_list.size()];
        for (int i = 0; i < zombie_list.size(); i++) { //For de asignacion 
            zombies[i] = new administrarZombie(zombie_list.get(i), this, plant_list, zombie_list); //Le asigna un hilo a la posicion i del arreglo
        }
        for (int i = 0; i < zombies.length; i++) { //For recorre el arreglo de hilos
            zombies[i].start(); //Inicia el hilo en la posicion i del arreglo
        }
    }

    /*Metodo que nos pone nuestra coordenada en Y para nuestra planta, recibe una Cadena que contiene
     * un caracter, y dependiendo el caracter le asigna un valor para Y por medio un bloque caso.
     */
    public int filas(String Y) {
        int y = 0;
        switch (Y) {
            case "A":
                y = 90;
                break;
            case "B":
                y = 170;
                break;
            case "C":
                y = 250;
                break;
            case "D":
                y = 320;
                break;
            case "E":
                y = 400;
                break;
            default:
                JOptionPane.showMessageDialog(this, "Coordenada no Valida!");
                break;
        }
        return y;
    }
    /*Metodo que nos pone nuestra coordenada en X para nuestra planta, recibe una Cadena que contiene
     * un caracter, y dependiendo el caracter le asigna un valor para Y por medio un bloque caso.
     */

    public int columnas(int X) {
        int x = 0;
        switch (X) {
            case 1:
                x = 160;
                break;
            case 2:
                x = 210;
                break;
            case 3:
                x = 260;
                break;
            case 4:
                x = 310;
                break;
            case 5:
                x = 360;
                break;
            case 6:
                x = 420;
                break;
            case 7:
                x = 470;
                break;
            case 8:
                x = 510;
                break;
            case 9:
                x = 560;
                break;
            default:
                JOptionPane.showMessageDialog(this, "Coordenada no Valida!");
                break;
        }
        return x;
    }

    public void gameLoop() {
        ponerZombies();
        moverZombies();
    }
}
