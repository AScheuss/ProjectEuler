package main;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class UtilTest {

	private int int1;
	private int int2;
	private int int3;
	private int expected;
	private int actual;
	private ArrayList<Integer> actualList;
	private ArrayList<Integer> expectedList;
	private ArrayList<Integer> arrayList;
	private int[] simpleArray;

	@Before
	public void setUp() {
		arrayList = new ArrayList<>();
		simpleArray = new int[3];
	}

	@Test
	public void testMultiplicateArray() {
		int1 = 55;
		int3 = 86;
		int2 = 48;

		arrayList.add(int1);
		arrayList.add(int2);
		arrayList.add(int3);

		expected = int1 * int2 * int3;
		actual = Util.multiplicateArray(arrayList);
		assertEquals(expected, actual);
	}

	@Test
	public void testGetLCMIntInt() {
		int1 = 8;
		int2 = 2;

		expected = 8;
		actual = Util.getLCM(int1, int2);
		assertEquals(expected, actual);

		int1 = 3;
		int2 = 2;
		expected = 6;
		actual = Util.getLCM(int1, int2);
		assertEquals(expected, actual);

		int1 = 99;
		int2 = 22;
		expected = 198;
		actual = Util.getLCM(int1, int2);
		assertEquals(expected, actual);
	}

	@Test
	public void testGetLCMIntArray() {// TODO
		int1 = 8;
		int2 = 2;
		simpleArray[0] = int1;
		simpleArray[1] = int2;
		simpleArray[2] = int2;

		expected = 8;
		actual = Util.getLCM(simpleArray);
		assertEquals(expected, actual);

		int3 = 4;
		simpleArray[2] = int3;
		expected = 8;
		actual = Util.getLCM(simpleArray);
		assertEquals(expected, actual);
		
		int3 = 3;
		simpleArray[2] = int3;
		expected = 24;
		actual = Util.getLCM(simpleArray);
		assertEquals(expected, actual);
		
		int1 = 6;
		int2 = 5;
		int3 = 4;
		simpleArray[0] = int1;
		simpleArray[1] = int2;
		simpleArray[2] = int3;
		expected = 60;
		actual = Util.getLCM(simpleArray);
		assertEquals(expected, actual);
	}

	@Test
	public void testGetGCDIntInt() {
		int1 = 8;
		int2 = 2;

		expected = 2;
		actual = Util.getGCD(int1, int2);
		assertEquals(expected, actual);

		int1 = 3;
		int2 = 2;
		expected = 1;
		actual = Util.getGCD(int1, int2);
		assertEquals(expected, actual);

		int1 = 99;
		int2 = 22;
		expected = 11;
		actual = Util.getGCD(int1, int2);
		assertEquals(expected, actual);
	}

	@Test
	public void testGetGCDIntArray() {
		int1 = 8;
		int2 = 2;
		simpleArray[0] = int1;
		simpleArray[1] = int2;
		simpleArray[2] = int2;

		expected = 2;
		actual = Util.getGCD(simpleArray);
		assertEquals(expected, actual);

		int3 = 4;
		simpleArray[2] = int3;
		expected = 2;
		actual = Util.getGCD(simpleArray);
		assertEquals(expected, actual);
		
		int3 = 3;
		simpleArray[2] = int3;
		expected = 1;
		actual = Util.getGCD(simpleArray);
		assertEquals(expected, actual);
		
		int1 = 18;
		int2 = 30;
		int3 = 84;
		simpleArray[0] = int1;
		simpleArray[1] = int2;
		simpleArray[2] = int3;
		expected = 6;
		actual = Util.getGCD(simpleArray);
		assertEquals(expected, actual);
	}

	@Test
	public void testGetAllMultiples() {
		int1 = 2;
		int2 = 16;

		arrayList.add(2);
		arrayList.add(4);
		arrayList.add(6);
		arrayList.add(8);
		arrayList.add(10);
		arrayList.add(12);
		arrayList.add(14);
		arrayList.add(16);
		
		expectedList = arrayList;
		actualList = Util.getAllMultiples(int1, int2);
		assertEquals(expectedList, actualList);
		
		int2 = 17;
		assertEquals(expectedList, actualList);
		int2 = 18;
		arrayList.add(18);
		
		expectedList = arrayList;
		actualList = Util.getAllMultiples(int1, int2);
		assertEquals(expectedList, actualList);
	}

	@Test
	public void testGetFibonaccis() {
		int1 = 50;
		
		arrayList.add(1);
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(5);
		arrayList.add(8);
		arrayList.add(13);
		arrayList.add(21);
		arrayList.add(34);
		
		
		expectedList = arrayList;
		actualList = Util.getFibonaccis(int1);
		assertEquals(expectedList, actualList);
	}

	@Test
	public void testGetAllPrimeFactors() {
		int1 = 50;
		
		arrayList.add(2);
		arrayList.add(5);
		
		expectedList = arrayList;
		actualList = Util.getAllPrimeFactors(int1);
		assertEquals(expectedList, actualList);
	}

	@Test
	public void testIsPrime() {
		assertTrue(Util.isPrime(5));
		assertFalse(Util.isPrime(10));
		
		assertTrue(Util.isPrime(113));
		assertFalse(Util.isPrime(111));
		
		assertTrue(Util.isPrime(99971));
		assertFalse(Util.isPrime(9819));
	}

	@Test
	public void testGetAllPrimes() {
		int1 = 50;
		
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(5);
		arrayList.add(7);
		arrayList.add(11);
		arrayList.add(13);
		arrayList.add(17);
		arrayList.add(19);
		arrayList.add(23);
		arrayList.add(29);
		arrayList.add(31);
		arrayList.add(37);
		arrayList.add(41);
		arrayList.add(43);
		arrayList.add(47);
		
		
		expectedList = arrayList;
		actualList = Util.getAllPrimes(int1);
		assertEquals(expectedList, actualList);
	}

	@Test
	public void testGetAllFactors() {
		int1 = 15;

		arrayList.add(1);
		arrayList.add(3);
		arrayList.add(5);
		arrayList.add(15);
		
		expectedList = arrayList;
		actualList = Util.getAllFactors(int1);
		assertEquals(expectedList, actualList);

		
		int1 = 4;

		arrayList.clear();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(4);
		
		expectedList = arrayList;
		actualList = Util.getAllFactors(int1);
		assertEquals(expectedList, actualList);

		
		int1 = 28;

		arrayList.clear();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(4);
		arrayList.add(7);
		arrayList.add(14);
		arrayList.add(28);
		
		expectedList = arrayList;
		actualList = Util.getAllFactors(int1);
		assertEquals(expectedList, actualList);
		
		
		int1 = 35;

		arrayList.clear();
		arrayList.add(1);
		arrayList.add(5);
		arrayList.add(7);
		arrayList.add(35);
		
		expectedList = arrayList;
		actualList = Util.getAllFactors(int1);
		assertEquals(expectedList, actualList);
		
		
		
		//Spielerei...
		actualList = Util.getAllFactors(4);

		assertTrue(actualList.contains(1));
		assertTrue(actualList.contains(2));
		assertTrue(actualList.contains(4));
		actualList.remove(0);
		actualList.remove(0);
		actualList.remove(0);

		assertTrue(actualList.isEmpty());
	}

	@Test
	public void test_countDivisors() {
		assertEquals(4, Util.countDivisors(21));
		assertEquals(6, Util.countDivisors(28));
		assertEquals(1, Util.countDivisors(1));
		assertEquals(2, Util.countDivisors(2));
		assertEquals(9, Util.countDivisors(100));//1,2,4,5,10,20,25,50,100
		assertEquals(6, Util.countDivisors(18));//1,2,3,6,9,18
	}

	public void lb() {
		double lb = Util.lb(64);
		assertEquals(lb, 8, 1e-10);
	}
	
}
