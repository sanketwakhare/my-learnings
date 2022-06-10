/* Maximum Frequency stack */

const maxFreqStack = (A) => {

    let map = new Map();
    let maxFreq = 0;
    let mapFreqToStack = new Map();

    let result = [];
    for (let i = 0; i < A.length; i++) {
        const operation = A[i][0];
        const value = A[i][1];

        let currFreq = 0;
        let stack;
        switch (operation) {
            case 1:
                /* push operation */

                // step-1: update map
                currFreq = 1;
                if (map.has(value)) {
                    currFreq = map.get(value) + 1;
                }
                map.set(value, currFreq);

                // step-2: update max maxFreq
                maxFreq = Math.max(maxFreq, currFreq);

                // step-3: add value into stack
                stack = mapFreqToStack.get(currFreq);
                if (stack === undefined || stack === null) {
                    mapFreqToStack.set(currFreq, [value]);
                } else {
                    stack.push(value);
                }

                result.push(-1);
                break;
            case 2:
                /* pop operation */

                // step-1: remove element from current stack
                stack = mapFreqToStack.get(maxFreq);
                if (stack === null || stack === undefined) {
                    result.push(-1);
                    break;
                }
                let maxFreqElement = stack.pop();
                if (stack.length === 0) {
                    mapFreqToStack.delete(maxFreq);
                    // step-2: decrease maxFreq when there are no further elements in current freq stack
                    maxFreq--;
                }

                // step-3: decrease freq from map
                currFreq = map.get(maxFreqElement);
                if (currFreq === 1) {
                    map.delete(maxFreqElement);
                } else {
                    map.set(maxFreqElement, currFreq - 1);
                }

                result.push(maxFreqElement);
                break;
        }
    }
    return result;
}

const result = maxFreqStack([[1, 5], [1, 7], [1, 5], [1, 7], [1, 4], [1, 5], [2, 0], [2, 0], [2, 0], [2, 0]]);
console.log(result);