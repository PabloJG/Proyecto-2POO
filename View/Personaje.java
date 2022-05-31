package View;
import javax.swing.*;

import Model.Factory;

import java.awt.event.*;
import java.awt.Color;

public class Personaje{
    JButton Personaje;
    int X;
    int Y;
    static int vida;
    int cantmov;
    int[] coord;
    String posicion;

    public Personaje(){
        X = 17;
        Y = 17;
        Personaje = View.bMatriz[X][Y];
        vida = 5;
        coord = new int[2];
        coord[0] = X;
        coord[1] = Y;
        colorear();
        move();
    }

    private void colorear(){
        Personaje = View.bMatriz[X][Y];
        Personaje.setBackground(Color.red);
    }

    private void actualizar(){
        Personaje.setBackground(Color.gray);
    }

    private void move(){
        Personaje.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
            }
  
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    actualizar();
                    Y++;
                    colorear();
                    posicion = "derecha";
                    coord[1] = Y;
                    Enemigo.mover(coord);
                    cantmov++;
                }
                else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    actualizar();
                    Y--;
                    colorear();
                    posicion = "izquierda";
                    coord[1] = Y;
                    Enemigo.mover(coord);
                    cantmov++;
                }
                else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    actualizar();
                    X--;
                    colorear();
                    coord[0] = X;
                    posicion = "arriba";
                    Enemigo.mover(coord);
                    cantmov++;
                }
                else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    actualizar();
                    X++;
                    colorear();
                    coord[0] = X;
                    posicion = "abajo";
                    Enemigo.mover(coord);
                    cantmov++;
                }
                else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    disparo();
                }
                if(Enemigo.agregarnuevo(cantmov) == true)
                    cantmov = 0;
                actualizarVida();
            }
  
            @Override
            public void keyReleased(KeyEvent e) {
            }
        
        });
    }

    public void actualizarVida(){
        if(vida == 0){
            JOptionPane.showMessageDialog(null, "Haz perdido, no tienes mas vidas","Fin",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        else{
            if(Enemigo.vidaPersonaje(X, Y) == true)
                JOptionPane.showMessageDialog(null, "Haz perdido una vida, te quedan " + vida + " vidas","Cuidado",JOptionPane.WARNING_MESSAGE);
        }
    }

    public void disparo(){
        if(posicion.equals("arriba")){
            if (View.bMatriz[X-1][Y].getBackground() == Color.yellow)
                Enemigo.eliminar(X-1, Y);
        }
        if(posicion.equals("abajo")){
            if (View.bMatriz[X+1][Y].getBackground() == Color.yellow)
                Enemigo.eliminar(X+1, Y);
        }
        if(posicion.equals("izquierda")){
            if (View.bMatriz[X][Y-1].getBackground() == Color.yellow)
                Enemigo.eliminar(X, Y-1);
        }
        if(posicion.equals("derecha")){
            if (View.bMatriz[X][Y+1].getBackground() == Color.yellow)
                Enemigo.eliminar(X, Y+1);
        }
    }
}
