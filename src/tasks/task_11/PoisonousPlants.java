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
		//
		
		int daysPassed = 0;
		ArrayDeque<Integer> plantsNextDay;
		boolean plantsDying = true;
		int length;
		int firstPlant;
		
		while (plantsDying) {
			length = plants.size();
			plantsNextDay = new ArrayDeque<>();
			plantsDying = false;
			
			int nextPlant;
			int prevPlant = -1;	// -1 indicates that we are checking the first plant, which never dies
			for (int i = 0; i < length; i++) {
				nextPlant = plants.poll();
				if (prevPlant != -1 && nextPlant > prevPlant) {
					plantsDying = true;
				} else {
					plantsNextDay.add(nextPlant);
				}
				prevPlant = nextPlant;
			}
			//if no plant died, then we must print the number of days,
			//leading to this day
			if(plantsDying)  daysPassed++;
			plants = plantsNextDay;
		}
		System.out.println(daysPassed);
	}
}
