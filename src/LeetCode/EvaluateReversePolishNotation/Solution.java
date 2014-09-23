package LeetCode.EvaluateReversePolishNotation;

import java.util.Stack;

public class Solution {
	 public int evalRPN(String[] tokens) {
		 //["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
		  //["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
	        if(tokens == null || tokens.length < 3) return 0;
	        Stack<Integer> t_stack = new Stack<Integer>(); 
	        for(int i=0; i< tokens.length; i++)
	        {
	            String elem = tokens[i];
	            if(!isOperator(elem))
	            {
	                 t_stack.push(stringToInt(elem));
	            }
	            else
	            {
	                int operand2 = t_stack.pop();
	                int operand1 = t_stack.pop();
	                t_stack.push(evaluate(elem, operand1, operand2));
	            }
	        }
	        return t_stack.pop();
	    }
	    
	    public boolean isOperator(String elem)
	    {
	        return elem.equals("+") || elem.equals("-") ||elem.equals("*") ||elem.equals("/");
	    }
	    
	    
	    public int evaluate(String operator, int operand1, int operand2)
	    {
	    	if(operator.equals("+")) return operand1 + operand2;
	    	if(operator.equals("-")) return operand1 - operand2;
	    	if(operator.equals("*")) return operand1 * operand2;
	    	if(operator.equals("/")) return operand1 / operand2;
	        return 0;
	    }
	    
	    public int stringToInt(String val)
	    {
	        return Integer.parseInt(val);
	    }
}
