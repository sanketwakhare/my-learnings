public class ArrayUtils {

    public static void printArray(int[] A) {
        System.out.print("[ ");
        int i = 0;
        for (int temp : A) {
            if (i == A.length - 1)
                System.out.print(temp);
            else
                System.out.print(temp + ", ");
            i++;
        }
        System.out.print(" ]");
        System.out.println();
    }

    public static String print2DArray(int[][] A) {

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < A.length; i++) {
            if (i != 0) {
                sb.append(" [");
            } else {
                sb.append("[");
            }
            for (int j = 0; j < A[0].length; j++) {
                sb.append(A[i][j] + ", ");
            }
            sb.replace(sb.length() - 2, sb.length(), "");
            sb.append("],\n");
        }
        sb.replace(sb.length() - 2, sb.length(), "");
        sb.append("]");
        System.out.println(sb.toString());
        return sb.toString();

    }

}
