import java.util.Arrays;

public class Main {

    private static final int SIZE = 3;
    private static final int SUM = 15; // 每行、列、對角線的和
    private static final int[][] square = new int[SIZE][SIZE];

    public static void main(String[] args) {
        if (solve(0, 0)) {
            printSquare();
        } else {
            System.out.println("沒有找到解。");
        }
    }

    private static boolean solve(int row, int col) {
        if (col == SIZE) {
            row++;
            col = 0;
        }

        if (row == SIZE) {
            return checkSquare();
        }

        for (int num = 1; num <= 9; num++) {
            if (isValid(row, col, num)) {
                square[row][col] = num;
                if (solve(row, col + 1)) {
                    return true;
                }
                square[row][col] = 0; // 回溯
            }
        }

        return false;
    }

    private static boolean isValid(int row, int col, int num) {
        // 檢查這個數字是否已經在方陣中
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (square[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkSquare() {
        // 檢查所有行
        for (int i = 0; i < SIZE; i++) {
            if (Arrays.stream(square[i]).sum() != SUM) {
                return false;
            }
        }

        // 檢查所有列
        for (int j = 0; j < SIZE; j++) {
            int colSum = 0;
            for (int i = 0; i < SIZE; i++) {
                colSum += square[i][j];
            }
            if (colSum != SUM) {
                return false;
            }
        }

        // 檢查主對角線
        int diagSum = 0;
        for (int i = 0; i < SIZE; i++) {
            diagSum += square[i][i];
        }
        if (diagSum != SUM) {
            return false;
        }

        // 檢查副對角線
        diagSum = 0;
        for (int i = 0; i < SIZE; i++) {
            diagSum += square[i][SIZE - 1 - i];
        }
        return diagSum == SUM;
    }

    private static void printSquare() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(square[i][j] + " ");
            }
            System.out.println();
        }
    }
}