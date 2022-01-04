/**
 * Aptitude 47
 * 
 * If two dice are thrown, what is the probability that the sum of the two dice will be a prime number?
 */

/* Solution:

    max sum possible => 12 [when dice1 top is 6 and dice2 top is 6]
    min sum possible => 2 [when dice1 top is 1 and dice2 top is 1]

    prime numbers from range 2 to 12 are [2, 3, 5, 7, 11]

    all combinations where [dice1 top + dice2 top = prime number]
    
    [1+1
    1+2 and 2+1
    1+4 and 4+1
    1+6 and 6+1
    2+3 and 3+2
    2+5 and 5+2
    3+4 and 4+3
    5+6 and 6+5]

    total 15 combinations with prime sum out of 36 combination = 15/36 = 5/12

 */

/**
Options:->
A) 5/18
B) 5/36
B) 1/2
D) 5/12
 */