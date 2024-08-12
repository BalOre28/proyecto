package Main;
import Datos.Datardos;
import GUI.MarvelTactica.MainScene;
public class Main {
    public static void main(String[] args) {
        Datardos dato = new Datardos();
        dato.setUser("Guest");
        dato.getMirrorUsernames().add("Guest");
        dato.getUsernames().add("Guest");
        dato.getPasses().add("");
        dato.getWins().add(0);
        dato.getLosses().add(0);
        dato.getMirrorPuntos().add(0);
        dato.getPuntos().add(0);
        dato.getHeroes().add(0);
        dato.getVillanos().add(0);
        
        dato.setChange(false);
        
        new MainScene(dato).setVisible(false);

    }

}
