package GUI.MarvelTactica;

import Datos.Datardos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogoReg extends JFrame implements ActionListener {

    Datardos datos = new Datardos();

    public LogoReg(ArrayList<String> usernames, ArrayList<String> passes) {
        Canva();
    }

    JPasswordField Pass;
    JTextField Username;
    JLabel Name;
    JButton LogIn, Register, Cancel, concretar, regresar, BTNReveal;
    ;
    JFrame Canvas;
    int gamble;

    private void Canva() {
        //Data getter
        for (int loop = 0; loop < datos.getUsernames().size(); loop++) {
            if (datos.getUsernames().get(loop).equals(datos.getUser(""))) {
                gamble = loop;
            }
        }
        //main JFrame info
        Canvas = new JFrame();

        Canvas.setIconImage(new javax.swing.ImageIcon(getClass().getResource("Icons\\Icon.png")).getImage());
        Canvas.setResizable(false);
        Canvas.setSize(800, 320);
        Canvas.setLocationRelativeTo(null);
        Canvas.setTitle("Account options");
        Canvas.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        //General Panel
        JPanel Caja = new JPanel();
        JLabel BCKG = new JLabel(new javax.swing.ImageIcon(getClass().getResource("Icons\\LogoReg.png")));
        
        BCKG.setBounds(0, 0, 800, 320);
        Caja.setLayout(null);
        Caja.setSize(800, 320);
        Caja.setBackground(Color.black);
        //Texto aclarativo
        JLabel UpperText = new JLabel();

        UpperText.setFont(new Font("Lucida Bright", 3, 30));
        UpperText.setBounds(0, 15, Caja.getWidth(), 35);
        UpperText.setVerticalAlignment(JLabel.CENTER);
        UpperText.setHorizontalAlignment(JLabel.CENTER);
        UpperText.setForeground(Color.white);
        UpperText.setText("Informacion de la cuenta");
        //Name
        Name = new JLabel();

        Name.setText(datos.getUsernames().get(gamble));
        Name.setForeground(Color.white);
        Name.setFont(new Font("Lucida Bright", 3, 40));
        Name.setBounds(525, 70, 250, 50);
        //Username
        Username = new JTextField();

        Username.setText(datos.getUsernames().get(gamble));
        Username.setForeground(Color.gray);
        Username.setEditable(false);
        Username.setFont(new Font("Lucida Bright", 3, 22));
        Username.setBounds(50, 70, 450, 50);
        //Pass
        Pass = new JPasswordField();

        Pass.setText(datos.getPasses().get(gamble));
        Pass.setForeground(Color.gray);
        Pass.setEditable(false);
        Pass.setFont(new Font("Lucida Bright", 3, 22));
        Pass.setBounds(50, 145, 375, 50);
        //Boton revelar contrasegna
        ImageIcon image = new ImageIcon(getClass().getResource("Icons\\eye.png"));
        Image Scaleimage = image.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH);
        ImageIcon Eye = new ImageIcon(Scaleimage);
        BTNReveal = new JButton();

        BTNReveal.setBackground(new Color(155, 0, 0));
        BTNReveal.addActionListener(this);
        BTNReveal.setIcon(Eye);
        BTNReveal.setBorder(javax.swing.BorderFactory.createLineBorder(Color.yellow, 2));
        BTNReveal.setBounds(450, 145, 50, 50);
        //Boton Log in
        LogIn = new JButton();

        LogIn.addActionListener(this);
        LogIn.setForeground(new Color(239, 243, 130));
        LogIn.setBackground(new Color(155, 0, 0));
        LogIn.setFont(new Font("Lucida Bright", 3, 28));
        LogIn.setBounds(525, 70, 225, 50);
        LogIn.setBorder(javax.swing.BorderFactory.createLineBorder(Color.yellow, 4));
        LogIn.setText("Login");
        //Boton Registro
        Register = new JButton();

        Register.addActionListener(this);
        Register.setBorder(javax.swing.BorderFactory.createLineBorder(Color.yellow, 4));
        Register.setForeground(new Color(239, 243, 130));
        Register.setBackground(new Color(155, 0, 0));
        Register.setFont(new Font("Lucida Bright", 3, 28));
        Register.setBounds(525, 145, 225, 50);
        Register.setText("Registrar");
        //boton 'Concretar cambios'
        concretar = new JButton();

        concretar.addActionListener(this);
        concretar.setBorder(javax.swing.BorderFactory.createLineBorder(Color.yellow, 4));
        concretar.setForeground(new Color(239, 243, 130));
        concretar.setBackground(new Color(155, 0, 0));
        concretar.setFont(new Font("Lucida Bright", 3, 28));
        concretar.setBounds(50, 220, 300, 50);
        concretar.setText("Cambiar datos");
        //boton 'Cancelar cambios'
        regresar = new JButton();

        regresar.addActionListener(this);
        regresar.setBorder(javax.swing.BorderFactory.createLineBorder(Color.yellow, 4));
        regresar.setForeground(new Color(239, 243, 130));
        regresar.setBackground(new Color(155, 0, 0));
        regresar.setFont(new Font("Lucida Bright", 3, 28));
        regresar.setBounds(450, 220, 300, 50);
        regresar.setText("DEliminar Cuenta");
        //Boton de regresar
        Cancel = new JButton();

        Cancel.addActionListener(this);
        Cancel.setBorder(javax.swing.BorderFactory.createLineBorder(Color.yellow, 4));
        Cancel.setForeground(new Color(239, 243, 130));
        Cancel.setBackground(new Color(155, 0, 0));
        Cancel.setFont(new Font("Lucida Bright", 3, 22));
        Cancel.setBounds(0, 0, 45, 45);
        Cancel.setText("«");
        //Adicion de Opciones
        Caja.add(UpperText);
        Caja.add(LogIn);
        Caja.add(Cancel);
        Caja.add(Register);
        Caja.add(Username);
        Caja.add(Pass);
        Caja.add(BTNReveal);
        Caja.add(concretar);
        Caja.add(regresar);
        Caja.add(BCKG);
        
        Canvas.add(Caja);
        Canvas.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == LogIn) {
            datos.setChange(false);
            new LogScene(datos).setVisible(false);
            Canvas.dispose();
        } else if (e.getSource() == Register) {
            new RegScene(datos).setVisible(false);
            Canvas.dispose();
            if (datos.getUser("").equals("Guest"))
                JOptionPane.showMessageDialog(Canvas, "\t Por favor iniciar session...");
        } else if (e.getSource() == Cancel) {
            Canvas.dispose();
            new MainScene(datos).setVisible(false);
        } else if (e.getSource() == BTNReveal && Pass.echoCharIsSet()) {
            Pass.setEchoChar((char) 0);
        } else if (e.getSource() == BTNReveal && Pass.echoCharIsSet() == false) {
            Pass.setEchoChar('\u2022');
        } else if ((e.getSource() == concretar || e.getSource() == regresar) && regresar.getText().equals("Eliminar cuenta") && !datos.getUser("").equals("Guest")) {
            String ActPass = JOptionPane.showInputDialog(Canvas, "Ingrese su contraseña");
            if (datos.getUser("").equals(datos.getUsernames().get(gamble)) && datos.getPasses().get(gamble).equals(ActPass)) {
                if (e.getSource() == regresar) {
                    datos.getUsernames().remove(gamble);
                    datos.getMirrorUsernames().remove(gamble);
                    datos.getPasses().remove(gamble);
                    datos.getWins().remove(gamble);
                    datos.getLosses().remove(gamble);
                    datos.getMirrorPuntos().remove(gamble);
                    datos.getPuntos().remove(gamble);
                    datos.getHeroes().remove(gamble);
                    datos.getVillanos().remove(gamble);

                    datos.setUser("Guest");
                    Canvas.dispose();
                    new MainScene(datos).setVisible(false);
                } else if (e.getSource() == concretar) {
                    concretar.setText("Guardar cambios");
                    regresar.setText("Cancelar cambios");

                    Username.setForeground(Color.black);
                    Pass.setForeground(Color.black);

                    Username.setEditable(true);
                    Pass.setEditable(true);
                }
            }
        } else if ((e.getSource() == concretar || e.getSource() == regresar) && regresar.getText().equals("Cancelar cambios") && !datos.getUser("").equals("Guest") && Pass.getText().length() == 5) {
            if (e.getSource() == concretar) {
                datos.getUsernames().set(gamble, Username.getText());
                datos.getPasses().set(gamble, Pass.getText());
            } else if (e.getSource() == regresar) {
                Username.setText(datos.getUsernames().get(gamble));
                Pass.setText(datos.getPasses().get(gamble));
            }
            concretar.setText("Cambiar datos");
            regresar.setText("Eliminar cuenta");

            Username.setForeground(Color.gray);
            Pass.setForeground(Color.gray);

            Username.setEditable(false);
            Pass.setEditable(false);
        }
    }
}
