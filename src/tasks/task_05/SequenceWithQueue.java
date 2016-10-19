package tasks.task_05;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class SequenceWithQueue {
	
	private static final int MEMBERS_TO_PRINT = 50;
	
	public SequenceWithQueue() {
		
		
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		sc.close();
		Queue<Long> results = new ArrayDeque<>();  
		int resultsCounter = 1;
		int commandCounter = 0; // there are 3 commands
		
		System.out.print(n + " ");
		
		long numToAdd = n;
		
		while (resultsCounter < MEMBERS_TO_PRINT) {
			long newNum;
			
			if (commandCounter == 0) {//			Add 1
				newNum = numToAdd + 1;
			} else if (commandCounter == 1) {//		Multiply by 2 and add 1
				newNum = 2 * numToAdd + 1;
			} else {//								Add 2
				newNum = numToAdd + 2; 
			}
			
			System.out.print(newNum + " ");
			results.add(newNum);
			
			resultsCounter++;
			commandCounter++;
			
			if (commandCounter > 2) {	//reset the counter
				commandCounter = 0;
				numToAdd = results.poll();
			}
		}
	}
}
