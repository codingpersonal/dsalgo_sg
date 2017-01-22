package simple_algo;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main (String[] args) {
		System.out.println("hello world");
		
		// possible BSTs
//		int n = 5;
//		System.out.println("count for " + n + " is : " + PossibleBSTs.countBSTs(n));
		
		// decode string
//		String input = "3[a2[bd]g4[ef]h]";
//		String input = "ab3[cd]f2g1[h]";
//		System.out.println("Decoding for " + input + " is : " + DecodingString.decodeString(input));

		// car reorganizing in parking lot
		List<Integer> in = new ArrayList<>();
		in.add(1);
		in.add(2);
		in.add(3);
		in.add(-1);
		in.add(4);
		in.add(5);
    
		List<Integer> op = new ArrayList<>();
		op.add(5);
		op.add(1);
		op.add(-1);
		op.add(3);
		op.add(2);
		op.add(4);
		System.out.println("the minimum ordering is : " + ShortestParkingRearrangement.moveCars(in, op));
    }

}
