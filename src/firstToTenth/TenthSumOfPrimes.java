package firstToTenth;

import java.util.ArrayList;

import main.Util;
/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * 
 * Find the sum of all the primes below two million.
 * 
 * 
 * RMK: You calculate the primes correctly, but the sum is too large (over 2^32) and won't fit in an unsigned 32-bit long. You can use a 64-bit number (long long on some compilers) to fix this.
 * 
 * @author Andreas Scheuss
 *
 */
public class TenthSumOfPrimes {

	/**
	 * We calculate the primes and add them up. Be careful of the overflow for int!
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> primes = Util.getAllPrimes(2000000);
		long result =0;
		for (int i: primes) {
			result = result + i;
		}
		System.out.println(result);
	}

}
