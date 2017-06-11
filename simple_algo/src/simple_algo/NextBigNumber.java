package simple_algo;

import java.util.Arrays;

/*
 * http://www.geeksforgeeks.org/find-next-greater-number-set-digits/
 * 
 * Input: n = "534976"
 * Output: "536479"
 * 
 */
public class NextBigNumber {
	
	private String findJustNext(String in) {
		if (in.length() < 2) {
			return in;
		}
		char base_num = in.charAt(0);
		char just_bigger_char = 0;
		
		// sort the string
		char [] chars = in.toCharArray();
		Arrays.sort(chars);
		String ret = "";
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] > base_num && (int) just_bigger_char == 0)  {
				just_bigger_char = chars[i];
			} else {
				ret += chars[i];
			}
		}
		return just_bigger_char + ret;
	}
	
	public String findNextBig(String input) {
		if (input.length() < 2) {
			return "not possible";
		}
		
		int c = Integer.valueOf(input.charAt(input.length() - 1) - '0');
		for (int i = input.length() - 2; i >= 0; i--) {
			int nc = Integer.valueOf(input.charAt(i) - '0');
			if (nc < c) {
				// found a non-decreasing character
				// now find the next sequence from this index till end
				String jb = this.findJustNext(input.substring(i));
				return input.substring(0, i) + jb;
			}
		}
		return "not possible";
	}
}
