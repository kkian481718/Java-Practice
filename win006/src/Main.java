import java.awt.*; // java.swing.* 更漂亮
import java.awt.event.*;

public class Main extends Frame implements ActionListener, KeyListener, Runnable, WindowListener {
    Button bt1;
    TextArea ta;
    TextField tf;
    Thread th1;
    int dir = -1;

    Main(int width, int height, int sx, int sy) {
        this.setSize(width, height);
        this.setLocation(sx, sy);
        this.setLayout(null);
        this.setVisible(true);
        this.requestFocus(); // 得到焦點

        bt1 = new Button("Quit");
        bt1.setSize(60, 40);
        bt1.setLocation(20, 620);
        this.add(bt1);
        bt1.addActionListener(this);

        ta = new TextArea("");
        ta.setSize(150, 150);
        ta.setLocation(50, 100);
        this.add(ta);

        tf = new TextField("");
        tf.setSize(120, 30);
        tf.setLocation(500, 300);
        this.add(tf);

        th1 = new Thread(this);
        //th1.start();
        this.addWindowListener(this);

        //tf.addKeyListener(this);
        this.addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose(); // 結束程式
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_DELETE) {
            tf.setText(" ");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            dir = 1;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            dir = 3;
        }
//        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//            tf.setLocation(tf.getX() + 3, tf.getY());
//        }
//        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//            tf.setLocation(tf.getX() - 3, tf.getY());
//        }
//        if (e.getKeyCode() == KeyEvent.VK_UP) {
//            tf.setLocation(tf.getX(), tf.getY() - 3);
//        }
//        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//            tf.setLocation(tf.getX(), tf.getY() + 3);
//        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            dir = -1;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            dir = -1;
        }
    }

    public static void main(String[] args) {
        new Main(800, 900, 0, 0);
    }

    @Override
    public void run() {
        while (dir != -1) {
            if (dir == 1) {
                tf.setLocation(tf.getX() + 3, tf.getY());
            }
            if (dir == 3) {
                tf.setLocation(tf.getX() - 3, tf.getY());
            }

            try {
                Thread.sleep(1);
            } catch (Exception e) {

            }
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
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
}