import java.awt.*;
import java.awt.event.*;

public class Main extends Frame implements WindowListener, ActionListener, MouseListener {
    Cards[] cd = new Cards[5];

    Main(int width, int height, int sx, int sy) {
        this.setSize(width, height);
        this.setLocation(sx, sy);
        this.setVisible(true);
        this.setLayout(null);

        this.addWindowListener(this);

        // clr = 花色 (1=, 2=, 3=, 4= )
        // num = 數字 (1~13)
        for(int i = 0; i < cd.length; i++) {
            int clr = myfun.RandNM(1, 4);
            int num = myfun.RandNM(1, 13);

            cd[i] = new Cards(130, 200, 40 + 150*i, 100, clr, num);
            cd[i].addMouseListener(this);
            this.add(cd[i]);
        }
    }

    public void windowClosing(WindowEvent e) {
        this.dispose();
    }

    public void mouseClicked(MouseEvent e) {
        for (Cards c : cd) {
            if (e.getSource() == c) {
                if (c.getClr() == 0) {
                    c.setFront();
                } else {
                    c.setBack();
                }
            }
        }
    }

    public void windowClosed(WindowEvent e) {

    }

    public void windowOpened(WindowEvent e) {

    }

    public void windowIconified(WindowEvent e) {

    }

    public void windowDeiconified(WindowEvent e) {

    }

    public void windowActivated(WindowEvent e) {

    }

    public void windowDeactivated(WindowEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new Main(800, 800, 200, 50);
    }
}