import java.util.Arrays;

public class ClusterCalculator {
	static int NUM_BOOTHS = 8;
	static int NUM_LANES  = 3;
	static int TRUCK_LANES = 2;
	
	public static void main (String args[]){	
		int[] Clusters = new int[NUM_LANES];
		distributeWithTrucks(Clusters);
		System.out.println("With a dedicated truck lane " +Arrays.toString(Clusters));
	}
	
	public static void distributeWithTrucks(int[] Clusters){
		int j = 0;
		Clusters[Clusters.length-1] = TRUCK_LANES;
		
		for (int i = 0; i < NUM_BOOTHS - TRUCK_LANES; i++){
			Clusters[j] += 1;
			
			if (j < Clusters.length-2)	{j++;}
			else   						{j = 0;}
	}}
	
//	public static void distributeClusters(int[] Clusters){
//		int j = 0;
//		for (int i = 0; i < NUM_BOOTHS; i++){
//			Clusters[j] += 1;
//			if (j < Clusters.length-1){
//				j++;
//			}
//			else{
//				j = 0;
//			}
//		}
//	}	
}
