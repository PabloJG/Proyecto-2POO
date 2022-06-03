package View;
import Model.Factory;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import Controller.Controller;

public class Aliado implements Observer{
    Personaje personaje;
    int fila;
    int columna;
    public static int cantidadA;
    public static int coordmov;
    public int[] coord;

    public Aliado(Personaje pers){
        personaje = pers;
        
        fila = (int) (Math.random()*(34-1)) + 1;
        columna = (int) (Math.random()*(34-1)) + 1;
        coord = new int[2];
        coord[0] = fila;
        coord[1] = columna;
        coordmov = 0;
        generar();
    }

    @Override
    public void update(Observable o, Object ag){
        //
    }

    public static void agregarObservers(Personaje pers){
        for(int i = 0; i < cantidadA; i++)
            pers.addObserver(Factory.enemigos.get(i));
    }

    public static void colorear(int i){
        View.bMatriz[Factory.enemigos.get(i).fila][Factory.enemigos.get(i).columna].setBackground(Color.green);
    }

    public void generar(){
        if(cantidadA < 10){
            while(fila == 17 && columna == 17){
                fila = (int) (Math.random()*(34-1)) + 1;
                columna = (int) (Math.random()*(34-1)) + 1;
                coord[0] = fila;
                coord[1] = columna;
            }
            System.out.println(coord[0] + " "+ coord[1]);
            //View.bMatriz[coord[0]][coord[1]].setBackground(Color.green);
            cantidadA++;
        }
    }

    public static void pintarTodos(){
        for(int i = 0; i < cantidadA; i++){
            View.bMatriz[Factory.aliados.get(i).coord[0]][Factory.aliados.get(i).coord[1]].setBackground(Color.green);
        }
    }
}
