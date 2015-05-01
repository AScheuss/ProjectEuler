package firstToTenth;

import java.util.ArrayList;

/**
 * The sum of the squares of the first ten natural numbers is, 1^2 + 2^2 + ... + 10^2 = 385
 * 
 * The square of the sum of the first ten natural numbers is, (1 + 2 + ... + 10)^2 = 55^2 = 3025
 * 
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025  385 = 2640.
 * 
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 * 
 * @author Andreas Scheuss
 *
 */
public class SixthSquares {

	public static void main(String[] args) {
		ArrayList<Integer> arrayList = getArray(100);
		
		int squareOfTheSums = 0;
		int sumOfSquares = 0;
		
		for (int integer: arrayList) {
			squareOfTheSums=squareOfTheSums + integer;
		}
		squareOfTheSums = squareOfTheSums*squareOfTheSums;
		System.out.println(squareOfTheSums);
		
		
		for (int integer: arrayList) {
			sumOfSquares=sumOfSquares + integer*integer;
		}
		System.out.println(sumOfSquares);

		int result = squareOfTheSums - sumOfSquares;
		System.out.println(result);
	}
	
	public static ArrayList<Integer> getArray(int upperBound) {
		ArrayList<Integer> array = new ArrayList<>();
		for (int i=0; i<upperBound;i++) {
			array.add(i+1);
		}
		return array;
	}

}
