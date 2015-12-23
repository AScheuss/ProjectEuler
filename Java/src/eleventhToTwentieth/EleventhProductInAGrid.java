package eleventhToTwentieth;

import java.util.ArrayList;

import main.Util;

/**
 * In the 20x20 grid below, four numbers along a diagonal line have been marked in red.

 08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08
 49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00
 81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65
 52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91
 22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80
 24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50
 32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70
 67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21
 24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72
 21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95
 78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92
 16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57
 86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58
 19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40
 04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66
 88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69
 04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36
 20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16
 20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54
 01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48





The product of these numbers is 26 * 63 * 78 * 14 = 1788696.

What is the greatest product of four adjacent numbers in the same direction (up, down, left, right, or diagonally) in the 20x20 grid?
 * @author Andreas Scheuss
 *
 */
public class EleventhProductInAGrid {
	private static int[][] matrix = new int[20][20];

	/**
	 * Basically we just compute those products and compare them.
	 */
	public static void main(String[] args) {
		//initalize the matrix:
		construct();

		long maxValue = 0L;
		
		for (int i=0;i<20;i++) {
			for (int j=0;j<20;j++) {
				if (i<=16) {
					maxValue = Math.max(computeVertical(i,j),maxValue);
				}
				if (j<=16) {
					maxValue = Math.max(computeHorizontal(i,j),maxValue);
				}
				if (i<=16 && j<=16) {
					maxValue = Math.max(computeDiagonalLeftToRight(i,j),maxValue);
				}
				if (j>=3 && i<=16) {
					maxValue = Math.max(computeDiagonalRightToLeft(i,j),maxValue);
				}
			}
		}
		System.out.println(maxValue);
	}
		
	
	// --------------------------------- helper ----------------------
	// the computation methods
	/**
	 * Input: the coordinate of the upper left node. Be careful, the x and y cannot be larger than 16.
	 * 
	 * @param x must be smaller or equal 16
	 * @param y must be smaller or equal 16
	 * @return the product of the four 
	 */
		private static int computeDiagonalLeftToRight(int x, int y) {
			int result=0;
			ArrayList<Integer> array = new ArrayList<>();
			for (int i= 0; i<4;i++) {
				array.add(matrix[x+i][y+i]);
			}
			result = Util.multiplicateArray(array);
			return result;
			
		}
		
	/**
	 * Input: the coordinate of the upper left node. Be careful, the x and y cannot be larger than 16.
	 * 
	 * @param x must be smaller or equal 16
	 * @param y must be larger than or equal 3
	 * @return the product of the four 
	 */
		private static int computeDiagonalRightToLeft(int x, int y) {
			ArrayList<Integer> array = new ArrayList<>();
			for (int i= 0; i<4;i++) {
				array.add(matrix[x+i][y-i]);
			}
			return Util.multiplicateArray(array);
			
		}

	/**
	 * 
	 * @param x must be smaller or equal 16
	 * @param y 
	 * @return
	 */
		private static int computeVertical(int x, int y) {
			int result=0;
			ArrayList<Integer> array = new ArrayList<>();
			for (int i= 0; i<4;i++) {
				array.add(matrix[x+i][y]);
			}
			result = Util.multiplicateArray(array);
			return result;
			
		}
	
	/**
	 * 
	 * @param x 
	 * @param y must be smaller or equal 16
	 * @return
	 */
		private static int computeHorizontal(int x, int y) {
			int result=0;
			ArrayList<Integer> array = new ArrayList<>();
			for (int i= 0; i<4;i++) {
				array.add(matrix[x][y+i]);
			}
			result = Util.multiplicateArray(array);
			return result;
		}
	
		private static void construct() {
			String matrixAsString = "08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08, 49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00, 81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65, 52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91, 22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80, 24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50, 32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70, 67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21, 24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72, 21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95, 78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92, 16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57, 86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58, 19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40, 04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66, 88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69, 04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36, 20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16, 20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54, 01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48";			
			
			String[] matrixRowsAsStrings = matrixAsString.split(", ");
			int i = 0;
			for (String row: matrixRowsAsStrings) {
				String[] entries = row.split(" ");
				int j=0;
				for (String entry : entries) {
					matrix[j][i] = Integer.parseInt(entry);
					j++;
					
				}
				i++;
			}
		}
	
	@SuppressWarnings("unused")
	private static void constructMatrixCorrect() {
		int[] vektor1 = {8, 2, 22, 97, 38, 15, 00, 40, 00, 75, 04, 05, 07, 78, 52, 12, 50, 77, 91, 8};
		int[] vektor2 = {49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48, 04, 56, 62, 00};
		int[] vektor3 = {81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30, 03, 49, 13, 36, 65};
		int[] vektor4 = {52, 70, 95, 23, 04, 60, 11, 42, 69, 24, 68, 56, 01, 32, 56, 71, 37, 02, 36, 91};
		int[] vektor5 = {22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33, 13, 80};
		int[] vektor6 = {24, 47, 32, 60, 99, 03, 45, 02, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17, 12, 50};
		int[] vektor7 = {32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38, 64, 70};
		int[] vektor8 = {67, 26, 20, 68, 02, 62, 12, 20, 95, 63, 94, 39, 63, 8, 40, 91, 66, 49, 94, 21};
		int[] vektor9 = {24, 55, 58, 05, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72};
		int[] vektor10 = {21, 36, 23, 9, 75, 00, 76, 44, 20, 45, 35, 14, 00, 61, 33, 97, 34, 31, 33, 95};
		int[] vektor11 = {78, 17, 53, 28, 22, 75, 31, 67, 15, 94, 03, 80, 04, 62, 16, 14, 9, 53, 56, 92};
		int[] vektor12 = {16, 39, 05, 42, 96, 35, 31, 47, 55, 58, 88, 24, 00, 17, 54, 24, 36, 29, 85, 57};
		int[] vektor13 = {86, 56, 00, 48, 35, 71, 89, 07, 05, 44, 44, 37, 44, 60, 21, 58, 51, 54, 17, 58};
		int[] vektor14 = {19, 80, 81, 68, 05, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77, 04, 89, 55, 40};
		int[] vektor15 = {04, 52, 8, 83, 97, 35, 99, 16, 07, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66};
		int[] vektor16 = {88, 36, 68, 87, 57, 62, 20, 72, 03, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69};
		int[] vektor17 = {04, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18, 8, 46, 29, 32, 40, 62, 76, 36};
		int[] vektor18 = {20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74, 04, 36, 16};
		int[] vektor19 = {20, 73, 35, 29, 78, 31, 90, 01, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57, 05, 54};
		int[] vektor20 = {01, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52, 01, 89, 19, 67, 48};
		
		matrix[0] = vektor1;
		matrix[1] = vektor2;
		matrix[2] = vektor3;
		matrix[3] = vektor4;
		matrix[4] = vektor5;
		matrix[5] = vektor6;
		matrix[6] = vektor7;
		matrix[7] = vektor8;
		matrix[8] = vektor9;
		matrix[9] = vektor10;
		matrix[10] = vektor11;
		matrix[11] = vektor12;
		matrix[12] = vektor13;
		matrix[13] = vektor14;
		matrix[14] = vektor15;
		matrix[15] = vektor16;
		matrix[16] = vektor17;
		matrix[17] = vektor18;
		matrix[18] = vektor19;
		matrix[19] = vektor20;
	}
	
}
