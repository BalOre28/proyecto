package GUI.MarvelTactica;
import Datos.Datardos;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class BandChoose extends JFrame implements ActionListener{
Datardos datos = new Datardos();
    
    public BandChoose(Datardos datos){
        Elector();
    }
    int gamble, change;
    
    JFrame Canva;
    JButton Regresar, Heroes, Villains, Tutorial, HI, VI;
    BufferedImage SuperHeroes, SuperVillains;
    private void Elector(){
        try {
            SuperHeroes = ImageIO.read(getClass().getResource("Icons\\Heroes.png"));
            SuperVillains = ImageIO.read(getClass().getResource("Icons\\Villains.png"));
        } catch (IOException ex) {
            System.out.println("Error");
        }
        //Data getter
        for (int loop=0; loop < datos.getUsernames().size();loop++){
            if (datos.getUsernames().get(loop).equals(datos.getUser(""))){
                gamble = loop;
            }
        }
        //Main frame
        Canva = new JFrame();
                
        Canva.setIconImage(new javax.swing.ImageIcon(getClass().getResource("Icons\\Icon.png")).getImage());
        Canva.setSize(400,385);
        Canva.setResizable(false);
        Canva.setTitle("Escoge tu bando");
        Canva.setLocationRelativeTo(null);
        Canva.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        //Main Frame
        JPanel Caja = new JPanel();
        
        Caja.setLayout(null);
        Caja.setSize(400,385);
        Caja.setBackground(Color.black); 
        //Boton regresar
        Regresar = new JButton();
        
        Regresar.addActionListener(this);
        Regresar.setText("«");
        Regresar.setForeground(new Color(239, 243, 130));
        Regresar.setBackground(new Color(155,0,0));
        Regresar.setFont(new Font("Lucida Bright",3,22));
        Regresar.setBounds(0,0,45,45);
        //Upper text
        JLabel UpperText = new JLabel();
        
        UpperText.setText("Escoge tu bando");
        UpperText.setBounds(0, 5, 400, 35);
        UpperText.setFont(new Font("Lucida Bright",3,30));
        UpperText.setVerticalAlignment(JLabel.CENTER);
        UpperText.setHorizontalAlignment(JLabel.CENTER);
        UpperText.setForeground(Color.white);
        //Hero's side
        JPanel Hero = new JPanel();
        Heroes = new JButton();
        HI = new JButton(new ImageIcon(SuperHeroes));
        
        HI.addActionListener(this);
        HI.setBorder(javax.swing.BorderFactory.createLineBorder(Color.yellow, 3));
        HI.setBounds(0, 0, 175, 180);
        
        Heroes.addActionListener(this);
        Heroes.setBorder(javax.swing.BorderFactory.createLineBorder(Color.yellow, 3));
        Heroes.setFont(new Font("Lucida Bright",3,24));
        Heroes.setForeground(new Color(239, 243, 130));
        Heroes.setBounds(0,180,175, 40);
        Heroes.setBackground(new Color(155,0,0));
        Heroes.setText("HEROES");
        
        Hero.setBounds(10, 60, 175, 220);
        Hero.setLayout(null);
        Hero.add(HI);
        Hero.add(Heroes);
        //Villains's side
        JPanel villano = new JPanel();
        Villains = new JButton();
        VI = new JButton(new ImageIcon(SuperVillains));
        
        VI.addActionListener(this);
        VI.setBorder(javax.swing.BorderFactory.createLineBorder(Color.yellow, 3));
        VI.setBounds(0, 0, 175, 180);
        
        Villains.addActionListener(this);
        Villains.setBorder(javax.swing.BorderFactory.createLineBorder(Color.yellow, 3));
        Villains.setFont(new Font("Lucida Bright",3,24));
        Villains.setForeground(new Color(239, 243, 130));
        Villains.setBackground(new Color(155,0,0));
        Villains.setBounds(0,180,175, 40);
        Villains.setText("VILLAINS");
        
        villano.setBounds(200, 60, 175, 220);
        villano.setLayout(null);
        villano.add(VI);
        villano.add(Villains);
        //How to play
        Tutorial = new JButton();
        
        Tutorial.addActionListener(this);
        Tutorial.setBorder(javax.swing.BorderFactory.createLineBorder(Color.yellow, 3));
        Tutorial.setFont(new Font("Lucida Bright",3,24));
        Tutorial.setForeground(new Color(239, 243, 130));
        Tutorial.setBounds(10,290,365, 40);
        Tutorial.setBackground(new Color(155,0,0));
      //  Tutorial.setText("Solo play");
        //Adicion de implementos
        Canva.add(Caja);
        Caja.add(Regresar);
        Caja.add(UpperText);
        Caja.add(Hero);
        Caja.add(villano);
        Caja.add(Tutorial);
        
        Canva.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        datos.setHTP(false);
        if (e.getSource()==Villains||e.getSource()==VI){
            Canva.dispose();
            datos.setSelected(false);
            datos.setChange(true);
            if (datos.isPractice()==true){
                datos.setUser2("Guest");
                new NeoMap(datos).setVisible(false);
                JOptionPane.showMessageDialog(Canva, "The first move will always be of the Heroes, succeeded by the villains. On practice\nmode the turns turns are represented with the yellow border around the troops");
            } else{
                change = datos.getVillanos().get(gamble);
                change++;
                datos.getVillanos().set(gamble, change);
                new LogScene(datos).setVisible(false);
                JOptionPane.showMessageDialog(Canva, "You need to log into the account of player 2");
            }
        }
        
        if (e.getSource()==Heroes||e.getSource()==HI){
            Canva.dispose();
            datos.setSelected(true); 
            datos.setChange(true);
            if (datos.isPractice()==true){
                datos.setUser2("Guest");
                new NeoMap(datos).setVisible(false);
                JOptionPane.showMessageDialog(Canva, "The first move will always be of the Heroes, succeeded by the villains. On practice\nmode the turns turns are represented with the yellow border around the troops, click\none of this yellow troops to move it.");
            } else {                
                change = datos.getHeroes().get(gamble);
                change++;
                datos.getHeroes().set(gamble, change);
                new LogScene(datos).setVisible(false);
                JOptionPane.showMessageDialog(Canva, "You need to log into the account of player 2");
            }
        }
        
        if (e.getSource()==Tutorial){
            Canva.dispose();
            datos.setHTP(true);
            datos.setUser2("Guest");
            new NeoMap(datos).setVisible(false);
            if (datos.isPractice())
            JOptionPane.showMessageDialog(Canva, "The first move will always be of the Heroes, succeeded by the villains. On practice\nmode the turns turns are represented with the yellow border around the troops");
        }
        
        if (e.getSource()==Regresar){
            new MainScene(datos).setVisible(false);
            Canva.dispose();
        }
    }

}
