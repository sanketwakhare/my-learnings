import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// TODO: solution not working - getting memory limit error - Heap space exceeded
public class q3_Make_Circle_Kosaraju {

    // Maintain in degree and out degree arrays
    int[] inDegree, outDegree;

    public int solve(String[] A) {

        inDegree = new int[26];
        outDegree = new int[26];

        // build adjacency list using HashMAp
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        List<List<Integer>> transposeList = new ArrayList<List<Integer>>();
        if (!buildAdjList(A, adjList, transposeList)) {
            return 0;
        }

        // Apply DFS using original adjacency list
        boolean[] visited = new boolean[A.length];
        Stack<Integer> stack = new Stack<Integer>();
        int source = 0;
        fillDFS(source, adjList, visited, stack);

        // pop an element from stack and apply DFS on Transpose adjacency list
        int newSource = stack.pop();
        visited = new boolean[A.length];
        List<Integer> dfsPath = new ArrayList<Integer>();
        dfs(newSource, transposeList, visited, dfsPath);

        if (dfsPath.size() != A.length) {
            return 0;
        }
        return 1;
    }

    private void dfs(int newSource, List<List<Integer>> transposeList, boolean[] visited, List<Integer> dfsPath) {
        visited[newSource] = true;
        dfsPath.add(newSource);
        List<Integer> neighbors = transposeList.get(newSource);
        for (Integer neighbor : neighbors) {
            if (!visited[neighbor]) {
                dfs(neighbor, transposeList, visited, dfsPath);
            }
        }
    }

    private void fillDFS(int source, List<List<Integer>> adjList, boolean[] visited,
            Stack<Integer> stack) {

        visited[source] = true;
        List<Integer> neighbors = adjList.get(source);
        for (Integer neighbor : neighbors) {
            if (!visited[neighbor]) {
                fillDFS(neighbor, adjList, visited, stack);
            }
        }
        stack.add(source);
    }

    private boolean buildAdjList(String[] A, List<List<Integer>> adjList,
            List<List<Integer>> transposeList) {

        // build inDegree and outDegree array
        for (int i = 0; i < A.length; i++) {
            String str1 = A[i];
            char startChar = str1.charAt(0);
            char endChar = str1.charAt(str1.length() - 1);
            inDegree[startChar - 'a']++;
            outDegree[endChar - 'a']++;
        }

        // if in degree and out degree are not matching, return false
        for (int i = 0; i < 26; i++) {
            if (inDegree[i] != outDegree[i])
                return false;
        }

        // initialize lists
        for (int i = 0; i < A.length; i++) {
            adjList.add(new ArrayList<Integer>());
            transposeList.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < A.length; i++) {
            String fromStr = A[i];
            char u = fromStr.charAt(fromStr.length() - 1);
            for (int j = 0; j < A.length; j++) {
                if (i != j) {
                    String toStr = A[j];
                    char v = toStr.charAt(0);
                    if (u == v) {
                        adjList.get(i).add(j);
                        transposeList.get(j).add(i);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        q3_Make_Circle_Kosaraju t1 = new q3_Make_Circle_Kosaraju();
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
}
