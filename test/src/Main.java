import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] ans = new int[9];
        boolean[] used = new boolean[10];

        solve(0, ans, used);
    }

    public static void solve(int index, int[] arr, boolean[] used) {
        if (index == 9) {
            if (checkAns(arr)) {
                System.out.println(Arrays.toString(arr));
            }
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (!used[i]) {
                arr[index] = i;
                used[i] = true;

                solve(index + 1, arr, used);
                used[i] = false;
            }
        }
    }

    public static boolean checkAns(int[] ans) {
        int row1 = ans[0] + ans[1] + ans[2];
        int row2 = ans[3] + ans[4] + ans[5];
        int row3 = ans[6] + ans[7] + ans[8];

        return row1 == 18 && row2 == 12 && row3 == 15;
    }
}