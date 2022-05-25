import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;

/*
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
}*/



public class View extends JFrame {

JButton button;
JPanel[] p = new JPanel[100];
int k = 0;

public View() {
    super();
    button = new JButton("");
    button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
                    requestFocusInWindow();
        }
    });
    
    JPanel panel = new JPanel(new GridLayout(10, 10));
    for (int i = 0; i < 100; i++) {
        p[i] = new JPanel(new BorderLayout());
        p[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.add(p[i]);
    }

    p[0].add(button);

    setFocusable(true);
    requestFocusInWindow();
    addKeyListener(new KeyListener() {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            try {
                if (k <= 99 && k >= 0) {
                    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                        if (k + 1 <= 99) {
                            p[++k].add(button);
                        }
                        repaint();
                    } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                        if (k - 1 >= 0) {
                            p[--k].add(button);
                        }
                        repaint();
                    } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                        if (k - 10 >= 0) {
                            p[k -= 10].add(button);
                        }
                        repaint();
                    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                        if (k + 10 <= 99) {
                            p[k += 10].add(button);
                        }
                        repaint();
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }

    });
    setSize(600, 600);
    add(panel);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
}


}