const cyclicPermutations = (A, B) => {

    // Idea: to use pattern matching algorithm

    let s = A + "$" + B + B;

    // Use z - algorithm
    const N = s.length - 1;
    let zArray = [N];

    // maintain pink windows as discussed in class
    // L and R are start and end indices are second window, the first window will be from 0 to L-R
    let L = 0;
    let R = 0;
    for (let i = 1; i < N; i++) {

        // Brute force code - when s[i] is outside second window
        if (i > R) {
            // update start of second window
            L = i;

            // initialize R
            R = i;
            while (R < N && s[R] === s[R - L]) {
                // R-L will give corresponding element from first window
                R++;
            }

            // update zArray value for ith element
            zArray[i] = R - L;
            // when brute force is finished, update end index of newly created windows
            R--;

        } else {

            let j = i - L;
            if (zArray[j] < R - i + 1) {
                // if element zArray value is within window size-- within boundary
                // copy the value as it is. this is the optimization with this approach
                zArray[i] = zArray[j];
            } else {
                // update start index of second window
                L = i;
                // 
                R++;
                while (R < N && s[R] === s[R - L]) {
                    // R-L will give corresponding element from first window
                    R++;
                }
                // update zArray value for ith element
                zArray[i] = R - L;
                // set end index of second pink window
                R--;
            }
        }
    }

    let count = 0;
    for (let i = A.length + 1; i < N; i++) {

        if (zArray[i] === A.length) {
            count++;
        }

    }
    console.log(count);
    return count;
}

cyclicPermutations('abcd', 'abcd'); //expected output 1
cyclicPermutations('1001', '0011'); //expected output 1
cyclicPermutations('111', '111'); //expected output 3