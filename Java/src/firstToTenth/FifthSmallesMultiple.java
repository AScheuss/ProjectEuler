package firstToTenth;

import main.Util;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * 
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 * 
 * @author Andreas Scheuss
 *
 */
public class FifthSmallesMultiple {

	/**
	 * We are locking for the least common multiple.
	 *
	 * We implemented the method in Util.java, as it will be handy in the future.
	 */
	public static void main(String[] args) {

		int[] array= new int[20];
		for (int i=0;i<20;i++) {
			array[i]=i+1;
		}

		int result = Util.getLCM(array);

		System.out.print(result);
		
	}
}
