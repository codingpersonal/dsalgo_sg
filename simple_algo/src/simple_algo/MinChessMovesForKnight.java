package simple_algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given an initial position of a knight in a chess board and a final position, you need to find out the 
 * minimum moves for this knight to reach to final position.
 */
public class MinChessMovesForKnight {
	
	// contains the DP for start position and the min moves till end position
	private Map<Integer, Integer> visitedNodes = new HashMap<>();
	
	private boolean isValidPosition(int pos) {
		return pos >=0 && pos <= 63;
	}
	
	// startPos is normalized according to denser representation of the row and column numbers
	private List<Integer> getAllPossibleMovesFromCurrentLocation(
			int startPos) {
		
		List<Integer> ret = new ArrayList<>();
		if (isValidPosition(startPos- 6))		// right then up
			ret.add(startPos - 6);
		if (isValidPosition(startPos + 10))		// right then down
			ret.add(startPos + 10);
		if (isValidPosition(startPos- 10))		// left then up
			ret.add(startPos - 10);
		if (isValidPosition(startPos + 6))		// left then down
			ret.add(startPos + 6);
		if (isValidPosition(startPos- 15))		// up then right
			ret.add(startPos - 15);
		if (isValidPosition(startPos- 17))		// up then left
			ret.add(startPos - 17);
		if (isValidPosition(startPos + 17))		// down then right
			ret.add(startPos + 17);
		if (isValidPosition(startPos + 15))		// down then left
			ret.add(startPos + 15);

		return ret;
	}
	
	public int minMovesForKnight(
			int startPos, 
			int endPos
			) {
		
		if (startPos == endPos)
			return 0;
		
		if (visitedNodes.containsKey(startPos)) {
			return visitedNodes.get(startPos);
		}
		
		// now find all the min moves from the next all positions
		visitedNodes.put(startPos,-1);		// to indicate that this is the current position in the stack so that we don't call it again and again causing infinite recursion.
		
		List<Integer> nextPos = this.getAllPossibleMovesFromCurrentLocation(startPos);
		int minMove = 9999;
		for (Integer nextPosition: nextPos) {
			if (visitedNodes.containsKey(nextPosition) && visitedNodes.get(nextPosition) == -1) {
				continue;	// don't call again.
			}
			
			minMove = Math.min(minMove, 1 + this.minMovesForKnight(nextPosition, endPos));
		}

		visitedNodes.put(startPos, minMove);
		return minMove;
	}
	
	
	// rows and columns are indexed from 0 to 7
	public int minMovesForKnight(
			int start_r,
			int start_c,
			int final_r, 
			int final_c
			) {
		return minMovesForKnight(start_r *8 + start_c, final_r*8 + final_c);
	}

}
