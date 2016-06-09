// If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
// Find the sum of all the multiples of 3 or 5 below 1000.

#include <iostream>
using namespace std;

// There is a formula to give the sum of all multiples up to a certain number (Remeber geometric series!)
long sumOfMultiples(int d, int below) {
	long m = (below-1)/d; // we add all the multiples strictly below the second parameter
	return d*(m*(m+1))/2; //we use integer division
}

long pe1(long below) {
	return sumOfMultiples(3,below) + sumOfMultiples(5,below) - sumOfMultiples(15,below);
}


int main() {
	long solution = pe1(1000);
	cout << solution << endl;
	return 0;
}

