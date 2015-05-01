package firstToTenth;

import java.util.*;

import main.Util;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * 
 * Find the sum of all the multiples of 3 or 5 below 1000.
 * 
 * (RMK: This can be computed easily with the formula: sum_{n=1}^{m}{a*q^n}=a*\frac{1-q^n}{1-q}) MINUS the ones that got calculated twice ("or" is not exluding).
 */

public class FirstMultiples {
	
	
	public static void main(String[] args) {
		ArrayList<Integer> multiplesOf3 = Util.getAllMultiples(3, 1000);
		ArrayList<Integer> multiplesOf5 = Util.getAllMultiples(5, 1000);
		ArrayList<Integer> multiplesOf15 = Util.getAllMultiples(15, 1000);//to subtract the ones that got calculated twice...
		
		Integer sumOfAllMultiples = 0;
		for (Integer i: multiplesOf3) {
			sumOfAllMultiples = sumOfAllMultiples + i;
		}
		for (Integer i: multiplesOf5) {
			sumOfAllMultiples = sumOfAllMultiples + i;
		}
		
		Integer getRidOfDoubles=0;
		for (Integer i: multiplesOf15) {
			getRidOfDoubles = getRidOfDoubles + i;
		}
		
		Integer tempResult = sumOfAllMultiples - getRidOfDoubles;
		System.out.println(tempResult);
	}
}
