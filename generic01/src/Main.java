import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> ls = new ArrayList<String>();
        ArrayList<Integer> nt = new ArrayList<Integer>();
        // ArrayList<myfun> mm = new ArrayList<myfun>();

        // 1. 增加物件
        ls.add("DOG");
        ls.add("PIG");
        ls.add("CAT");
        ls.add("MOUSE");

        // 2. 用名稱找物件
        if(ls.contains("DOG")) {
            System.out.println("有 DOG");
        } else {
            System.out.println("沒有 DOG");
        }

        // 3. 用位置找物件
        System.out.println(ls.get(1)); // 輸出 PIG

        // 4. 刪物件
        ls.remove(0);
        System.out.println(ls.get(1)); // 輸出 CAT

        // 5. 算長度
        System.out.println(ls.size()); // 輸出 3
    }
}

// 1 問答:
// 甚麼是建構子

// 程式:
// 1 泛型
// 1 畫圖
// 1 button
// 1 textfield
