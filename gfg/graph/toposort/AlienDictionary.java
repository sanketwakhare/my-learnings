package graph.toposort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

// Alien Dictionary
// https://practice.geeksforgeeks.org/problems/alien-dictionary/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=alien-dictionary

public class AlienDictionary {
    //{ Driver Code Starts
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("gfg/graph/resources/Alien_Dictionary.txt"));

        int t = Integer.parseInt(sc.next());
        while (t-- > 0) {
            int n = Integer.parseInt(sc.next());
            int k = Integer.parseInt(sc.next());

            String[] words = new String[n];

            for (int i = 0; i < n; i++) {
                words[i] = sc.next();
            }

            AlienDictionary ob = new AlienDictionary();
            //  System.out.println(T.findOrder(words,k));
            String order = ob.findOrder(words, n, k);
            if (order.length() == 0) {
                System.out.println(0);
                continue;
            }
            String[] temp = new String[n];
            System.arraycopy(words, 0, temp, 0, n);

            Arrays.sort(temp, (a, b) -> {
                int index1 = 0;
                int index2 = 0;
                for (int i = 0; i < Math.min(a.length(), b.length())
                        && index1 == index2; i++) {
                    index1 = order.indexOf(a.charAt(i));
                    index2 = order.indexOf(b.charAt(i));
                }

                if (index1 == index2 && a.length() != b.length()) {
                    if (a.length() < b.length())
                        return -1;
                    else
                        return 1;
                }

                if (index1 < index2)
                    return -1;
                else
                    return 1;

            });

            int flag = 1;
            for (int i = 0; i < n; i++) {
                if (!words[i].equals(temp[i])) {
                    flag = 0;
                    break;
                }
            }

            System.out.println(flag);
        }
    }
    // } Driver Code Ends

    public String findOrder(String[] dict, int N, int K) {
        // build graph and inDegree array
        int[] inDeg = new int[K];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int minLength = Math.min(s1.length(), s2.length());
            for (int p = 0; p < minLength; p++) {
                if (s1.charAt(p) != s2.charAt(p)) {
                    adjList.get(s1.charAt(p) - 'a').add(s2.charAt(p) - 'a');
                    inDeg[s2.charAt(p) - 'a']++;
                    break;
                }
            }
        }

        // initialize queue with all elements with 0 inDegree
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDeg.length; i++) {
            if (inDeg[i] == 0) {
                queue.add(i);
            }
        }

        List<Character> topoSortOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            topoSortOrder.add((char) (curr + 'a'));
            List<Integer> neighbors = adjList.get(curr);
            for (int neighbor : neighbors) {
                inDeg[neighbor]--;
                if (inDeg[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if (topoSortOrder.size() == K) {
            for (Character ch : topoSortOrder) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
