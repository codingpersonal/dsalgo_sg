package amazon_pretest;

import java.util.Stack;

public class Question1 {
	 // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public int totalScore(String[] blocks, int n)
    {
        Stack<Integer> lastScores = new Stack<>();
        for (int i = 0; i < blocks.length; i++) {
            String currBlock = blocks[i];
            System.out.println("hello");
            if (currBlock.equals("+")) {
            	if (lastScores.isEmpty()) {
            		lastScores.push(0);
            	} else {
            		Integer num1 = lastScores.pop();
            		
            		if (lastScores.isEmpty()) {
            			lastScores.push(num1);
            			lastScores.push(num1);
            		} else {
            			Integer num2 = lastScores.peek();
            			lastScores.push(num1);
            			lastScores.push(num1 + num2);
            		}
            	}

            } else if (currBlock.equals("X")) {
            	if (lastScores.isEmpty()) {
            		lastScores.push(0);
            	} else {
            		Integer le = lastScores.peek();
            		lastScores.push(2*le);
            	}
            	
            } else if (currBlock.equals("Z")) {
            	if (!lastScores.isEmpty()) {
            		lastScores.pop();
            	}
 
            } else {
            	Integer num = Integer.valueOf(currBlock);
            	lastScores.push(num);
            }
        }
        
        int sum = 0;
        for (Integer itr:lastScores) {
        	sum += itr;
        }
        return sum;
    }
}
