## Minimum Coins

* arr = [1, 2, 3] denominations
* target = 7

find the minimum no of coins required to make a target.

### Approach:

Greedy fails

* arr = [9, 6, 5, 1]
* expected ans = 2 [5, 6]
* but with greedy we will get 3 as [1, 1, 9]

Try out all the combination and take the combination that has minimum coins.

#### 1. Recursive Approach

* Express recurrence in terms of Index and Target
* Express all possibilities
    * either take the coin
    * or don't take the coin
* f(index, target) represents the minimum no of coins required to make a target using coins from 0 to index

```
f(index, target) = min(f(index, target - arr[index]) + 1, f(index - 1, target))

f(index, target) {

    // base case
    if(index == 0) {
        if(target % arr[index] == 0) {
            return target / arr[index];
        } else {
            // not possible to achieve target
            return Integer.MAX_VALUE;
        }
    }

    int notPick = 0 + f(index -1, target);
    int pick = Integer.MAX_VALUE;
    if(target - arr[index] >= 0) {
        // here index will still be same as we can pick the same coin again
        pick = 1 + f(index, target - arr[index]);
    }
    return min(pick, notPick);
}
```

