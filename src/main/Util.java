package main;

import java.util.ArrayList;

public final class Util {

	public static int multiplicateArray(ArrayList<Integer> array) {
		int result = 1;
		for (int i=0; i<array.size();i++) {
			result *=  array.get(i);
		}
		return result;
	}

	/**
	 * This method uses the algorithm "Reduction by the greatest common divisor" to compute the LCD of two integers. 
	 * This approach uses the GCD. It divides the absolute value of the product of the two integers by the GCD.
	 * 
	 * @param intOne
	 * @param intTwo
	 * @return The LCD of intOne and intTwo.
	 */
	public static Integer getLCM(int intOne, int intTwo) {
		int gcd = Util.getGCD(intOne, intTwo);
		if (gcd!=0) {
			return intOne * (intTwo / gcd);
		}
		else 
			return 0;
		
	}

	public static Integer getLCM(int[] numbers) {
		int result = numbers[0];
	    for(int i = 1; i < numbers.length; i++) {
	    	result = getLCM(result, numbers[i]);
	    }
	    return result;
	}

	public static Integer getGCD(int[] numbers) {
		int result = numbers[0];
	    for(int i = 1; i < numbers.length; i++) {
	    	result = Util.getGCD(result, numbers[i]);
	    }
	    return result;
	}

	/**
	 * this method uses the euclidean algorithm to compute the gcd of two integers.
	 * 
	 * @param intOne
	 * @param intTwo
	 * @return the gcd of the intOne and intTwo
	 */
	public static Integer getGCD(int intOne, int intTwo) {
		while (intTwo > 0)
	    {
	        int temp = intTwo;
	        intTwo = intOne % intTwo; // % is remainder
	        intOne = temp;
	    }
	    return intOne;
	}

	/**
	 * This returns all the multiples of the baseNumber until the maxNumber.
	 */
	public static ArrayList<Integer> getAllMultiples(Integer baseNumber, Integer maxNumber) {
		ArrayList<Integer> multiples= new ArrayList<Integer>();
		Integer multiple=0;
		Integer i=0;
		while (multiple <maxNumber-(baseNumber-1)) {//minus the baseNumber because we will go trough the while-loop afterwards
			multiple = baseNumber*++i;
			multiples.add(multiple);
		}
		return multiples;
	}

	public static ArrayList<Integer> getFibonaccis(int upperBound) {
		ArrayList<Integer> fibonaccis= new ArrayList<Integer>();
		Integer i0 = 1;
		Integer i1 = 1;
		fibonaccis.add(i0);
		fibonaccis.add(i1);
		
		int i2 = 0;
		do {
			i2 = i1 + i0;
			fibonaccis.add(i2);
			
			i0 = i1;
			i1 = i2;
		}
		while (i1+i0<=upperBound);
		 
		return fibonaccis;
	}

// ------------------------------------- prime factors -----------------------
	
	/**
	 * Remember 1 is not a prime...
	 */
	public static ArrayList<Integer> getAllPrimeFactors(long number) {
		ArrayList<Integer> primes;
		primes = Util.getAllPrimes((int) Math.round(Math.sqrt(number)) + 1);
		
		ArrayList<Integer> allPrimeFactors = new ArrayList<>();
		for (Integer primeFactor: primes) {
			if (number%primeFactor == 0) {
				allPrimeFactors.add(primeFactor);
				number = number/primeFactor;
			}
		}
		return allPrimeFactors;
	}
	
	
	// -------------------------------------- dealing with primes -------------------------
	public static boolean isPrime(int number) {
		boolean isPrime = true;
		if (number ==1 || number ==0){
			isPrime = false;
		}
		for (int l=2;l<=Math.sqrt(number)+1;l++) {
			if (number%l == 0 && number!=2) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}

	public static ArrayList<Integer> getAllPrimes(int number) {
			ArrayList<Integer> primes = new ArrayList<Integer>();
			if (number==1)
				System.out.print("ERROR: 1 ist keine Primzahl");
			else if (number==0)
				System.out.print("ERROR: 0 ist keine Primzahl");
			else {
				int j=2;
				while (j<=number) {
					if(isPrime(j)) {
						primes.add(j);
					}
					j++;
				}
			}
			return primes;
	}

	/**
	 * Returns all the factor of number - including 1 and number itself.
	 * 
	 * Example: 8 -> 1, 2, 4, 8.
	 */
	public static ArrayList<Integer> getAllFactors(int number) {

		ArrayList<Integer> factors = new ArrayList<Integer>();	
		factors.add(1);
		
		int tempNumber;
		tempNumber = number;
		for (int l=2;l<=number/2;l++) {
			if (tempNumber%l == 0 ) {
				factors.add(l);
			}
		}
		factors.add(number);
		return factors;
	}

	
	public static double lb(double n) {
		return Math.log1p(n)/Math.log1p(2);
	}


	public static int countDivisors(int m) {
		int divisorCount = 1;
		int p=2;
		int tempDivisorCount = 0;
		while(0 == m % p) {
			tempDivisorCount++;
			m=m / p;
		}
		divisorCount*=(tempDivisorCount+1);
		p=3;
		while(m!=1) {
			tempDivisorCount = 0;
			while(0 == m % p) {
				tempDivisorCount++;
				m=m / p;
			}
			divisorCount*=(tempDivisorCount+1);
			p+=2;
		}
		return divisorCount;
	}
}
