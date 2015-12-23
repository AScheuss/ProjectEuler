#!/usr/bin/python

from tools.util import getResult

# The prime factors of 13195 are 5, 7, 13 and 29.

# What is the largest prime factor of the number 600851475143 ?


number = 600851475143


from tools.primes import primeFactorList
def pe3(n):
	return max(primeFactorList(n))


assert pe3(13195) == 29
getResult(pe3,600851475143)