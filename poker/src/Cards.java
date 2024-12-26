import java.awt.*;

public class Cards extends Canvas {
    int mw, mh, msx, msy;
    int mclr, mnum;
    int omclr, omnum;
    Image cim;

    Cards(int w, int h, int sx, int sy, int clr, int num) {
        // 位置變數
        mw = w;
        mh = h;
        msx = sx;
        msy = sy;

        // 花色、數字變數
        mclr = clr;
        mnum = num;

        String z1 = getClrString(clr); // 設定花色
        String z2 = getNumString(num); // 設定數字
        cim = getToolkit().getImage(getClass().getResource(z1 + z2 + ".jpg"));

        this.setSize(w, h);
        this.setLocation(sx, sy);
    }

    public String getClrString(int clr) {
        String z1;
        // 設定花色
        switch (clr) {
            case 1:
                z1 = "CL";
                break;
            case 2:
                z1 = "DM";
                break;
            case 3:
                z1 = "HR";
                break;
            case 4:
                z1 = "SP";
                break;
            default:
                z1 = "CL";
                System.out.println("Invalid CLR");
                break;
        }

        return z1;
    }

    public String getNumString(int num) {
        String z2 = String.valueOf(num);
        if (num < 1 || num > 13) num = 1;
        if (num < 10) z2 = "0" + z2;

        return z2;
    }

    public void paint(Graphics g) {
        g.drawImage(cim, 0, 0, mw, mh, this);
    }

    public void setBack() {
        omclr = mclr;
        mclr = 0;
        omnum = mnum;
        mnum = 0;

        cim = getToolkit().getImage(getClass().getResource("back2.jpg"));
        repaint();
    }

    public void setFront() {
        mclr = omclr;
        mnum = omnum;
        String z1 = getClrString(mclr);
        String z2 = getNumString(mnum);

        cim = getToolkit().getImage(getClass().getResource(z1 + z2 + ".jpg"));
        repaint();
    }

    public int getClr() { return mclr; }
}
