package View;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import Model.Factory;
import Controller.Controller;

public class Aliado{
    private Personaje personaje;
    private int fila;
    private int columna;
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

    /*public static void agregarObservers(Personaje pers){
        for(int i = 0; i < cantidadA; i++)
            pers.addObserver(Factory.aliados.get(i));
    }*/

    public static void colorear(int i){
        View.bMatriz[Factory.aliados.get(i).fila][Factory.aliados.get(i).columna].setBackground(Color.green);
    }

    private void generar(){
        if(cantidadA < 10){
            while(fila == 17 && columna == 17){
                fila = (int) (Math.random()*(34-1)) + 1;
                columna = (int) (Math.random()*(34-1)) + 1;
                coord[0] = fila;
                coord[1] = columna;
            }
            //View.bMatriz[coord[0]][coord[1]].setBackground(Color.green);
            cantidadA++;
        }
    }

    static void pintarTodos(){
        for(int i = 0; i < cantidadA; i++){
            View.bMatriz[Factory.aliados.get(i).coord[0]][Factory.aliados.get(i).coord[1]].setBackground(Color.green);
        }
    }
}
