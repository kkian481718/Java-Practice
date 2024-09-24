package prj003;

public class main {
	// 用while迴圈轉字串
    public static int Inverse_while(int x) {
        int y, p;
        p = 0;
        int n = (int) Math.log10(x); // 取得n的位數

        while (x > 0) {
            y = x % 10;
            x = x / 10;
            p = p + y * (int) Math.pow(10, n);

            n--;
        }

        return(p);
    }
    
    // 用字串轉數字
    public static int Inverse_string(int x) {
    	String z = String.valueOf(x);
    	String new_z = "";
    	for(int i = z.length(); i > 0; i--) {
    		new_z += z.substring(i-1, i);
    	}
    	
    	int new_x = Integer.parseInt(new_z);
    	return new_x;
    }
    
    
//  String s = "1234";
//	int k = Integer.parseInt(s); //字串轉數字
//	String z = String.valueOf(k); //數字轉字串
//	
//	System.out.println("數字: " + k);
//	System.out.println("字串: " + z);
//	
//	System.out.println(s.substring(1, 3));
    
    public static void main(String[] args) {
    	//System.out.print(Inverse_while(578921));
    	System.out.print(Inverse_string(123492));
    }
}
