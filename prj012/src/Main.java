public class Main {
    public static void main(String[] args) {
        int[] solu = new int[9999];
        int[] solu2 = new int[9999];
        int pt = 0, pt2 = 0;
        int gus = 0;

        myfun.ResultAB rst = new myfun.ResultAB();

        // 產生 4 位數字的答案
        for (int i = 1023; i <= 9876; i++) {
            if (!myfun.checksame(String.valueOf(i))) {
                solu[pt] = i;
                pt++;
            }
        }
        // System.out.println("Total: " + pt);

        // 電腦猜答案，人類回答幾A幾B
        do {
            // 電腦猜
            gus = solu[myfun.RandNM(0, pt - 1)];
            System.out.println("my guess is... " + gus);

            // 人類回答幾A幾B
            int A = 0, B = 0;
            A = myfun.InputInt("幾A: ");
            B = myfun.InputInt("幾B: ");

            // 產生新的解集合
            pt2 = 0;
            for (int i = 0; i < pt; i++) {
                rst = myfun.CountAB(gus, solu[i]);
                if ((A == rst.A) && (B == rst.B)) {
                    solu2[pt2] = solu[i];
                    pt2++;
                }
            }
            // System.out.println("Total2 : " + pt2);

            for (int i = 0; i < pt2; i++) {
                solu[i] = solu2[i];
            }
            pt = pt2;

            if(pt2 < 0) {
                System.out.println("智障喔！！！");
                break;
            }

        } while (pt2 != 0);

        System.out.println("Answer= " + solu2[0]);

    }
}