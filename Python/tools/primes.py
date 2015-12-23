#!/usr/bin/python

def isPrime(n):
	"""Returns True if n is prime"""
	if n==2: return True
	if n==3: return True
	if n%2==0: return False
	if n%3==0: return False


	i=5
	w=2

	while(i*i<n):
		if n%i==0: 
			return False
		i+=w
		w=6-w
	return True


from random import randrange
from fractions import gcd
def monteCarloIsPrime(n):
	"""Returns True if n is probably prime and False if it is definitely not prime."""
	for i in range(0,50):
		k = randrange(2, n, 1)
		if gcd(n,k)!=1:
			return False
	return True



def getAllPrimesBelow(n):
	list = []
	if (n>3):
		list.append(2)
		list.append(3)

	i=5
	w=2

	while(i<n):
		if isPrime(i): 
			list.append(i)
		i+=w
		w=6-w
	return list



from math import sqrt
from math import floor
def primeFactorList(n):
	primes = getAllPrimesBelow(floor(sqrt(n)+1))
	list = []
	for k in primes:
		if n%k==0:
			list.append(k)
	return list
