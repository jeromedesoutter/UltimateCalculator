/****************************************************************************************************************
* Developer: Minhas Kamal(BSSE-0509, IIT, DU)																	*
* Date: Dec-2013																								*
* Date: 11-Jan-2014																								*
****************************************************************************************************************/

package com.minhasKamal.ultimateCalculator.calculators.simpleCalculator;


import java.util.function.BiFunction;

import com.minhasKamal.ultimateCalculator.notifications.message.Message;
import com.minhasKamal.ultimateCalculator.utils.operations.UtilsOperations;

/**
 * Controls operation of simple calculator.
 *
 * @author Minhas Kamal
 */
public class SimpleCalculatorOperation {
	
	public SimpleCalculatorOperation() {

	}
	
	//Interfacing method
    public String operation(String operand1, String operand2, String operator){
        
        try{
            double a=Double.parseDouble(operand1);
            double b=Double.parseDouble(operand2);
            
            BiFunction<Double,Double,Double> func = parseOperator(operator);
            Double result = func.apply(a,b);
            return (result == null ? "" : result.toString());
     
        }catch(NumberFormatException e){
            new Message("Wrong input!", 420);
            
            return "";
        }
    }

    
public BiFunction<Double,Double,Double> parseOperator(String operator){
        if(operator.equals("+")) return UtilsOperations::sum;
                else if(operator.equals("-")) return UtilsOperations::substract;
                else if(operator.equals("x") || operator.equals("*")) return UtilsOperations::multiply;
                else if(operator.equals("/")) return UtilsOperations::divide;
                else if(operator.equals("^")) return  UtilsOperations::power;
                else return (a,b)->null;
}

	//sqrt method
	public String sqrt(String operand1){
		
		double a;
		try {
			a = Double.parseDouble(operand1);
		}catch(NumberFormatException e) {
			new Message("Wrong Input! \nUse result as input!", 420);
			return "";
		}
		Double result = UtilsOperations.sqrt(a);
		return (result == null ? "" : result.toString());
	}
}
