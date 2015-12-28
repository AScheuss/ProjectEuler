% If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
% Find the sum of all the multiples of 3 or 5 below 1000.


function sumOfMultiples = sumOfMultiples (n,d)
  sumOfMultiples = d*(floor(n/d)*(floor(n/d)+1))/2;
endfunction
 

result1 = sumOfMultiples(9,3) + sumOfMultiples(9,5) - sumOfMultiples(9,15)
tic
result2 = sumOfMultiples(999,3) + sumOfMultiples(999,5) - sumOfMultiples(999,15)
toc