import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int booths = 2;
		int cars = 1000000;
		double time = .10;
		boolean isCar = false;
		ClusterSimulation c = new ClusterSimulation(booths, cars, time, isCar);
		
		double totalTime = 0;
		while(c.runSimulation()){
			totalTime += time;
		}
		
		System.out.println("Total time elapsed "+totalTime);
		System.out.println("Average wait time in queue for " +cars+ " cars in worst case conditions is with " +booths+ " booths is "+c.averageQueueTime()+ " seconds");
		System.out.println(c.averageQueueTime());
	}

}
