package firstToTenth;

import java.util.*;

import main.Util;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * 
 * Find the sum of all the multiples of 3 or 5 below 1000.
 * 
 */

public class FirstMultiples {

	/**
	 * We follow the remark and calculate those.
	 */
	public static void main(String[] args) {
		// There is  the Gaussian formula, which computes the sum of the multiples

		assert getPE1(10) == 23: "Method wrong!";;

		long time = System.currentTimeMillis();
		long pe1 = getPE1(1000);
		time = System.currentTimeMillis() - time;
		System.out.println(pe1);
		System.out.println("Time needed: " + time + "ms");


		// One could apply some algorithm:
		assert getPE1_2(10) == 23: "Method wrong!";;

		time = System.currentTimeMillis();
		Integer pe1_2 = getPE1_2(1000);
		time = System.currentTimeMillis() - time;
		System.out.println(pe1_2);
		System.out.println("Time needed: " + time + "ms");
	}



	private static long getPE1(int upperBound) {
		return getSumOfMultiples(3, upperBound) + getSumOfMultiples(5, upperBound) - getSumOfMultiples(15, upperBound);
	}

	private static long getSumOfMultiples(int multiple, int upperBound) {
		int m = (upperBound-1)/multiple; // we add all the multiples strictly below the second parameter
		return multiple*(m*(m+1))/2;
	}



	private static Integer getPE1_2(int upperBound) {
		ArrayList<Integer> multiplesOf3 = Util.getAllMultiples(3, upperBound);
		ArrayList<Integer> multiplesOf5 = Util.getAllMultiples(5, upperBound);
		ArrayList<Integer> multiplesOf15 = Util.getAllMultiples(15, upperBound);//to subtract the ones that got calculated twice...

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

		return sumOfAllMultiples - getRidOfDoubles;
	}

}
