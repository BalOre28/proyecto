package GUI.MarvelTactica;

import Datos.Datardos;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Stats extends JFrame implements ActionListener{
    Datardos datos = new Datardos();
    
    public Stats(Datardos datos){
        DataEast();
    }
    int gamble = 0;
    
    JFrame Canva;
    JButton Regresar, log, logUni, Users, ranking, general;
    JPanel Caja;
    JTable Data;
    String rep;
    int loop, bucle, temp, wins, lost, heroes, villains;
    DefaultTableModel model;
    private void DataEast(){
        //Data getter
        for (loop=0; loop < datos.getUsernames().size();loop++){
            if (datos.getUsernames().get(loop).equals(datos.getUser(""))){
                gamble = loop;
            }
        }
        
        //Main Frame
        Canva = new JFrame();
    
        Canva.setIconImage(new javax.swing.ImageIcon(getClass().getResource("Icons\\Icon.png")).getImage());
        Canva.setSize(650,420);
        Canva.setResizable(false);
        Canva.setTitle("Player statistics");
        Canva.setLocationRelativeTo(null);
        Canva.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        //main Panel
        Caja = new JPanel();
        
        Caja.setLayout(null);
        Caja.setSize(650,420);
        Caja.setBackground(Color.black);
        //separador
        JSeparator Sep = new JSeparator();
        
        Sep.setOrientation(JSeparator.VERTICAL);
        Sep.setBounds(324, 15, 3, 360);
        //UpperText
        JLabel UpperText = new JLabel();
        
        UpperText.setText(datos.getUser("")+"'s data");      
        UpperText.setBounds(0, 0, 325, 45);
        UpperText.setForeground(Color.white);
        UpperText.setVerticalAlignment(JLabel.CENTER);
        UpperText.setHorizontalAlignment(JLabel.CENTER);    
        UpperText.setFont(new Font("Lucida Bright",3,28));
        //second uppertext
        JLabel Games = new JLabel();
        
        Games.setText("Games"); 
        Games.setForeground(Color.white);
        Games.setBounds(0, 80, 325, 45);  
        Games.setVerticalAlignment(JLabel.CENTER);
        Games.setHorizontalAlignment(JLabel.CENTER); 
        Games.setFont(new Font("Lucida Bright",3,22));          
        //Partidas ganadas
        JLabel Won = new JLabel();
        
        Won.setText("Won: "+datos.getWins().get(gamble)); 
        Won.setForeground(Color.white);
        Won.setBounds(10, 115, 315, 45);   
        Won.setFont(new Font("Lucida Bright",3,22));  
        //partidas perdidas
        JLabel lost = new JLabel();
        
        lost.setText("lost: "+datos.getLosses().get(gamble)); 
        lost.setForeground(Color.white);
        lost.setBounds(10, 150, 315, 45);  
        lost.setFont(new Font("Lucida Bright",3,22));
        //second uppertext
        JLabel played = new JLabel();
        
        played.setText("Matches won as: "); 
        played.setForeground(Color.white);
        played.setBounds(0, 185, 325, 45);  
        played.setVerticalAlignment(JLabel.CENTER);
        played.setHorizontalAlignment(JLabel.CENTER); 
        played.setFont(new Font("Lucida Bright",3,22));          
        //Partidas ganadas
        JLabel hero = new JLabel();
        
        hero.setText("Heroes: "+datos.getHeroes().get(gamble)); 
        hero.setForeground(Color.white);
        hero.setBounds(10, 220, 315, 45);   
        hero.setFont(new Font("Lucida Bright",3,22));  
        //partidas perdidas
        JLabel villain = new JLabel();
        
        villain.setText("Villains: "+datos.getVillanos().get(gamble)); 
        villain.setForeground(Color.white);
        villain.setBounds(10, 255, 315, 45);  
        villain.setFont(new Font("Lucida Bright",3,22));
        //puntos
        JLabel points = new JLabel();
        
        points.setText("Score: "+datos.getPuntos().get(gamble));      
        points.setBounds(0, 290, 325, 45);
        points.setForeground(Color.white);
        points.setVerticalAlignment(JLabel.CENTER);
        points.setHorizontalAlignment(JLabel.CENTER);    
        points.setFont(new Font("Lucida Bright",3,28));
        //Boton regresar
        Regresar = new JButton();
        
        Regresar.addActionListener(this);
        Regresar.setText("«");
        Regresar.setFont(new Font("Lucida Bright",3,22));
        Regresar.setBounds(0,0,45,45);
//ZONA DE LOG GLOBAL ZONA DE LOG GLOBAL ZONA DE LOG GLOBAL ZONA DE LOG GLOBAL ZONA DE LOG GLOBAL ZONA DE LOG GLOBAL ZONA DE LOG GLOBAL ZONA DE LOG GLOBAL ZONA DE LOG GLOBAL ZONA DE LOG GLOBAL ZONA DE LOG GLOBAL
        //Tabla de datos
        model = new DefaultTableModel();
        model.addColumn("Usernames");
        model.addColumn("status");
        model.addRow(new Object[] {"Usernames","Status"});
        for (loop=1;loop < datos.getUsernames().size();loop++){
            model.addRow(new Object[] {datos.getUsernames().get(loop),"Active"});
        }

        if (datos.getTaken().isEmpty()==false){
            for (loop = 0; loop < datos.getTaken().size();loop++){
                model.addRow(new Object[] {datos.getTaken().get(loop),"Deleted"});
            }
        }
        Data = new JTable(model);
        Data.setEnabled(false);
        Data.setBounds(335, 55, 290, 320);
        //User's log
        log = new JButton();
        
        log.addActionListener(this);
        log.setText("User's log");
        log.setFont(new Font("Lucida Bright",3,12));
        log.setBounds(335, 10, 58, 40);
        //User's log
        logUni = new JButton();
        
        logUni.addActionListener(this);
        logUni.setText("total log");
        logUni.setFont(new Font("Lucida Bright",3,12));
        logUni.setBounds(393, 10, 58, 40);
        //User's log
        Users = new JButton();
        
        Users.addActionListener(this);
        Users.setText("Users");
        Users.setFont(new Font("Lucida Bright",3,12));
        Users.setBounds(451, 10, 58, 40);
        //Ranking log
        ranking = new JButton();
        
        ranking.addActionListener(this);
        ranking.setText("Ranking");
        ranking.setFont(new Font("Lucida Bright",3,12));
        ranking.setBounds(509, 10, 58, 40);
        //General data
        general = new JButton();
        
        general.addActionListener(this);
        general.setText("General");
        general.setFont(new Font("Lucida Bright",3,12));
        general.setBounds(567, 10, 58, 40);        
        //Adicion de complementos
        Canva.add(Caja);
        Caja.add(Sep);
        Caja.add(UpperText);
        Caja.add(Games);
        Caja.add(Won);
        Caja.add(lost);
        Caja.add(played);
        Caja.add(hero);
        Caja.add(villain);
        Caja.add(points);
        Caja.add(Regresar);
        Caja.add(Data);
        Caja.add(log);
        Caja.add(logUni);
        Caja.add(Users);
        Caja.add(ranking);
        Caja.add(general);
        
        Canva.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.setColumnCount(0);
        model.setRowCount(0); 
        if (e.getSource()==Regresar){
            Canva.dispose();
        }
        
        if (e.getSource()==log){
            model.addColumn("Log");
            model.addRow(new Object[] {"User's log"});
            for (loop=0; loop < datos.getLog().size();loop++){
                if (datos.getLog().get(loop).contains(datos.getUser("").toUpperCase())){
                    model.addRow(new Object[] {datos.getLog().get(loop)});
                    System.out.println(datos.getLog().get(loop));
                }
            }
        }
        
        if (e.getSource()==general){
            temp = 0;
            wins = 0;
            lost = 0;
            heroes = 0;
            villains = 0;
            model.addColumn("request");
            model.addColumn("info");
            model.addRow(new Object[] {"Amount of active players: ",datos.getUsernames().size()-1});
            model.addRow(new Object[] {"Amount of deleted players: ",datos.getTaken().size()});
            model.addRow(new Object[] {"Amount of historical players: ",(datos.getTaken().size()+datos.getUsernames().size()-1)});
            for (loop=0;loop<datos.getWins().size();loop++){
                wins += datos.getWins().get(loop);
                temp += datos.getWins().get(loop);
            }
            model.addRow(new Object[] {"Matches won: ", wins});
            for (loop=0;loop<datos.getLosses().size();loop++){
                lost += datos.getLosses().get(loop);
                temp += datos.getLosses().get(loop);
            }
            model.addRow(new Object[] {"Matches lost: ", lost});
            for (loop=0; loop < datos.getHeroes().size();loop++){
                heroes += datos.getHeroes().get(loop);
            }
            model.addRow(new Object[] {"Matches played as heroes: ",heroes});
            for (loop=0; loop < datos.getVillanos().size();loop++){
                villains += datos.getHeroes().get(loop);
            }
            model.addRow(new Object[] {"Matches played as villains: ",villains});
            model.addRow(new Object[] {"Total matches played",(temp/2)});
        }
        
        if (e.getSource()==logUni){
            model.addColumn("Log");
            model.addRow(new Object[] {"Universal log"});
            for (loop=0; loop < datos.getLog().size();loop++){
                model.addRow(new Object[] {datos.getLog().get(loop)});
            }
        }
        
        if (e.getSource()==Users ) {
            model.addColumn("Usernames");
            model.addColumn("status");
            model.addRow(new Object[] {"Usernames","Status"});
            for (loop=1;loop < datos.getUsernames().size();loop++){
                model.addRow(new Object[] {datos.getUsernames().get(loop),"Active"});
            }
            
            if (datos.getTaken().isEmpty()==false){
                for (loop = 0; loop < datos.getTaken().size();loop++){
                    model.addRow(new Object[] {datos.getTaken().get(loop),"Deleted"});
                }
            }
        }
        
        if (e.getSource()==ranking){
            for (loop=1;loop < datos.getMirrorUsernames().size();loop++){
                datos.getMirrorPuntos().set(loop, datos.getPuntos().get(loop));
                datos.getMirrorUsernames().set(loop, datos.getUsernames().get(loop));
            }
            
            for (loop=1;loop < datos.getMirrorUsernames().size()-1;loop++){
                for (bucle = 1;bucle < datos.getMirrorUsernames().size()-loop;bucle++){
                    if (datos.getMirrorPuntos().get(bucle+1)>datos.getMirrorPuntos().get(bucle)){
                        temp = datos.getMirrorPuntos().get(bucle);
                        datos.getMirrorPuntos().set(bucle, datos.getMirrorPuntos().get(bucle+1));
                        datos.getMirrorPuntos().set(bucle+1, temp);
                        
                        rep = datos.getMirrorUsernames().get(bucle);
                        datos.getMirrorUsernames().set(bucle, datos.getMirrorUsernames().get(bucle+1));
                        datos.getMirrorUsernames().set(bucle+1, rep);
                    }
                }
            }     
            model.addColumn("Puesto");
            model.addColumn("Username");
            model.addColumn("Puntos");
            model.addRow(new Object[] {"POSITION","USERNAME","SCORE"});
            
            for (loop=1;loop < datos.getMirrorUsernames().size();loop++){
                model.addRow(new Object[] {loop,datos.getMirrorUsernames().get(loop),datos.getMirrorPuntos().get(loop)});
            }
        }
        
    }
    
}
