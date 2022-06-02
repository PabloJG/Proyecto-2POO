package Model;
import Controller.Controller;
import java.awt.Color;
import View.*;

public class Model {
    Controller controlador;
    Enemigo enemigo;

    public void setCoordinador(Controller controlador) {
        this.controlador = controlador;
    }
    
    public void disparo(int X, int Y, String posicion){
        switch(posicion){
            case "arriba":
                if (View.bMatriz[X-1][Y].getBackground() == Color.yellow)
                    eliminarE(X-1, Y);
                break;
            case "abajo":
                if (View.bMatriz[X+1][Y].getBackground() == Color.yellow)
                    eliminarE(X+1, Y);
                break;
            case "izquierda":
                if (View.bMatriz[X][Y-1].getBackground() == Color.yellow)
                    eliminarE(X, Y-1);
                break;
            case "derecha":
                if (View.bMatriz[X][Y+1].getBackground() == Color.yellow)
                    eliminarE(X, Y+1);
                break;
        }
    }

    public static void eliminarE(int fila, int columna){
        for(int i = 0; i < Enemigo.cantidadE; i++){
            if (Factory.enemigos.get(i).coord[1] == columna && Factory.enemigos.get(i).coord[0] == fila){
                Factory.enemigos.remove(i);
                Enemigo.cantidadE--;
                View.bMatriz[fila][columna].setBackground(Color.gray);
            }
        }
    }

    public static void eliminarA(int fila, int columna){
        for(int i = 0; i < Aliado.cantidadA; i++){
            if (Factory.aliados.get(i).coord[1] == columna && Factory.aliados.get(i).coord[0] == fila){
                Factory.aliados.remove(i);
                Aliado.cantidadA--;
                View.bMatriz[fila][columna].setBackground(Color.gray);
            }
        }
    }

    public boolean sumarVida(int fila, int columna){
        for(int i = 0; i < Aliado.cantidadA; i++){
            if((Factory.aliados.get(i).coord[0] == fila) && (Factory.aliados.get(i).coord[1] == columna)){
                eliminarA(fila, columna);
                View.bMatriz[fila][columna].setBackground(Color.red);
                if(Personaje.vida < 5)
                    Personaje.vida++;
                return true;
            }
        }
        return false;
    }

    public boolean restarVida(int fila, int columna){
        for(int i = 0; i < Enemigo.cantidadE; i++){
            if((Factory.enemigos.get(i).coord[0] == fila) && (Factory.enemigos.get(i).coord[1] == columna)){
                eliminarE(fila, columna);
                View.bMatriz[fila][columna].setBackground(Color.red);
                Personaje.vida--;
                return true;
            }
        }
        return false;
    }

    public void moverE(int[] coordp){
        for(int i = 0; i < Enemigo.cantidadE; i++){
            if(coordp[Enemigo.coordmov] != Factory.enemigos.get(i).coord[Enemigo.coordmov]){
                Enemigo.actualizar(i);
                Factory.enemigos.get(i).coord[Enemigo.coordmov] += (coordp[Enemigo.coordmov] - Factory.enemigos.get(i).coord[Enemigo.coordmov])/Math.abs(coordp[Enemigo.coordmov] - Factory.enemigos.get(i).coord[Enemigo.coordmov]);
                Enemigo.colorear(i);
            }
        }
        Enemigo.coordmov = (Enemigo.coordmov + 1) % 2;
    }
}
