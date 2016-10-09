package visitorvsinterpreter.interpreter;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class InterpreterDemo {
	
	public static void main(String args[]) {
		String tokenString = "- + 10 5 - 8 2";
		Stack<IExpression> stack = new Stack<>();

		String[] tokenList = tokenString.split(" ");
				
		 List<String> list = Arrays.asList(tokenList);
         
         Collections.reverse(list);
  
         tokenList = (String[]) list.toArray();		
		
		for (String s : tokenList) {
			
			if (isOperator(s)) {
				IExpression rightExpression = stack.pop();
				IExpression leftExpression = stack.pop();
				IExpression operator = getOperatorInstance(s, rightExpression,
						leftExpression);
				int result = operator.interpret();
				stack.push(new NumberExpression(result));
			} else {
				IExpression i = new NumberExpression(s);
				stack.push(i);
			}
		}
		System.out.println("Result: "+stack.pop().interpret());
	}

	public static boolean isOperator(String s) {
		if (s.equals("+") || s.equals("-") || s.equals("*"))
			return true;
		else
			return false;
	}

	public static IExpression getOperatorInstance(String s, IExpression left,
			IExpression right) {
		switch (s) {
		case "+":
			return new PlusExpression(left, right);
		case "-":
			return new MinusExpression(left, right);
		case "*":
			return new MultiplyExpression(left, right);
		}
		return null;
	}
}