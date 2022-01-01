const gcd = (a, b) => {
    const tempA = a;
    const tempB = b;
    if (a > b) {
        // swap a and b if a > b
        const temp = b;
        b = a;
        a = temp;
    }
    while (a > 0) {
        if (a > b) {
            // swap a and b if a > b
            const temp = b;
            b = a;
            a = temp;
        }
        let temp = a;
        a = b % a;
        b = temp;
    }
    console.log('gcd of', tempA, tempB, 'is', b);
    return b;
}

gcd(3, 9);
gcd(1, 10);
gcd(10, 1);
gcd(101, 44);
gcd(12, 15);
gcd(270, 120);
gcd(500, 510);
gcd(8632, 8650);