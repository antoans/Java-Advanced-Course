package tasks.task_04;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BasicQueueOperations {

	public BasicQueueOperations() {
		
		Queue<Integer> queue = new ArrayDeque<>();
		
		int length; 
		int removeCount;
		int checkNum;
		boolean checkNumFound = false;
		int minNum = Integer.MAX_VALUE;
		String[] numbers;
		
		Scanner sc = new Scanner(System.in);
		
		length = sc.nextInt();
		removeCount = sc.nextInt();
		checkNum = sc.nextInt();
		sc.nextLine();
		numbers = sc.nextLine().split(" ");
		sc.close();
		
		//add elements
		for (int i = 0; i < length; i++) {
			int currNum = Integer.parseInt(numbers[i]);
			queue.add(currNum);
		}
		
		//remove elements
		for (int i = 0; i < removeCount; i++) {
			queue.poll();
		}
		
		//find min and check numbers
		if (queue.size() == 0) {
			minNum = 0;
		}
		
		while (queue.size() > 0 ) {
			int currNum = queue.poll().intValue();
			if (currNum == checkNum) {
				checkNumFound = true;
			}
			
			if (currNum < minNum) {
				minNum = currNum;
			}
		}
		
		if (checkNumFound) {
			System.out.println("true");
		} else {
			System.out.println(minNum);
		}
		
	}
}

