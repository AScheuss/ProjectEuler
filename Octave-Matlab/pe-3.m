# The prime factors of 13195 are 5, 7, 13 and 29.
# What is the largest prime factor of the number 600851475143 ?


number = 600851475143;

function max = pe3(n)
	max = max(factor(n));
endfunction

tic
result1 = pe3(number)
toc


# TODO implement a solution without built-in methods...