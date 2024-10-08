package prj005;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class myFun {
    // 傳入提示msg，引導玩家輸入後，回傳玩家輸入的字串
    static String stringInput(String msg) {
        String s = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print(msg);
            s = br.readLine();
        } catch (Exception e) {
            System.out.println(e);
        }

        return s;
    }

    // 回傳 0 ~ N-1 的整數亂數
    static int Rand_int_N(int n) {
        return (int) (Math.random() * n);
    }

    // 回傳 N ~ M 的整數亂數
    static int Rand_int_N_M(int n, int m) {
        return n + Rand_int_N(m - n + 1);
    }
}
