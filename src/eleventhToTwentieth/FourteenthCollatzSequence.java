package eleventhToTwentieth;

import java.util.Arrays;

/**
 * Created by AScheuss on 01.05.15.
 *
 * The following iterative sequence is defined for the set of positive integers:

 n → n/2 (n is even)
 n → 3n + 1 (n is odd)

 Using the rule above and starting with 13, we generate the following sequence:

 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

 Which starting number, under one million, produces the longest chain?

 NOTE: Once the chain starts the terms are allowed to go above one million.

 */
public class FourteenthCollatzSequence {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		new FourteenthCollatzSequence().bruteForce();
		System.out.println("cost time : " + (System.currentTimeMillis() - start) + "ms.");

		start = System.currentTimeMillis();
		new FourteenthCollatzSequence().withMemorization();
		System.out.println("cost time : " + (System.currentTimeMillis() - start) + "ms.");
	}

	private void bruteForce() {
	/* brute force...*/
		int n=3;
		int numberWithHighestChain = 0;
		int lengthOfHighestChain = 0;

		while (n <= 1e6) {
			long step = n;
			int lengthOfChain = 0;

			while (step!=1) {
				step = computeStep(step);
				lengthOfChain++;
			}
			if (lengthOfChain > lengthOfHighestChain) {
				lengthOfHighestChain = lengthOfChain;
				numberWithHighestChain = n;
			}

			n++;
		}
		System.out.println("With brute force:");
		System.out.println("number with highest chain: " + numberWithHighestChain);
		System.out.println("length of highest chain: " + lengthOfHighestChain);
	}

	private void withMemorization() {
		int max = (int) 1e6;

		int[] cache = new int[max];
		Arrays.fill(cache, 0);

		int lengthOfHighestChain = 0;
		int numberWithHighestChain = 0;

		for (int i = 1; i <= max ;i++) {
			int length = lengthOfChain(i, cache);
			if (length > lengthOfHighestChain) {
				lengthOfHighestChain = length;
				numberWithHighestChain = i;
			}
		}

		System.out.println("With brute force:");
		System.out.println("number with highest chain: " + numberWithHighestChain);
		System.out.println("length of highest chain: " + lengthOfHighestChain);
	}

	private int lengthOfChain(final int n, final int[] cache) {
		long step = n;
		int lengthOfChain=0;

		while (step!=1) {
			step = computeStep(step);
			lengthOfChain++;

			//use the cache
			if (step < cache.length && cache[((int) step)] > 0) {
				lengthOfChain += cache[((int) step)];
				break;
			}
		}

		//fill the cache
		if (n < cache.length) {
			cache[n] = lengthOfChain;
		}

		return lengthOfChain;
	}

	private long computeStep(long step) {
		if (0 == step % 2) {
			step = step / 2;
		} else {
			step = 3 * step + 1;
		}
		return step;
	}


}
