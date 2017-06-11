package codejam2017;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;

public class PanCakeFlip {
	
	private String flipFromIndex(String in, int index, int k) {
		String ret = "";
		for (int i = 0; i < in.length(); i++) {
			if (i < index || i >= index + k) {
				ret = ret + in.charAt(i);
			} else {
				// flip
				if (in.charAt(i) == '+') {
					ret = ret + '-';
				} else {
					ret += '+';
				}
			}
		}
		return ret;
	}
	
	private String flipFirstBase(String in, int k, HashSet<String> visited) {
		for (int i = 0; i < in.length() - k + 1; i++) {
			if (in.charAt(i) == '-') {
				String pr = this.flipFromIndex(in, i, k);
				if (visited.contains(pr)) {
					continue;
				} else {
					return pr;
				}
			}
		}
		return null;
	}
	
	private boolean isConvered(String in) {
		for (int i = 0; i < in.length(); i ++) {
			if (in.charAt(i) == '-') {
				return false;
			}
		}
		return true;
	}
	
	public int findMinFlips(String in, int k) {
		HashSet<String> visited = new HashSet<>();
		int flips = 0;
		while (true) {
			String sr = this.flipFirstBase(in, k, visited);
			if (sr == null) {
				if (this.isConvered(in)) {
					return flips;
				} else {
					return -1;
				}
			} else {
				in = sr;
				visited.add(sr);
				flips++;
			}
		}
	}
	
	
	public void solveProblem(String inputFile) {
		FileReader fr;
		try {
			fr = new FileReader(inputFile);
			Scanner in = new Scanner(new BufferedReader(fr));
			int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
//			System.out.println("test case size is: " + t);
			for (int i = 1; i <= t; ++i) {
				String s = in.next();
				int k = in.nextInt();
				int fl = this.findMinFlips(s, k);
				String oo = fl >= 0 ? String.valueOf(fl) : "IMPOSSIBLE"; 
				System.out.println("Case #" + i + ": " +  oo);
//				System.out.println("input is :" +  s + " with k :" + k);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	

}
