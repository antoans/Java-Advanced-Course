package tasks.task_09;

import java.util.Scanner;
import java.util.Stack;

public class StackFibonacci {
	public StackFibonacci() {

		Stack<Long> numbers = new Stack<>();
		numbers.push((long) 1);
		numbers.push((long) 1);
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		if (n == 0 || n == 1) {
			System.out.println(1);
			return;
		}
		
		long last;
		long secondLast;
		long newNum;
		for (int i = 0; i < n - 1; i++) {
			last = numbers.pop();
			secondLast = numbers.peek();
			newNum = last + secondLast;
			numbers.push(last);
			numbers.push(newNum);
		}
		
		System.out.println(numbers.peek());
	}
}
