import java.util.LinkedList;

public class TollQueue {
	LinkedList<TollBooth> q = new LinkedList<>();
	
	double timeIncrement;
	double queueTime;
	double waitTime;
	boolean waiting = false;
	
	public TollQueue(double time, boolean isCar){
		this.timeIncrement = time;
		setQueueTime(isCar);
	}

	//based on if the queue is for cars or trucks we will use our calculated wait times
	//to determine how frequently cars should be released from the queue
	private void setQueueTime(boolean isCar){
		if(isCar){
			queueTime = 3.086;
			//queueTime = 5;
		}
		else{
			queueTime = 6.3245;
		}
	}
	
	public void addToQueue(TollBooth t){
		q.add(t);
	}
	
	public boolean isEmpty(){
		if (q.peek() == null){
			return true;
		}
		
		else {
			return false;
		}
	}
	
	private void waitTollBooth(){
		//goes through our queue and passes time on every element
		//it is because of this method we are unable to use an actual queue :(
		for (int i = 0; i < q.size(); i++){
			q.get(i).timePasses();
		}
	}
	
	public TollBooth timePasses(){
		//if we arent waiting we attempt to remove the head of the queue and reset the waiting time
		if(!waiting){
			if (q.peek() != null){
				waitTime = queueTime;
				waiting = true;
				TollBooth temp = q.remove();
				waitTollBooth();
				return temp;
			}
		}
		else{
			waitTollBooth();
			waitTime -= timeIncrement;
			
			if (waitTime <= 0){
				waiting = false;
			}
		}
		
		return null;
	}
}
