package firstToTenth;

import java.util.ArrayList;
import java.util.Collections;

import main.Util;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * 
 * What is the largest prime factor of the number 600851475143 ?
 * 
 * @author Andreas Scheuss
 *
 */

public class ThirdPrimeFactors {
	public static void main(String[] args) {
		final long number = 600851475143L;
		
		ArrayList<Integer> allPrimeFactors = Util.getAllPrimeFactors(number);
		if (allPrimeFactors.size() >0) {
			System.out.print(Collections.max(allPrimeFactors));
		}
		else {
			System.out.print("The number " + number + " is a prime number.");
		}
	}
	
}
