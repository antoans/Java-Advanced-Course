package tasks.task_01;

import java.util.Scanner;
import java.util.Stack;

public class ReverseNumbers {
	public ReverseNumbers() {
		
		Stack<Integer> stack = new Stack<>();
		
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		String[] numbers = input.split(" ");
		
		for (int i = 0; i < numbers.length; i++) {
			int currNum = Integer.parseInt(numbers[i]);
			stack.push(currNum);
		}
		
		sc.close();
		int length = stack.size();
		
		for (int i = 0; i < length; i++) {
			System.out.print(stack.pop() + " ");
		}
	}
}
