package tasks.task_04;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BasicQueueOperations {

	public BasicQueueOperations() {
		
		Queue<Integer> queue = new ArrayDeque<>();
		PriorityQueue<Integer> prioQueue;
		
		int length; 
		int removeCount;
		int checkNum;
		int minNum = Integer.MAX_VALUE;
		String[] numbers;
		
		Scanner sc = new Scanner(System.in);
		
		
		length = sc.nextInt();
		prioQueue = new PriorityQueue<Integer>(length, new IntegerComparator());
		removeCount = sc.nextInt();
		checkNum = sc.nextInt();
		sc.nextLine();
		numbers = sc.nextLine().split(" ");
		//add elements
		for (int i = 0; i < numbers.length; i++) {
			int currNum = Integer.parseInt(numbers[i]);
			queue.add(currNum);
			
			prioQueue.offer(currNum);
		}
		
		//remove elements
		for (int i = 0; i < numbers.length; i++) {
			int removedNumber = queue.poll();

			if (removedNumber == prioQueue.peek()) {
				prioQueue.poll();
			}
		}
		
		//
	}
	class IntegerComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer i1, Integer i2) {

			if(i1.intValue() == 70 || i2.intValue() == 70) {
				System.out.println("kur");
			}
			
			if (i1.intValue() > i2.intValue()) {
				return 1;
			} else if (i1 < i2){
				return -1;
			} 
			return 0;
		}
		
	}
}

