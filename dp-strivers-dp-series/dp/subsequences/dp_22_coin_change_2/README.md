## Coin Change 2

**f(n, target) represents the number of ways to make the target using the first n coins.**


f(index, target) {

    // base case
    if(index == 0) {
        if(target % coins[0] == 0) {
            return 1;
        }
        return 0;
    }

    int notPick = f(index - 1, target);
    int pick = 0;
    if(coins[index - 1] <= target) {
        // pick the coin and reduce the target
        // stay on the same coin as we can pick it again
        pick = f(index, target - coins[index - 1]);
    }
    return notPick + pick;
}