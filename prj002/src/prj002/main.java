package prj002;

public class main {
    public static int Inverse(int x) {
        int y1, y2, y3, y4;
        y1 = x % 10;
        y2 = (x / 10) % 10;
        y3 = (x / 100) % 10;
        y4 = (x / 1000);

        return y1 * 1000 + y2 * 100 + y3 * 10 + y4;
    }

    public static void main(String[] arg) {
        int x_new = 0;
        for (int x = 1000; x <= 9999; x++) {

            x_new = Inverse(x);

            for (int i = 2; i <= 9; i++) {
                if (x * i == x_new) {
                    System.out.println(x + " * " + i + " = " + x_new);
                    System.out.println();
                }
            }
        }
    }
}
