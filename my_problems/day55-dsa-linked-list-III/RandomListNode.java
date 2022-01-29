// Definition for singly-linked list with a random pointer.
public class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }

    @Override
    public String toString() {
        return this.label + " - " + super.toString();
    }
};