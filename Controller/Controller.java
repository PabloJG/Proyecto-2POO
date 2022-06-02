package Controller;
import java.util.ArrayList;

import Model.*;
import View.*;

public class Controller {
    private View matriz;
    Enemigo enemigo;
    Aliado aliado;
    Personaje pers;
    Model modelo;
    Factory fact;
    ArrayList<Enemigo> enemigos;

    public void setMatriz(View matriz) {
        this.matriz = matriz; 
    }

    public void setPersonaje(Personaje pers) {
        this.pers = pers;
    }

    public void setModelo(Model modelo) {
        this.modelo = modelo;
    }

    public void setFactory(Factory fact) {
        this.fact = fact;
        crear("enemigo");
        crear("aliado");
    }

    void crear(String tipo){
        switch(tipo){
            case "enemigo":
                fact.iniciarenem();
                
            break;
            case "aliado":
                fact.iniciaralia();
            break;
        }
    }

    public void disparo(int X, int Y, String posicion){
        modelo.disparo(X, Y, posicion);
    }

    public boolean agregarnuevoE(int cant){
        return fact.agregarnuevoE(cant);
    }

    public boolean agregarnuevoA(int cant){
        return fact.agregarnuevoA(cant);
    }

    public void eliminarE(int x, int i) {
        modelo.eliminarE(x, i);
    }

    void eliminarA(int fila, int columna){
        modelo.eliminarA(fila, columna);
    }

    public boolean sumarVida(int fila, int columna){
        return modelo.sumarVida(fila, columna);
    }

    public boolean restarVida(int fila, int columna){
        return modelo.restarVida(fila, columna);
    }

    public void moverE(int[] coordp){
        modelo.moverE(coordp);
    }
}
