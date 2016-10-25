package tasks.task_11;

import java.util.ArrayDeque;
import java.util.Scanner;

import sun.security.util.PendingException;

public class PoisonousPlants {
	public PoisonousPlants() {

		//read input
		Scanner sc = new Scanner(System.in);
		int plantsCount = Integer.parseInt(sc.nextLine());
		String[] input = sc.nextLine().split(" ");
		
		
		ArrayDeque<Integer> plants = new ArrayDeque<>();
		
		for (int i = 0; i < plantsCount; i++) {
			plants.add(Integer.parseInt(input[i]));
		}
		sc.close();
		//
		
		int daysPassed = 0;
		boolean plantsDying = true;
		int length;
		int nextPlant;
		int prevPlant;
		
		while (plantsDying) {
			length = plants.size();
			plantsDying = false;
			
			prevPlant = Integer.MAX_VALUE;
			for (int i = 0; i < length; i++) {
				nextPlant = plants.poll();
				if (nextPlant > prevPlant) {
					plantsDying = true;
				} else {
					plants.add(nextPlant);
				}
				prevPlant = nextPlant;
			}
			
			daysPassed++;
		}
		System.out.println(daysPassed - 1);
		//https://softuni.bg/forum/9722/useful-info-exercises-advanced-csharp-stacks-and-queues-problem-11-poisonous-plants-spoiler-alert
	}
}
