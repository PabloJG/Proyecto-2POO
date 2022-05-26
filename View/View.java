package View;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Color;

public class View{
    private static JFrame ventana = new JFrame();
    public static JButton bMatriz[][] = new JButton[35][35];
    private static JPanel panel = new JPanel();

    public View(){
        panel.setLayout(new GridLayout(35, 35));
        panel.setBackground(new java.awt.Color(0, 151, 7));
        ventana.add(panel);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crearTablero();
    }

    private void crearTablero(){
        for (int f = 0; f < 35; f++) {
            for (int c = 0; c < 35; c++) {
                bMatriz[f][c] = new JButton();
                bMatriz[f][c].setBounds(20, 10, 360, 360);
                bMatriz[f][c].setBackground(Color.gray);
                ventana.setBounds(300, 20, 850, 710);
                panel.setBounds(300, 20, 850, 710);
                panel.add(bMatriz[f][c]);
                panel.setVisible(true);
            }
        }
        ventana.setVisible(true);
    }
}