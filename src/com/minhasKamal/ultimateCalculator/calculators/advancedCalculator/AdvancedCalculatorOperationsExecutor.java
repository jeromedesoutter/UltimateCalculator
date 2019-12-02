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
	
	/*
	public String infixEvaluation_init(String string) {
		//necessary object
		System.out.println(string);
		AdvancedCalculatorOperation aCOperation = new AdvancedCalculatorOperation();

		String result = "";    //the main result

		//Finding number of spaces in a string
		int numberOfElements = charNumber(string, ' ');

		try {                //may occur math error

			//initializing attributes of the element
			Element[] element = new Element[numberOfElements + 1];    //element array
			int charFrom = 0, charTo = 0;
			for (int i = 0; i < numberOfElements; i++) {
				String s = "";     //string property
				boolean o = false;      //operator-true, operand-false

				//cutting sub strings
				int j = charFrom;
				while (string.charAt(j) != ' ') {
					j++;
				}
				charTo = j;
				s = string.substring(charFrom, charTo);
				charFrom = charTo + 1;


				if (s.equals("+") || s.equals("-") || s.equals("x") || s.equals("/") || s.equals("^") ||    //when an operator is found
						s.equals("sqrt") || s.equals("(") || s.equals(")") || s.equals("P") || s.equals("C") || s.equals("mod") ||
						s.equals("log") || s.equals("ln") || s.equals("fact") || s.equals("sin") || s.equals("sinh") ||
						s.equals("asin") || s.equals("cbrt") || s.equals("cos") || s.equals("cosh") || s.equals("acos") ||
						s.equals("cube") || s.equals("tan") || s.equals("tanh") || s.equals("atan") || s.equals("sqre")) {

					o = true;
				} else {        //when operand
					o = false;
				}

				element[i] = new Element(s, o);
			}



			element[numberOfElements] = new Element(")", true);

			//Stack 
			Stack<String> operand = new Stack<>();    //postfix form of the input
			Stack<String> operator = new Stack<>();    //temporarily stores operators

			operator.push("(");    //indicates the end

			for (int i = 0; !operator.empty(); i++) { //evaluation
				if (!element[i].isOperator()) {    //when operand is found
					operand.push(element[i].getString());
				} else {
					if (element[i].getString().equals("(")) {
						operator.push("(");
					} else if (element[i].getString().equals(")")) {
						while (operator.lastElement() != "(") {
							if (operator.lastElement().equals("+") || operator.lastElement().equals("-") ||
									operator.lastElement().equals("x") || operator.lastElement().equals("/") ||
									operator.lastElement().equals("P") || operator.lastElement().equals("C") ||
									operator.lastElement().equals("^") || operator.lastElement().equals("mod")) {
								String b = (String) operand.pop();   //taking first two elements of the stack
								String a = (String) operand.pop();

								String oprt = operator.pop();   //taking the top the operator of stack

								String r = aCOperation.operation(a, b, oprt);  //result after the operation of a & b
								operand.push(r);   //pushing the result in the operand stack
							} else {
								String a = (String) operand.pop();   //taking first element of the stack

								String oprt = operator.pop();   //taking the top the operator of stack

								String r = aCOperation.operation(a, oprt);  //result after the operation of a
								operand.push(r);   //pushing the result in the operand stack
							}
						}
						operator.pop();   //pops the "("
					} else {
						int opertPrecedence = operatorPrecedence(element[i].getString());

						while (operator.lastElement() != "(") {
							int stackPrecedence = operatorPrecedence(operator.lastElement());

							if (stackPrecedence <= opertPrecedence) {
								break;
							} else {
								if (operator.lastElement().equals("+") || operator.lastElement().equals("-") ||
										operator.lastElement().equals("x") || operator.lastElement().equals("/") ||
										operator.lastElement().equals("P") || operator.lastElement().equals("C") ||
										operator.lastElement().equals("^") || operator.lastElement().equals("mod")) {
									String b = (String) operand.pop();   //taking first two elements of the stack
									String a = (String) operand.pop();

									String oprt = operator.pop();   //taking the top the operator of stack

									String r = aCOperation.operation(a, b, oprt);  //result after the operation of a & b
									operand.push(r);   //pushing the result in the operand stack
								} else {
									String a = (String) operand.pop();   //taking first element of the stack

									String oprt = operator.pop();   //taking the top the operator of stack

									String r = aCOperation.operation(a, oprt);  //result after the operation of a
									operand.push(r);   //pushing the result in the operand stack
								}
							}
						}
						operator.push(element[i].getString());
					}
				}

				if (i > element.length) {
					new Message("Math error!", 420);
					break;
				}
			}
			//Ends

			result = (String) operand.pop();

			if (!operator.isEmpty() || !operand.isEmpty()) {
				result = "";
				new Message("Wrong input!", 420);
			}
		} catch (Exception e) {
			new Message("Math Error!\n   Invalid input!", 420);
		}

		return result;
	}
*/

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
	
	
	/*///test main method
	public static void main(String[] args) {
		System.out.println(new AdvancedCalculatorOperationsExecutor().infixEvaluation("1.099 + 223 - 12 x 2 "));
	}
	/**/
}
