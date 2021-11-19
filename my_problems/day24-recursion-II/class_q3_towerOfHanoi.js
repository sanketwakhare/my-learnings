
/**
 * Tower of Hanoi
 * @param {*} N no of discs
 * @param {*} S source
 * @param {*} T temp
 * @param {*} D destination
 * @returns 
 */
const TOH = (N, S, T, D) => {

    if (N === 0) {
        return;
    }

    TOH(N - 1, S, D, T);
    console.log(`disc ${N} : ${S} -> ${D}`);
    TOH(N - 1, T, S, D);

}

TOH(3, 'A', 'B', 'C');