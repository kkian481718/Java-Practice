import java.io.BufferedReader;
import java.io.InputStreamReader;

public class myfun {
    static String Input(String msg) {
        String s = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(msg);
        try {
            s = br.readLine();
        } catch (Exception e) {
            System.out.println("請輸入正確的內容" + e);
        }
        return s;
    }

    static int InputInt(String msg) {
        int k = 0;
        String sans = "";
        int bnd = 0;
        do {
            k = 1;
            sans = myfun.Input(msg);
            try {
                bnd = Integer.parseInt(sans);
            } catch (Exception e) {
                System.out.println("請輸入正確的數字格式" + e);
                k = 0;
            }
        } while (k == 0);

        return bnd;
    }

    static boolean checksame(String s) {
        int n = s.length();
        String z1, z2;
        for (int i = 0; i <= (n - 2); i++) {
            for (int j = i + 1; j <= (n - 1); j++) {
                z1 = s.substring(i, i + 1);
                z2 = s.substring(j, j + 1);
                if (z1.compareTo(z2) == 0) {
                    return (true);
                }
            }
        }
        return (false);
    }

    // 0 ~ n-1 整數
    static int RandN(int n) {
        return ((int) (Math.random() * n));
    }

    // n ~ m 整數
    static int RandNM(int n, int m) {
        return (n + RandN(m - n + 1));
    }

    static int getAnswer() {
        int ans = 1111;
        while (myfun.checksame(String.valueOf(ans)) == true) {
            ans = myfun.RandNM(1000, 9999);
        }

        return ans;
    }
}
