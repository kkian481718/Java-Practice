import java.awt.*;
import java.awt.event.*;

public class Main extends Frame implements WindowListener, MouseMotionListener, MouseListener, ActionListener {
    int mx = 0, my = 0; // 滑鼠座標
    int omx = 0, omy = 0;
    int mbt = 0; // 按下的按鈕

    Button[] buttons = new Button[5]; // 建立按鈕陣列
    String[] colors = {"R", "G", "B", "W", "BK"}; // 按鈕顯示的文字
    int startX = 50; // 按鈕的起始 X 座標
    int startY = 540; // 按鈕的固定 Y 座標

    Color cr = new Color(0, 0, 0);

    Main(int width, int height, int sx, int sy) {
        this.setSize(width, height);
        this.setLocation(sx, sy);
        this.setLayout(null);
        this.setVisible(true);

        this.addWindowListener(this);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);

        // 換顏色按鈕
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new Button(colors[i]); // 建立按鈕並設置文字
            buttons[i].setSize(40, 40); // 設置按鈕大小
            buttons[i].setLocation(startX + (i * 60), startY); // 設置按鈕位置 (橫向排列)
            buttons[i].addActionListener(this); // 添加監聽器
            this.add(buttons[i]); // 加入按鈕到視窗
        }
    }

    public static void main(String[] args) {
        new Main(800, 600, 100, 100);
    }

    public void update(Graphics g) {
        paint(g);
    }

    public void paint(Graphics g) {
        if(mbt == MouseEvent.BUTTON1) {
            // 左鍵
            g.setColor(cr);
            g.drawLine(omx, omy, mx, my);
        } else if (mbt == MouseEvent.BUTTON3) {
            // 右鍵
            g.setColor(new Color(255, 255, 255));
            g.fillOval(mx - 10, my - 10, 21, 21);
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        this.dispose();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(mbt == MouseEvent.BUTTON1) {
            omx = mx;
            omy = my;
            mx = e.getX();
            my = e.getY();
            repaint();
        } else if (mbt == MouseEvent.BUTTON3) {
            mx = e.getX();
            my = e.getY();
            repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mbt = e.getButton();

        mx = e.getX();
        my = e.getY();
        omx = mx;
        omy = my;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mbt = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttons[0]) {
            cr = new Color(255, 0, 0);
        } else if(e.getSource() == buttons[1]) {
            cr = new Color(0, 255, 0);
        } else if(e.getSource() == buttons[2]) {
            cr = new Color(0, 0, 255);
        } else if(e.getSource() == buttons[3]) {
            cr = new Color(255, 255, 255);
        } else if(e.getSource() == buttons[4]) {
            cr = new Color(0, 0, 0);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

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
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}