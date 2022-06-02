/* Count Rectangles */
module.exports = {
    //param A : array of integers
    //param B : array of integers
    //return an integer
    solve: function(A, B) {

        // build hashmap with frequencies <'x/y', freq>
        let map = new Map();
        for (let i = 0; i < A.length; i++) {
            const key = `${A[i]}/${B[i]}`;
            if (map.has(key)) {
                map.set(key, map.get(key) + 1);
            } else {
                map.set(key, 1);
            }
        }

        let count = 0;
        // consider one diagonals and find if another diagonal is present as coordinate
        for (let i = 0; i < A.length; i++) {
            for (let j = i + 1; j < A.length; j++) {
                const x1 = A[i];
                const y1 = B[i];
                const x2 = A[j];
                const y2 = B[j];

                // id i and j coordinated on same line
                if (x1 === x2 || y1 === y2) {
                    continue;
                }

                // if (x1,y2) and (x2,y1) are present, we can form rectangle with i and j coordinates
                const key1ToSearch = `${x1}/${y2}`;
                const key2ToSearch = `${x2}/${y1}`;
                if (map.has(key1ToSearch) && map.has(key2ToSearch)) {
                    const currCount = map.get(key1ToSearch) * map.get(key2ToSearch);
                    count += currCount;
                }
            }
        }
        return count / 2;
    }
};