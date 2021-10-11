const repeatedNumber = function (A) {

    const N = A.length;

    let sum = BigInt(0);
    let squareSum = BigInt(0);
    let arrSum = BigInt(0);
    let arrSquareSum = BigInt(0);

    // for(let i=1; i<=N; i++) {
    //     sum = sum + i;
    //     squareSum = squareSum + i*i;
    // }

    for (let i = 1; i <= N; i++) {

        sum = sum + BigInt(i);
        squareSum = squareSum + BigInt(i * i);

        const currentElement = BigInt(A[i - 1]);
        arrSum = arrSum + currentElement;
        arrSquareSum = arrSquareSum + BigInt(currentElement * currentElement);
    }

    let duplicate;
    let missing;

    duplicate = ((((BigInt(squareSum - arrSquareSum) / BigInt(sum - arrSum)) - sum + arrSum) / BigInt(2)));
    missing = BigInt(sum - arrSum) + BigInt(duplicate);

    return [duplicate, missing];

}

repeatedNumber([3, 1, 2, 5, 3]);
repeatedNumber([2, 5, 4, 5, 3]);