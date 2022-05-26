package View;

import java.awt.Color;

public class Enemigo {
    int fila;
    int columna;

    public Enemigo(int i){
        fila = (int) (Math.random()*(34-1)) + 1;
        columna = (int) (Math.random()*(34-1)) + 1;
        pintar(i);
    }

    public void pintar(int i){
        while(fila == 17 && columna == 17){
            fila = (int) (Math.random()*(34-1)) + 1;
            columna = (int) (Math.random()*(34-1)) + 1;
        }
        View.bMatriz[fila][columna].setBackground(Color.yellow);
    }
}
