/* Window String */

/***
 * Problem Description

Given a string A and a string B, find the window with minimum length in A which will contain all the characters in B in linear time complexity.
Note that when the count of a character c in B is x, then the count of c in minimum window in A should be at least x.

Note:
If there is no such window in A that covers all characters in B, return the empty string.
If there are multiple such windows, return the first occurring minimum window ( with minimum start index )

Problem Constraints
1 <= size(A), size(B) <= 10^6

Input Format
First argument is a string A.
Second argument is a string B.

Output Format
Return a string denoting the minimum window.

Example Input
Input 1:
 A = "ADOBECODEBANC"
 B = "ABC"
Input 2:
 A = "Aa91b"
 B = "ab"

Example Output
Output 1:
 "BANC"
Output 2:
 "a91b"

Example Explanation
Explanation 1:
 "BANC" is a substring of A which contains all characters of B.
Explanation 2:
 "a91b" is the substring of A which contains all characters of B.
 */


/**
 * TC: O(N * 26) => O(N)
 * SC: O(N)
 * @param {String} A 
 * @param {String} B 
 * @returns 
 */
//working approach - hashMap with 2 pointers approach
const minWindow = (A, B) => {

    // create map of B - neededFreq map
    let bNeededFreqMap = new Map();
    for (let i = 0; i < B.length; i++) {
        const currentEle = B[i];
        if (bNeededFreqMap.has(currentEle)) {
            const currFreq = bNeededFreqMap.get(currentEle);
            bNeededFreqMap.set(currentEle, currFreq + 1);
        } else {
            bNeededFreqMap.set(currentEle, 1);
        }
    }

    console.log(bNeededFreqMap);

    let answer = Number.MAX_SAFE_INTEGER;
    let aMap = new Map();
    let output = "";

    let i = 0;
    let j = 0;
    let jPointerMoved = true;
    while (j < A.length) {

        if (jPointerMoved) {
            const currEle = A[j];

            // if current element is not present in neededMap, then continue
            if (!bNeededFreqMap.has(currEle)) {
                j++;
                continue;
            }

            // update frequency in aMap
            if (aMap.has(currEle)) {
                aMap.set(currEle, aMap.get(currEle) + 1);
            } else {
                aMap.set(currEle, 1);
            }
        }

        // check if frequency is matching
        let freqMatching = false;
        if (bNeededFreqMap.size === aMap.size) {
            freqMatching = true;
            for (const [aKey, aVal] of aMap) {
                if (bNeededFreqMap.has(aKey)) {
                    const neededFreq = bNeededFreqMap.get(aKey);
                    const currentFreq = aVal;
                    if (currentFreq < neededFreq) {
                        freqMatching = false;
                        break;
                    }
                } else {
                    freqMatching = false;
                    break;
                }
            }
        }

        if (!freqMatching) {
            // move pointer j
            j++;
            jPointerMoved = true;
        } else {
            // update answer
            const currentAnswerLength = j - i + 1;
            if (answer > currentAnswerLength) {
                answer = currentAnswerLength;
                output = A.substring(i, j + 1);
            }

            // if A[i] is present in hashMap, decrease its freq by 1
            if (aMap.has(A[i])) {
                const currFreq = aMap.get(A[i]);
                if (currFreq === 1) {
                    aMap.delete(A[i]);
                } else {
                    aMap.set(A[i], currFreq - 1);
                }
            }

            // move pointer i
            i++;
            jPointerMoved = false;
        }

    }
    if (answer === Number.MAX_SAFE_INTEGER) {
        output = "";
    }
    console.log(answer);
    console.log(output);
    return answer;

}


minWindow("ADOBECODEBANC", "ABC"); // BANC
minWindow("Aa91b", "ab"); // a91b
minWindow("A", "A"); // A
minWindow("w", "o"); // empty string
minWindow("xiEjBOGeHIMIlslpQIZ6jERaAVoHUc9Hrjlv7pQpUSY8oHqXoQYWWll8Pumov89wXDe0Qx6bEjsNJQAQ0A6K21Z0BrmM96FWEdRG69M9CYtdBOrDjzVGPf83UdP3kc4gK0uHVKcPN4HPdccm9Qd2VfmmOwYCYeva6BSG6NGqTt1aQw9BbkNsgAjvYzkVJPOYCnz7U4hBeGpcJkrnlTgNIGnluj6L6zPqKo5Ui75tC0jMojhEAlyFqDs7WMCG3dmSyVoan5tXI5uq1IxhAYZvRQVHtuHae0xxwCbRh6S7fCLKfXeSFITfKHnLdT65K36vGC7qOEyyT0Sm3Gwl2iXYSN2ELIoITfGW888GXaUNebAr3fnkuR6VwjcsPTldQSiohMkkps0MH1cBedtaKNoFm5HbH15kKok6aYEVsb6wOH2w096OwEyvtDBTQwoLN87JriLwgCBBavbOAiLwkGGySk8nO8dLHuUhk9q7f0rIjXCsQeAZ1dfFHvVLupPYekXzxtWHd84dARvv4Z5L1Z6j8ur2IXWWbum8lCi7aErEcq41WTo8dRlRykyLRSQxVH70rUTz81oJS3OuZwpI1ifBAmNXoTfznG2MXkLtFu4SMYC0bPHNctW7g5kZRwjSBKnGihTY6BQYItRwLUINApd1qZ8W4yVG9tnjx4WyKcDhK7Ieih7yNl68Qb4nXoQl079Vza3SZoKeWphKef1PedfQ6Hw2rv3DpfmtSkulxpSkd9ee8uTyTvyFlh9G1Xh8tNF8viKgsiuCZgLKva32fNfkvW7TJC654Wmz7tPMIske3RXgBdpPJd5BPpMpPGymdfIw53hnYBNg8NdWAImY3otYHjbl1rqiNQSHVPMbDDvDpwy01sKpEkcZ7R4SLCazPClvrx5oDyYolubdYKcvqtlcyks3UWm2z7kh4SHeiCPKerh83bX0m5xevbTqM2cXC9WxJLrS8q7XF1nh", "dO4BRDaT1wd0YBhH88Afu7CI4fwAyXM8pGoGNsO1n8MFMRB7qugS9EPhCauVzj7h");
// The expected return value: 8oHqXoQYWWll8Pumov89wXDe0Qx6bEjsNJQAQ0A6K21Z0BrmM96FWEdRG69M9CYtdBOrDjzVGPf83UdP3kc4gK0uHVKcPN4HPdccm9Qd2VfmmOwYCYeva6BSG6NGqTt1aQw9BbkNsgAjvYzkVJPOYCnz7U4hBeGpcJkrnlTgNIGnluj6L6zPqKo5Ui75tC0jMojhEAlyFqDs7WMCG3dmSyVoan5tXI5uq1IxhAYZvR



/*non wokring approach*/
const doNotUseMinWindowOld = (A, B) => {

    // create map of B - neededFreq map
    let bNeededFreqMap = new Map();
    for (let i = 0; i < B.length; i++) {
        const currentEle = B[i];
        if (bNeededFreqMap.has(currentEle)) {
            const currFreq = bNeededFreqMap.get(currentEle);
            bNeededFreqMap.set(currentEle, currFreq + 1);
        } else {
            bNeededFreqMap.set(currentEle, 1);
        }
    }

    console.log(bNeededFreqMap);

    let answer = Number.MAX_SAFE_INTEGER;
    let total = B.length;

    // l is start index of current substring
    let l = 0;
    let arr = [];
    let aMap = new Map();
    let output = "";

    for (let i = 0; i < A.length; i++) {

        const currEle = A[i];

        // if current element is not present in neededMap, then continue
        if (!bNeededFreqMap.has(currEle)) {
            continue;
        }

        // update frequency in aMap
        if (aMap.has(currEle)) {
            aMap.set(currEle, aMap.get(currEle) + 1);
        } else {
            aMap.set(currEle, 1);
        }

        const neededFreq = bNeededFreqMap.get(currEle);
        const currentFreq = aMap.get(currEle);

        arr.push([i, currEle]);
        if (currentFreq <= neededFreq) {
            total--;
        }

        if (total === 0) {
            const startIndex = arr.length - B.length;
            const endIndex = i;

            if (endIndex - arr[startIndex][0] + 1 < answer) {
                // update answer
                output = A.substring(arr[startIndex][0], endIndex + 1);
                answer = endIndex - arr[startIndex][0] + 1;
            }
            // answer = Math.min(answer, endIndex - arr[startIndex][0] + 1);

            // remove freq of start from aMap
            const eleToRemove = arr[startIndex][1];
            if (aMap.get(eleToRemove) === 1) {
                aMap.delete(eleToRemove);
            } else {
                aMap.set(eleToRemove, aMap.get(eleToRemove) - 1);
            }
            // increase total need value
            total++;
        }
    }
    if (answer === Number.MAX_SAFE_INTEGER) {
        output = "";
    }
    console.log(answer);
    console.log(output);
    return answer;

}