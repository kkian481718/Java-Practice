import java.awt.*;
import java.awt.event.*;

public class Main extends Frame implements WindowListener {
    Main(int width, int height, int sx, int sy) {
        this.setSize(width, height);
        this.setLocation(sx, sy);
        this.setLayout(null);
        this.setVisible(true);

        this.addWindowListener(this);
    }

    public static void main(String[] args) {
        new Main(800, 600, 100, 100);
    }

    public void windowClosing(WindowEvent e) {
        this.dispose();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }
}