/**
 * Developer: Minhas Kamal(BSSE-0509, IIT, DU)
 * Date: Jul-2014
**/

package com.minhasKamal.ultimateCalculator.calculators.advancedCalculator;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.minhasKamal.ultimateCalculator.notifications.message.Message;


public class AdvancedCalculatorOperationsExecutor {

	private ArrayList<Element> splitOperation(String operation){
		Predicate<String> isOperator = s->List.of("+","-","x","/","^","sqrt","(",")","P","C","mod","log","ln","fact","sin",
				"sinh","asin","cbrt","cos","cosh","acos","cube","tan","tanh","atan","sqre").contains(s);
		ArrayList<Element> elements = Arrays.stream(operation.split(" "))
				.map(s->new Element(s,isOperator.test(s)))
				.collect(Collectors.toCollection(ArrayList::new));
		return elements;
	}
	public String infixEvaluation(String string) {

		AdvancedCalculatorOperation aCOperation = new AdvancedCalculatorOperation();

		String result = "";    //the main result

		try {                //may occur math error

			//initializing attributes of the element
			ArrayList<Element> elements = splitOperation(string);
			elements.add(new Element(")", true));

			//Stack
			Stack<String> operand = new Stack<>();    //postfix form of the input
			Stack<String> operator = new Stack<>();    //temporarily stores operators

			operator.push("(");    //indicates the end

			/**
			 * Starts
			 **/
			int index =0;
			while (!operator.empty()){
				// if operand
				if(elements.get(index).isOperator()){
					operand.push(elements.get(index).getString());
				}
				// if operator
				else
				{
					if (elements.get(index).getString().equals("(")) { // begin sub operation
						operator.push("(");
					}
					else if (elements.get(index).getString().equals(")")) { // end sub operation
						BackpropagateOperation(aCOperation, operand, operator, -1);
						operator.pop();   //pops the "("
					}
					else { // classical operation
						BackpropagateOperation(aCOperation, operand, operator, operatorPrecedence(elements.get(index).getString()));
						operator.push(elements.get(index).getString());
					}
				}
				if (index > elements.size()) {
					new Message("Math error!", 420);
					break;
				}
				index++;
			}
			result = operand.pop();

			if (!operator.isEmpty() || !operand.isEmpty()) {
				result = "";
				new Message("Wrong input!", 420);
			}
		} catch (Exception e) {
			new Message("Math Error!\n   Invalid input!", 420);
		}

		return result;
	}

	private void BackpropagateOperation(AdvancedCalculatorOperation aCOperation, Stack<String> operand, Stack<String> operator, int precedence) throws EmptyStackException
	{
		while (!operator.lastElement().equals("(")) {
			int stackPrecedence = operatorPrecedence(operator.lastElement());

			if (stackPrecedence > precedence || precedence == -1) { // Has priority
				if (List.of("+", "-", "x", "/", "P", "C", "^", "mod").contains(operator.lastElement())) {
					String b = operand.pop();   //taking first two elements of the stack
					String a = operand.pop();

					String oprt = operator.pop();   //taking the top the operator of stack

					String r = aCOperation.operation(a, b, oprt);  //result after the operation of a & b
					operand.push(r);   //pushing the result in the operand stack
				} else {
					String a = operand.pop();   //taking first element of the stack

					String oprt = operator.pop();   //taking the top the operator of stack

					String r = aCOperation.operation(a, oprt);  //result after the operation of a
					operand.push(r);   //pushing the result in the operand stack
				}
			}else{
				break;
			}
		}
	}


	//returns specific number of a char in a string
	private int charNumber(String string, char ch){
		int num=0;
		int length=string.length();

		for(int i=0; i<length; i++){
			if(string.charAt(i)==ch) num++;
		}
		
		return num;
	}
	
	//returns number depending on the operators
	private int operatorPrecedence(String str){
		int i= List.of("+","-","x","/","mod","^","!","P","C").indexOf(str)+1;
		return (i==0?9:(i==9?8:i));
	}
	

}
