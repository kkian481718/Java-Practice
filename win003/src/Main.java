import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends Frame implements ActionListener, Runnable {
    Button bt1 = null, bt2 = null;
    Thread th1 = null, th2 = null;
    int count1 = 0, count2 = 0;

    Main(int width, int height, int screen_y, int screen_x) {
        this.setSize(width, height);
        this.setLocation(screen_x, screen_y);
        this.setLayout(null);   // 不要自動排物件，不然btn會填滿整個畫面
        this.setVisible(true);

        bt1 = new Button("BT-01");
        bt1.setSize(150, 40);
        bt1.setLocation(100, 50);
        this.add(bt1);
        bt1.addActionListener(this);

        bt2 = new Button("BT-02");
        bt2.setSize(150, 40);
        bt2.setLocation(100, 150);
        this.add(bt2);
        bt2.addActionListener(this);

        th1 = new Thread(this);
        th1.start();
        th2 = new Thread(this);
        th2.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {    // e.getSource()
        if (e.getSource() == bt1) {
            bt1.setLabel(String.valueOf(count1) + " " + String.valueOf(count2));
        }
    }

    void delay (int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {

        }
    }

    @Override
    public void run() { // Thread.currentThread()
        if (Thread.currentThread() == th1) {
            while (true) {
                count1++;
                if (count1 > 100) {
                    count1 = 0;
                    bt1.setLocation(bt1.getX() + 1, 50);
                    delay(500);
                }
            }
        } else if (Thread.currentThread() == th2) {
            while (true) {
                count2++;
                if (count2 > 100) {
                    count2 = 0;
                    bt2.setLocation(bt2.getX() + 1, 150);
                    delay(500);
                }
            }
        }
    }

    public static void main(String[] args) {
        new Main(800, 600, 300, 300);
    }
}