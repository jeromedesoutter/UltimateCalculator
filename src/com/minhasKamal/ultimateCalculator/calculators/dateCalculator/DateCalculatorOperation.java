/**
 * Developer: Minhas Kamal (BSSE-0509, IIT, DU)
 * Date: 05-Jan-2014
**/ 

package com.minhasKamal.ultimateCalculator.calculators.dateCalculator;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

import com.minhasKamal.ultimateCalculator.notifications.message.Message;




public class DateCalculatorOperation {
	public String Date(int day1, int month1, int year1, int day2, int month2, int year2){	
		String difference = "";
		System.out.println(day1);
		
		try {
		LocalDate d1 = LocalDate.of(year1, month1, day1);
		LocalDate d2 = LocalDate.of(year2, month2, day2);
			
		Period diff = Period.between(d1, d2);

		difference = " " + Math.abs(diff.getYears()) + "Y, " + Math.abs(diff.getMonths()) + "M, " + Math.abs(diff.getDays()) + "D.";
		}catch(DateTimeException e) {
			new Message("Wrong Input!\n   You may have exceeded the range.", 420);
		}
		return difference;
	}
}