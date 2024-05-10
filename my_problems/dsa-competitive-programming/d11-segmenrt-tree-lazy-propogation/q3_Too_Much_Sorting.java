import java.util.Arrays;
import java.util.Comparator;

/*
Too Much Sorting

 */
public class q3_Too_Much_Sorting {
    public static void main(String[] args) {
        q3_Too_Much_Sorting t = new q3_Too_Much_Sorting();
        {
            String A = "8408780";
            int[] T = {1, 1, 1, 1, 2, 2};
            int[] L = {1, 3, 1, 3, 3, 1};
            int[] R = {3, 5, 4, 6, 7, 3};
            String answer = t.solve(A, T, L, R);
            System.out.println(answer);
        }
    }

    public String solve(String A, int[] T, int[] L, int[] R) {
        int n = A.length();
        String[] seg = new String[n * 4];
        int[] lazy = new int[n * 4];
        build(0, 0, n - 1, A, seg);

        for (int i = 0; i < T.length; i++) {
            int l = L[i] - 1;
            int r = R[i] - 1;
            int type = T[i];
            // sort asc or desc based on type
            update(0, 0, n - 1, l, r, seg, lazy, type == 1);
        }

        return seg[0];
    }

    private void updateLazy(int[] lazy, int index, boolean isAsc) {
        if (lazy[index] == 0) {
            lazy[index] = isAsc ? 1 : -1;
        } else if (lazy[index] > 0) {
            if (!isAsc) {
                lazy[index] = -1;
            }
        } else if (lazy[index] < 0) {
            if (isAsc) {
                lazy[index] = 1;
            }
        }
    }

    private void update(int currIndex, int start, int end, int l, int r, String[] seg, int[] lazy, boolean isAsc) {
        int leftChildIndex = 2 * currIndex + 1;
        int rightChildIndex = 2 * currIndex + 2;

        if (lazy[currIndex] != 0) {
            // sort
            seg[currIndex] = sortString(seg[currIndex], isAsc);
            if (start != end) {
                updateLazy(lazy, leftChildIndex, isAsc);
                updateLazy(lazy, rightChildIndex, isAsc);
            }
            // reset
            lazy[currIndex] = 0;
        }

        // disjoint
        if (start > r || l > end) {
            return;
        }
        // overlapping
        if (start >= l && end <= r) {
            if (lazy[currIndex] > 0) {
                seg[currIndex] = sortString(seg[currIndex], isAsc);
            } else if (lazy[currIndex] < 0) {
                seg[currIndex] = sortString(seg[currIndex], isAsc);
            }
            if (start != end) {
                updateLazy(lazy, leftChildIndex, isAsc);
                updateLazy(lazy, rightChildIndex, isAsc);
            }
            return;
        }

        int mid = start + (end - start) / 2;
        update(leftChildIndex, start, mid, l, r, seg, lazy, isAsc);
        update(rightChildIndex, mid + 1, end, l, r, seg, lazy, isAsc);
    }

    public String sortString(String inputString, boolean isAsc) {
        char[] tempArray = inputString.toCharArray();
        Arrays.sort(tempArray);
        StringBuilder sb = new StringBuilder(new String(tempArray));
        if (!isAsc) {
            sb.reverse();
        }
        return sb.toString();
    }

    public void build(int currIndex, int start, int end, String A, String[] seg) {
        if (start == end) {
            char ch = A.charAt(start);
            seg[currIndex] = String.valueOf(ch);
            return;
        }
        int mid = start + (end - start) / 2;
        int leftChildIndex = 2 * currIndex + 1;
        int rightChildIndex = 2 * currIndex + 2;
        build(leftChildIndex, start, mid, A, seg);
        build(rightChildIndex, mid + 1, end, A, seg);

        String str = (seg[leftChildIndex] != null ? seg[leftChildIndex] : "") +
                (seg[rightChildIndex] != null ? seg[rightChildIndex] : "");
        seg[currIndex] = sortString(str, true);
    }
}
