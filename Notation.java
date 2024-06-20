/**
 * Utility class for handling postfix, infix expressions and evaluating postfix expressions.
 * Provides methods to convert infix to postfix, convert postfix to infix, and evaluate postfix expressions.
 *
 * @author JLi
 */
public class Notation {	
	
	/**
     * Evaluates a postfix expression and returns the result.
     *
     * @param postfixExpr the postfix expression to evaluate
     * @return the result of the postfix expression evaluation
     * @throws InvalidNotationFormatException if the postfix expression format is invalid
     */
	public static Double evaluatePostfixExpression(String postfixExpr) throws
		InvalidNotationFormatException {
		MyStack<Double> stackSolution = new MyStack<Double>(postfixExpr.length());
		double result = 0;

		for (int i = 0; i < postfixExpr.length(); i++) {
			char current = postfixExpr.charAt(i);

			if (current == ' ') {
				continue;
			}

			if (Character.isDigit(current)) {
				try {
					stackSolution.push((double) (current - '0'));
				} catch (StackOverflowException e) {
					e.printStackTrace();
				}
			} else if (isOperator(current)) {
				if (stackSolution.size() < 2) {
					throw new InvalidNotationFormatException("Invalid postfix expression.");
				}
				try {
					double operand2 = stackSolution.pop();
					double operand1 = stackSolution.pop();
					result = performOperation(current, operand1, operand2);
					stackSolution.push(result);
				} catch (StackUnderflowException | StackOverflowException e) {
					e.printStackTrace();
				}
			}
		}
		if (stackSolution.size() != 1) {
			throw new InvalidNotationFormatException("Invalid postfix expression.");
		}
		return result;
	}
	
	/**
     * Converts a postfix expression to infix notation.
     *
     * @param postfix the postfix expression to convert
     * @return the infix notation equivalent of the postfix expression
     * @throws InvalidNotationFormatException if the postfix expression format is invalid
     */
	public static String convertPostfixToInfix(String postfix) throws 
		InvalidNotationFormatException {
		MyStack<String> stackSolution = new MyStack<String>(postfix.length());

		for (int i = 0; i < postfix.length(); i++) {
			char current = postfix.charAt(i);

			if (current == ' ') {
				continue;
			}

			if (Character.isDigit(current)) {
				try {
					stackSolution.push(Character.toString(current));
				} catch (StackOverflowException e) {
					e.printStackTrace();
				}
			} else if (isOperator(current)) {
				if (stackSolution.size() < 2) {
					throw new InvalidNotationFormatException();
				}
				try {
					String operand2 = stackSolution.pop();
					String operand1 = stackSolution.pop();
					String result = "(" + operand1 + current + operand2 + ")";
					stackSolution.push(result);
				} catch (StackUnderflowException | StackOverflowException e) {
					e.printStackTrace();
				}
			}
		}

		if (stackSolution.size() != 1) {
			throw new InvalidNotationFormatException("Invalid postfix expression.");
		}
		return stackSolution.toString();
	}
	
	/**
     * Converts an infix expression to postfix notation.
     *
     * @param infix the infix expression to convert
     * @return the postfix notation equivalent of the infix expression
     * @throws InvalidNotationFormatException if the infix expression format is invalid
     */
	public static String convertInfixToPostfix(String infix) throws 
		InvalidNotationFormatException {
			MyStack<Character> stack = new MyStack<Character>(infix.length());
			MyQueue<Character> postfixSolution = new MyQueue<Character>(infix.length());
			
			for (int i = 0; i < infix.length(); i++) {
				char current = infix.charAt(i);

				if (current == ' ') {
					continue;
				}

				if (Character.isDigit(current)) {
					try {
						postfixSolution.enqueue(current);
					} catch (QueueOverflowException e) {
						e.printStackTrace();
					}
				} else if (current == '(') {
					try {
						stack.push(current);
					} catch (StackOverflowException e) {
						e.printStackTrace();
					}
				} else if (isOperator(current)) {
					try {
						while (!stack.isEmpty() && isOperator(stack.top())
								&& precedence(stack.top()) >= precedence(current)) {
							postfixSolution.enqueue(stack.pop());
						}
						stack.push(current);
					} catch (StackUnderflowException | StackOverflowException | QueueOverflowException e) {
						throw new InvalidNotationFormatException("Error processing operator.");
					}
				} else if (current == ')') {
					try {
						while (!stack.isEmpty() && stack.top() != '(') {
		                    postfixSolution.enqueue(stack.pop());
		                }
		                if (stack.isEmpty() || stack.top() != '(') {
		                    throw new InvalidNotationFormatException("Mismatched parentheses.");
		                }
		                stack.pop();
					} catch (StackUnderflowException | QueueOverflowException e) {
						e.printStackTrace();
					}
				}
			}
			try {
				while (!stack.isEmpty()) {
					postfixSolution.enqueue(stack.pop());
				}
			} catch (StackUnderflowException | QueueOverflowException e) {
				throw new InvalidNotationFormatException("Error finalizing postfix expression.");
			}
		return postfixSolution.toString();
	}
	
	/**
     * Checks if a character is an arithmetic operator (+, -, *, /).
     *
     * @param c the character to check
     * @return true if the character is an operator, false otherwise
     */
	private static boolean isOperator(Character c) {
		return c == '+' || c == '-' || c == '*' || c == '/';
	}
	
	/**
     * Returns the precedence level of an arithmetic operator.
     *
     * @param c the operator character (+, -, *, /)
     * @return the precedence level of the operator
     */
	private static int precedence(char c) {
        switch (c) {
        case '+':
        case '-':
            return 1;
        case '*':
        case '/':
            return 2;
        default:
            return -1;
        }
	}
	
	/**
     * Performs an arithmetic operation on two operands based on the operator.
     *
     * @param operator the arithmetic operator (+, -, *, /)
     * @param operand1 the first operand
     * @param operand2 the second operand
     * @return the result of the arithmetic operation
     * @throws ArithmeticException if division by zero is attempted
     * @throws IllegalArgumentException if an unknown operator is provided
     */
	private static double performOperation(char operator, double operand1, double operand2) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero.");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
}
