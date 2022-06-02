/* Replicating Substring */

module.exports = {
    //param A : integer
    //param B : string
    //return an integer
    solve: function(A, B) {
        // edge case
        if (B.length < A) return -1;

        // build map with frequencies
        let map = new Map();
        for (let i = 0; i < B.length; i++) {
            const ch = B.charAt(i);
            if (map.has(ch)) {
                map.set(ch, map.get(ch) + 1);
            } else {
                map.set(ch, 1);
            }
        }

        // iterate map and check if every frequency is divisible by value A
        for (let freq of map.values()) {
            if (freq % A !== 0) {
                return -1;
            }
        }
        return 1;
    }
};