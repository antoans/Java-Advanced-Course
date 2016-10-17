package tasks.task_03;

import java.util.Scanner;
import java.util.Stack;

public class MaximumElement {
	public MaximumElement() {

		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> maxStack = new Stack<>();
		int max = Integer.MIN_VALUE;
		
		
		int length = sc.nextInt();

		for (int i = 0; i < length; i++) {
			int cmd = sc.nextInt();
			
			if (cmd == 1) {
				int numToPush = sc.nextInt();
				stack.push(numToPush);
				
				if (numToPush > max) {
					max = numToPush;
					maxStack.push(numToPush);
				}
			} else if (cmd == 2) {
				if (max == stack.pop()) {
					maxStack.pop();
					max = maxStack.peek();
				}
			} else if (cmd == 3) {
				System.out.println(maxStack.peek());
			}
		}
		sc.close();
		
		
		
	}
}
