import java.awt.*;
import java.awt.image.BufferedImage;

public class Main extends Frame implements Runnable {
    Image im1, im2, im3, im4;
    Graphics gg;

    int ax = 50, ay = 50, bx = 50, by = 50;
    int axv = 1, ayv = 1, bxv = 1, byv = 1;

    Thread th1;

    Main(int width, int height, int sx, int sy) {
        this.setSize(width, height);
        this.setLocation(sx, sy);
        this.setLayout(null);
        this.setVisible(true);

        getToolkit();
        im1 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("space_ship-01.png"));
        im2 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("space_ship-02.png"));
        im3 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Space800x700.jpg"));
        im4 = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);

        gg = im4.getGraphics();

        th1 = new Thread(this);
        th1.start();
    }

    public void update(Graphics g) {
        paint(g);
        // 拿掉清除畫面
    }

    public void paint(Graphics g) {
        g.drawImage(im4, 0, 0, this);
    }

    public static void main(String[] args) {
        new Main(800, 700, 300, 50);
    }

    @Override
    public void run() {
        while (true) {
            bx += bxv;
            by += byv;

            //gg.drawImage(im1, ax, ay, axv, ayv, this);
            gg.drawImage(im3, 0, 0, this);
            gg.drawImage(im2, bx, by, 100, 100, this);
            repaint();

            int frameWidth = getSize().width - 100;
            int frameHeight = getSize().height - 100;

            if (bx >= frameWidth || bx < 10) {
                bxv *= -1;
            }

            if (by >= frameHeight || by < 10) {
                byv *= -1;
            }

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}