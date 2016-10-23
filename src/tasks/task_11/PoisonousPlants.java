package tasks.task_11;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PoisonousPlants {
	public PoisonousPlants() {
		//read input
		Scanner sc = new Scanner(System.in);
		int plantsCount = sc.nextInt();
		ArrayDeque<Integer> plants = new ArrayDeque<>();
		
		for (int i = 0; i < plantsCount; i++) {
			plants.add(sc.nextInt());
		}
		sc.close();
		
		int daysPassed = 0;
		ArrayDeque<Integer> plantsNextDay;
		boolean plantsDying = true;
		
		while (plantsDying) {
			plantsNextDay = new ArrayDeque<>();
			plantsDying = false;
			plantsNextDay.push(plants.pop());
			
			int length = plants.size();
			int nextPlant;
			for (int i = 0; i < length; i++) {
				nextPlant = plants.pop();
				if (nextPlant <= plantsNextDay.peek()) {
					plantsNextDay.push(nextPlant);
				} else {
					plantsDying = true;
				}
			}
			daysPassed++;
			plants = plantsNextDay.clone();
		}
		System.out.println(daysPassed - 1);
	}
}
