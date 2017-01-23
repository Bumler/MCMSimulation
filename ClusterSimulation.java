import java.util.ArrayList;

public class ClusterSimulation {
	double timeIncrement;	
	double totalTimeWaited = 0;
	int totalCars, cars;
	
	TollQueue tq;
	ArrayList<TollBooth> inService;
	
	public ClusterSimulation (int B, int totalCars, double time, boolean isCar){
		this.timeIncrement = time;
		this.totalCars = totalCars;
		this.cars = totalCars;
		
		//we will start the simulation with B vehicles in the toll booths and none on the queue
		tq = new TollQueue (timeIncrement, isCar);
		
		inService = new ArrayList<>();
		for (int i = 0; i < B; i++){
			addCar();
		}
	}
	
	private void addCar(){
		if(cars > 0){
			inService.add(new TollBooth(timeIncrement));
			cars--;
	}}
	
	public boolean runSimulation(){
		if (cars > 0 || !tq.isEmpty()){
			timePasses();
			return true;
		}
		else return false;
	}
	
	private void timePasses(){
		for (int i = 0; i < inService.size(); i++){
		//if after time passes the toll booths wait time is <= 0 it should be taken out of service and placed onto the queue
			if (inService.get(i).timePasses() == true){
				tq.addToQueue(inService.get(i));
				inService.remove(i);
				i--;
				System.out.println("Placed on queue");
		}}		
		TollBooth temp = tq.timePasses();
		
		if (temp != null){
			System.out.println("Removed from queue after " +temp.timeInQueue+ " seconds");
			totalTimeWaited += temp.timeInQueue;
			
			addCar();
		}
	}
	
	public double averageQueueTime(){
		return totalTimeWaited/totalCars;
	}
}
