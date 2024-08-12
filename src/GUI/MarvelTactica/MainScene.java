package GUI.MarvelTactica;

import Datos.Datardos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainScene extends JFrame implements ActionListener{
    Random Randy = new Random();
    Datardos datos = new Datardos();
    
    public MainScene(Datardos datos){
        MainMenu();
    }
    
    int BI;
    JFrame Canva;
    BufferedImage BCKG, Play, Prac;
    JButton Jugar, Practica, Ajustes, Estadisticas, Registro, PracI, PlayI;
    private void MainMenu(){
        //JFrame general
        Canva = new JFrame();
        
        Canva.setIconImage(new javax.swing.ImageIcon(getClass().getResource("Icons\\Icon.png")).getImage());
        Canva.setSize(800,650);
        Canva.setResizable(false);
        Canva.setTitle("MARVEL'S STRATEGO");
        Canva.setLocationRelativeTo(null);
        Canva.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        //Panel entero (todo el JFrame)
        JPanel Panel = new JPanel();
        do {
            BI = Randy.nextInt(6);
        } while (BI > 4 || BI == 0);
        try{ 
            switch(BI){
                case 1 -> {
                    BCKG = ImageIO.read(getClass().getResource("Icons\\BCKG1.png"));
                }
                case 2 -> {
                    BCKG = ImageIO.read(getClass().getResource("Icons\\BCKG2.png"));
                }
                case 3 -> {
                    BCKG = ImageIO.read(getClass().getResource("Icons\\BCKG3.png"));
                }
            }
            Play = ImageIO.read(getClass().getResource("Icons\\Play.png"));
        } catch (IOException e){
            System.out.println("Error");
        }
        JLabel BCKGF = new JLabel(new ImageIcon(BCKG));
        BCKGF.setBounds(0, 0, 800, 650); 
        
        Panel.add(BCKGF);
        Panel.setLayout(null);
        Panel.setSize(800,650);
        
        //Panel de Menu
        JPanel Opciones = new JPanel();
        
        Opciones.setLayout(null);
        Opciones.setBackground(new Color(210,33,33,100));
        Opciones.setBounds(50, -5, 320, 650);
        Opciones.setBorder(javax.swing.BorderFactory.createLineBorder(Color.red,4));
        
        //Panel de logo
        ImageIcon image = new ImageIcon(getClass().getResource("Icons\\Logo.png"));
        Image Scaleimage = image.getImage().getScaledInstance(260, 140, Image.SCALE_SMOOTH);
        ImageIcon neoimage = new ImageIcon(Scaleimage);
        JLabel imagen = new JLabel();
        
        imagen.setIcon(neoimage);
        imagen.setBounds(25, 30, 260, 140);        
        //Panel boton juego
        JPanel PlayP = new JPanel();
        PlayI = new JButton();
        PlayI.addActionListener(this);
        PlayI.setIcon(new ImageIcon(Play));
        PlayI.setBounds(0, 0, 160, 145);        
        PlayI.setBorder(javax.swing.BorderFactory.createLineBorder(Color.yellow, 4));
        
        PlayP.add(PlayI);
        PlayP.setLayout(null);
        PlayP.setBounds(80, 190, 160, 175);
        //Boton de juego
        Jugar = new JButton();
        
        Jugar.setText("Jugar");
        Jugar.addActionListener(this);
        Jugar.setBackground(new Color(155,0,0));
        Jugar.setForeground(new Color(239, 243, 130));
        Jugar.setFont(new Font("Lucida Bright",3,20));
        Jugar.setBorder(javax.swing.BorderFactory.createLineBorder(Color.yellow, 3));
        Jugar.setBounds(0,145,PlayP.getWidth(),30);        
        //Practice Panel
      /*  JPanel PracP = new JPanel();
        PracI = new JButton();
        PracI.addActionListener(this);
        PracI.setIcon(new ImageIcon(Prac));
        PracI.setBounds(0, 0, 160, 90);
        PracI.setBorder(javax.swing.BorderFactory.createLineBorder(Color.yellow, 4));
        
        PracP.add(PracI);
        PracP.setLayout(null);
        PracP.setBounds(80, 385, 160, 120);
        //Boton de practica
        Practica = new JButton();
        
        Practica.setText("PRACTICE");
        Practica.addActionListener(this);
        Practica.setBackground(new Color(155,0,0));
        Practica.setForeground(new Color(239, 243, 130));
        Practica.setFont(new Font("Lucida Bright",3,20));
        Practica.setBorder(javax.swing.BorderFactory.createLineBorder(Color.yellow, 3));
        Practica.setBounds(0,90,160,30);    */  
        //Boton de Ajustes
        Ajustes = new JButton();
        
        Ajustes.setText("Salir");
        Ajustes.addActionListener(this);
        Ajustes.setBackground(new Color(155,0,0));
        Ajustes.setForeground(new Color(239, 243, 130));
        Ajustes.setFont(new Font("Lucida Bright",3,20));
        Ajustes.setBorder(javax.swing.BorderFactory.createLineBorder(Color.yellow, 3));
        Ajustes.setBounds(80,575,160,30);        
        //Boton de Estadisticas
        Estadisticas = new JButton(); 
        
        Estadisticas.setText("Cuenta");
        Estadisticas.addActionListener(this);
        Estadisticas.setBackground(new Color(155,0,0));
        Estadisticas.setForeground(new Color(239, 243, 130));
        Estadisticas.setFont(new Font("Lucida Bright",3,20));
        Estadisticas.setBorder(javax.swing.BorderFactory.createLineBorder(Color.yellow, 3));
        Estadisticas.setBounds(80,525,160,30);        
        //Panel de perfil
        JPanel Personal = new JPanel();
        
        Personal.setLayout(null);
        Personal.setBackground(new Color(210,33,33,100));
        Personal.setBounds(550,-5,350,85);
        Personal.setBorder(javax.swing.BorderFactory.createLineBorder(Color.red,4));        
        //Boton creacion de cuenta
        Registro = new JButton();
        
        ImageIcon regI = new ImageIcon(getClass().getResource("Icons\\Accounts.png"));
        Image ScaleReg = regI.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon neoReg = new ImageIcon(ScaleReg);
        JLabel RegIF = new JLabel();
        
        RegIF.setIcon(neoReg);
        RegIF.setBounds(5, 1, 50, 50);
        Registro.add(RegIF);
        Registro.setLayout(null);
        Registro.addActionListener(this);
        Registro.setBackground(new Color(155,0,0));
        Registro.setBounds(15,18,50,50);
        Registro.setBorder(javax.swing.BorderFactory.createLineBorder(Color.yellow,3));
        //txtbox 'Nombre de usuario'
        JTextField UsernameBox = new JTextField();
            
        UsernameBox.setText(datos.getUser(""));
        UsernameBox.setEditable(false);
        UsernameBox.setBounds(75,18,150,50);
        UsernameBox.setFont(new Font("Lucida Bright",3,18));
        
        //adicion de componentes generales
        Canva.add(Panel);
        Panel.add(Opciones);
        Panel.add(Personal);
        //Componentes del panel 'Menu'
        Opciones.add(imagen);
        Opciones.add(PlayP);
        PlayP.add(Jugar);
       // Opciones.add(PracP);
        //PracP.add(Practica);
        Opciones.add(Ajustes);
        Opciones.add(Estadisticas);
        //Componentes del panel 'Personales'
        Personal.add(Registro);
        Personal.add(UsernameBox);
        
        Panel.add(BCKGF);
        Canva.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ((e.getSource()==Jugar || e.getSource() == PlayI) && datos.getUsernames().size()>2 && !"Guest".equals(datos.getUser(""))){
            Canva.dispose();
            datos.setPractice(false);
            new BandChoose(datos).setVisible(false);
        } else if (e.getSource()==Jugar || e.getSource() == PlayI){
            JOptionPane.showMessageDialog(Canva,"Necesitas registrar dos cuentas primero");
            Canva.dispose();
            new RegScene(datos).setVisible(false);
            if (datos.getUser("").equals("Guest"))
                JOptionPane.showMessageDialog(Canva, "\tPor favor crear una cuenta");
        }
        
        if ((e.getSource()==Practica || e.getSource() == PracI)&& !"Guest".equals(datos.getUser(""))){
            Canva.dispose();
            datos.setPractice(true); 
            new BandChoose(datos).setVisible(false);
        } else if (e.getSource()==Practica || e.getSource() == PracI){
            JOptionPane.showMessageDialog(Canva,"You need to register into an account first");
            Canva.dispose();
            new RegScene(datos).setVisible(false);
            if (datos.getUser("").equals("Guest"))
JOptionPane.showMessageDialog(Canva, "\tPor favor crear una cuenta");        }
        if (e.getSource()==Ajustes){
            Canva.dispose();
        }
        
        if (e.getSource()==Registro && !"Guest".equals(datos.getUser(""))){
            new Stats(datos).setVisible(false);
        } else if (e.getSource()==Registro){
            JOptionPane.showMessageDialog(Canva,"You need to register into an account first");
            Canva.dispose();
            new RegScene(datos).setVisible(false);
            if (datos.getUser("").equals("Guest"))
JOptionPane.showMessageDialog(Canva, "\tPor favor crear una cuenta");        }
        
        if (e.getSource()==Estadisticas){
            Canva.dispose();
            datos.setChange(false);
            new LogoReg(datos.getUsernames(), datos.getPasses()).setVisible(false);
        }
    }
    
}
