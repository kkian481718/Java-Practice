import java.awt.*;

public class Main extends Frame {
    // 建構子 constructor
    Main() {
        this.setSize(500, 500);
        this.setLocation(400, 100);   // 和桌面左上角 = (0, 0)
        this.setVisible(true);
    }

    // 建構子也可以"重載 overload"
    Main(int width, int height, int x, int y) {
        this.setSize(width, height);
        this.setLocation(x, y);   // 和桌面左上角 = (0, 0)
        this.setVisible(true);
    }

    // override "Frame" 中的 paint 函式
    public void paint(Graphics g) {
        // Color cr = new Color(255, 0, 0); 紅色
        // g.setColor(cr);

        for (int i = 0; i < 1000; i++) {
            int _r = myfun.RandNM(0, 255);
            int _g = myfun.RandNM(0, 255);
            int _b = myfun.RandNM(0, 255);
            g.setColor(new Color(_r, _g, _b));

            int x1 = myfun.RandNM(0, 600);
            int y1 = myfun.RandNM(0, 500);
            int x2 = myfun.RandNM(0, 600);
            int y2 = myfun.RandNM(0, 500);
            //g.drawLine(x1, y1, x2, y2);
            //g.drawRect(x2, y2, x1, y1);
            //g.fillRect(x1, y1, x2, y2);
            //g.drawOval(x1, y1, x2 - x1, y2 - y1);
            g.fillOval(x1, y1, x2 - x1, y2 - y1);
        }
    }

    public static void main(String[] args) {
        Main mm = new Main(600, 500, 100, 300);   // 執行建構子函式
    }
}