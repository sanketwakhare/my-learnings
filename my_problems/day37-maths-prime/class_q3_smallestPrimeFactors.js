const smallestPrimeFactors = (N) => {

    // initialize spf array with i for each number
    let spf = new Array(N + 1);
    for (let i = 1; i <= N; i++) {
        spf[i] = i;
    }

    for (let i = 2; i * i <= N; i++) {
        if (spf[i] === i) {
            // i is prime
            for (let j = i + i; j <= N; j = j + i) {
                if (spf[j] === j) {
                    spf[j] = i;
                }
            }
        }
    }
    console.log(spf);
    return spf;
}

smallestPrimeFactors(50);