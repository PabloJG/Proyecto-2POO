package View;
import Model.*;
import Controller.Controller;
import java.awt.Color;

public class Enemigo implements TipoA{
    Controller controlador;
    int fila;
    int columna;
    public static int cantidadE;
    public static int coordmov;
    public int[] coord;

    public Enemigo(){
        fila = (int) (Math.random()*(34-1)) + 1;
        columna = (int) (Math.random()*(34-1)) + 1;
        coord = new int[2];
        coord[0] = fila;
        coord[1] = columna;
        coordmov = 0;
        generar();
    }

    @Override
    public void tipo(){

    }

    public static void colorear(int i){
        View.bMatriz[Factory.enemigos.get(i).coord[0]][Factory.enemigos.get(i).coord[1]].setBackground(Color.yellow);
    }

    public static void actualizar(int i){
        View.bMatriz[Factory.enemigos.get(i).coord[0]][Factory.enemigos.get(i).coord[1]].setBackground(Color.gray);
    }

    public void generar(){
        while(fila == 17 && columna == 17){
            fila = (int) (Math.random()*(34-1)) + 1;
            columna = (int) (Math.random()*(34-1)) + 1;
            coord[0] = fila;
            coord[1] = columna;
        }
        View.bMatriz[coord[0]][coord[1]].setBackground(Color.yellow);
        cantidadE++;
    }

    public void setCoordinador(Controller controlador) {
        this.controlador = controlador;
    }
}
