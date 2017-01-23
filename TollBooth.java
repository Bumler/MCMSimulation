public class TollBooth {
	double timeIncrement;
	
	double transactionTime;
	
	double timeInQueue = 0;
	boolean inQueue = false;
	
	boolean priority;
	
	public TollBooth (double time){
		this.timeIncrement = time;
		generateTransactionTime();	
	}
	
	//based off the maximum cars observed through a toll booth of 500/hour
	//a toll booth receives on average a car every 13.888 seconds
	//to account for varying speeds we made this a range between 12-16
	private void generateTransactionTime(){
		//Human Interaction (8 - 12 seconds)
		transactionTime = 8 + (Math.random() * 5); 
		//Electronic Interaction (.5 - 1.5)
		//transactionTime = .5 + (Math.random() * 1); 
	}
	
	//this method passes time either decrementing the transactionTime or incrementing the time spent in queue
	//the first time the wait time goes lower than zero the toll booth will return true indicating that it 
	//should be added onto the queue
	public boolean timePasses(){
		if (!inQueue){
			transactionTime -= timeIncrement;
			
			if (transactionTime <= 0){
				inQueue = true;
				return true;
			}
		}
		else{
			timeInQueue += timeIncrement;
		}
		
		return false;
	}
	
	//before being removed the queue will take the amount of time the car spent waiting in the queue
	public double getTimeInQueue(){
		return timeInQueue;
	}
}
