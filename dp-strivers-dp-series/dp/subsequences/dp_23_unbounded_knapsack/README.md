## Unbounded Knapsack
Infinite supply of items

### Problem Statement
Given a knapsack with capacity `W` and a set of `n` items with their respective weights and values, find the maximum value that can be obtained by filling the knapsack with the given items. You cannot break an item, either pick the complete item or don’t pick it (0-1 property).
There is an infinite supply of each item.

### Example
n = 3
W = 9
values = [1 2 3]
weights = [1 3 5]

- 1 2 3 4 5 6 7 8 9 
- 1 2 3 4 5 6 7 8 9 
- 1 2 3 4 5 6 7 8 9


n = 3
w = 15
values = [7 2 4]
weights = [5 10 20]

* 0 0 0 0 0 7 7 7 7 7 14 14 14 14 14 21 
* 0 0 0 0 0 7 7 7 7 7 14 14 14 14 14 21 
* 0 0 0 0 0 7 7 7 7 7 14 14 14 14 14 21