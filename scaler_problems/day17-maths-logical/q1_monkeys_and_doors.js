const monkeysAndDoors = (N) => {

    let A = new Array(100);
    for (let i = 0; i < N; i++) {
        A[i] = 0;
    }

    console.log(A);

    for (let i = 1; i <= N; i++) {
        for (let j = i; j <= N; j = j + i) {
            if (A[j - 1] === 0) {
                A[j - 1] = 1;
            } else {
                A[j - 1] = 0;
            }
        }
    }

    console.log(A);
    let noOfOpenDoors = 0;
    for (let i = 0; i < N; i++) {
        if (A[i] === 1) {
            noOfOpenDoors++;
        }
    }

    console.log(noOfOpenDoors);
}

monkeysAndDoors(100);