package View;
import Model.*;
import Controller.Controller;
import java.awt.Color;
import java.util.Observer;
import java.util.Observable;

public class Enemigo implements Observer{
    private Personaje personaje;
    private Enemigo prueba;
    private int fila;
    private int columna;
    public static int cantidadE;
    public static int coordmov;
    public int[] coord;

    public Enemigo(Personaje pers){
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
        Controller.moverE();
    }

    public static void agregarObservers(Personaje pers){// hace que enemigo sea capaz de observar Personaje
        for(int i = 0; i < cantidadE; i++)
            pers.addObserver(Factory.enemigos.get(i));
    }

    public static void colorear(int i){
        View.bMatriz[Factory.enemigos.get(i).coord[0]][Factory.enemigos.get(i).coord[1]].setBackground(Color.yellow);
    }

    public static void descolorear(int i){
        View.bMatriz[Factory.enemigos.get(i).coord[0]][Factory.enemigos.get(i).coord[1]].setBackground(Color.gray);
    }

    public void generar(){//genera enemigos despues de cierta cantidad de turnos
        while(fila == 17 && columna == 17){
            fila = (int) (Math.random()*(34-1)) + 1;
            columna = (int) (Math.random()*(34-1)) + 1;
            coord[0] = fila;
            coord[1] = columna;
        }
        View.bMatriz[coord[0]][coord[1]].setBackground(Color.yellow);
        cantidadE++;
    }
}
