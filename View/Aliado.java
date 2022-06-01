package View;
import Model.*;
import java.awt.Color;

public class Aliado {
    int fila;
    int columna;
    static int cantidadA;
    static int coordmov;
    int[] coord;

    public Aliado(){
        fila = (int) (Math.random()*(34-1)) + 1;
        columna = (int) (Math.random()*(34-1)) + 1;
        coord = new int[2];
        coord[0] = fila;
        coord[1] = columna;
        coordmov = 0;
        pintar();
        generar();
    }

    public void pintar(){
        while(fila == 17 && columna == 17){
            fila = (int) (Math.random()*(34-1)) + 1;
            columna = (int) (Math.random()*(34-1)) + 1;
        }
        View.bMatriz[fila][columna].setBackground(Color.green);
    }

    public void generar(){
        while(fila == 17 && columna == 17){
            fila = (int) (Math.random()*(34-1)) + 1;
            columna = (int) (Math.random()*(34-1)) + 1;
            coord[0] = fila;
            coord[1] = columna;
        }
        View.bMatriz[coord[0]][coord[1]].setBackground(Color.green);
        cantidadA++;
    }
    public static boolean agregarnuevo(int cant){
        if(cant == 4){
            Factory.aliados.add(new Aliado());
            return true;
        }
        return false;
    }
    
    static void eliminar(int fila, int columna){
        for(int i = 0; i < cantidadA; i++){
            if (Factory.aliados.get(i).coord[1] == columna && Factory.aliados.get(i).coord[0] == fila){
                Factory.aliados.remove(i);
                cantidadA--;
                View.bMatriz[fila][columna].setBackground(Color.gray);
            }
        }
    }

    public static boolean vidaPersonaje(int fila, int columna){
        for(int i = 0; i < cantidadA; i++){
            if((Factory.aliados.get(i).coord[0] == fila) && (Factory.aliados.get(i).coord[1] == columna)){
                eliminar(fila, columna);
                View.bMatriz[fila][columna].setBackground(Color.red);
                Personaje.vida++;
                return true;
            }
        }
        return false;
    }


}
