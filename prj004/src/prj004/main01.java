package prj004;

/*
 * x x x x x
 *   y y y y (-
 * ------------
 * 6 6 6 6 6
 *
 * {x, y| [1, 9]}
 * 找出 x y
 */

public class main01 {
    static boolean isSameCharInsideString(String s) {
        int n = s.length();

        for (int i = 0; i < (n - 1); i++) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j))
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] arg) {

        String z;
        int k = 0;
        int x, y;

//        for (x = 61234; x <= 79865; x++) {
//            for (y = 1234; y <= 9876; y++) {
//                if (x - y == 66666) {
//
//                    // step1. 排除 0
//                    z = String.valueOf(x) + String.valueOf(y);
//                    k = z.indexOf("0");
//
//                    if (k < 0 && !isSameCharInsideString(z)) {
//                        System.out.println(x + " - " + y + " = " + (x - y));
//                    }
//                }
//            }
//        }

        for (y = 1234; y <= 9876; y++) {
            x = y + 66666;
            z = String.valueOf(x) + String.valueOf(y);
            k = z.indexOf("0");
            if (k < 0) {
                if (!isSameCharInsideString(z)) {
                    System.out.println(x + " - " + y + " = " + (x - y));
                }
            }
        }
    }
}