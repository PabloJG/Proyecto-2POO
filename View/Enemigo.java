package View;
import Model.*;
import java.awt.Color;

public class Enemigo {
    int fila;
    int columna;
    static int cantidadE;
    static int coordmov;
    int[] coord;

    public Enemigo(){
        fila = (int) (Math.random()*(34-1)) + 1;
        columna = (int) (Math.random()*(34-1)) + 1;
        coord = new int[2];
        coord[0] = fila;
        coord[1] = columna;
        coordmov = 0;
        generar();
    }

    private static void colorear(int i){
        View.bMatriz[Factory.enemigos.get(i).coord[0]][Factory.enemigos.get(i).coord[1]].setBackground(Color.yellow);
    }

    private static void actualizar(int i){
        System.out.println(Factory.enemigos.get(i).coord[0] +" "+Factory.enemigos.get(i).coord[1]);
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

    public static boolean agregarnuevo(int cant){
        if(cant == 6){
            Factory.enemigos.add(new Enemigo());
            return true;
        }
        return false;
    }

    public static void mover(int[] coordp){
        for(int i = 0; i < cantidadE; i++){
            if(coordp[coordmov] != Factory.enemigos.get(i).coord[coordmov]){
                actualizar(i);
                Factory.enemigos.get(i).coord[coordmov] += (coordp[coordmov] - Factory.enemigos.get(i).coord[coordmov])/Math.abs(coordp[coordmov] - Factory.enemigos.get(i).coord[coordmov]);
                colorear(i);
            }
        }
        coordmov = (coordmov + 1) % 2;
    }

    static void eliminar(int fila, int columna){
        for(int i = 0; i < cantidadE; i++){
            if (Factory.enemigos.get(i).coord[1] == columna && Factory.enemigos.get(i).coord[0] == fila){
                Factory.enemigos.remove(i);
                cantidadE--;
                View.bMatriz[fila][columna].setBackground(Color.gray);
            }
        }
    }
}
