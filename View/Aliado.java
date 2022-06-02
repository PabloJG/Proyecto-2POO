package View;
import Model.Factory;
import java.awt.Color;

import Controller.Controller;

public class Aliado {
    Controller controlador;
    int fila;
    int columna;
    public static int cantidadA;
    int coordmov;
    public int[] coord;

    public Aliado(){
        fila = (int) (Math.random()*(34-1)) + 1;
        columna = (int) (Math.random()*(34-1)) + 1;
        coord = new int[2];
        coord[0] = fila;
        coord[1] = columna;
        coordmov = 0;
        generar();
    }

    public void generar(){
        System.out.println(cantidadA);
        if(cantidadA < 10){
            while(fila == 17 && columna == 17){
                fila = (int) (Math.random()*(34-1)) + 1;
                columna = (int) (Math.random()*(34-1)) + 1;
                coord[0] = fila;
                coord[1] = columna;
            }
            View.bMatriz[coord[0]][coord[1]].setBackground(Color.green);
            cantidadA++;
        }
    }

    public static void pintarTodos(){
        for(int i = 0; i < cantidadA; i++){
            View.bMatriz[Factory.aliados.get(i).coord[0]][Factory.aliados.get(i).coord[1]].setBackground(Color.green);
        }
    }

    public void setCoordinador(Controller controlador) {
        this.controlador = controlador;
    }
}
