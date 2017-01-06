package simple_algo;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ShortestPathGraph {
	
	// non weighted edges
	// DAG
	public static int findNonWeightedShortestPath(
		Map<Integer, List<Integer>> edges,
		int start, 
		int end
	) {
		
		Deque<Integer> q = new LinkedList<>();
		Map<Integer, Integer> dist = new HashMap<>();
		Set<Integer> visited = new HashSet<>();
		
		dist.put(start, 0);
		q.push(start);
		
		while (!q.isEmpty()) {
			int currNode = q.pop();
			int currNodeDist = dist.get(currNode);
			
			for (Integer edge: edges.get(currNode)) {
				if (visited.contains(edge)) {
					continue;
				}
				
				if (edge == end) {
					return currNodeDist + 1;
				}
				
				visited.add(edge);
				dist.put(edge, currNodeDist + 1);
				q.add(edge);
			}
		}

		return 0;
	}

}
