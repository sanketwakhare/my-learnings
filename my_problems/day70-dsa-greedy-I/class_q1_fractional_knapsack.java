/**
 * Fractional KnapSack problem
 * 
 * Given array A => where A[i] represents no of items at i
 * array B => where B[i] represents total price of all items in A[i]
 * integer K => capacity of bag
 * 
 * Spend the max value/money by picking bag full of items
 * choose K items such that you spend max value [get top K expensive items]
 * 
 * Return the max amount/money which can be spent
 * 
 * NOTE: Picking fractional items not allowed. Either pick all items of a
 * product or
 * no items from
 * ith index
 */
public class class_q1_fractional_knapsack {

    public static void main(String[] args) {

        class_q1_fractional_knapsack t1 = new class_q1_fractional_knapsack();

        // A[i] = no of item at index i
        int[] A = new int[] { 10, 20, 30 };
        // B[i] = price of all items at A[i]
        int[] B = new int[] { 60, 100, 120 };
        int K = 50;
        // choose K items such that you spend max value [get top K expensive items]
        System.out.println(t1.solve(A, B, K)); // 240

        A = new int[] { 100, 40, 70, 30, 40 };
        B = new int[] { 600, 200, 280, 240, 800 };
        K = 100;
        System.out.println(t1.solve(A, B, K)); // 1220
    }

    public int solve(int[] A, int[] B, int bagSize) {

        // build inventory items
        InventoryItem[] items = new InventoryItem[A.length];
        for (int i = 0; i < A.length; i++) {
            int pricePerItem = B[i] / A[i];
            items[i] = new InventoryItem(A[i], pricePerItem);
        }

        // TODO:
        int moneySpent = 0;
        return moneySpent;
    }

    class InventoryItem implements Comparable<InventoryItem> {
        int totalItems;
        int itemPrice;

        public InventoryItem(int totalItems, int itemPrice) {
            this.totalItems = totalItems;
            this.itemPrice = itemPrice;
        }

        // sort in descending order
        @Override
        public int compareTo(InventoryItem o) {
            return o.itemPrice - this.itemPrice;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(" price:" + itemPrice);
            sb.append(", totalItems:" + totalItems);
            sb.append("]");
            return super.toString();
        }
    }

}
