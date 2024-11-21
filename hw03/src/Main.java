public class Main {
    static class computerGuessResult {
        boolean isWin;
        int[] possibleAns;
        int possibleAnsSize;
    }

    public static computerGuessResult generateComputerAns() {
        computerGuessResult result = new computerGuessResult();

        int[] possible_ans_com = new int[9999]; // 初始化電腦的可猜答案
        int iterator = 0;
        for(int l = 1023; l <= 9876; l++) {
            if (!myfun.checksame(String.valueOf(l))) {
                possible_ans_com[iterator] = l;
                iterator++;
            }
        }

        result.possibleAns = possible_ans_com;
        result.possibleAnsSize = iterator;
        result.isWin = false;

        return result;
    }

    public static computerGuessResult computerGuess(computerGuessResult com_r) {
        System.out.println();
        System.out.println(">>> 電腦的回合 <<<");

        boolean isWin;
        int[] possibleAns = com_r.possibleAns;
        int size = com_r.possibleAnsSize;

        // 電腦猜答案，人類回答幾A幾B
        // 電腦猜
        int guess = possibleAns[myfun.RandNM(0,  size - 1)];
        System.out.println("【電腦】我猜是...逼逼波逼波..." + guess);

        // 人類回答幾A幾B
        int A, B;
        A = myfun.InputInt("> 請回答 | 電腦猜中幾A: ");
        B = myfun.InputInt("> 請回答 | 電腦猜中幾B: ");

        int new_size = 0;
        int[] new_possibleAns = new int[5000];
        myfun.ResultAB tempAB; // 暫存AB計算結果。用來比較該數字是否符合玩家提供的AB值

        if (A == 4) {
            System.out.println("【系統】電腦猜中了！");
            isWin = true;
        } else {
            // 產生新的解集合

            for (int i = 0; i < size; i++) {
                tempAB = myfun.CountAB(guess, possibleAns[i]); // 確認 "原本 possibleAns 中每個數字的AB = 玩家提供的AB" ?
                if ((A == tempAB.A) && (B == tempAB.B)) {
                    new_possibleAns[new_size] = possibleAns[i];
                    new_size++;
                }
            }

            // 確認是否無解
            if(new_size <= 0) {
                System.out.println("【系統】Oh no, 你好像出錯題目了，因此這場判定為電腦贏！");
                isWin = true;
            } else {
                System.out.println("【電腦】太可惜了！但我只剩 " + new_size + " 個數字需要猜～");
                isWin = false;
            }
        }

        computerGuessResult new_com_r = new computerGuessResult();
        new_com_r.isWin = isWin;
        new_com_r.possibleAns = new_possibleAns;
        new_com_r.possibleAnsSize = new_size;

        return new_com_r;
    }

    public static boolean playerGuess(int ans) {
        System.out.println();
        System.out.println(">>> 你的回合 <<<");

        int guess = -1;
        while (guess < 1000 || guess > 9999 || myfun.checksame(String.valueOf(guess))) {
            guess = myfun.InputInt("【系統】請輸入一個不重複數字的四位數: ");
        }

        if (guess != ans) {
            myfun.ResultAB guess_result_AB = myfun.CountAB(guess, ans);
            System.out.println("【系統】可惜了！這樣是 " + guess_result_AB.A + "A" + guess_result_AB.B + "B");
            return false;
        } else {
            System.out.println("【系統】你猜中了！");
            return true;
        }
    }

    public static void main(String[] args) {
        // 初始化玩家資訊
        System.out.println("【系統】已產生玩家答案！");
        int ans_player = myfun.getAnswer(); // 產生一組四位數字給玩家

        // 初始化電腦資訊
        System.out.println("【系統】請想一組不重複數字的四位數字，並記在心裡");
        computerGuessResult com_result = generateComputerAns();

        boolean is_player_win = false;
        boolean is_computer_win = false;

        // 作弊看答案
        // System.out.println(ans_player);

        // 只要有任一方贏就結束遊戲：）
        while(!is_player_win || !is_computer_win) {
            if (!is_player_win) is_player_win = playerGuess(ans_player);

            if (!is_computer_win) {
                com_result = computerGuess(com_result);
                is_computer_win = com_result.isWin;
            }
        }

        System.out.println();
        System.out.println(">>> 遊戲結束 <<<");
    }
}