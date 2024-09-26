package hw01;

public class main {
	// 用字串轉數字
    public static int Invert2(int x) {
    	String z = String.valueOf(x);
    	String new_z = "";
    	for(int i = z.length(); i > 0; i--) {
    		new_z += z.substring(i-1, i);
    	}
    	
    	return Integer.parseInt(new_z);
    }
    
    public static void main(String[] args) {
    	System.out.print(Inverse_string(123456));
    }
}
