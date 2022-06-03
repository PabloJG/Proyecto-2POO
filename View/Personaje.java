package View;
import javax.swing.*;
import Controller.Controller;
import java.awt.event.*;
import java.awt.Color;
import java.util.Observer;
import java.util.Observable;

public class Personaje extends Observable{
    private Observer observer;
    private Controller controlador;
    private JButton Personaje;
    private int X;
    private int Y;
    public static int vida;
    private int cantmov;
    public int[] coord;
    private String posicion;

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

    @Override
    public void addObserver(Observer observer){
        this.observer = observer;
    }

    @Override
    public void notifyObservers(){
        if(observer != null){
            System.out.println("aqui perimero");
            observer.update(this, "enemigo");
        }
    }

    private void colorear(){
        Personaje = View.bMatriz[X][Y];
        Personaje.setBackground(Color.red);
    }

    private void descolorear(){
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
                    descolorear();
                    Y++;
                    colorear();
                    posicion = "derecha";
                    coord[1] = Y;
                    controlador.getPosP(coord);
                    notifyObservers();
                    //controlador.moverE(coord);
                    cantmov++;
                }
                else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    descolorear();
                    Y--;
                    colorear();
                    posicion = "izquierda";
                    coord[1] = Y;
                    controlador.getPosP(coord);
                    notifyObservers();
                    //controlador.moverE(coord);
                    cantmov++;
                }
                else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    descolorear();
                    X--;
                    colorear();
                    coord[0] = X;
                    posicion = "arriba";
                    controlador.getPosP(coord);
                    notifyObservers();
                    //controlador.moverE(coord);
                    cantmov++;
                }
                else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    descolorear();
                    X++;
                    colorear();
                    coord[0] = X;
                    posicion = "abajo";
                    controlador.getPosP(coord);
                    notifyObservers();
                    cantmov++;
                }
                else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    controlador.disparo(X, Y, posicion);
                }
                if((controlador.agregarnuevoE(cantmov) == true) && (controlador.agregarnuevoA(cantmov) == true))
                    cantmov = 0;
                //controlador.getPosP(coord);
                //controlador.moverE();
                //notifyObservers();
                controlador.aparecerA();
                //Aliado.pintarTodos();
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
