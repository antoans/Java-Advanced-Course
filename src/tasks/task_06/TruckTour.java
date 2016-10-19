package tasks.task_06;

import java.util.ArrayDeque;
import java.util.Scanner;

public class TruckTour {
	
	private ArrayDeque<GasPump> gasPumps;
	private ArrayDeque<GasPump> cloneQueue;
	private int pumpsCount;
	private int pumpsTravelled;
	private int currentGas;
	
	public TruckTour() {
		
		gasPumps = new ArrayDeque<GasPump>();
		readInput();
		
		for (int i = 0; i < pumpsCount; i++) {
			cloneQueue = gasPumps.clone();
			currentGas = 0;
			pumpsTravelled = 0;
			if (canMakeFullCircle()) {
				System.out.println(i);
				break;
			}
			gasPumps.add(gasPumps.poll());
		}
		
	}
	
	private boolean canMakeFullCircle() {
		
		GasPump currGasPump = cloneQueue.poll();
		cloneQueue.add(currGasPump);
		
		currentGas += currGasPump.getGas();	//fill some gasoline...
		
		if (currentGas < currGasPump.getDistance()) {
			return false;
		} else {
			currentGas -= currGasPump.getDistance();
			pumpsTravelled++;
			if (pumpsTravelled == pumpsCount) {
				return true;
			}
			return canMakeFullCircle();
		}
	}

	private void readInput() {
		Scanner sc = new Scanner(System.in);
		pumpsCount = sc.nextInt();
		
		for (int i = 0; i < pumpsCount; i++) {
			GasPump pump = new GasPump(sc.nextInt(), sc.nextInt());
			gasPumps.add(pump);
		}
		sc.close();
	}
	
	private class GasPump {
		private int gas;
		private int distance;
		
		public int getGas() {
			return gas;
		}
		private void setGas(int gas) {
			this.gas = gas;
		}
		public int getDistance() {
			return distance;
		}
		private void setDistance(int distance) {
			this.distance = distance;
		}
		
		public GasPump(int gas, int distance) {
			this.setGas(gas);
			this.setDistance(distance);
		}

	}
}
