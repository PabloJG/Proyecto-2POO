package Model;
import View.Aliado;
import View.Enemigo;
import java.util.ArrayList; 

public class Factory{
    //public static Enemigo[] enemigos;
    public static ArrayList<Enemigo> enemigos = new ArrayList<Enemigo>();
    public static ArrayList<Aliado> aliados = new ArrayList<Aliado>();

    public Factory (){
        iniciaralia();
        iniciarenem();
    }

    public void iniciaralia(){
        for(int i = 0; i<3; i++){
            aliados.add(new Aliado());
        }
    }

    public void iniciarenem(){
        for(int i = 0; i<3; i++){
            enemigos.add(new Enemigo());
        }
    }
        
}
