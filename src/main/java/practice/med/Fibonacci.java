package practice.med;

public class Fibonacci {

	public static int fib(int no) {
		if (no <= 1) {
			return no;

		}

		int fibp = 0;
		int fib = 1;
		for (int i = 1; i < no; i++) {
			int temp = fib;
			fib = fib + fibp;
			fibp = temp;

		}
		return fib;
	}

	public static int fib_recursive(int no) {

		if (no <= 1) {
			return no;

		} else {
			return fib_recursive(no - 1) + fib_recursive(no - 2);
		}
	}

	public static int fib_tabulation(int no) {

		if (no <= 0) {
			return no;

		} 
		
		int[] fib = new int[no + 2];
		fib[0] = 0;
		fib[1] = 1;
		for (int i = 2; i < no+1; i++) {
			if (fib[i] == 0) {
				fib[i] = fib[i - 1] + fib[i - 2];
			}
		}
		return fib[no];

	}

}
