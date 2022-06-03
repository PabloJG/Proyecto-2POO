package Controller;

import Model.*;

public class Controller {
    private static Model modelo;
    private Factory fact;

    public void setModelo(Model modelo) {
        this.modelo = modelo;
    }

    public void setFactory(Factory fact) {
        this.fact = fact;
        crear("enemigo");
        crear("aliado");
    }

    private void crear(String tipo){
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
        return fact.agregarE(cant);
    }

    public boolean agregarnuevoA(int cant){
        return fact.agregarA(cant);
    }

    public void eliminarE(int x, int i) {
        modelo.eliminarE(x, i);
    }

    public void eliminarA(int fila, int columna){
        modelo.eliminarA(fila, columna);
    }

    public boolean sumarVida(int fila, int columna){
        return modelo.sumarVida(fila, columna);
    }

    public boolean restarVida(int fila, int columna){
        return modelo.restarVida(fila, columna);
    }

    public static void moverE(){
        modelo.moverE();
    }

    public void getPosP(int[] coord){
        modelo.getPosP(coord);
    }

    public void aparecerA(){
        modelo.aparecerA();
    }
}
