package codejam2017;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class IncreasingNum {
	
	public String findMax(String in) {
		
		String ret = "";
		boolean conv = false;
		for (int i = 0; i < in.length() - 1; i++) {
			int cc = Integer.valueOf(in.charAt(i) - '0');
			int cn = Integer.valueOf(in.charAt(i + 1) - '0');
			
			if (cc >= cn) {
				// we caught a non-decreasing ordering here
				if (cc > 1)
					ret += cc - 1;
				for (int j = i+1; j < in.length(); j++) {
					ret += "9";
				}
				conv = true;
				break;
			} else {
				ret += cc;
			}
		}
		
		if (!conv) {
			ret += in.charAt(in.length() - 1);
		}
		return ret;
	}
	
	
	public void solveProblem(String inputFile) {
		FileReader fr;
		try {
			fr = new FileReader(inputFile);
			Scanner in = new Scanner(new BufferedReader(fr));
			int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
			for (int i = 1; i <= t; ++i) {
				String s = in.next();
				String sr = this.findMax(s);
				System.out.println("Case #" + i + ": " +  sr);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}


}
