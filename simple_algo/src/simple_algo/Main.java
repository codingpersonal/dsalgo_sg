package simple_algo;

public class Main {

    public static void main (String[] args) {
		System.out.println("hello world");
		
		// possible BSTs
//		int n = 5;
//		System.out.println("count for " + n + " is : " + PossibleBSTs.countBSTs(n));
		
		// decode string
//		String input = "3[a2[bd]g4[ef]h]";
		String input = "ab3[cd]f2g1[h]";
		System.out.println("Decoding for " + input + " is : " + DecodingString.decodeString(input));
	}

}
