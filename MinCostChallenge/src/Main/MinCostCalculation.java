package Main;

import java.util.*;

public class MinCostCalculation {

	
	public static void main (String[] args) {
		Scanner sc= new Scanner(System.in); 
		int T= sc.nextInt();
		long N = 0;
		List<long[]> allcosts = new ArrayList<long[]>();
		for(int i=0; i<T; i++) {
			N = sc.nextLong();
			long[] A = new long[(int) N];
			for(int z=0; z < N; z++) {
				if(z == 0) {
					A[z] = sc.nextLong();
				}else {
					if(sc.hasNext()) {
						A[z] = Long.parseLong(sc.next());
					}
				}
			}
			allcosts.add(A);
			
		}
		List<Long> output = getMinimumCost(allcosts);
		for(Long o : output) {
			System.out.println(o);
		}
	}

	private static List<Long> getMinimumCost(List<long[]> allcosts) {
		List<Long> output = new ArrayList<Long>();
		for(long[] costs : allcosts) {
			
			Arrays.sort(costs); 
	        long totalCost = 0; 
	        int n = costs.length;
	        for (int i = n - 1; i > 1; i -= 2){ 
	            if (i == 2){ 
	                totalCost += costs[2] + costs[0]; 
	            }else{ 
	      
	                long costs_first = costs[i] + costs[0] + 2 * costs[1]; 
	                long costs_second = costs[i] + costs[i - 1] + 2 * costs[0]; 
	                totalCost += Math.min(costs_first, costs_second); 
	            } 
	        } 
	      
	        if (n == 1){ 
	            totalCost += costs[0]; 
	        }else{ 
	            totalCost += costs[1]; 
	        }
	        output.add(totalCost);
		}
		
		return output;
	}
}
