/**
 * Developer: Minhas Kamal(BSSE-0509, IIT, DU)
 * Date: 31-May-2013
**/

package com.minhasKamal.ultimateCalculator.calculators.primeNumberHunter;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.LongPredicate;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static java.lang.Long.max;

/**
 * My most improved version of haunting prime numbers. As finding prime number is very time consuming,
 * I have tried to make it more time efficient, but at the same time more complex.It finds all prime 
 * number in its domain (3 - 999,999,999,999,999,999).
 *
 * @author Minhas Kamal
 */
public class PrimeNumberHunterOperation {

	public String primeNumberFinder(long start, long finish)
	{
		if(finish < 2 || start > finish) return "No Number Found!";
		if(finish > 100000)	return "Too High number!";
		return String.join(", ",eratosthene(start,finish))+" End.";
	}
	static private LongPredicate isAPrimeNumber = num -> true;
	private List<String> eratosthene(long start, long finish)
	{
		isAPrimeNumber = num -> true;
		return LongStream.iterate(max(start,2), i->i+1)
				.limit(finish)
				.boxed()
				.filter(i -> isAPrimeNumber.test(i))
				.peek(i -> isAPrimeNumber = isAPrimeNumber.and(v -> v % i != 0))
				.map(Object::toString)
				.collect(Collectors.toList());
	}

	//returns specific number of a char in a string
	public int charNumber(String string, char ch){
		int num=0;
		int length=string.length();

		for(int i=0; i<length; i++){
			if(string.charAt(i)==ch) num++;
		}
		
		return num;
	}
}




