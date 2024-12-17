import java.awt.*; // java.swing.* 更漂亮
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Main extends Frame implements ActionListener, KeyListener, Runnable, WindowListener {
    Image im1, im2, im3;

    BufferedImage offScreen; // 雙緩衝畫布
    Graphics offG;

    Thread th1;

    int dir = -1;
    int x = 0, y = 100;

    ArrayList<Point> bullets = new ArrayList<>(); // 儲存子彈的位置

    Main(int width, int height, int sx, int sy) {
        this.setSize(width, height);
        this.setLocation(sx, sy);
        this.setLayout(null);
        this.setVisible(true);
        this.requestFocus(); // 得到焦點

        // 初始化雙緩衝
        offScreen = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        offG = offScreen.getGraphics();

        // 載入圖片
        im1 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("space_ship-01.png"));
        im2 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("space_ship-02.png"));
        im3 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Space800x700.jpg"));

        this.addWindowListener(this);
        this.addKeyListener(this);

        th1 = new Thread(this);
        th1.start();
    }

    public void update(Graphics g) {
        paint(g); // 拿掉清除畫面，使用雙緩衝來解決閃爍
    }

    public void paint(Graphics g) {
        // 清除背景
        offG.setColor(Color.BLACK);
        offG.fillRect(0, 0, getWidth(), getHeight());

        // 畫背景圖片
        offG.drawImage(im3, 0, 0, getWidth(), getHeight(), this);

        // 畫飛船
        offG.drawImage(im1, x, y, 100, 100, this);

        // 畫子彈
        ArrayList<Point> toRemove = new ArrayList<>();
        for (Point bullet : bullets) {
            bullet.y -= 5; // 子彈向上移動
            offG.drawImage(im2, bullet.x, bullet.y, 20, 20, this);

            // 判斷子彈是否超出畫面
            if (bullet.y < 0) {
                toRemove.add(bullet);
            }
        }
        bullets.removeAll(toRemove);

        // 將畫布顯示到螢幕
        g.drawImage(offScreen, 0, 0, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose(); // 結束程式
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            dir = 1;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            dir = 2;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            dir = 3;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            dir = 4;
        }

        // 空白鍵發射子彈
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            bullets.add(new Point(x + 50, y)); // 子彈位置根據目前飛船位置
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT
                || e.getKeyCode() == KeyEvent.VK_LEFT
                || e.getKeyCode() == KeyEvent.VK_UP
                || e.getKeyCode() == KeyEvent.VK_DOWN) {
            dir = -1;
        }
    }

    public static void main(String[] args) {
        new Main(800, 900, 0, 0);
    }

    @Override
    public void run() {
        while (true) {
            // 移動飛船
            if (dir == 1) x += 5;
            else if (dir == 2) y += 5;
            else if (dir == 3) x -= 5;
            else if (dir == 4) y -= 5;

            // 繪製子彈
            ArrayList<Point> toRemove = new ArrayList<>();
            for (Point bullet : bullets) {
                bullet.y -= 5; // 子彈向上移動
                offG.drawImage(im2, bullet.x, bullet.y, 20, 20, this);

                if (bullet.y < 0) { // 移除超出畫面的子彈
                    toRemove.add(bullet);
                }
            }
            bullets.removeAll(toRemove);

            // 重繪畫面
            repaint();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        this.dispose();
    }

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}
}