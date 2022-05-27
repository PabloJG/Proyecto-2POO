package Model;
import View.Aliado;
import View.Enemigo;

public class Factory{
    public static Enemigo[] enemigos;
    Aliado[] aliados;

    public Factory (){
        enemigos = new Enemigo[100];
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
            enemigos[i] = new Enemigo(i);
        }
    }
        
}
