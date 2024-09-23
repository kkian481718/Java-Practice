package prj002;

public class main {
	public static void main(String[] arg) {
		for (int x = 1000; x <= 9999; x++) {
			int y1 = x % 10;
			int y2 = (x / 10) % 10;
			int y3 = (x / 100) % 10;
			int y4 = (x / 1000);
			
			int x_new = y1*1000 + y2*100 + y3*10 + y4;
			
			for (int i = 2; i <= 9; i++) {
				if (x * i == x_new) {
					System.out.print(x);
					System.out.print(" * ");
					System.out.print(i);
					System.out.print(" = ");
					System.out.print(x_new);
					System.out.println();
				}
			}
		}
	}
}
