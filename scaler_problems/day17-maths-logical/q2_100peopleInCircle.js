/***
 * 100 People in a Circle
100 people standing in a circle in an order 1 to 100.

No.1 has a sword. He kills next person (i.e. no. 2) and gives sword to next to next (i.e no.3). All person does the same until only 1 survives.

Which number survives at the last?

 Answer is a integer. Just put the number without any decimal places if its an integer. If the answer is Infinity, output Infinity. Feel free to get in touch with us if you have any questions
 */

const nPeopleStandingInCircle = (N) => {


    closest2PowerN = Math.floor(Math.log2(N));

    // console.log(closest2PowerN);
    let twoPowerNValue = 1;
    for (let i = 0; i < closest2PowerN; i++) {
        twoPowerNValue = 2 * twoPowerNValue;
    }

    // console.log(twoPowerNValue);
    const killsTillLast2PowerN = (N - twoPowerNValue);
    const lastManStanding = (killsTillLast2PowerN * 2) + 1

    console.log(lastManStanding);
    return lastManStanding;
}

nPeopleStandingInCircle(100);
nPeopleStandingInCircle(8);