/**
 * Developers: Minhas Kamal(BSSE-0509) 
 * Date: Dec-2013
 * Date: 13-Jan-2014
**/

package com.minhasKamal.ultimateCalculator.calculators.baseCalculator;

import com.minhasKamal.ultimateCalculator.notifications.message.Message;


public class BaseCalculatorOperation {

	@FunctionalInterface
	private interface BaseOperation {
		String makeOperation(String a,String b, int base);
	}

	public enum Base{
		BINARY(2),
		DECIMAL(10),
		OCTAL(8),
		HEXADECIMAL(16);

		public int value;
		Base(int value){this.value = value;}
	}

	public String operation(Base base, String operand1, String operand2, String operator)
	{
		return operation(base.value, operand1, operand2, operator);
	}
	public String operation(int base, String operand1, String operand2, String operator)
	{
		String result="";
		
		if(!operand1.equals("") && !operator.equals("")){	//general case
			result = parseOperator(operator).makeOperation(operand1,operand2,base);
		}
		else result = operand2;

		return result;
	}

	private BaseOperation parseOperator(String operator)
	{
		switch (operator) {
			case "+":
				return (a, b, base) -> convertfromDec(base, convertToDec(base, a) + convertToDec(base, b));
			case "-":
				return (a, b, base) -> convertfromDec(base, convertToDec(base, a) - convertToDec(base, b));
			case "x":
			case "*":
				return (a, b, base) -> convertfromDec(base, convertToDec(base, a) * convertToDec(base, b));
			case "/":
				return (a, b, base) -> (convertToDec(base, b) != 0 ? convertfromDec(base, convertToDec(base, a) / convertToDec(base, b)) : "");
			default:
				return (a, b, base) -> "";
		}
	}


	//base conversions
	String conversion(int init_base,int dest_base,String operand){
		return convertfromDec(dest_base,convertToDec(init_base,operand));
	}
	private String convertfromDec(int dest_base, Long operand) {
		long result_base10 = operand;

		StringBuilder result = new StringBuilder();

		while (result_base10 != 0) {
			result.insert(0, intToChar((int) (result_base10 % dest_base)));
			result_base10 = result_base10 / dest_base;
		}

		return result.toString();
	}
	private Long convertToDec(int init_base, String operand) {
		if(operand.length()>(int)(64/(Math.log(init_base)/Math.log(2)))-1) { // Check variable overflow
			new Message("Cannot convert!", 420);
			return -1L;
		}

		long result_base10 = 0;
		for(int i=0; i<operand.length(); i++){
			int pos = operand.length()-i-1;
			result_base10 = result_base10 + (charToInt(operand.charAt(pos)) * (long)Math.pow(init_base, i));
		}
		return result_base10;
	}

	private int charToInt(char c) {
		return c-("ABCDEF".contains(String.valueOf(c)) ? 55:48);
	}
	private char intToChar(int i){
		return (char)(i+(i>=10 && i<=15 ? 55:48));
	}
}