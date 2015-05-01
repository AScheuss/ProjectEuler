package firstToTenth;


/**
 * A Pythagorean triplet is a set of three natural numbers, a  b  c, for which, a2 + b2 = c2
 * 
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 * 
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 * 
 * @author Andreas Scheuss
 *
 */
public class NinthPythagoreanTriple {

	public static void main(String[] args) {
		
		for (int a=0; a<5000;a++) {
			for (int b=1; b<500; b++) {
				if (getCeiling(a,b)!=0) {
					if (a+b+getCeiling(a,b) == 1000) {
//						System.out.println(a);
//						System.out.println(b);
//						System.out.println(getC(a,b));
						
						System.out.println(a*b*getCeiling(a,b));
						a=1000;
						break;
					}
				}
			}
		}

	}

	private static int getCeiling(int a, int b) {
		if (Math.sqrt(a*a + b*b)-Math.ceil(Math.sqrt(a*a + b*b))==0) {
			return (int) Math.sqrt(a*a + b*b);
			 
		 }
		 return 0;
	}
}
