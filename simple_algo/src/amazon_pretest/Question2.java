package amazon_pretest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question2 {

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    // RETURN AN EMPTY MATRIX IF PREFERRED LUNCH IS NOT FOUND
    public String[][] matchLunches(String[][] lunchMenuPairs, 
                            String[][] teamCuisinePreference)
    {
    	Map<String, List<String>> cuisineMap = new HashMap<>();
    	for (int i = 0; i < lunchMenuPairs.length; i++) {
    		String cuisine_name = lunchMenuPairs[i][0];
    		String cuisine_type = lunchMenuPairs[i][1];
    		
    		if (!cuisineMap.containsKey(cuisine_type)) {
    			List<String> newL = new ArrayList<>();
    			cuisineMap.put(cuisine_type, newL);
    		} 
			cuisineMap.get(cuisine_type).add(cuisine_name);
    	}

    	// cuisine list is prepared. We need to get all the possible combinations now
    	List<String[]> possibleTeamCuisines = new ArrayList<>();		// a dynamic growing list
    	for (int i = 0; i < teamCuisinePreference.length; i++) {
    		String memberName = teamCuisinePreference[i][0];
    		String cuisinePrefered = teamCuisinePreference[i][1];
    		
    		if (cuisinePrefered.equals("*")) {
    			// find all combinations
    			for (Map.Entry<String, List<String>> entry: cuisineMap.entrySet()) {
    				for (String cn: entry.getValue()) {
    					String[] new_entry = new String[2];
    					new_entry[0] = memberName;
    					new_entry[1] = cn;
    					possibleTeamCuisines.add(new_entry);
    				}
    			}
    		} else if (cuisineMap.containsKey(cuisinePrefered)) {
    			for (String cn: cuisineMap.get(cuisinePrefered)) {
					String[] new_entry = new String[2];
					new_entry[0] = memberName;
					new_entry[1] = cn;
					possibleTeamCuisines.add(new_entry);
    			}
    		}
    	}
    	
    	// construct the final return
    	String[][] ret = new String[possibleTeamCuisines.size()][2]; 
    	int count = 0;
    	for (String[] en: possibleTeamCuisines) {
    		ret[count++] = en;
    	}
    	
    	return ret;
    }
    // METHOD SIGNATURE ENDS
}
