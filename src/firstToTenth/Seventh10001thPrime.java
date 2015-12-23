package firstToTenth;

import main.Util;

public class Seventh10001thPrime {

	/**
	 * We have to find the 10001st prime.
	 */
	public static void main(String[] args) {
		
		int primeIterator = 0;
		int i= 0;
		while (primeIterator <=10000) {
			if (Util.isPrime(i)) {
				primeIterator++;
			}
			i++;

		}
		int result = i-1;
		
		System.out.println(result);
	}

}
