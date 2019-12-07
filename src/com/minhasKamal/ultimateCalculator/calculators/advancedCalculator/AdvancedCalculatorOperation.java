/**
 * Developers: Minhas Kamal(BSSE-0509)
 * Date: Dec-2013
 * Date: Jan-2014
 * Date: 01-Jan-2015
**/

package com.minhasKamal.ultimateCalculator.calculators.advancedCalculator;

import java.util.function.BiFunction;
import java.util.function.Function;

import com.minhasKamal.ultimateCalculator.notifications.message.Message;
import com.minhasKamal.ultimateCalculator.utils.operations.UtilsOperations;


public class AdvancedCalculatorOperation {
	
	// constructor
		public AdvancedCalculatorOperation() {
			super();
		}

		/**
		 * Interfacing method #****IM****#
		 **/

		// Interfacing method
		public String operation(String operand1, String operand2, String operator) {

			try {
				double a = Double.parseDouble(operand1);
				double b = Double.parseDouble(operand2);

				BiFunction<Double, Double, Double> func = simpleParseOperator(operator);
				Double result = func.apply(a, b);
				return (result == null ? "": result.toString());

			} catch (NumberFormatException e) {
				new Message("Math Error! \nOr, invalid input! \nPlease input correctly.", 420);

				return "";
			}
		}

		public BiFunction<Double, Double, Double> simpleParseOperator(String operator) {
			if (operator.equals("+"))
				return UtilsOperations::sum;
			else if (operator.equals("-"))
				return UtilsOperations::substract;
			else if (operator.equals("x") || operator.equals("*"))
				return UtilsOperations::multiply;
			else if (operator.equals("/")) {
				return UtilsOperations::divide;
			} else if (operator.equals("^"))
				return UtilsOperations::power;
			
			else if(operator.equals("C")) 
				return UtilsOperations::nCr	;
			else if(operator.equals("P")) 
				return UtilsOperations::nPr;
			else if(operator.equals("mod")) 
				return UtilsOperations::modulus;
			
			else {
				return (a,b)->null;
			}
		}

		
		public String operation(String operand, String operator) {

			try {
				double a = Double.parseDouble(operand);

				Function<Double, Double> func = complexeParseOperator(operator);
				Double result = func.apply(a);
				return (result == null ? "": result.toString());

			} catch (NumberFormatException e) {
				new Message("Math Error! \nOr, invalid input! \nPlease input correctly.", 420);

				return "";
			}
		}

		public Function<Double, Double> complexeParseOperator(String operator) {
			if (operator.equals("sqrt"))
				return UtilsOperations::sqrt;
			else if (operator.equals("cbrt"))
				return UtilsOperations::cbrt;
			else if (operator.equals("fact"))
				return UtilsOperations::factorial;
			else if (operator.equals("sqre"))
				return UtilsOperations::sqre;
			else if (operator.equals("cube"))
				return UtilsOperations::cube;
			else if (operator.equals("sin"))
				return UtilsOperations::sine;
			else if (operator.equals("asin"))
				return UtilsOperations::asine;
			else if (operator.equals("sinh"))
				return UtilsOperations::sineH;
			else if (operator.equals("cos"))
				return UtilsOperations::cosine;
			else if (operator.equals("acos"))
				return UtilsOperations::acosine;
			else if (operator.equals("cosh"))
				return UtilsOperations::cosineH;
			else if (operator.equals("tan"))
				return UtilsOperations::tangent;
			else if (operator.equals("atan"))
				return UtilsOperations::atangent;
			else if (operator.equals("tanh"))
				return UtilsOperations::tangentH;
			else if (operator.equals("log"))
				return UtilsOperations::logarithm10;
			else if (operator.equals("ln"))
				return UtilsOperations::logarithmE;
			else
				return a->null;
		}
}



