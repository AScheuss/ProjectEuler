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

	public static void main(String[] args) {
		int result = 0;
		test();
		test2();
		
		int[] array= new int[20];
		for (int i=0;i<20;i++) {
			array[i]=i+1;
		}
		
		result = Util.getLCM(array);
		System.out.print(result);
		
	}



	private static void test() {
		assert Util.getGCD(8,6) == 2;
		assert Util.getLCM(8, 6) == 24;
	}

	private static void test2() {
	    int[] data = {8,6,4,2};
		assert Util.getGCD(data) == 2;
		assert Util.getLCM(data) == 24;
	}
	
}
