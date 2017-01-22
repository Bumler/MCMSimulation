public class TollBooth {
	double timeIncrement;
	
	double waitTime;
	
	double timeInQueue = 0;
	boolean inQueue = false;
	
	boolean priority;
	
	public TollBooth (double time){
		this.timeIncrement = time;
		generateWaitTime();	
	}
	
	//based off the maximum cars observed through a toll booth of 500/hour
	//a toll booth receives on average a car every 13.888 seconds
	//to account for varying speeds we made this a range between 12-16
	private void generateWaitTime(){
		waitTime = 12 + (Math.random() * 5); 
//		waitTime = 13.888;
//		waitTime = 1;
		
//		waitTime = .5 + (Math.random() * 1);
	}
	
	//this method passes time either decrementing the waitTime or incrementing the time spent in queue
	//the first time the wait time goes lower than zero the toll booth will return true indicating that it 
	//should be added onto the queue
	public boolean timePasses(){
		if (!inQueue){
			waitTime -= timeIncrement;
			
			if (waitTime <= 0){
				inQueue = true;
				return true;
			}
		}
		else{
			//System.err.println("does this ever happen");
			timeInQueue += timeIncrement;
		}
		
		return false;
	}
	
	//before being removed the queue will take the amount of time the car spent waiting in the queue
	public double getTimeInQueue(){
		return timeInQueue;
	}
}
