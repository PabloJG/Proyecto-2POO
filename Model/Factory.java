package Model;
import View.*;
import java.util.ArrayList;

import Controller.Controller; 

public class Factory{
    Controller controlador;
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

    public void setCoordinador(Controller controlador) {
        this.controlador = controlador;
    }

    public static boolean agregarnuevoE(int cant){
        if(cant == 9){
            Factory.enemigos.add(new Enemigo());
            return true;
        }
        return false;
    }
        
    public static boolean agregarnuevoA(int cant){
        if(cant == 9){
            Factory.aliados.add(new Aliado());
            return true;
        }
        return false;
    }
}
