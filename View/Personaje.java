package View;
import javax.swing.*;

import Controller.Controller;

import java.awt.event.*;
import java.awt.Color;

public class Personaje{
    Controller controlador;
    JButton Personaje;
    int X;
    int Y;
    public static int vida;
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
                    controlador.moverE(coord);
                    cantmov++;
                }
                else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    actualizar();
                    Y--;
                    colorear();
                    posicion = "izquierda";
                    coord[1] = Y;
                    controlador.moverE(coord);
                    cantmov++;
                }
                else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    actualizar();
                    X--;
                    colorear();
                    coord[0] = X;
                    posicion = "arriba";
                    controlador.moverE(coord);
                    cantmov++;
                }
                else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    actualizar();
                    X++;
                    colorear();
                    coord[0] = X;
                    posicion = "abajo";
                    controlador.moverE(coord);
                    cantmov++;
                }
                else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    controlador.disparo(X, Y, posicion);
                }
                if((controlador.agregarnuevoE(cantmov) == true) && (controlador.agregarnuevoA(cantmov) == true))
                    cantmov = 0;
                Aliado.pintarTodos();
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
            if(controlador.restarVida(X, Y) == true)
                JOptionPane.showMessageDialog(null, "Haz perdido una vida, te quedan " + vida + " vidas","Cuidado",JOptionPane.WARNING_MESSAGE);

            else if(controlador.sumarVida(X, Y) == true)
                JOptionPane.showMessageDialog(null, "Haz ganado una vida, te quedan " + vida + " vidas","Sigue asi!",JOptionPane.INFORMATION_MESSAGE);    
        }
    }

    public void setCoordinador(Controller controlador) {
        this.controlador = controlador;
    }
}
