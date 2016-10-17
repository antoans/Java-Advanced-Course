package tasks.task_02;

import java.util.Scanner;
import java.util.Stack;

public class BasicStackOperations {
	public BasicStackOperations() {
		
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> minStack = new Stack<>();
		
		int pushCount;
		int popCount;
		int checkNumber;
		int checkNumberCount = 0;
		String[] numbers;
		String[] firstLine;
		
		Scanner sc = new Scanner(System.in);
		
		firstLine = sc.nextLine().split(" ");
		
		pushCount = Integer.parseInt(firstLine[0]);
		popCount = Integer.parseInt(firstLine[1]);
		checkNumber = Integer.parseInt(firstLine[2]);
		
		numbers = sc.nextLine().split(" ");
		
		
		for (int i = 0; i < pushCount; i++) {
			int nextNum = Integer.parseInt(numbers[i]);
			stack.push( nextNum );
			
			if (nextNum == checkNumber) {
				checkNumberCount ++;
			}
			
			if (minStack.isEmpty() || nextNum < minStack.peek()) {
				minStack.push(nextNum);
			} else {
				minStack.push(minStack.peek());
			}
		}
		
		for (int i = 0; i < popCount; i++) {
			if( stack.pop() == checkNumber ) {
				checkNumberCount --;
			}
			minStack.pop();
		}
		
		if (checkNumberCount > 0) {
			System.out.println(true);
		} else if (minStack.isEmpty()) {
			System.out.println(0);
		} else {
			System.out.println(minStack.peek());
		}
		
		
	}
	
}


