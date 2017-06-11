package simple_algo;

import java.util.ArrayList;

public class LongestIncreasingSubsequence {
	
	public void findLIS(int[] in) {
		int l = in.length;
		if (l < 2) {
			System.out.println("Lis len is:" + in.length + " and LIS is : " + in);;
		}
		
		int[] dp = new int[l];
		dp[l-1] = 1;
		int[] lis = new int[l];		// store the next index of the best LIS for this index. 
									// This way we can reconstruct the LIS without consuming a lot of extra memory
		lis[l-1] = -1;			// means there is no next index for this LIS
		int maxLisIndex = l-1;
		
		for(int i = l-2; i >=0; i--) {
			dp[i]= 1;
			lis[i] = -1;
			for (int j = i+1; j < l; j++) {
				if (in[j] >= in[i] && (1 + dp[j] > dp[i])) {
					dp[i] = 1+dp[j];
					lis[i] = j;
				}
			}
			
			if (dp[i] > dp[maxLisIndex]) {
				maxLisIndex = i;
			}
		}
		
		// reconstruct the LIS
		ArrayList<Integer> finalLis = new ArrayList<>();
		int nextIndex = maxLisIndex;
		while (nextIndex != -1) {
			finalLis.add(in[nextIndex]);
			nextIndex = lis[nextIndex];
		}
		System.out.println("Lis len is:" + finalLis.size() + " and LIS is : " + finalLis);
	}

}
