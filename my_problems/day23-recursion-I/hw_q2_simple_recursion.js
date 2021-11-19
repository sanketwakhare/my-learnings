/**
 * MCQ
 */

const bar = (x, y) => {
    if (y === 0) return 0;
    return (x + bar(x, y - 1));
}

const foo = (x, y) => {
    if (y === 0) return 1;
    return bar(x, foo(x, y - 1));
}

console.log(foo(3, 5));

/* Options:
15
18
243
125

Correct Answer: 243 */