package GUI.MarvelTactica;

import Datos.Datardos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class NeoMap extends JFrame implements ActionListener {
    Datardos datos = new Datardos();
    Random Randy = new Random();

    String HoV = "Heroe", turn;
    boolean Legal = false, movement = false, first = true;
    int acc1 = 0, acc2 = 0, HP = 0, VP = 0, loop, fila, columna, fila0, columna0, MaFi, MeFi, MaCo, MeCo;

    public NeoMap(Datardos datos) {
        Yggdrasil();
    }
    JFrame Canva = new JFrame();
    Image Scalecard;
    Date Fecha = new Date();
    JButton Ginyu, Resign;
    ImageIcon hidden, neocard;
    JLabel txtuser1, txtuser2;
    JPanel Mapa, Portrait1, Portrait2;

    String Illegal[] = {"villain\\0- (1).png", "villain\\0- (35).png", "villain\\0- (36).png", "villain\\0- (37).png", "villain\\0- (38).png", "villain\\0- (39).png", "villain\\0- (40).png", "Heroes\\0- (1).png", "Heroes\\0- (35).png", "Heroes\\0- (36).png", "Heroes\\0- (37).png", "Heroes\\0- (38).png", "Heroes\\0- (39).png", "Heroes\\0- (40).png"};
    ImageIcon Cards[][] = new ImageIcon[40][2];
    JButton Botones[][] = new JButton[10][10];
    JButton taken[][] = new JButton[40][2];
    JLabel portrait[] = new JLabel[2];
    int troops[][] = new int[12][2];
    boolean Moves[] = new boolean[4];
    //AI movement
    boolean MoAv[] = new boolean[4];
    ArrayList<Integer> row = new ArrayList();
    ArrayList<Integer> column = new ArrayList();

    private void Yggdrasil() {
        try {
            //Iconos
            hidden = new ImageIcon(getClass().getResource("Scrolls.png"));
            fila = 0;
            columna = 0;
            for (loop = 0; loop < 40; loop++) {
                Cards[loop][0] = new ImageIcon(getClass().getResource("Heroes\\0- (" + (loop + 1) + ").png"));
                Cards[loop][0].setDescription("Heroes\\0- (" + (loop + 1) + ").png");

                Cards[loop][1] = new ImageIcon(getClass().getResource("villain\\0- (" + (loop + 1) + ").png"));
                Cards[loop][1].setDescription("villain\\0- (" + (loop + 1) + ").png");

                if (loop == 10 || loop == 19 || loop == 28 || loop == 37) {
                    fila += 50;
                    columna = 0;
                }

                for (acc1 = 0; acc1 < 2; acc1++) {
                    taken[loop][acc1] = new JButton();
                    taken[loop][acc1].setVisible(false);
                    taken[loop][acc1].setBounds(columna, fila, 50, 50);
                }
                columna += 25;
            }
            //loop inicializacion de botones
            for (fila = 0; fila < 10; fila++) {
                for (columna = 0; columna < 10; columna++) {
                    Botones[fila][columna] = new JButton();
                    Botones[fila][columna].setName("free");
                }
            }
            //Cantidad de enemigos/heroes
            fila = 0;
            for (loop = 1; loop >= 0; loop--) {
                troops[0][loop] = 1;
                troops[1][loop] = 1;
                troops[2][loop] = 8;
                troops[3][loop] = 5;
                troops[4][loop] = 4;
                troops[5][loop] = 4;
                troops[6][loop] = 4;
                troops[7][loop] = 3;
                troops[8][loop] = 2;
                troops[9][loop] = 1;
                troops[10][loop] = 1;
                troops[11][loop] = 6;
//EARTH & SURROUNDING BOMBS SPAWNS EARTH & SURROUNDING BOMBS SPAWNS EARTH & SURROUNDING BOMBS SPAWNS EARTH & SURROUNDING BOMBS SPAWNS EARTH & SURROUNDING BOMBS SPAWNS EARTH & SURROUNDING BOMBS SPAWNS EARTH & SURROUNDING BOMBS SPAWNS EARTH & SURROUNDING BOMBS SPAWNS EARTH & SURROUNDING BOMBS SPAWNS EARTH & SURROUNDING BOMBS SPAWNS EARTH & SURROUNDING BOMBS SPAWNS EARTH & SURROUNDING BOMBS SPAWNS EARTH & SURROUNDING BOMBS SPAWNS EARTH & SURROUNDING BOMBS SPAWNS 
                do {
                    columna = Randy.nextInt(10);
                } while (columna == 9 || columna == 0);
                Botones[columna][fila].setText("0");
                //EARTH SPAWN
                Scalecard = Cards[0][loop].getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                Botones[columna][fila].setName(Cards[0][loop].getDescription());
                neocard = new ImageIcon(Scalecard);
                Botones[columna][fila].setIcon(neocard);
                troops[0][loop]--;
                //LEFT BOMB
                Botones[columna - 1][fila].setText("11");
                Scalecard = Cards[39][loop].getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                Botones[columna - 1][fila].setName(Cards[39][loop].getDescription());
                neocard = new ImageIcon(Scalecard);
                Botones[columna - 1][fila].setIcon(neocard);
                troops[11][loop]--;
                //RIGHT BOMB
                Botones[columna + 1][fila].setText("11");
                Scalecard = Cards[38][loop].getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                Botones[columna + 1][fila].setName(Cards[38][loop].getDescription());
                neocard = new ImageIcon(Scalecard);
                Botones[columna + 1][fila].setIcon(neocard);
                troops[11][loop]--;
                //TOP/BUTTON BOMB
                if (fila == 0) {
                    Scalecard = Cards[37][loop].getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                    Botones[columna][fila + 1].setName(Cards[37][loop].getDescription());
                    neocard = new ImageIcon(Scalecard);
                    Botones[columna][fila + 1].setIcon(neocard);
                    Botones[columna][fila + 1].setText("11");
                } else {
                    Scalecard = Cards[37][loop].getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                    Botones[columna][fila - 1].setName(Cards[37][loop].getDescription());
                    neocard = new ImageIcon(Scalecard);
                    Botones[columna][fila - 1].setIcon(neocard);
                    Botones[columna][fila - 1].setText("11");
                }
                troops[11][loop]--;
                fila = 9;
                acc1 = 36;
                if (loop == 1) {
                    fila0 = 1;
                } else {
                    fila0 = 9;
                }
//BOMBS SPAWN BOMBS SPAWN BOMBS SPAWN BOMBS SPAWN BOMBS SPAWN BOMBS SPAWN BOMBS SPAWN BOMBS SPAWN BOMBS SPAWN BOMBS SPAWN BOMBS SPAWN BOMBS SPAWN BOMBS SPAWN BOMBS SPAWN BOMBS SPAWN BOMBS SPAWN BOMBS SPAWN BOMBS SPAWN BOMBS SPAWN BOMBS SPAWN BOMBS SPAWN BOMBS SPAWN BOMBS SPAWN BOMBS SPAWN BOMBS SPAWN BOMBS SPAWN BOMBS SPAWN BOMBS SPAWN BOMBS SPAWN BOMBS SPAWN BOMBS SPAWN BOMBS SPAWN BOMBS SPAWN BOMBS SPAWN BOMBS SPAWN  
                do {
                    if (loop == 1 && fila0 == -1) {
                        fila0 = 1;
                    } else if (loop == 0 && fila0 == 7) {
                        fila0 = 9;
                    }
                    do {
                        columna0 = Randy.nextInt(10);
                    } while (columna0 == 10);
                    if (Botones[columna0][fila0].getName().equals("free")) {
                        Botones[columna0][fila0].setName(Cards[acc1][loop].getDescription());
                        Scalecard = Cards[acc1][loop].getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                        neocard = new ImageIcon(Scalecard);
                        Botones[columna0][fila0].setIcon(neocard);
                        Botones[columna0][fila0].setText("11");
                        troops[11][loop]--;
                        acc1--;
                    }
                    fila0--;
                } while (troops[11][loop] > 0);
//TOWERS SPAWN (RANGE 2) TOWERS SPAWN (RANGE 2) TOWERS SPAWN (RANGE 2) TOWERS SPAWN (RANGE 2) TOWERS SPAWN (RANGE 2) TOWERS SPAWN (RANGE 2) TOWERS SPAWN (RANGE 2) TOWERS SPAWN (RANGE 2) TOWERS SPAWN (RANGE 2) TOWERS SPAWN (RANGE 2) TOWERS SPAWN (RANGE 2) TOWERS SPAWN (RANGE 2) TOWERS SPAWN (RANGE 2) TOWERS SPAWN (RANGE 2) TOWERS SPAWN (RANGE 2) TOWERS SPAWN (RANGE 2) TOWERS SPAWN (RANGE 2) TOWERS SPAWN (RANGE 2) TOWERS SPAWN (RANGE 2) 
                if (loop == 1) {
                    fila0 = 2;
                } else {
                    fila0 = 6;
                }
                acc1 = 25;
                do {
                    if (loop == 1 && fila0 == 4) {
                        fila0 = 2;
                    } else if (loop == 0 && fila0 == 8) {
                        fila0 = 6;
                    }
                    do {
                        columna0 = Randy.nextInt(10);
                    } while (columna0 == 10);
                    if (Botones[columna0][fila0].getName().equals("free")) {
                        Botones[columna0][fila0].setName(Cards[acc1][loop].getDescription());
                        Scalecard = Cards[acc1][loop].getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                        neocard = new ImageIcon(Scalecard);
                        Botones[columna0][fila0].setIcon(neocard);
                        Botones[columna0][fila0].setText("2");
                        troops[2][loop]--;
                        acc1++;
                    }
                    fila0++;
                } while (troops[2][loop] > 0);
            }
            //JFrame general            

            Canva.setIconImage(new javax.swing.ImageIcon(getClass().getResource("Icons\\Icon.png")).getImage());
            Canva.setSize(1015, 650);
            Canva.setResizable(false);
            Canva.setTitle("MARVEL'S STRATEGO");
            Canva.setLocationRelativeTo(null);
            Canva.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
            //Map background
            JPanel Caja = new JPanel();
            JLabel MB = new JLabel();

            MB.setIcon(new ImageIcon(getClass().getResource("Icons\\Map_BCKG.jpg")));
            MB.setBounds(0, 0, 1015, 650);

            Caja.setLayout(null);
            Caja.setSize(1015, 650);
            //Square size
            Mapa = new JPanel();

            Mapa.setLayout(null);
            Mapa.setBounds(250, 80, 500, 500);
            Mapa.setBackground(Color.BLACK);
            //Boton de inicio
            Ginyu = new JButton();

            Ginyu.addActionListener(this);
            Ginyu.setBounds(250, 30, 200, 40);
            Ginyu.setFont(new Font("Lucida Bright", 3, 30));
            Ginyu.setText("Cambiar turno");
            Ginyu.setForeground(new Color(239, 243, 130));
            Ginyu.setBackground(new Color(155, 0, 0));
            Ginyu.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED, 2));
            //Resign button
            Resign = new JButton();

            Resign.addActionListener(this);
            Resign.setBounds(550, 30, 200, 40);
            Resign.setText("Rendirse");
            Resign.setForeground(new Color(239, 243, 130));
            Resign.setBackground(new Color(155, 0, 0));
            Resign.setBorder(javax.swing.BorderFactory.createLineBorder(Color.yellow, 4));
            Resign.setFont(new Font("Lucida Bright", 3, 30));
            //Boton hell
            for (fila = 0; fila < 10; fila++) {
                acc1 = 0;
                for (columna = 0; columna < 10; columna++) {
                    Botones[columna][fila].setBackground(Color.black);
                    //Villain's side
                    if (fila <= 3 && Botones[columna][fila].getText().isBlank()) {
                        do {
                            loop = Randy.nextInt(12);
                        } while (loop > 11 || troops[loop][0] == 0);
                        Botones[columna][fila].setText(String.valueOf(loop));

                        troops[loop][0]--;
                        turn = "1";
                        //Heroe's side
                    } else if (fila >= 6 && Botones[columna][fila].getText().isBlank()) {
                        do {
                            loop = Randy.nextInt(12);
                        } while (loop > 11 || troops[loop][1] == 0);
                        Botones[columna][fila].setText(String.valueOf(loop));

                        troops[loop][1]--;
                        turn = "0";
                    } else if (fila == 4 || fila == 5) {
                        if (columna == 2 || columna == 3 || columna == 6 || columna == 7) {
                            Botones[columna][fila].setName("Ocupado");
                            
                            Botones[columna][fila].setIcon(new ImageIcon(getClass().getResource("Icons\\Cloud.png")));
                            Botones[columna][fila].setBackground(Color.black);
                        }
                        turn = "3";
                        Botones[columna][fila].setText("0");
                    }
                    Botones[columna][fila].addActionListener(this);
                    Botones[columna][fila].setIconTextGap(-50);
                    Botones[columna][fila].setForeground(new Color(0, 0, 0, 0));
                    Botones[columna][fila].setBounds(acc1, acc2, 50, 50);
                    if ((fila != 4 || fila != 5) && !turn.equals("3")) {
                        do {
                            loop = Randy.nextInt(40);
                            if (loop < 40 && !Cards[loop][Integer.parseInt(turn)].getDescription().equals("Used")) {
                                if (Botones[columna][fila].getText().equals("10") && loop == 1) {
                                    Scalecard = Cards[loop][Integer.parseInt(turn)].getImage().getScaledInstance(60, 50, Image.SCALE_SMOOTH);
                                    neocard = new ImageIcon(Scalecard);
                                    Botones[columna][fila].setName(Cards[loop][Integer.parseInt(turn)].getDescription());
                                    Cards[loop][Integer.parseInt(turn)].setDescription("Used");
                                    turn = "3";
                                } else if (Botones[columna][fila].getText().equals("9") && (loop == 2)) {
                                    Scalecard = Cards[loop][Integer.parseInt(turn)].getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                                    neocard = new ImageIcon(Scalecard);
                                    Botones[columna][fila].setName(Cards[loop][Integer.parseInt(turn)].getDescription());
                                    Cards[loop][Integer.parseInt(turn)].setDescription("Used");
                                    turn = "3";
                                } else if (Botones[columna][fila].getText().equals("8") && (loop == 3 || loop == 4)) {
                                    Scalecard = Cards[loop][Integer.parseInt(turn)].getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                                    neocard = new ImageIcon(Scalecard);
                                    Botones[columna][fila].setName(Cards[loop][Integer.parseInt(turn)].getDescription());
                                    Cards[loop][Integer.parseInt(turn)].setDescription("Used");
                                    turn = "3";
                                } else if (Botones[columna][fila].getText().equals("7") && (loop >= 5 && loop <= 7)) {
                                    Scalecard = Cards[loop][Integer.parseInt(turn)].getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                                    neocard = new ImageIcon(Scalecard);
                                    Botones[columna][fila].setName(Cards[loop][Integer.parseInt(turn)].getDescription());
                                    Cards[loop][Integer.parseInt(turn)].setDescription("Used");
                                    turn = "3";
                                } else if (Botones[columna][fila].getText().equals("6") && (loop >= 8 && loop <= 11)) {
                                    Scalecard = Cards[loop][Integer.parseInt(turn)].getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                                    neocard = new ImageIcon(Scalecard);
                                    Botones[columna][fila].setName(Cards[loop][Integer.parseInt(turn)].getDescription());
                                    Cards[loop][Integer.parseInt(turn)].setDescription("Used");
                                    turn = "3";
                                } else if (Botones[columna][fila].getText().equals("5") && (loop >= 12 && loop <= 15)) {
                                    Scalecard = Cards[loop][Integer.parseInt(turn)].getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                                    neocard = new ImageIcon(Scalecard);
                                    Botones[columna][fila].setName(Cards[loop][Integer.parseInt(turn)].getDescription());
                                    Cards[loop][Integer.parseInt(turn)].setDescription("Used");
                                    turn = "3";
                                } else if (Botones[columna][fila].getText().equals("4") && (loop >= 16 && loop <= 19)) {
                                    Scalecard = Cards[loop][Integer.parseInt(turn)].getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                                    neocard = new ImageIcon(Scalecard);
                                    Botones[columna][fila].setName(Cards[loop][Integer.parseInt(turn)].getDescription());
                                    Cards[loop][Integer.parseInt(turn)].setDescription("Used");
                                    turn = "3";
                                } else if (Botones[columna][fila].getText().equals("3") && (loop >= 20 && loop <= 24)) {
                                    Scalecard = Cards[loop][Integer.parseInt(turn)].getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                                    neocard = new ImageIcon(Scalecard);
                                    Botones[columna][fila].setName(Cards[loop][Integer.parseInt(turn)].getDescription());
                                    Cards[loop][Integer.parseInt(turn)].setDescription("Used");
                                    turn = "3";
                                } else if (Botones[columna][fila].getText().equals("2") && (loop >= 25 && loop <= 32)) {
                                    Scalecard = Cards[loop][Integer.parseInt(turn)].getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                                    neocard = new ImageIcon(Scalecard);
                                    Botones[columna][fila].setName(Cards[loop][Integer.parseInt(turn)].getDescription());
                                    Cards[loop][Integer.parseInt(turn)].setDescription("Used");
                                    turn = "3";
                                } else if (Botones[columna][fila].getText().equals("1") && (loop == 33)) {
                                    Scalecard = Cards[loop][Integer.parseInt(turn)].getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                                    neocard = new ImageIcon(Scalecard);
                                    Botones[columna][fila].setName(Cards[loop][Integer.parseInt(turn)].getDescription());
                                    Cards[loop][Integer.parseInt(turn)].setDescription("Used");
                                    turn = "3";
                                } else if (Botones[columna][fila].getText().equals("11") && (loop >= 34)) {
                                    Scalecard = Cards[loop][Integer.parseInt(turn)].getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                                    neocard = new ImageIcon(Scalecard);
                                    Botones[columna][fila].setName(Cards[loop][Integer.parseInt(turn)].getDescription());
                                    Cards[loop][Integer.parseInt(turn)].setDescription("Used");
                                    turn = "3";
                                }
                            }
                            Botones[columna][fila].setIcon(neocard);
                        } while (loop >= 40 || !turn.equals("3"));
                    }
                    if (datos.isPractice() == false && Botones[columna][fila].getName().contains("villain") && (fila != 4 || fila != 5)) {
                        Scalecard = hidden.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                        neocard = new ImageIcon(Scalecard);
                        Botones[columna][fila].setIcon(neocard);
                    }
                    if (Botones[columna][fila].getName().contains(HoV) && (datos.isHTP() == true || datos.isPractice() == true)) {
                        Botones[columna][fila].setBorder(javax.swing.BorderFactory.createLineBorder(Color.YELLOW, 1));
                    } else if (datos.isPractice() == true) {
                        Botones[columna][fila].setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED, 1));
                    }
                    Mapa.add(Botones[columna][fila]);
                    acc1 += 50;
                }
                acc2 += 50;
            }
            //user 1 side
            txtuser1 = new JLabel();
            txtuser1.setText(datos.getUser(""));
            if (datos.isSelected() == false) {
                txtuser1.setName("villain");
            } else {
                turn = txtuser1.getText();
                txtuser1.setName("Heroe");
            }
            txtuser1.setForeground(Color.white);
            txtuser1.setBounds(0, 30, 250, 50);
            txtuser1.setVerticalAlignment(JLabel.CENTER);
            txtuser1.setHorizontalAlignment(JLabel.CENTER);
            txtuser1.setFont(new Font("Lucida Bright", 3, 30));
            //Portrait 1 
            Portrait1 = new JPanel();
            portrait[0] = new JLabel();

            portrait[0].setIcon(null);
            portrait[0].setBounds(0, 0, 250, 250);
            Portrait1.setLayout(null);
            Portrait1.setOpaque(false);
            Portrait1.setBounds(0, 80, 250, 250);
            //Taken 1
            JPanel taken1 = new JPanel();

            taken1.setLayout(null);
            taken1.setBackground(null);
            taken1.setOpaque(false);
            taken1.setBounds(0, 330, 250, 250);
            for (loop = 0; loop < 40; loop++) {
                taken1.add(taken[loop][0]);
            }
            //user 2 side
            txtuser2 = new JLabel();
            txtuser2.setText(datos.getUser2(""));
            if (datos.isSelected() == true) {
                txtuser2.setName("villain");
            } else {
                turn = txtuser2.getText();
                txtuser2.setName("Heroe");
            }
            txtuser2.setForeground(Color.white);
            txtuser2.setBounds(750, 30, 250, 50);
            txtuser2.setVerticalAlignment(JLabel.CENTER);
            txtuser2.setHorizontalAlignment(JLabel.CENTER);
            txtuser2.setFont(new Font("Lucida Bright", 3, 30));
            //Portrait 2 
            Portrait2 = new JPanel();
            portrait[1] = new JLabel();

            portrait[1].setIcon(null);
            portrait[1].setBounds(0, 0, 250, 250);
            Portrait2.setLayout(null);
            Portrait2.setOpaque(false);
            Portrait2.setBounds(750, 80, 250, 250);
            //Taken 2
            JPanel taken2 = new JPanel();

            taken2.setLayout(null);
            taken2.setBackground(null);
            taken2.setOpaque(false);
            taken2.setBounds(750, 330, 250, 250);
            for (loop = 0; loop < 40; loop++) {
                taken2.add(taken[loop][1]);
            }
            //loop identificador de nombres
            for (loop = 0; loop < datos.getUsernames().size(); loop++) {
                if (datos.getUsernames().get(loop).equals(datos.getUser(""))) {
                    acc1 = loop;
                }
                if (datos.getUsernames().get(loop).equals(datos.getUser2(""))) {
                    acc2 = loop;
                }
            }
            //Adicion de complementos
            Canva.add(Caja);
            Caja.add(Mapa);
            Caja.add(Resign);
            Caja.add(Ginyu);
            Caja.add(txtuser1);
            Caja.add(Portrait1);
            Portrait1.add(portrait[0]);
            Caja.add(taken1);
            Caja.add(txtuser2);
            Caja.add(Portrait2);
            Portrait2.add(portrait[1]);
            Caja.add(taken2);
            Caja.add(MB);

            Canva.setVisible(true);
        } catch (Exception e) {
            Canva.dispose();
            new NeoMap(datos).setVisible(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (fila = 0; fila < 10; fila++) {
            for (columna = 0; columna < 10; columna++) {
                if (e.getSource() == Botones[columna][fila] && Botones[columna][fila].getName().contains(HoV) && movement == false) {
                    columna0 = columna;
                    fila0 = fila;
                    MaCo = columna0;
                    MeCo = columna0;
                    MaFi = fila0;
                    MeFi = fila0;
                    Legal = true;
                    if (Botones[columna0][fila0].getName().contains("Heroe")) {
                        portrait[0].setIcon(new ImageIcon(getClass().getResource(Botones[columna0][fila0].getName())));
                    } else {
                        portrait[1].setIcon(new ImageIcon(getClass().getResource(Botones[columna0][fila0].getName())));
                    }
                    for (loop = 0; loop < Illegal.length; loop++) {
                        if (Illegal[loop].contains(Botones[columna][fila].getName())) {
                            Legal = false;
                        }
                    }
                    if (Legal == true) {
                        movement = true;
                        Moves[0] = false;
                        Moves[1] = false;
                        Moves[2] = false;
                        Moves[3] = false;
//LEFT MOVEMENT LEFT MOVEMENT LEFT MOVEMENT LEFT MOVEMENT LEFT MOVEMENT LEFT MOVEMENT LEFT MOVEMENT LEFT MOVEMENT LEFT MOVEMENT LEFT MOVEMENT LEFT MOVEMENT LEFT MOVEMENT LEFT MOVEMENT LEFT MOVEMENT LEFT MOVEMENT LEFT MOVEMENT LEFT MOVEMENT LEFT MOVEMENT LEFT MOVEMENT LEFT MOVEMENT 
                        do {
                            Resign.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED, 2));
                            if (columna != 0) {
                                columna--;
                            }
                            if (columna != 0 && !Botones[columna][fila].getName().equals("Ocupado") && (!Botones[columna][fila].getName().contains(HoV) || (Botones[columna + 1][fila].getName().equals("free")))) {
                                Botones[columna][fila].setBorder(javax.swing.BorderFactory.createLineBorder(Color.GREEN, 4));
                                movement = false;
                                Moves[0] = true;
                                if (Botones[columna0][fila0].getText().equals("2") && !Botones[columna][fila].getName().equals("Ocupado")) {
                                    movement = true;
                                    if (!Botones[columna][fila].getName().contains("free")) {
                                        movement = false;
                                    }
                                }
                            } else {
                                if (columna == 0 && (!Botones[columna][fila].getName().contains(HoV))) {
                                    Moves[0] = true;
                                    Botones[columna][fila].setBorder(javax.swing.BorderFactory.createLineBorder(Color.GREEN, 4));
                                }
                                movement = false;
                            }
                            if (!Botones[columna][fila].getName().equals("Ocupado") && (!Botones[columna][fila].getName().contains(HoV))) {
                                MeCo = columna;
                            }
                        } while (movement == true);
                        movement = true;
//RIGHT MOVEMENT RIGHT MOVEMENT RIGHT MOVEMENT RIGHT MOVEMENT RIGHT MOVEMENT RIGHT MOVEMENT RIGHT MOVEMENT RIGHT MOVEMENT RIGHT MOVEMENT RIGHT MOVEMENT RIGHT MOVEMENT RIGHT MOVEMENT RIGHT MOVEMENT RIGHT MOVEMENT RIGHT MOVEMENT RIGHT MOVEMENT RIGHT MOVEMENT RIGHT MOVEMENT RIGHT MOVEMENT 
                        columna = columna0;
                        fila = fila0;
                        do {
                            if (columna != 9) {
                                columna++;
                            }
                            if (columna != 9 && !Botones[columna][fila].getName().equals("Ocupado") && (!Botones[columna][fila].getName().contains(HoV) || (Botones[columna - 1][fila].getName().equals("free")))) {
                                Moves[1] = true;
                                Botones[columna][fila].setBorder(javax.swing.BorderFactory.createLineBorder(Color.GREEN, 4));
                                movement = false;
                                if (Botones[columna0][fila0].getText().equals("2") && !Botones[columna][fila].getName().equals("Ocupado")) {
                                    movement = true;
                                    if (!Botones[columna][fila].getName().contains("free")) {
                                        movement = false;
                                    }
                                }
                            } else {
                                if ((columna == 9) && (!Botones[columna][fila].getName().contains(HoV))) {
                                    Moves[1] = true;
                                    Botones[columna][fila].setBorder(javax.swing.BorderFactory.createLineBorder(Color.GREEN, 4));
                                }
                                movement = false;
                            }
                            if (!Botones[columna][fila].getName().equals("Ocupado") && (!Botones[columna][fila].getName().contains(HoV))) {
                                MaCo = columna;
                            }
                        } while (movement == true);
                        movement = true;
//UP MOVEMENT UP MOVEMENT UP MOVEMENT UP MOVEMENT UP MOVEMENT UP MOVEMENT UP MOVEMENT UP MOVEMENT UP MOVEMENT UP MOVEMENT UP MOVEMENT UP MOVEMENT UP MOVEMENT UP MOVEMENT UP MOVEMENT UP MOVEMENT UP MOVEMENT UP MOVEMENT UP MOVEMENT UP MOVEMENT UP MOVEMENT UP MOVEMENT UP MOVEMENT 
                        columna = columna0;
                        fila = fila0;
                        do {
                            if (fila != 9) {
                                fila++;
                            }
                            if (fila != 9 && !Botones[columna][fila].getName().equals("Ocupado") && (!Botones[columna][fila].getName().contains(HoV))) {
                                Botones[columna][fila].setBorder(javax.swing.BorderFactory.createLineBorder(Color.GREEN, 4));
                                movement = false;
                                Moves[2] = true;
                                if (Botones[columna0][fila0].getText().equals("2") && !Botones[columna][fila].getName().equals("Ocupado")) {
                                    movement = true;
                                    if (!Botones[columna][fila].getName().contains("free")) {
                                        movement = false;
                                    }
                                }
                            } else {
                                if (fila == 9 && (!Botones[columna][fila].getName().contains(HoV))) {
                                    Moves[2] = true;
                                    Botones[columna][fila].setBorder(javax.swing.BorderFactory.createLineBorder(Color.GREEN, 4));
                                }
                                movement = false;
                            }
                            if (!Botones[columna][fila].getName().equals("Ocupado") && (!Botones[columna][fila].getName().contains(HoV))) {
                                MaFi = fila;
                            }
                        } while (movement == true);
                        movement = true;
//DOWN MOVEMENT DOWN MOVEMENT DOWN MOVEMENT DOWN MOVEMENT DOWN MOVEMENT DOWN MOVEMENT DOWN MOVEMENT DOWN MOVEMENT DOWN MOVEMENT DOWN MOVEMENT DOWN MOVEMENT DOWN MOVEMENT DOWN MOVEMENT DOWN MOVEMENT DOWN MOVEMENT DOWN MOVEMENT DOWN MOVEMENT DOWN MOVEMENT DOWN MOVEMENT DOWN MOVEMENT                     
                        fila = fila0;
                        do {
                            if (fila != 0) {
                                fila--;
                            }
                            if (fila != 0 && !Botones[columna][fila].getName().equals("Ocupado") && !Botones[columna][fila].getName().contains(HoV)) {
                                Botones[columna][fila].setBorder(javax.swing.BorderFactory.createLineBorder(Color.GREEN, 4));
                                movement = false;
                                Moves[3] = true;
                                if (Botones[columna0][fila0].getText().equals("2") && !Botones[columna][fila].getName().equals("Ocupado")) {
                                    movement = true;
                                    if (!Botones[columna][fila].getName().contains("free")) {
                                        movement = false;
                                    }
                                }
                            } else {
                                if (fila == 0 && (!Botones[columna][fila].getName().contains(HoV))) {
                                    Moves[3] = true;
                                    Botones[columna][fila].setBorder(javax.swing.BorderFactory.createLineBorder(Color.GREEN, 4));
                                }
                                movement = false;
                            }
                            if (!Botones[columna][fila].getName().equals("Ocupado") && (!Botones[columna][fila].getName().contains(HoV))) {
                                MeFi = fila;
                            }
                        } while (movement == true);
                        if (Moves[0] == true || Moves[1] == true || Moves[2] == true || Moves[3] == true) {
                            movement = true;
                            if (datos.isPractice()&&first)
                                JOptionPane.showMessageDialog(Canva, "click on one of the spaces with a green border to concrete your move, this will only work if it's on a free \nspace or an enemy troop. Every piece has a range, if your piece has a greater range than the enemy one it will beat it,\nthe only exception being if a range 1 battle a range 10 as it will succeed (if the range 10 starts the battle it will win)");
                        }
                    } else if (datos.isPractice()&&first) JOptionPane.showMessageDialog(Canva, "Click on a troop who has free spaces near by");
                    fila = 11;
                    columna = 11;
//CAPTURE SPACE CAPTURE SPACE CAPTURE SPACE CAPTURE SPACE CAPTURE SPACE CAPTURE SPACE CAPTURE SPACE CAPTURE SPACE CAPTURE SPACE CAPTURE SPACE CAPTURE SPACE CAPTURE SPACE CAPTURE SPACE CAPTURE SPACE CAPTURE SPACE CAPTURE SPACE CAPTURE SPACE CAPTURE SPACE CAPTURE SPACE CAPTURE SPACE CAPTURE SPACE CAPTURE SPACE CAPTURE SPACE CAPTURE SPACE CAPTURE SPACE CAPTURE SPACE CAPTURE SPACE CAPTURE SPACE CAPTURE SPACE CAPTURE SPACE CAPTURE SPACE 
                } else if (e.getSource() == Botones[columna][fila] && movement == true && Legal == true) {
                    Resign.setBorder(javax.swing.BorderFactory.createLineBorder(Color.yellow, 4));
                    movement = false;
                    if ((((fila >= MeFi && fila <= MaFi) && columna == columna0) || ((columna >= MeCo && columna <= MaCo) && fila == fila0)) && Botones[columna][fila] != Botones[columna0][fila0]) {
                        Resign.setBorder(javax.swing.BorderFactory.createLineBorder(Color.red, 2));
                        if (Botones[columna][fila].getText().equals("0")) {
                            portrait[0].setIcon(null);
                            portrait[1].setIcon(null);
                        }
                        Ginyu.setBorder(javax.swing.BorderFactory.createLineBorder(Color.YELLOW, 4));
                        if (Botones[columna][fila].getText().equals("0") && !Botones[columna][fila].getName().equals("Ocupado") && !Botones[columna][fila].getName().equals("free")) {
                            if (datos.isPractice() == false) {
                                if (turn.equals(txtuser2.getText())) {
                                    datos.getPuntos().set(acc1, (datos.getPuntos().get(acc1) + 3));
                                    datos.getWins().set(acc1, (datos.getWins().get(acc1) + 1));
                                    datos.getLosses().set(acc2, datos.getLosses().get(acc2) + 1);
                                    datos.getLog().add(txtuser2.getText().toUpperCase() + " CAPTURED THE PLANET OF " + txtuser1.getText().toUpperCase() + " - (DD/MM/YYYY) - " + Fecha.getDate() + "/" + (Fecha.getMonth() + 1) + "/" + Fecha.getYear());
                                } else if (turn.equals(txtuser1.getText())) {
                                    datos.getPuntos().set(acc2, (datos.getPuntos().get(acc2) + 3));
                                    datos.getWins().set(acc2, (datos.getWins().get(acc2) + 1));
                                    datos.getLosses().set(acc1, datos.getLosses().get(acc1) + 1);
                                    datos.getLog().add(txtuser1.getText().toUpperCase() + " CAPTURED THE PLANET OF " + txtuser2.getText().toUpperCase() + " -  (DD/MM/YYYY) - " + Fecha.getDate() + "/" + (1 + Fecha.getMonth()) + "/" + Fecha.getYear());
                                }
                                JOptionPane.showMessageDialog(Canva, datos.getLog().get(datos.getLog().size()-1));
                            }
                            datos.setPractice(false);
                            Canva.dispose();
                            new MainScene(datos).setVisible(false);
                        }
                        if ((Botones[columna0][fila0].getText().equals("3") && Botones[columna][fila].getText().equals("11")) || (Botones[columna0][fila0].getText().equals("1") && Botones[columna][fila].getText().equals("10"))) {
                            Legal = false;
                        }
                        if (Legal == false || Integer.parseInt(Botones[columna0][fila0].getText()) > Integer.parseInt(Botones[columna][fila].getText())) {
                            if (Botones[columna][fila].getName().contains("villain") && !Botones[columna][fila].getText().equals("0")) {
                                neocard = new ImageIcon(getClass().getResource(Botones[columna][fila].getName()));
                                Scalecard = neocard.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                                neocard = new ImageIcon(Scalecard);
                                taken[HP][0].setIcon(neocard);
                                taken[HP][0].setVisible(true);
                                HP++;
                            } else if (!Botones[columna][fila].getText().equals("0")) {
                                neocard = new ImageIcon(getClass().getResource(Botones[columna][fila].getName()));
                                Scalecard = neocard.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                                neocard = new ImageIcon(Scalecard);
                                taken[VP][1].setIcon(neocard);
                                taken[VP][1].setVisible(true);
                                VP++;
                            }
                            Botones[columna][fila].setText(Botones[columna0][fila0].getText());
                            Botones[columna][fila].setName(Botones[columna0][fila0].getName());
                            neocard = new ImageIcon(getClass().getResource(Botones[columna0][fila0].getName()));
                            Scalecard = neocard.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                            neocard = new ImageIcon(Scalecard);
                            Botones[columna][fila].setIcon(neocard);
                        } else if (Integer.parseInt(Botones[columna0][fila0].getText()) == Integer.parseInt(Botones[columna][fila].getText())) {
                            Botones[columna][fila].setText("0");
                            Botones[columna][fila].setName("free");
                            Botones[columna][fila].setIcon(null);
                        }
                        if (Botones[columna][fila].getText().equals("11")) {
                            Botones[columna][fila].setText("0");
                            Botones[columna][fila].setName("free");
                            Botones[columna][fila].setIcon(null);
                        }
                        Botones[columna0][fila0].setText("0");
                        Botones[columna0][fila0].setName("free");
                        Botones[columna0][fila0].setIcon(null);
                        for (columna = 0; columna < 10; columna++) {
                            for (fila = 0; fila < 10; fila++) {
                                if (!Botones[columna][fila].getName().equals("free") && !Botones[columna][fila].getName().equals("Ocupado") && datos.isPractice() == false && datos.isHTP() == false) {
                                    Scalecard = hidden.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                                    neocard = new ImageIcon(Scalecard);
                                    Botones[columna][fila].setIcon(neocard);
                                } else if (Botones[columna][fila].getName().contains(HoV) && datos.isPractice() == true) {
                                    Botones[columna][fila].setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED, 1));
                                }
                            }
                        }

                        if (turn.equals(txtuser1.getText())) {
                            turn = txtuser2.getText();
                        } else {
                            turn = txtuser1.getText();
                        }
                        movement = true;
                        Legal = false;
                    }
                    for (loop = columna0; loop <= MaCo; loop++) {
                        Botones[loop][fila0].setBorder(new JButton().getBorder());
                    }
                    for (loop = columna0; loop >= MeCo; loop--) {
                        Botones[loop][fila0].setBorder(new JButton().getBorder());
                    }
                    for (loop = fila0; loop <= MaFi; loop++) {
                        Botones[columna0][loop].setBorder(new JButton().getBorder());
                    }
                    for (loop = fila0; loop >= MeFi; loop--) {
                        Botones[columna0][loop].setBorder(new JButton().getBorder());
                    }
                    fila = 11;
                    columna = 11;
                    if (datos.isPractice()&&first)
                        JOptionPane.showMessageDialog(Canva, "After every move, being from a hero or a villain, you'll need to press the 'Change' button, on a real match every troop will be hidden so that will \nmark the end of your turn. If you eat an enemy troop and your range is greater the troop will be on display so the enemy\nwill know which troop you use on him and can react to it, so be carefull with your moves");
                }
            }
        }
//Cambiar turno Cambiar turno Cambiar turno Cambiar turno Cambiar turnoCambiar turno Cambiar turno Cambiar turno Cambiar turnoCambiar turnoCambiar turno Cambiar turno Cambiar turnoCambiar turnoCambiar turno Cambiar turnoCambiar turnoCambiar turno Cambiar turnoCambiar turnoCambiar turno Cambiar turno Cambiar turno Cambiar turno Cambiar turno Cambiar turno Cambiar turno Cambiar turno 
        if (e.getSource() == Ginyu && Legal == false && movement == true) {
            Legal = true;
            movement = false;
            Ginyu.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED, 2));
            Resign.setBorder(javax.swing.BorderFactory.createLineBorder(Color.yellow, 4));
            if (datos.isHTP() == false) {
                if (HoV.equals("Heroe")) {
                    HoV = "villain";
                } else {
                    HoV = "Heroe";
                }
                for (columna = 0; columna < 10; columna++) {
                    for (fila = 0; fila < 10; fila++) {
                        if (!Botones[columna][fila].getName().equals("free") && !Botones[columna][fila].getName().equals("Ocupado") && Botones[columna][fila].getName().contains(HoV)) {
                            neocard = new ImageIcon(getClass().getResource(Botones[columna][fila].getName()));
                            Scalecard = neocard.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                            neocard = new ImageIcon(Scalecard);
                            Botones[columna][fila].setIcon(neocard);
                        }
                        if (Botones[columna][fila].getName().contains(HoV) && (datos.isHTP() == true || datos.isPractice() == true)) {
                            Botones[columna][fila].setBorder(javax.swing.BorderFactory.createLineBorder(Color.YELLOW, 1));
                        }
                    }
                }
                if (datos.isPractice()&&first)
                    JOptionPane.showMessageDialog(Canva, "You win by either eating the planet of your enemy, beating all his troops or he resigns. Both, your planet and the enemy, is surrounded by explosives\nso be careful when infiltrating on the enemy side, as they beat every troop (except the range 3 whom can defuse 'em)");
                first=false;
            } else {
//IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF 
                row.clear();
                column.clear();
                acc1 = 0; //Mayor rango del villano
                for (fila = 0; fila < 10; fila++) {
                    for (columna = 0; columna < 10; columna++) {
                        MoAv[0] = false;
                        MoAv[1] = false;
                        MoAv[2] = false;
                        MoAv[3] = false;
                        if (Botones[columna][fila].getName().contains("villain")) {
                            if (columna != 0) {
                                if (Botones[columna - 1][fila].getName().equals("free") || Botones[columna - 1][fila].getName().contains(HoV)) {
                                    MoAv[0] = true;
                                }
                            }
                            if (columna != 9) {
                                if (Botones[columna + 1][fila].getName().equals("free") || Botones[columna + 1][fila].getName().contains(HoV)) {
                                    MoAv[1] = true;
                                }
                            }
                            if (fila != 0) {
                                if (Botones[columna][fila - 1].getName().equals("free") || Botones[columna][fila - 1].getName().contains(HoV)) {
                                    MoAv[2] = true;
                                }
                            }
                            if (fila != 9) {
                                if (Botones[columna][fila + 1].getName().equals("free") || Botones[columna][fila + 1].getName().contains(HoV)) {
                                    MoAv[3] = true;
                                }
                            }
                            if ((MoAv[0] == true || MoAv[1] == true || MoAv[2] == true || MoAv[3] == true) && (!Botones[columna][fila].getText().equals("0") && !Botones[columna][fila].getText().equals("11"))) {
                                row.add(fila);
                                column.add(columna);
                            }
                        }
                    }
                }

                do {
                    loop = Randy.nextInt(row.size());
                    fila = fila0 = row.get(loop);
                    columna = columna0 = column.get(loop);
                    if (columna != 0 && Botones[columna - 1][fila].getName().contains(HoV)) {
                        columna--;
                    } else if (columna != 9 && Botones[columna + 1][fila].getName().contains(HoV)) {
                        columna++;
                    } else if (fila != 0 && Botones[columna][fila - 1].getName().contains(HoV)) {
                        fila--;
                    } else if (fila != 9 && Botones[columna][fila + 1].getName().contains(HoV)) {
                        fila++;
                    }
                    loop = Randy.nextInt(2);
                    if (loop == 0) {
                        if (columna != 0 && (columna == columna0 && fila == fila0)) {
                            if (Botones[columna - 1][fila].getName().equals("free")) {
                                columna--;
                            }
                        }
                        if (columna != 9 && (columna == columna0 && fila == fila0)) {
                            if (Botones[columna + 1][fila].getName().equals("free")) {
                                columna++;
                            }
                        }
                    } else {
                        if (fila != 0 && (columna == columna0 && fila == fila0)) {
                            if (Botones[columna][fila - 1].getName().equals("free")) {
                                fila--;
                            }
                        }
                        if (fila != 9 && (columna == columna0 && fila == fila0)) {
                            if (Botones[columna][fila + 1].getName().equals("free")) {
                                fila++;
                            }
                        }
                    }
                } while (fila == fila0 && columna == columna0);
//IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF IA STUFF
                if (Botones[columna][fila].getText().equals("0") && !Botones[columna][fila].getName().equals("Ocupado") && !Botones[columna][fila].getName().equals("free")) {
                    Canva.dispose();
                }

                if ((Botones[columna0][fila0].getText().equals("3") && Botones[columna][fila].getText().equals("11")) || (Botones[columna][fila].getText().equals("1") && Botones[columna][fila].getText().equals("10"))) {
                    Legal = false;
                }

                if (Legal == false || Integer.parseInt(Botones[columna0][fila0].getText()) > Integer.parseInt(Botones[columna][fila].getText())) {
                    if (Botones[columna][fila].getName().contains("villain") && !Botones[columna][fila].getText().equals("0")) {
                        neocard = new ImageIcon(getClass().getResource(Botones[columna][fila].getName()));
                        Scalecard = neocard.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                        neocard = new ImageIcon(Scalecard);
                        taken[HP][0].setIcon(neocard);
                        taken[HP][0].setVisible(true);
                        HP++;
                    } else if (!Botones[columna][fila].getText().equals("0")) {
                        neocard = new ImageIcon(getClass().getResource(Botones[columna][fila].getName()));
                        Scalecard = neocard.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                        neocard = new ImageIcon(Scalecard);
                        taken[VP][1].setIcon(neocard);
                        taken[VP][1].setVisible(true);
                        VP++;
                    }
                    if (!Botones[columna][fila].getText().equals("0")) {
                        portrait[1].setIcon(new ImageIcon(getClass().getResource(Botones[columna0][fila0].getName())));
                    }
                    Botones[columna][fila].setText(Botones[columna0][fila0].getText());
                    Botones[columna][fila].setName(Botones[columna0][fila0].getName());
                    neocard = new ImageIcon(getClass().getResource(Botones[columna0][fila0].getName()));
                    Scalecard = neocard.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                    neocard = new ImageIcon(Scalecard);
                    Botones[columna][fila].setIcon(neocard);
                } else if (Integer.parseInt(Botones[columna0][fila0].getText()) == Integer.parseInt(Botones[columna][fila].getText())) {
                    Botones[columna][fila].setText("0");
                    Botones[columna][fila].setName("free");
                    Botones[columna][fila].setIcon(null);
                }
                if (Botones[columna][fila].getText().equals("11")) {
                    Botones[columna][fila].setText("0");
                    Botones[columna][fila].setName("free");
                    Botones[columna][fila].setIcon(null);
                }
                Botones[columna0][fila0].setText("0");
                Botones[columna0][fila0].setName("free");
                Botones[columna0][fila0].setIcon(null);

                if (datos.isPractice() == false){
                    Scalecard = hidden.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                    neocard = new ImageIcon(Scalecard);
                    Botones[columna][fila].setIcon(neocard);
                } 
            }
            Legal = true;
            movement = false;
            if (datos.isPractice()&&first)
                JOptionPane.showMessageDialog(Canva, "On solo mode you'll face a training AI, the only wining condition will be eating his planet card or beating all his troops as he will not resign.");
            first=false;
        }
//Dejar partida Dejar partida Dejar partida Dejar partida Dejar partida Dejar partida Dejar partida Dejar partida Dejar partida Dejar partida Dejar partida Dejar partida Dejar partida Dejar partida Dejar partida Dejar partida Dejar partida Dejar partida Dejar partida Dejar partida Dejar partida Dejar partida Dejar partida Dejar partida Dejar partida Dejar partida Dejar partida Dejar partida         
        if (e.getSource() == Resign && movement == false) {
            if (datos.isPractice() == false && !datos.getUser2("").equals("Guest")) {
                if (turn.equals(txtuser2.getText())) {
                    datos.getPuntos().set(acc1, (datos.getPuntos().get(acc1) + 3));
                    datos.getWins().set(acc1, (datos.getWins().get(acc1) + 1));
                    datos.getLosses().set(acc2, datos.getLosses().get(acc2) + 1);
                    datos.getLog().add(txtuser2.getText().toUpperCase() + " Se Rindio, la vistoria es para: " + txtuser1.getText().toUpperCase() + " - (DD/MM/YYYY)  - " + Fecha.getDate() + "/" + (Fecha.getMonth() + 1) + "/" + Fecha.getYear());
                } else if (turn.equals(txtuser1.getText())) {
                    datos.getPuntos().set(acc2, (datos.getPuntos().get(acc2) + 3));
                    datos.getWins().set(acc2, (datos.getWins().get(acc2) + 1));
                    datos.getLosses().set(acc1, datos.getLosses().get(acc1) + 1);
                    datos.getLog().add(txtuser1.getText().toUpperCase() + " Se rindio, la victoria es para: " + txtuser2.getText().toUpperCase() + " - (DD/MM/YYYY) - " + Fecha.getDate() + "/" + (1 + Fecha.getMonth()) + "/" + Fecha.getYear());
                }
                JOptionPane.showMessageDialog(Canva, datos.getLog().get(datos.getLog().size()-1));
            }
            datos.setPractice(false);
            Canva.dispose();
            new MainScene(datos).setVisible(false);
        }
    }
}
