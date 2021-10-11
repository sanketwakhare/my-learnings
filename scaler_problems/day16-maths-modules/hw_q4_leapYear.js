

const isLeapYear = (A) => {

    // Year is multiple of 400.
    if (A % 400 === 0) {
        return 1;
    } else if (A % 4 === 0 && A % 100 !== 0) {
        // Year is multiple of 4 and not multiple of 100.
        return 1;
    }

    return 0;
}