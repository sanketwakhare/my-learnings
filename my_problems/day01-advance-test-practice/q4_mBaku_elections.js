/**
 * Bribe the Tribe
Its that time of the year again for choosing the new leader of the Jabari tribe.
M'baku, a revered general was also contesting for the elections along with N-1 other candidates.
A person will win the elections if he has strictly more votes than all other candidates.
You are given an array A of size N that denotes the current fixtures of the votes, A[i] denotes the number of votes that the i'th candidate is getting. (Note: M'Baku is the first in the array)
M'Baku wants to win the elections at any cost, so he is ready to bribe the people of the tribe.
Each person he bribes decides to retreat his vote from the person he was initally voting for and give it to M'Baku.
Find the minimum number of people he will have to bribe to win the elections.

Constraints:
2<= Size of array <=100
1 <= A[i] <= 1000

Input Format An array A denoting the initial votes every candidate is getting
Output Format An integer denoting minimum people M'Baku has to bribe to win the elections

Example Input
A:[5 1 11 2 8]

Example Output
4
Explanation M'Baku has 5 votes here. One way to win the elections is to bribe 4 people who are going to vote for third candidate and reduce his/her votes from 11 to 7. One more way can be to bribe 3 people who are going to vote candidate 3 and bribe 1 person who is going to vote to candidate 2.
 */

/**
 * Since constraints are less, N^2 solution is acceptable.
 * 
 * Total Time Complexity:
 * For Sorting:  N*log(N) * N => N^2 * log(N)
 * 
 * @param {Array} A 
 * @returns 
 */
const makeMBakuWinTheElections = (A) => {
    let mBakuVotes = A[0];
    let tempArray = [...A];
    //remove first elements from tempArray. i.e. remove mBaku's votes from temp array.
    tempArray.shift();

    // tempArray sort by descending order
    tempArray = tempArray.sort((a, b) => b - a);

    let mBakuWon = false;
    while (!mBakuWon) {
        mBakuWon = true;
        // if there are greater no of votes than mBaku in tempArray,
        // add 1 vote to mBaku and remove from greatest number
        for (let i = 0; i < tempArray.length; i++) {
            if (tempArray[i] >= mBakuVotes) {
                tempArray[i]--;
                mBakuVotes++;
                mBakuWon = false;
                // sort tempArray by descending order every time after there are greater no of votes than mBaku
                tempArray = tempArray.sort((a, b) => b - a);
                break;
            }
        }
    }
    const noOfVotesRRequiredToBeBribedForMBakuToWin = mBakuVotes - A[0];
    console.log(noOfVotesRRequiredToBeBribedForMBakuToWin);
    return noOfVotesRRequiredToBeBribedForMBakuToWin;
}

makeMBakuWinTheElections([5, 1, 11, 2, 8]);
makeMBakuWinTheElections([9, 6, 9, 9, 9, 9, 9, 9, 9, 9]);
makeMBakuWinTheElections([0, 2, 9, 9, 11]);
makeMBakuWinTheElections([8, 10, 9, 8, 7]);