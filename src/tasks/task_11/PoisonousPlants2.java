package tasks.task_11;

import java.util.Scanner;
import java.util.Stack;

public class PoisonousPlants2 {
	public PoisonousPlants2() {
		
		//read input
		Scanner sc = new Scanner(System.in);
		int plantsCount = Integer.parseInt(sc.nextLine());
		String[] input = sc.nextLine().split(" ");
		int[] plants = new int[plantsCount]; 
		
		for (int i = 0; i < plantsCount; i++) {
			plants[i] = Integer.parseInt(input[i]);
		}
		sc.close();
		//
		
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		
		int[] daySpan = new int[plantsCount];
		int longestPeriod = 0;
		int maxDaySpan = 0;
		
		for (int i = 1; i < plantsCount; i++) {
			maxDaySpan = 0;
			
			while (stack.size() > 0 && plants[stack.peek()] >= plants[i]) {
				maxDaySpan = Integer.max(maxDaySpan, daySpan[stack.pop()]);
			}
			
			if (stack.size() > 0) {
				daySpan[i] = maxDaySpan + 1;
				longestPeriod = Integer.max(longestPeriod, maxDaySpan + 1);
			}
			stack.push(i);
		}
		
		System.out.println(longestPeriod);
	}
}
