package View;
import Model.*;
import java.awt.Color;

public class Enemigo {
    int fila;
    int columna;
    static int cantidadE;

    public Enemigo(){
        fila = (int) (Math.random()*(34-1)) + 1;
        columna = (int) (Math.random()*(34-1)) + 1;
        generar();
    }

    private static void colorear(int i){
        View.bMatriz[Factory.enemigos.get(i).fila][Factory.enemigos.get(i).columna].setBackground(Color.yellow);
    }

    private static void actualizar(int i){
        View.bMatriz[Factory.enemigos.get(i).fila][Factory.enemigos.get(i).columna].setBackground(Color.gray);
    }

    public void generar(){
        while(fila == 17 && columna == 17){
            fila = (int) (Math.random()*(34-1)) + 1;
            columna = (int) (Math.random()*(34-1)) + 1;
        }
        View.bMatriz[fila][columna].setBackground(Color.yellow);
        cantidadE++;
    }

    public static boolean agregarnuevo(int cant){
        if(cant == 6){
            Factory.enemigos.add(new Enemigo());
            return true;
        }
        return false;
    }

    public static void mover(int filap, int columnap){
        for(int i = 0; i < cantidadE; i++){
            actualizar(i);
            if((columnap < Factory.enemigos.get(i).columna && filap < Factory.enemigos.get(i).fila) || (columnap > Factory.enemigos.get(i).columna && filap < Factory.enemigos.get(i).fila) || (columnap == Factory.enemigos.get(i).columna && filap < Factory.enemigos.get(i).fila))
                arriba(i);
            else if((columnap < Factory.enemigos.get(i).columna && filap > Factory.enemigos.get(i).fila) || (columnap > Factory.enemigos.get(i).columna && filap > Factory.enemigos.get(i).fila) || (columnap == Factory.enemigos.get(i).columna && filap > Factory.enemigos.get(i).fila))
                abajo(i);
            else if(columnap < Factory.enemigos.get(i).columna && filap == Factory.enemigos.get(i).fila)
                izquierda(i);
            else if(columnap > Factory.enemigos.get(i).columna && filap == Factory.enemigos.get(i).fila)
                derecha(i);
        }
    }

    public static void arriba(int i){
        Factory.enemigos.get(i).fila--;
        colorear(i);
    }

    public static void abajo(int i){
        Factory.enemigos.get(i).fila++;
        colorear(i);
    }

    public static void izquierda(int i){
        Factory.enemigos.get(i).columna--;
        colorear(i);
    }

    public static void derecha(int i){
        Factory.enemigos.get(i).columna++;
        colorear(i);
    }

    static void eliminar(int fila, int columna){
        for(int i = 0; i < cantidadE; i++){
            if (Factory.enemigos.get(i).columna == columna && Factory.enemigos.get(i).fila == fila){
                Factory.enemigos.remove(i);
                cantidadE--;
                View.bMatriz[fila][columna].setBackground(Color.gray);
            }
        }
    }
}
