import java.util.Arrays;

public class Main {
    static void doubleValueInArray(int[] m) { // call by address
        int k = m.length;

        for (int i = 0; i < k; i++) {
            m[i] *= 2;
        }
    }

    static void setValueInArrayToOne(int[] m) { // call by value
        int k = m.length;
        m = new int[k]; // <--- 這裡

        for (int i = 0; i < k; i++) {
            m[i] = 1;
        }
    }

    public static void main(String[] args) {
        // int[10] a; -> java 不允許靜態矩陣

        int n = myfun.InputInt("計算總和與平均，請輸入總共要給幾個數字：");
        int[] num = new int[n];

        int sum = 0;
        for(int i = 0; i < n; i++){
            num[i] = myfun.InputInt("請輸入第" + (i+1) + "/" + n + "個數字: ");
            sum += num[i];
        }

        System.out.println("總和 = " + sum);
        System.out.println("平均 = " + sum/n);
        System.out.println("num = " + Arrays.toString(num));
        System.out.println();

        doubleValueInArray(num);
        System.out.println("num = " + Arrays.toString(num));
        System.out.println();

        setValueInArrayToOne(num);
        System.out.println("num = " + Arrays.toString(num));
        System.out.println();
    }
}