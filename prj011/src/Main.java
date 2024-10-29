/*
怎麼回傳一個自訂物件
 */

public class Main {

    public static void main(String[] args) {
        myfun.ResultAB result;
        int ans_int = myfun.getAnswer(); // 產生四位數字
        int guess_int = 0;

        // System.out.println(ans_int);

        do {
            do {
                guess_int = myfun.InputInt("請輸入一個四位數(四個數字都不一樣): ");
            } while (guess_int < 1000 || guess_int > 9999 || myfun.checksame(String.valueOf(guess_int)));

            result = myfun.CountAB(guess_int, ans_int);
            System.out.println(result.A + "A" + result.B + "b");

        } while (guess_int != ans_int);

        System.out.println("猜中了！");
    }
}