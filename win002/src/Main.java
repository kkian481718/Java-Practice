import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends Frame implements ActionListener {
    Button bt1 = null, bt2 = null, bt3 = null;

    Main(int w, int h, int sw, int sx) {
        this.setSize(w, h);
        this.setLocation(sw, sx);
        this.setVisible(true);
        this.setLayout(null);

        bt1 = new Button("Hello 01");
        bt1.setSize(80, 40);
        bt1.setLocation(100, 100);
        this.add(bt1);
        bt1.addActionListener(this);

        bt2 = new Button("Hello 02");
        bt2.setSize(80, 40);
        bt2.setLocation(200, 100);
        this.add(bt2);
        bt2.addActionListener(this);

        bt3 = new Button("quit");
        bt3.setSize(80, 40);
        bt3.setLocation(300, 100);
        this.add(bt3);
        bt3.addActionListener(this);
    }

    public static void main(String[] args) {
        Main nn = new Main(900, 500, 0, 0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int _x = myfun.RandNM(0, 300);
        int _y = myfun.RandNM(0, 300);

        if (e.getSource() == bt1) {
            bt1.setLabel("Good!!! 01");
            bt2.setLocation(_x, _y);
        } else if (e.getSource() == bt2) {
            bt2.setLabel("Good!!! 02");
            bt1.setLocation(_x, _y);
        } else if (e.getSource() == bt3) {
            this.dispose();
        }

    }
}