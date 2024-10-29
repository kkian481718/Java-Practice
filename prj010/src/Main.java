/*
二維的動態矩陣
 */

public class Main {
    public static void main(String[] args) {
        int[][] a = new int[4][]; // 一開始要先定義是幾維矩陣
        for (int i = 0; i < 4; i++) {
            a[i] = new int[i + 1];
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = 1;
            }
        }
    }
}