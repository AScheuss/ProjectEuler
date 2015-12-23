#!/usr/bin/python

from tools.util import getResult

# A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

# Find the largest palindrome made from the product of two 3-digit numbers.

def getIndex(string):
	length= len(string)
	index = length//2
	index2 = index
	if length%2==1:
		index2 += 1
	return [index, index2]

def getParts(string):
	stringIndex = getIndex(string)
	return [string[:stringIndex[0]], string[stringIndex[1]:] ]

def isPalindromeNumber(n,m):
	parts= getParts(str(n*m))
	if parts[0]==parts[1][::-1]:
		return True
	else:
		return False


def pe4(n):
	upperNumber = int("9"*n)
	lowerNumber = int("9" + "0"*(n-2)) # the number is probably above 900*900... (If there was no result we could extend the ranges.)
	rangeToConsider = range(int(upperNumber), int(lowerNumber),-1)

	palindromes = []
	for i in rangeToConsider:
		for j in rangeToConsider:
			if isPalindromeNumber(i,j):
				palindromes.append(j*i)

	return max(palindromes)



assert pe4(2) == 9009

getResult(pe4,3) 



## Improvements based on the downloadable overview - sheet on projecteuler.net
# Analysis:
# 1. In the code above we consider some numbers several times. For example 99*98 and 98*99
# 2. If we start from above we will be able to just stop, when we will find the first palindrome (if we go down correctly)
# 3. As we have 111111 = 143×777, the largest palindrome numer must have 6 digits
#    Any 6 digit palindrome number must be divisible by 11 (proof see sheet). Hence one of the two 3 digits number must be divisible by 11

def pe4Fast(): # Is there a possibility to generify this? The third point from above analysis does not necessarily hold for 
	largestPalindrome = 0
	a = 999

	while a>143: # TODO how can we mathematically argue that this number can be much bigger (900 also works, but why?)
		if a%11==0:
			down = 1
			b=999
		else: # b must be divisible by 11
			down = 11
			b=990 # =11*90 and thus the smallest number <1000 divisible by 11
		while b>=a:
			if a*b < largestPalindrome:
				break
			if isPalindromeNumber(a,b):
				largestPalindrome = a*b
				break
			b-=down
		a-=1
	return largestPalindrome


getResult(pe4Fast)