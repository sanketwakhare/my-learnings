import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO: solution not working
public class q3_Make_Circle {

    // Maintain a count variable and apply DFS considering source as any node
    int count = 0;
    int[] inDegree, outDegree;

    public int solve(String[] A) {

        count = 0;
        inDegree = new int[26];
        outDegree = new int[26];

        // build adjacency list using HashMAp
        Map<Character, List<Integer>> map = buildAdjList(A);

        // if in degree and out degree are not matching, return false
        for (int i = 0; i < 26; i++) {
            if (inDegree[i] != outDegree[i])
                return 0;
        }

        boolean[] visited = new boolean[A.length];
        boolean flag = false;

        int source = 0;
        flag = dfsTraversal(source, A, map, visited);

        return flag == true ? 1 : 0;
    }

    private Map<Character, List<Integer>> buildAdjList(String[] A) {

        Map<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();

        for (int i = 0; i < A.length; i++) {

            String str1 = A[i];
            char startChar = str1.charAt(0);
            if (map.containsKey(startChar)) {
                map.get(startChar).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(startChar, list);
            }

            char endChar = str1.charAt(str1.length() - 1);

            inDegree[startChar - 'a']++;
            outDegree[endChar - 'a']++;

        }
        return map;
    }

    private boolean dfsTraversal(int source, String[] A, Map<Character, List<Integer>> map, boolean[] visited) {

        if (count == A.length && visited[source]) {
            return true;
        }

        if (!visited[source]) {
            visited[source] = true;
            count++;

            String sourceStr = A[source];
            List<Integer> neighbors = map.get(sourceStr.charAt(sourceStr.length() - 1));

            if (neighbors == null) {
                return false;
            }
            for (int i = 0; i < neighbors.size(); i++) {
                int target = neighbors.get(i);
                if (A[target] != A[source]
                        && ((!visited[target] && count < A.length) || (visited[target] && count == A.length))) {
                    if (dfsTraversal(target, A, map, visited)) {
                        return true;
                    }
                    count--;
                    visited[target] = false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        q3_Make_Circle t1 = new q3_Make_Circle();
        String[] A;
        {
            A = new String[] { "aab", "bac", "aaa", "cda" };
            System.out.println(t1.solve(A));
            A = new String[] { "da", "bc", "cd", "ab" };
            System.out.println(t1.solve(A));
            A = new String[] { "ihgg", "gigfi", "hggii", "gh", "ihhfhfh" };
            System.out.println(t1.solve(A));
            A = new String[] { "g", "ggfhhgfi", "ihifhhgf" };
            System.out.println(t1.solve(A));
        }

    }

    /*
     * Topological sorting- not working
     * public int solve(String[] A) {
     * 
     * List<List<Integer>> list = new ArrayList<List<Integer>>();
     * int[] inDegree = new int[26];
     * for (int i = 0; i < 26; i++) {
     * list.add(new ArrayList<Integer>());
     * inDegree[i] = -1;
     * }
     * 
     * for (int i = 0; i < A.length; i++) {
     * String str = A[i];
     * int u = str.charAt(0) - 'a';
     * int v = str.charAt(str.length() - 1) - 'a';
     * if (u != v) {
     * list.get(u).add(v);
     * if (inDegree[u] == -1)
     * inDegree[u] = 0;
     * if (inDegree[v] == -1)
     * inDegree[v] = 0;
     * }
     * }
     * for (int i = 0; i < list.size(); i++) {
     * int u = i;
     * int v = -1;
     * List<Integer> neighbors = list.get(i);
     * if (neighbors.size() > 0 && inDegree[u] == -1) {
     * inDegree[u] = 0;
     * }
     * for (int j = 0; j < neighbors.size(); j++) {
     * v = neighbors.get(j);
     * inDegree[v]++;
     * }
     * }
     * 
     * // Apply Topological sorting
     * int noOfNodes = 0;
     * Queue<Integer> queue = new LinkedList<Integer>();
     * for (int i = 0; i < inDegree.length; i++) {
     * if (inDegree[i] == 0) {
     * queue.add(i);
     * }
     * if (inDegree[i] != -1) {
     * noOfNodes++;
     * }
     * }
     * 
     * List<Integer> path = new ArrayList<Integer>();
     * while (!queue.isEmpty()) {
     * int x = queue.poll();
     * path.add(x);
     * List<Integer> neighbors = list.get(x);
     * for (int i = 0; i < neighbors.size(); i++) {
     * int child = neighbors.get(i);
     * inDegree[child]--;
     * if (inDegree[child] == 0) {
     * queue.add(child);
     * }
     * }
     * }
     * 
     * if (path.size() == noOfNodes) {
     * return 0;
     * }
     * 
     * return 1;
     * }
     */
}
