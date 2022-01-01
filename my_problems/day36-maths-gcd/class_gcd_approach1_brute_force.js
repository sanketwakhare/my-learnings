/**
 * Find gcd of a and b
 * TC: O(min(a,b))
 * @param {Number} a integer
 * @param {Number} b integer 
 * @returns 
 */
const gcd_approach1 = (a, b) => {

    let ans = 1;
    const min = Math.min(a, b);
    for (let i = min; i >= 1; i--) {
        if (a % i === 0 && b % i === 0) {
            ans = i;
            break;
        }
    }
    console.log('gcd of ', a, b, 'is -> ', ans);
    return ans;
}

gcd_approach1(3, 9);
gcd_approach1(1, 10);
gcd_approach1(10, 1);
gcd_approach1(101, 44);
gcd_approach1(12, 15);
gcd_approach1(270, 120);
gcd_approach1(500, 510);
gcd_approach1(8632, 8650);