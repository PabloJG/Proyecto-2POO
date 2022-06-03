package Model;
import View.*;
import java.util.ArrayList;

public class Factory{
    private Personaje personaje;
    public static ArrayList<Enemigo> enemigos = new ArrayList<Enemigo>();
    public static ArrayList<Aliado> aliados = new ArrayList<Aliado>();  

    public Factory(Personaje pers){
        personaje = pers;
    }

    void nuevoA(){
        aliados.add(new Aliado(personaje));
        Aliado.agregarObservers(personaje);
    }

    void nuevoE(){
        enemigos.add(new Enemigo(personaje));
        Enemigo.agregarObservers(personaje);
    }

    public void iniciaralia(){
        for(int i = 0; i<3; i++){
            nuevoA();
        }
    }

    public void iniciarenem(){
        for(int i = 0; i<3; i++){
            nuevoE();
        }
    }

    void agregarObs(){
        Enemigo.agregarObservers(personaje);
    }


    public boolean agregarE(int cant){
        if(cant == 9){
            nuevoE();
            return true;
        }
        return false;
    }
        
    public boolean agregarA(int cant){
        if(cant == 9){
            nuevoA();
            return true;
        }
        return false;
    }
}
