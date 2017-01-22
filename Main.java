import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int booths = 2;
		int cars = 10000;
		double time = .10;
		boolean isCar = false;
		ClusterSimulation c = new ClusterSimulation(booths, cars, time, isCar);
		
		double totalTime = 0;
		while(c.runSimulation()){
			totalTime += time;
			
//			//if we are simulating real time the program will then wait for the time increment
//			//this means are simulation will actually be slightly slower than the actual queue
//			//but this will not affect the calculations and is in effect purely cosmetic
//				try {
//					TimeUnit.SECONDS.sleep((long) time);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			
		}
		
		System.out.println("Total time elapsed "+totalTime);
		System.out.println("Average wait time in queue for " +cars+ " in worst case conditions is "+c.averageQueueTime()+ " seconds");
	}

}
