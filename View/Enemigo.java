package View;
import Model.*;
import java.awt.Color;

public class Enemigo {
    int fila;
    int columna;
    static int cantidadE;

    public Enemigo(int i){
        fila = (int) (Math.random()*(34-1)) + 1;
        columna = (int) (Math.random()*(34-1)) + 1;
        cantidadE = 3;
        generar(i);
    }

    private static void colorear(int i){
        View.bMatriz[Factory.enemigos[i].fila][Factory.enemigos[i].columna].setBackground(Color.yellow);
    }

    private static void actualizar(int i){
        View.bMatriz[Factory.enemigos[i].fila][Factory.enemigos[i].columna].setBackground(Color.gray);
    }

    public void generar(int i){
        while(fila == 17 && columna == 17){
            fila = (int) (Math.random()*(34-1)) + 1;
            columna = (int) (Math.random()*(34-1)) + 1;
        }
        View.bMatriz[fila][columna].setBackground(Color.yellow);
    }

    public static void cargarnuevo(int filap, int columnap){
        for(int i = 0; i < cantidadE; i++){
            System.out.println(Factory.enemigos[i].fila);
            actualizar(i);
            if((columnap < Factory.enemigos[i].columna && filap < Factory.enemigos[i].fila) || (columnap > Factory.enemigos[i].columna && filap < Factory.enemigos[i].fila) || (columnap == Factory.enemigos[i].columna && filap < Factory.enemigos[i].fila))
                arriba(i);
            else if((columnap < Factory.enemigos[i].columna && filap > Factory.enemigos[i].fila) || (columnap > Factory.enemigos[i].columna && filap > Factory.enemigos[i].fila) || (columnap == Factory.enemigos[i].columna && filap > Factory.enemigos[i].fila))
                abajo(i);
            else if(columnap < Factory.enemigos[i].columna && filap == Factory.enemigos[i].fila)
                izquierda(i);
            else if(columnap > Factory.enemigos[i].columna && filap == Factory.enemigos[i].fila)
                derecha(i);
        }
    }

    public static void arriba(int i){
        Factory.enemigos[i].fila--;
        colorear(i);
    }

    public static void abajo(int i){
        Factory.enemigos[i].fila++;
        colorear(i);
    }

    public static void izquierda(int i){
        Factory.enemigos[i].columna--;
        colorear(i);
    }

    public static void derecha(int i){
        Factory.enemigos[i].columna++;
        colorear(i);
    }
}
