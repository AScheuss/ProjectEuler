#!/usr/bin/python


from primes import isPrime

assert isPrime(13)
assert isPrime(23)
assert isPrime(31)
assert not isPrime(1024)
assert not isPrime(101*63423)



from primes import monteCarloIsPrime

assert monteCarloIsPrime(13)
assert monteCarloIsPrime(23)
assert monteCarloIsPrime(31)
assert not monteCarloIsPrime(1024)
assert not monteCarloIsPrime(101*63423)
assert not monteCarloIsPrime(48039758943759842378954983)




from primes import getAllPrimesBelow

assert 0 == len(getAllPrimesBelow(2))

primes= [2]
value = getAllPrimesBelow(3)
assert len(set(primes) & set(value)) == len(primes)
assert 0==(primes > value) - (primes < value)

primes= [2,3]
value = getAllPrimesBelow(4)
assert len(set(primes) & set(value)) == len(primes)
assert 0==(primes > value) - (primes < value)

primes= [2,3,5,7]
value = getAllPrimesBelow(10)
assert len(set(primes) & set(value)) == len(primes)
assert 0==(primes > value) - (primes < value)

primes.extend([11,13,17,19])
value = getAllPrimesBelow(19)
assert not len(set(primes) & set(value)) == len(primes)

value = getAllPrimesBelow(20)
assert len(set(primes) & set(value)) == len(primes)
assert 0==(primes > value) - (primes < value)