import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Color;

public class View {
    public static Color negro = new java.awt.Color(0, 0, 0);
    private static JFrame ventana = new JFrame();
    public static JButton bMatriz[][] = new JButton[36][36];
    private static JPanel panel = new JPanel();

    public View(){
        panel.setLayout(new GridLayout(50, 50));
        panel.setBackground(new java.awt.Color(0, 151, 7));
        ventana.add(panel);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crearMatriz();
    }

    private void crearMatriz(){
        for (int f = 0; f < 36; f++) {
            for (int c = 0; c < 36; c++) {
                bMatriz[f][c] = new JButton();
                bMatriz[f][c].setBounds(20, 20, 200, 200);
                bMatriz[f][c].setBackground(negro);
                //bMatriz[f][c].setBorderPainted(false);
                ventana.setBounds(250, 20, 500, 700);
                //panel.setBounds(300, 20, 640, 700);
                panel.add(bMatriz[f][c]);
                panel.setVisible(true);
            }
        }
        ventana.setVisible(true);
    }
}