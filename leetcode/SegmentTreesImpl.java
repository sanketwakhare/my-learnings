public class SegmentTreesImpl {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 5, 7};
        SegmentTree root = new SegmentTree(nums, 0, nums.length - 1);
        System.out.println("done1");

        root.update(3, 4);
        System.out.println("done2");

        System.out.println("sum " + root.sum(0, 2));
        System.out.println("sum " + root.sum(1, 2));
        System.out.println("sum " + root.sum(0, 3));
        System.out.println("sum " + root.sum(3, 2));

        //["NumArray","sumRange","sumRange","sumRange","update","update","update","sumRange","update","sumRange","update"]
        //[[[0,9,5,7,3]],[4,4],[2,4],[3,3],[4,5],[1,7],[0,8],[1,2],[1,9],[4,4],[3,4]]

        nums = new int[]{0, 9, 5, 7, 3};
        root = new SegmentTree(nums, 0, nums.length - 1);

        System.out.println("sum " + root.sum(4, 4));
        System.out.println("sum " + root.sum(2, 4));
        System.out.println("sum " + root.sum(3, 3));

        root.update(4, 5);
        root.update(1, 7);
        root.update(0, 8);

        System.out.println("sum " + root.sum(1, 2));
        root.update(1, 9);
        System.out.println("sum " + root.sum(4, 4));
        root.update(3, 4);
    }
}

class SegmentTree {
    int val;
    SegmentTree left;
    SegmentTree right;
    int start;
    int end;

    public SegmentTree(int[] nums, int start, int end) {
        if (start == end) {
            this.val = nums[start];
            this.start = this.end = start;
        } else {
            int mid = start + (end - start) / 2;
            this.left = new SegmentTree(nums, start, mid);
            this.right = new SegmentTree(nums, mid + 1, end);
            this.val = this.left.val + this.right.val;
            this.start = Math.min(this.left.start, this.right.start);
            this.end = Math.max(this.left.end, this.right.end);
        }
    }

    public void update(int index, int val) {
        if (this.left == this.right) {
            this.val = val;
        } else {
            int mid = this.start + (this.end - this.start) / 2;
            if (index <= mid) {
                this.left.update(index, val);
            } else {
                this.right.update(index, val);
            }
            this.val = this.left.val + this.right.val;
        }
    }

    public int sum(int start, int end) {
        if (start > end) return 0;
        if (start == this.start && end == this.end) return this.val;
        int mid = this.start + (this.end - this.start) / 2;
        return this.left.sum(start, Math.min(mid, end)) + this.right.sum(Math.max(mid + 1, start), end);
    }
}


//A = [2, 4, 5, 7]
//
//
//              23[0,3]
//            /           \
//        6[0,1]          17[2,3]
//        /   \          /    \
//    2[0,0]  4[1,1]  10[2,2]  7[3,3]
//
//
//[0,2] = [0,3] - [3,3] = 18 - 7 = 11
//[0,2] = mid = 1