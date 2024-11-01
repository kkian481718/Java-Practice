import java.io.BufferedReader;
import java.io.InputStreamReader;

public class myfun {
    static class ResultAB {
        int A = 0;
        int B = 0;
    }

    // 計算幾A幾B
    static ResultAB CountAB(int _ans, int _guess) {
        ResultAB p = new ResultAB();
        p.A = 0;
        p.B = 0;
        String ans_string = String.valueOf(_ans);
        String guess_string = String.valueOf(_guess);

        for (int i = 0; i < 4; i++) {
            // 第 i 個guess值
            String n_guess_string = guess_string.substring(i, i + 1);

            // 第 i 個guess值在ans裡的位置 (如果沒出現就回傳-1)
            int n_guess_pos = ans_string.indexOf(n_guess_string);

            if (n_guess_pos >= 0) {
                if (n_guess_pos == i) p.A++;
                else p.B++;
            }
        }

        return p;
    }

    // 輸出提示訊息(msg)，並讓使用者輸入文字
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

    // 輸出提示訊息(msg)，並讓使用者輸入數字（並檢查只能是數字）
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

    // 檢查字串s內是否有重複的數字
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

    // 隨機產生 0 ~ n-1 整數
    static int RandN(int n) {
        return ((int) (Math.random() * n));
    }

    // 隨機產生 n ~ m 整數
    static int RandNM(int n, int m) {
        return (n + RandN(m - n + 1));
    }

    // 隨機產生四位數字
    static int getAnswer() {
        int ans = 1111;
        while (myfun.checksame(String.valueOf(ans)) == true) {
            ans = myfun.RandNM(1000, 9999);
        }

        return ans;
    }
}
