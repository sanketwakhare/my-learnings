var reverse = function(x) {

    let sign = BigInt(1);
    if (x < 0) {
        sign = BigInt(-1);
    } else {
        sign = BigInt(1);
    }
    let a = BigInt(Math.abs(x));
    let temp = BigInt(Math.abs(x));

    let noOfDigits = BigInt(0);
    while (temp > 0) {
        noOfDigits++;
        temp = temp / BigInt(10);
    }

    let ans = BigInt(0);
    let power = BigInt(1);
    let i = noOfDigits - BigInt(1);
    while (i > 0) {
        power = power * BigInt(10);
        i--;
    }
    while (a > 0 && noOfDigits > 0) {

        let currentDigit = BigInt(a % BigInt(10));
        a = a / BigInt(10);

        ans = ans + currentDigit * power;
        noOfDigits--;
        power = power / BigInt(10);

    }
    if (ans > 2147483647) {
        ans = Number(0);
    }
    console.log(Number(ans) * Number(sign));
    return Number(ans) * Number(sign);

};

reverse(123);
reverse(4234700);
reverse(-130);
reverse(-868939);
reverse(1534236469);