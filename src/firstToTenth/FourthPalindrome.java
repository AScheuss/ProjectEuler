package firstToTenth;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91  99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * @author Andreas Scheuss
 *
 */

public class FourthPalindrome {

	/**
	 * We calculate all products, check if the product is a palindrome and then get the highest number.
	 */
	public static void main(String[] args) {
		testIsPalindrome();
		
		ArrayList<Integer> allThreeDigitNumbers = new ArrayList<>();
		ArrayList<Integer> allPalindromeNumbers = new ArrayList<>();
		
		for (int i = 100; i<1000;i++) {
			allThreeDigitNumbers.add(i);
		}
		for (Integer firstMultiplicant: allThreeDigitNumbers) {
			for (Integer secondMultiplicant: allThreeDigitNumbers) {
				Integer test = firstMultiplicant*secondMultiplicant;
				if (isPalindrome(test)) {
					allPalindromeNumbers.add(test);
				}
			}
		}
		if (allPalindromeNumbers.size()>0)
			System.out.print(Collections.max(allPalindromeNumbers));
		else 
			System.out.print("Error");
	}


	
	
	public static boolean isPalindrome(Integer number) {
		boolean isPalindrome = true;
		String toCheck = number.toString();
		
		int i=0;
		int length = toCheck.length();
		while (i<length/2+1) {
			if(toCheck.charAt(i)!=toCheck.charAt(length-i-1)) {
				isPalindrome = false;
				break;
			}
			i++;
		}
		return isPalindrome;
	}
	
//	Test for isPalilndrome: 
		private static void testIsPalindrome() {
			assert(!isPalindrome(5078505));
		}

}
