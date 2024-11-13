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
        g.drawLine(100, 100, 340, 400);
    }

    public static void main(String[] args) {

        Main mm = new Main(600, 500, 100, 300);   // 執行建構子函式
    }
}