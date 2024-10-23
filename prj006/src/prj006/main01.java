package prj006;

public class main01 {
	public static void main(String[] args) {
		String sans = myfun.Input("輸入數字範圍: ");
		int bnd = Integer.parseInt(sans);
		int low = 1;
		int high = bnd;
		int ans = myfun.RandNM(1, bnd);

		System.out.println(ans + ":" + low + "~" + high);

		do {
			bnd = myfun.InputInt("請猜一個數字(" + low + "~" + high + ")");
			if (bnd > high || bnd < low) {
				System.out.println("白癡你輸錯了吧");
			} else if (bnd == ans) {
				System.out.println("侯賽雷!!!");
				break;
			} else {
				if (bnd > ans) {
					high = bnd;
				} else {
					low = bnd;
				}
			}
		} while (true);

		System.out.println("ByeBye");
	}
}
