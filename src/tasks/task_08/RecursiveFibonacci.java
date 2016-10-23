package tasks.task_08;

import java.util.Scanner;

public class RecursiveFibonacci {
	
	private static int LIMIT = 49;
	long[] results;
	
	public RecursiveFibonacci() {
		results = new long[LIMIT + 1];	//[0,0,0,0,0, ... , 0, 0]
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		long output = getFibonacci(n);
		System.out.println(output);
	}

	private long getFibonacci(int n) {
		if (n == 0 || n == 1) {
			return 1;
		} else if(results[n] != 0) {
			return results[n];
		} else {
			long res = getFibonacci(n - 1) + getFibonacci(n - 2);
			results[n] = res;
			return res;
		}
	}
}
