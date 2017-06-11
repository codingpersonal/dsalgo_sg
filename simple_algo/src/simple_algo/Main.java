package simple_algo;

import java.util.ArrayList;
import java.util.List;

import codejam2017.IncreasingNum;
import codejam2017.PanCakeFlip;

public class Main {

    public static void main (String[] args) {
		System.out.println("hello world everyone");
		
		// ******************* possible BSTs ***********************
//		int n = 5;
//		System.out.println("count for " + n + " is : " + PossibleBSTs.countBSTs(n));
		
		// ***************** decode string ***************************
//		String input = "3[a2[bd]g4[ef]h]";
//		String input = "ab3[cd]f2g1[h]";
//		System.out.println("Decoding for " + input + " is : " + DecodingString.decodeString(input));

		// **************** car reorganizing in parking lot ******************
//		List<Integer> in = new ArrayList<>();
//		in.add(1);
//		in.add(-1);
//		in.add(2);
//		in.add(5);
//		in.add(3);
//		in.add(4);
//    
//		List<Integer> op = new ArrayList<>();
//		op.add(5);
//		op.add(1);
//		op.add(-1);
//		op.add(4);
//		op.add(2);
//		op.add(3);
//		System.out.println("the minimum ordering is : " + ShortestParkingRearrangement.moveCars(in, op));

		// ******************* minimum moves for a knight in a chess board from start to end position ***********
//		MinChessMovesForKnight obj = new MinChessMovesForKnight();
//		int start_r = 5, start_c = 4, end_r = 7, end_c = 4;
//		System.out.println("Min moves from (" + start_r + " , " + start_c + ") to (" + end_r + " , " + end_c + ") is: " + obj.minMovesForKnight(start_r, start_c, end_r, end_c));

//		PanCakeFlip pc = new PanCakeFlip();
//		int min = pc.findMinFlips("-+-+-", 4);
////		System.out.println("min flips:" + min);
//		pc.solveProblem("/Users/saurabg/Downloads/A-large-practice.in");

//    	IncreasingNum nn = new IncreasingNum();
////    	String maxx = nn.findMax("7");
////    	System.out.println("maxx is : " +  maxx);
//    	nn.solveProblem("/Users/saurabg/Downloads/B-large-practice.in");

		// just bigger number using same digits
//		NextBigNumber jb = new NextBigNumber();
//		String in = "534976";
//		System.out.println("just bigger number of " + in + " is :" + jb.findNextBig(in));

		// longest increasing subsequence
		int[] in = {50, 3, 10, 7, 40, 80};
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		lis.findLIS(in);
		
		
		
		
		
    }
}
