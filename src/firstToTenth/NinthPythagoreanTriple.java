package firstToTenth;


/**
 * A Pythagorean triplet is a set of three natural numbers, a  b  c, for which, a^2 + b^2 = c^2
 * 
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * 
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 * 
 * @author Andreas Scheuss
 *
 */
public class NinthPythagoreanTriple {

	/**
	 * We calculate the possible values for a,b and c and check their sum, then multiply.
	 */
	public static void main(String[] args) {
		
		for (int a=0; a<5000;a++) {
			for (int b=1; b<500; b++) {
				if (getC(a, b)!=0) {
					if (a+b+ getC(a, b) == 1000) {
						System.out.println(a * b * getC(a, b));
						a=1000;
						break;
					}
				}
			}
		}
	}

	private static int getC(int a, int b) {
		if (Math.sqrt(a*a + b*b)-Math.ceil(Math.sqrt(a*a + b*b))==0) {
			return (int) Math.sqrt(a*a + b*b);
			 
		 }
		 return 0;
	}
}
