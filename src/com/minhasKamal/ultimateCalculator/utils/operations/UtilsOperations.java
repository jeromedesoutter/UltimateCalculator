package com.minhasKamal.ultimateCalculator.utils.operations;

import com.minhasKamal.ultimateCalculator.notifications.message.Message;

public class UtilsOperations {

	public static Double sum(Double a, Double b)  {
		return (a + b);
	}

	public static Double substract(Double a, Double b)  {
		return (a - b);
	}

	public static Double multiply(Double a, Double b)  {
		return (a * b);
	}

	public static Double divide(Double a, Double b)  {
		Double r = null;
		if (b != 0) {
			r = (a / b);
		} else {
			new Message("Cannot divide by Zero!", 420);
		}
		return r;
	}

	public static Double power(Double a, Double b)  {
		return Math.pow(a, b);
	}

	public static Double sqrt(Double a)  {
		Double r = null;
		if (a >= 0) {
			r = Math.sqrt(a);
		} else {
			new Message("There is no square-root of \nnegative number!", 420);
		}
		return r;
	}
	
	
	// End of Simple operational methods #______S______#

	/**
	 * complex operational methods #******C******#
	 **/

	public static Double nPr(Double a, Double b)  {
		Double r = null;
		if (a < 0 || b < 0 || a < b) {
			new Message("In valid input. \nhere- a<0 || b<0 || a<b", 420);
		} else {
			r = divide(factorial(a), factorial(substract(a, b)));
		}
		return r;
	}

	public static Double nCr(Double a, Double b)  {
		Double r = null;
		if (a < 0 || b < 0 || a < b) {
			new Message("In valid input. \nhere- a<0 || b<0 || a<b", 420);
		} else {
			r = divide(factorial(a), multiply((factorial(substract(a, b))), factorial(b)));
		}
		return r;
	}

	public static Double modulus(Double a, Double b)  {
		return (a % b);
	}

	public static Double sqre(Double a)  {
		return a * a;
	}

	public static Double cube(Double a)  {
		return a * a * a;
	}

	public static Double cbrt(Double a)  {
		return Math.cbrt(a);
	}

	public static Double factorial(Double a)  {
		long i = 1;
		for (long j = 1; j <= a; j++) {
			i *= j;
		}
		return (double) i;
	}

	// *************
	public static Double sine(Double a)  {		
		return Math.sin((a * Math.PI) / 180);
	}

	public static Double asine(Double a)  {		
		return (Math.asin(a) * 180) / Math.PI;
	}

	public static Double cosine(Double a)  {		
		return Math.cos((a * Math.PI) / 180);
	}

	public static Double acosine(Double a)  {	
		return (Math.acos(a) * 180) / Math.PI;
	}

	public static Double tangent(Double a)  {
		return Math.tan((a * Math.PI) / 180);
	}

	public static Double atangent(Double a)  {	
		return (Math.atan(a) * 180) / Math.PI;
	}

	public static Double sineH(Double a)  {
		return Math.sinh((a * Math.PI) / 180);
	}

	public static Double cosineH(Double a)  {	
		return Math.cosh((a * Math.PI) / 180);
	}

	public static Double tangentH(Double a)  {
		return Math.tanh((a * Math.PI) / 180);
	}

	// ***
	public static Double logarithm10(Double a)  {	
		return Math.log10(a);
	}

	public static Double logarithmE(Double a)  {
		return Math.log(a);
	}	
}
