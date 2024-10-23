package prj007;

public class main01 {
	static class man {
		int age = 0;
		int height = 0;
	}
	
	static int fun01(int x) {
		x = x + 100;
		return x;
	}
	
	static void swap(man x, man y) {
		man k = new man();
		k.age = x.age;
		k.height = x.height;
		
		x.age = y.age;
		x.height = y.height;
		
		y.age = k.age;
		y.height = k.height;
	}
	
	public static void main(String[] args) {
		man a = new man(), b = new man();
		
		a.age = 1;
		a.height = 1;
		
		b.age = 100;
		b.height = 100;
		
		swap(a, b);
		System.out.println(a.age + ",  " + b.age);
		
	}
}
