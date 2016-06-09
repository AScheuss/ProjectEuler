#!/usr/bin/python

from tools.util import getResult

# If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
# Find the sum of all the multiples of 3 or 5 below 1000.


# There is a formula to give the sum of all multiples up to a certain number
def sumOfMultiples(d, below): 
	m = (below-1)//d # we add all the multiples strictly below the second parameter
	return d*(m*(m+1))//2 # we use integer division


def pe1(below):
	return sumOfMultiples(3,below) + sumOfMultiples(5,below) - sumOfMultiples(15,below)


print("With Formula:")
assert 23 == pe1(10)

getResult(pe1,1000)





##-------------------- Another, more algorithmical approach
##--------------------

def findMultiples(a, below):
	returnList = []
	i=1;
	while a*i < below:
		returnList.append(a*i)
		i+=1
	return returnList

##--------------------

def pe1_2(below):
	multiples3 = sum(findMultiples(3, below))
	multiples5 = sum(findMultiples(5, below))
	multiples15 = sum(findMultiples(15, below))
	return multiples5 + multiples3 - multiples15


print("With \"Algorithm\":")
assert 23 == pe1_2(10)

getResult(pe1_2,1000)


##-------------------- And with another way to generate the multiples in the previous algorithm (using list comprehension)
##--------------------

def pe1_3(below):
	multiples3 = sum([i for i in range(1,below) if i%3 == 0])
	multiples5 = sum([i for i in range(1,below) if i%5 == 0])
	multiples15 = sum([i for i in range(1,below) if i%15 == 0])
	return multiples5 + multiples3 - multiples15


print("With \"Algorithm\" and list comprehension:")
assert 23 == pe1_3(10)

getResult(pe1_3,1000)
