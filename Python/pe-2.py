#!/usr/bin/python

from tools.util import getResult

# Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:

# 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

# By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.


from math import sqrt
SQUARE_ROOT_OF_FIVE = sqrt(5)


def f(n): # Formula of Moivre-Binet. Add 1 because of the index-shift in the statement of the problem
	return (1/SQUARE_ROOT_OF_FIVE) * ( ((1+ SQUARE_ROOT_OF_FIVE)/2)**(n+1) - ((1- SQUARE_ROOT_OF_FIVE)/2)**(n+1) )//1 # to get an integer divide by one... (better way?)


def pe2(below):
	sum = 0
	step = 2
	f_nPlus = 2
	while(f_nPlus < below):
		sum += f_nPlus
		step = 3 +  step
		f_nPlus = f(step)
	return sum


print("With Formula:")
assert pe2(9) ==  10
assert pe2(8) ==  2


getResult(pe2,4*10**6)