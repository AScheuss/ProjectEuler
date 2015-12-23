#!/usr/bin/python

import sys
sys.path.insert(0, 'ProjectEuler/tools')

from util import isPrime


assert isPrime(13)
assert isPrime(23)
assert isPrime(31)
assert not isPrime(1024)
assert not isPrime(101*63423)



from util import monteCarloIsPrime

assert monteCarloIsPrime(13)
assert monteCarloIsPrime(23)
assert monteCarloIsPrime(31)
assert not monteCarloIsPrime(1024)
assert not monteCarloIsPrime(101*63423)
assert not monteCarloIsPrime(48039758943759842378954983)