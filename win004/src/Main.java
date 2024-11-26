import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class Main extends Frame implements ActionListener, Runnable {
    Button bt1;
    Thread th1 = null;
    int dx = 0, dy = 0, dw = 0, dh = 0;
    int hour, min, sec;

    Main(int width, int height, int screen_y, int screen_x) {
        this.setSize(width, height);
        this.setLocation(screen_x, screen_y);
        this.setLayout(null);   // 不要自動排物件，不然btn會填滿整個畫面
        this.setVisible(true);

        bt1 = new Button("show clock");
        bt1.setSize(150, 40);
        bt1.setLocation(100, 50);
        this.add(bt1);
        bt1.addActionListener(this);

        th1 = new Thread(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {    // e.getSource()
        th1.start();
    }

    @Override
    public void run() { // Thread.currentThread()
        while (true) {
            LocalDateTime dt = LocalDateTime.now();
            hour = dt.getHour();
            min = dt.getMinute();
            sec = dt.getSecond();

            repaint(); // 重新繪製畫面

            delay(100);
        }
    }

    void delay (int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void paint (Graphics g) {
        int _r = myfun.RandNM(0, 255);
        int _g = myfun.RandNM(0, 255);
        int _b = myfun.RandNM(0, 255);

        Font ft = new Font("Serif", Font.BOLD, 120);

        g.setFont(ft);
        g.setColor(new Color(_r, _g, _b));
        g.drawString(hour + ":" + min + ":" + sec, 100, 200 );
    }

    public static void main(String[] args) {
        new Main(800, 600, 300, 300);
    }
}