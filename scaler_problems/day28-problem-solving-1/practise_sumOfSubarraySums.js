const sumOfSubarraySums = (A) => {
    // use contribution of each element method
    let sum = BigInt(0);
    for (let i = 0; i < A.length; i++) {
        // left and right
        const left = i + 1;
        const right = A.length - i;
        const totalContributionOfIthElement = BigInt(left * right);
        sum = sum + BigInt(totalContributionOfIthElement * BigInt(A[i]));
    }
    console.log(sum);
    return sum;
}

sumOfSubarraySums([1, 2, 3, 4, 5]);