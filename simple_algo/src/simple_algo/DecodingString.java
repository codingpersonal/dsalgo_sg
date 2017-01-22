package simple_algo;

import java.util.Stack;

/*
 * Given "3[a2[bd]g4[ef]h]", output should be abdbdgefefefefhabdbdgefefefefhabdbdgefefefefh
 * 
 */

class charState {
	public int count = 1;
	public String seq = "";
}


public class DecodingString {

	static private boolean is_number(char c) {
		return c >= '0' && c <= '9';
	}
	
	static private String replicateString (String inp, int count) {
		String ret = "";
		while (count > 0) {
			ret+= inp;
			count--;
		}
		return ret;
	}

	static public String decodeString(String input) {
		Stack<charState> currStr = new Stack<>();

		String currNum = "";
		currStr.push(new charState());

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (is_number(c)) {
				currNum += c;
			}

			else if (c == '[') {
				charState cs = new charState();
				cs.count = Integer.parseInt(currNum);
				currStr.push(cs);
				currNum = "";
			}

			else if (c == ']') {
				// replicate the string which is present on the top of stack
				charState top = currStr.pop();
				String repStr = replicateString(top.seq, top.count);
				currStr.peek().seq += repStr;
			}
			
			else {
				// append the char with the string on top of stack
				currStr.peek().seq += c;
				if (currNum != "") {
					System.out.println("invalid string. Numbers shouldn't be followed by character");
					currNum = "";
				}
			}			
			
		}
		
		if (!currStr.isEmpty()) {
			return currStr.peek().seq;
		}
		return "";
	}
	
}
