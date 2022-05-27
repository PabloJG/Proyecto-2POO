package View;
import java.awt.Color;

public class Aliado {
    int fila;
    int columna;

    public Aliado(int i){
        fila = (int) (Math.random()*(34-1)) + 1;
        columna = (int) (Math.random()*(34-1)) + 1;
        pintar(i);
    }

    public void pintar(int i){
        while(fila == 17 && columna == 17){
            fila = (int) (Math.random()*(34-1)) + 1;
            columna = (int) (Math.random()*(34-1)) + 1;
        }
        View.bMatriz[fila][columna].setBackground(Color.green);
    }
}
