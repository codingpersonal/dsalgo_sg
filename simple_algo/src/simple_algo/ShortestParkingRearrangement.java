package simple_algo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://www.careercup.com/question?id=5750868554022912
 * find the minimum moves which can reorganize cars in a parking lot
 */
public class ShortestParkingRearrangement {

	static private boolean isEqual(List<Integer> ip1, List<Integer> ip2) {
		if (ip1.size() != ip2.size()) {
			return false;
		}

		for (int i=0; i < ip1.size(); i++) {
			if (ip1.get(i) != ip2.get(i)) {
				return false;
			}
		}

		return true;
	}

	// the moves are represented by :: seprator. e.g., 4::2::5::6 and so on
	// this function mutates the input list
	static public String moveCars(List<Integer> inputSpots, List<Integer> opSpots) {
		
		if (inputSpots.size() != opSpots.size()) {
			return "invalid state";
		}
		
		int currEmptySpotIndex = -1;
		
		Map<Integer, Integer> carToSpotMapping = new HashMap<>();

		int count = 0;
		for (Integer e: inputSpots) {
			carToSpotMapping.put(e, count);		// car number vs the index on which it should be
			count++;
		}

		currEmptySpotIndex = carToSpotMapping.get(-1);
		String final_seq = "";

		while (!isEqual(inputSpots, opSpots)) {
			System.out.println("empty spot is: " +  currEmptySpotIndex);
			if (opSpots.get(currEmptySpotIndex) == -1) {
				// empty spot is at right position
				// find the first car which is not at right place and swap it with empty spot. Then
				// in next iteration, proper cars would start following their places.
				
				for (int i = 0; i < inputSpots.size(); i++) {
					if (inputSpots.get(i) == -1) {
						continue;
					}
					
					if (inputSpots.get(i) != opSpots.get(i)) {
						// swap this car with the empty spot
						int next_car_to_move = inputSpots.get(i);
						final_seq += next_car_to_move + "::";
						
						// swap the empty spot with this car
						inputSpots.set(currEmptySpotIndex, next_car_to_move);
						inputSpots.set(i, -1);
						carToSpotMapping.put(next_car_to_move, currEmptySpotIndex);
						carToSpotMapping.put(-1, i);
						currEmptySpotIndex = i;
						break;
					}
				}
				
			} else {
				// possible to move a car in single shot
				int next_car_to_move = opSpots.get(currEmptySpotIndex);
				final_seq += next_car_to_move + "::";
				
				// swap the empty spot with this car
				int prev_pos = carToSpotMapping.get(next_car_to_move);
				inputSpots.set(currEmptySpotIndex, next_car_to_move);
				inputSpots.set(prev_pos, -1);
				carToSpotMapping.put(next_car_to_move, currEmptySpotIndex);
				carToSpotMapping.put(-1, prev_pos);
				currEmptySpotIndex = prev_pos;
			}
		}
		return final_seq;
	}
}
