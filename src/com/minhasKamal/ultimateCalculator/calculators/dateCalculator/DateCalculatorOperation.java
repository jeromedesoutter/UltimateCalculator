/**
 * Developer: Minhas Kamal (BSSE-0509, IIT, DU)
 * Date: 05-Jan-2014
**/ 

package com.minhasKamal.ultimateCalculator.calculators.dateCalculator;

import java.time.LocalDate;
import java.time.Period;

import com.minhasKamal.ultimateCalculator.notifications.message.Message;




public class DateCalculatorOperation {
	public String Date(int day1, int month1, int year1, int day2, int month2, int year2){	
		String difference = "";
		System.out.println(day1);
		if(day1<0 || month1<0 || year1<0 || day2<0 || month2<0 || year2<0 ||		//wrong input
				day1>31 || month1>12 || year1>1000000 || day2>31 || month2>12 || year2>1000000 ||
				(day1>29 && month1==2) || (day2>29 && month2==2) || (day1>30 && month1==4) || (day2>30 && month2==4) ||
				(day1>30 && month1==6) || (day2>30 && month2==6) ||(day1>30 && month1==9) || (day2>30 && month2==9) ||
				(day1>30 && month1==11) || (day2>30 && month2==11)){		
			new Message("Wrong Input!\n   You may have exceeded the range.", 420);
		}
		else {
		LocalDate d1 = LocalDate.of(year1, month1, day1);
		LocalDate d2 = LocalDate.of(year2, month2, day2);
			
		Period diff = Period.between(d1, d2);

		difference = " " + Math.abs(diff.getYears()) + "Y, " + Math.abs(diff.getMonths()) + "M, " + Math.abs(diff.getDays()) + "D.";
		}
		return difference;
	}
}