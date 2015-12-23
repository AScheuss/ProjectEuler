#!/usr/bin/python

numbers = [45, 101, 2**7 -1, 2**31 - 1]

from util import takeTime

from primes import isPrime
print("isPrime:")
for i in numbers:
	takeTime(isPrime, i)

from primes import monteCarloIsPrime
print("monteCarloIsPrime:")
for i in numbers:
	takeTime(monteCarloIsPrime, i)

# or print it in a csv via (i/o-stuff!)
# print("isPrime, monteCarloIsPrime")
# for i in numbers:
# 	print(isPrime(i), ",",monteCarloIsPrime(i),"")
