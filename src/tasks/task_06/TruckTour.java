package tasks.task_06;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class TruckTour {
	
	private Queue<GasPump> gasPumps;
	private int pumpsCount;
	private int pumpsTravelled;
	
	public TruckTour() {
		
		gasPumps = new ArrayDeque<GasPump>();
		readInput();
		pumpsTravelled = 0;
		
		for (int i = 0; i < pumpsCount; i++) {
			if (canMakeFullCircle(0)) {
				System.out.println(i);
				break;
			}
		}
		
	}
	
	private boolean canMakeFullCircle(int gas) {
		
		GasPump currGasPump = gasPumps.poll();
		gasPumps.add(currGasPump);
		
		gas += currGasPump.getGas();	//fill some gasoline...
		
		if (gas < currGasPump.getDistance()) {
			return false;
		} else {
			pumpsTravelled++;
			if (pumpsTravelled == pumpsCount) {
				return true;
			}
			return canMakeFullCircle(gas);
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
