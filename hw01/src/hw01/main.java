package hw01;

public class main {
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
    
    public static void main(String[] args) {
    	System.out.print(Inverse_string(123456));
    }
}
