/**
 * MCQ
 */

const fun = (x, n) => {
    if (n === 0) return 1;
    else if (n % 2 === 0)
        return fun(x * x, n / 2);
    else
        return x * fun(x * x, (n - 1) / 2);
}

console.log(fun(2, 10));

/* Options:
1024
2048
1023
None of these

Correct Answer: 1024 */