package View;
import javax.swing.JButton;
import java.awt.event.*;
import java.awt.Color;

public class Personaje{
    JButton Personaje;
    int X;
    int Y;
    int vida;
    int cantmov;
    String posicion;

    public Personaje(){
        X = 17;
        Y = 17;
        Personaje = View.bMatriz[X][Y];
        vida = 5;
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
                    Enemigo.cargarnuevo(X, Y);
                }
                else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    actualizar();
                    Y--;
                    colorear();
                    posicion = "izquierda";
                    Enemigo.cargarnuevo(X, Y);
                }
                else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    actualizar();
                    X--;
                    colorear();
                    posicion = "arriba";
                    Enemigo.cargarnuevo(X, Y);
                }
                else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    actualizar();
                    X++;
                    colorear();
                    posicion = "abajo";
                    Enemigo.cargarnuevo(X, Y);
                }
                else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    disparo();
                }
                cantmov++;
            }
  
            @Override
            public void keyReleased(KeyEvent e) {
            }
        
        });
    }

    public void disparo(){
        //System.out.println(posicion);
        //System.out.println("X" + X + "Y" + Y);
        if(posicion.equals("arriba")){
            if (View.bMatriz[X-1][Y].getBackground() == Color.yellow)
                View.bMatriz[X-1][Y].setBackground(Color.gray);
        }
        if(posicion.equals("abajo")){
            if (View.bMatriz[X+1][Y].getBackground() == Color.yellow)
                View.bMatriz[X+1][Y].setBackground(Color.gray);
        }
        if(posicion.equals("izquierda")){
            if (View.bMatriz[X][Y-1].getBackground() == Color.yellow)
                View.bMatriz[X][Y-1].setBackground(Color.gray);
        }
        if(posicion.equals("derecha")){
            if (View.bMatriz[X][Y+1].getBackground() == Color.yellow)
                View.bMatriz[X][Y+1].setBackground(Color.gray);
        }
    }
}
