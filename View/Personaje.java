package View;
import javax.swing.JButton;
import java.awt.event.*;
import java.awt.Color;

public class Personaje{
    JButton Personaje;
    int X;
    int Y;
    int vida;

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
                }
                else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    actualizar();
                    Y--;
                    colorear();
                }
                else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    actualizar();
                    X--;
                    colorear();
                }
                else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    actualizar();
                    X++;
                    colorear();
                }
            }
  
            @Override
            public void keyReleased(KeyEvent e) {
            }
        
        });
    }
}
