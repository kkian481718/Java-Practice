import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static String INVString(String s) {
        StringBuilder reverse_s = new StringBuilder();
        for (char c : s.toCharArray()) {
            //reverse_s.insert(reverse_s.length(), c);
            //reverse_s.append(c);
            reverse_s.insert(0, c);
        }

        return reverse_s.toString();
    }

    public static String SepString(String s) {
        StringBuilder odd_s = new StringBuilder();
        StringBuilder even_s = new StringBuilder();

        int count = 0;
        for (char c : s.toCharArray()) {
            count++;
            if (count % 2 == 0) {
                even_s.append(c);
            } else {
                odd_s.append(c);
            }
        }

        return odd_s.toString() + even_s.toString();
    }

    public static int OddEvenRandom(int a, int b, boolean oe) {
        // oe == true: N%2 == 0 (偶數)
        // oe == false: 奇數

        int N = 0;
        do {
            N = (int) (Math.random() * (b - a)) + a;
        } while (oe == (N % 2 != 0));

        return N;
    }

    public static List<Integer> SpecialNum(int n1, int n2, int k) {
        List<Integer> ans = new ArrayList<>();

        for (int i = n1; i <= n2; i++) {
            String s = String.valueOf(i);
            int sum = 0;
            for (char c : s.toCharArray()) {
                sum += c - '0';
            }

            if (sum == k) {
                ans.add(i);
            }
        }

        return ans;
    }

    public static int Calu (int a, int b) {
        int k = a;
        int m = 0;
        int n = 0;

        String input = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean inputIsNum = false;
        do {
            try {
                input = br.readLine();
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (!inputIsNum);

        return 0;
    }

    public static void main(String[] args) {
        String s1 = "AB1230GP";
        String s2 = "AB123CDEF";

        System.out.println(INVString(s1));
        System.out.println(SepString(s2));
        System.out.println(OddEvenRandom(5, 10, false));
        System.out.println(OddEvenRandom(5, 10, true));
        System.out.println(SpecialNum(1, 30, 5));
    }
}