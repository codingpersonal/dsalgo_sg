package simple_algo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PossibleBSTs {
	private static Map<Integer, Integer> possibleCounts = new HashMap<>();
	
	public static int countPossibleBSTs(List<Integer> input) {
		if (input == null) {
			return 0;
		}

		return countBSTs(input.size());
	}
	
	public static int countBSTs(int n) {

		if (n < 2) {
			return 1;
		}

		if (possibleCounts.containsKey(n)) {
			return possibleCounts.get(n);
		}

		int count = 0;
		for (int i= 0; i < n; i++) {
			count += countBSTs(i) * countBSTs(n-i-1);
		}
		
		possibleCounts.put(n,count);
		return count;
	}

}
