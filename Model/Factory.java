package Model;
import View.Aliado;
import View.Enemigo;
import java.util.ArrayList; 

public class Factory{
    //public static Enemigo[] enemigos;
    public static ArrayList<Enemigo> enemigos = new ArrayList<Enemigo>();
    Aliado[] aliados;

    public Factory (){
        //enemigos = new Enemigo[100];
        aliados = new Aliado[3];
        iniciaralia();
        iniciarenem();
    }

    public void iniciaralia(){
        for(int i = 0; i<3; i++){
            aliados[i] = new Aliado(i);
        }
    }

    public void iniciarenem(){
        for(int i = 0; i<3; i++){
            enemigos.add(new Enemigo());
        }
    }
        
}
