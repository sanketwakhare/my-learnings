import java.util.ArrayList;
import java.util.Scanner;

// Given input:

public class hw_q1_flattenNestedLinkedList {
    ///input part
    Scanner sc;

    public static void main(String[] args) {
        new hw_q1_flattenNestedLinkedList().solve();
    }

    NestedInteger recu(NestedInteger x, int n) {
        for (int i = 0; i < n; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                int num = sc.nextInt();
                NestedInteger ni = new NestedInteger(num);
                x.getList().add(ni);
            } else {
                NestedInteger ni = new NestedInteger((int) 1e9);
                x.getList().add(recu(ni, n - (i + 1)));
                break;
            }
        }
        return x;
    }

    void solve() {
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            ArrayList<NestedInteger> v = new ArrayList<>();
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int type = sc.nextInt();
                if (type == 1) {
                    int x = sc.nextInt();
                    NestedInteger ni = new NestedInteger(x);
                    v.add(ni);
                } else {
                    int x = (int) 1e9;
                    NestedInteger ni = new NestedInteger(x);
                    v.add(recu(ni, n - (i + 1)));
                    break;
                }
            }
            NestedIterator i = new NestedIterator(v);
            while (i.hasNext()) System.out.print(i.next() + " ");
            System.out.println();
        }
        sc.close();
    }

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation.
}

class NestedInteger {
    Integer integer;
    ArrayList<NestedInteger> lis;
    ArrayList<NestedInteger> temp;

    NestedInteger(int x) {
        integer = x;
        lis = new ArrayList<>();
        temp = new ArrayList<>();
    }

    // Return true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger() {
        return integer != 1e9;
    }

    // Return the single integer that this NestedInteger holds, if it holds a single integer.
    // The result is 1e9 if this NestedInteger holds a nested list.
    int getInteger() {
        return integer;
    }

    // Return the nested list that this NestedInteger holds, if it holds a nested list.
    // The result is an empty ArrayList if this NestedInteger holds a single integer.
    ArrayList<NestedInteger> getList() {
        if (integer != 1e9) {
            return temp;
        }
        return lis;
    }
}


// Solution:

class NestedIterator {

    // maintain nested integer list and its current position
    ArrayList<NestedInteger> dataList;
    int current = 0;

    NestedIterator(ArrayList<NestedInteger> nestedList) {
        this.current = 0;
        this.dataList = nestedList;
    }

    int next() {
        NestedInteger nestedIntOrList = dataList.get(current++);

        if (!nestedIntOrList.isInteger()) {
            // if the next element is list, calculate the size of nested elements
            // print size -1 elements and return last element as next() function expects to return integer
            ArrayList<NestedInteger> temp = nestedIntOrList.getList();
            NestedIterator nestedItr = new NestedIterator(temp);
            int size = nestedItr.dataList.size();
            int i = 0;
            while (i < size - 1) {
                System.out.print(nestedItr.next() + " ");
                i++;
            }
            return nestedItr.next();
        }
        // if not list, return integer
        return nestedIntOrList.getInteger();
    }

    boolean hasNext() {
        return current < dataList.size();
    }
}


// https://codeshare.io/r9qOWq required prerequisite code is shared by mentor at


