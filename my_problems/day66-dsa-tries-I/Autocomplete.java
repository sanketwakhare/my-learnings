import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Autocomplete {

    public static void main(String[] args) {

        Autocomplete t1 = new Autocomplete();
        {
            String[] A = new String[] { "abcd", "aecd", "abaa", "abef", "acdcc", "acbcc"
            };
            int[] W = new int[] { 2, 1, 3, 4, 6, 5 };
            String[] P = new String[] { "ab", "abc", "a" };
            t1.solve(A, W, P);
        }

        {
            String[] A = new String[] { "aaaa", "aacd", "abaa", "abaa", "aadcc" };
            int[] W = new int[] { 3, 4, 1, 2, 6 };
            String[] P = new String[] { "aa", "aba", "abc" };
            t1.solve(A, W, P);
        }

        {
            String[] A = new String[] { "bbd", "cbbdec", "eaedbcdd", "bbddc", "ccced",
                    "ed", "aacdbac", "dbaae", "a",
                    "bddedee", "abbbdee", "dcddceb", "aede", "c" };
            int[] W = new int[] { 35, 8, 54, 12, 21, 46, 27, 19, 66, 76, 32, 58, 69, 36
            };
            String[] P = new String[] { "a", "eaedbcd", "eaedb", "cbb", "ccced", "cbbd",
                    "a", "ccce" };
            t1.solve(A, W, P);
        }

    }

    public void solve(String[] A, int[] W, String[] P) {

        // Step 1: Sort the input strings by weights
        List<Pair> list = new ArrayList<Pair>();
        for (int i = 0; i < A.length; i++) {
            String word = A[i];
            int wt = W[i];
            list.add(new Pair(word, wt));
        }
        Collections.sort(list);

        // Step 2: Build the Trie
        TrieNode root = buildTrie(list);

        // Step 3: for each prefix, get the list of indices/output strings
        for (int i = 0; i < P.length; i++) {
            String prefix = P[i];
            List<Integer> indices = root.getIndices(prefix);
            // print strings
            if (indices.size() == 0) {
                System.out.println(-1);
            } else {
                StringBuilder sb = new StringBuilder();
                for (int index : indices) {
                    sb.append(list.get(index) + " ");
                }
                System.out.println(sb.toString());
            }
        }
        System.out.println("done\n");
    }

    // Build Trie
    private TrieNode buildTrie(List<Pair> words) {
        TrieNode root = new TrieNode('$');

        for (int index = 0; index < words.size(); index++) {
            String word = words.get(index).inputText;
            root.insertWord(word, index);
        }
        return root;
    }

    // custom class for sorting the inputs words by weights
    class Pair implements Comparable<Pair> {
        String inputText;
        // weight will be only used for sorting the input strings
        int weight;

        // constructor
        public Pair(String inputText, int weight) {
            this.inputText = inputText;
            this.weight = weight;
        }

        @Override
        public int compareTo(Autocomplete.Pair o) {
            // sort in descending order of weights
            return o.weight - this.weight;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            // sb.append(weight);
            sb.append(inputText);
            return sb.toString();
        }
    }

    // TrieNode custom class
    class TrieNode {
        Character data;
        Map<Character, TrieNode> children;
        // maintain indices of the string which are part of the current prefix
        List<Integer> indices;
        boolean isLeaf;

        // constructor
        public TrieNode(Character data) {
            this.data = data;
            children = new HashMap<Character, TrieNode>();
            // store max 5 indices
            indices = new ArrayList<Integer>(5);
            isLeaf = false;
        }

        // insert word into Trie
        public void insertWord(String word, int index) {
            TrieNode parent = this;
            for (int i = 0; i < word.length(); i++) {
                Character ch = word.charAt(i);
                boolean isLeaf = i == word.length() - 1;
                if (!parent.children.containsKey(ch)) {
                    parent.insertCharacter(ch, index, isLeaf);
                } else {
                    // add 5 indexes max
                    if (parent.children.get(ch).indices.size() < 5) {
                        parent.children.get(ch).indices.add(index);
                    }
                    // update isLeaf to true only when it is not already tru and current character
                    // is last
                    if (parent.children.get(ch).isLeaf == false && isLeaf) {
                        parent.children.get(ch).isLeaf = isLeaf;
                    }
                }
                // go to the next character in Trie
                parent = parent.children.get(ch);
            }
        }

        // insert a single character into Trie
        public void insertCharacter(Character ch, int index, boolean isLeaf) {
            // insert character into Trie
            TrieNode child = new TrieNode(ch);
            child.indices.add(index);
            child.isLeaf = isLeaf;
            this.children.put(ch, child);
        }

        // get indices list for a given prefix from Trie
        public List<Integer> getIndices(String prefix) {

            TrieNode parent = this;
            // traverse till prefix and get the indices associated with it
            for (int i = 0; i < prefix.length(); i++) {
                Character ch = prefix.charAt(i);
                if (parent.children.containsKey(ch)) {
                    parent = parent.children.get(ch);
                } else {
                    parent = null;
                    break;
                }
            }
            // return indices for a prefix
            // if prefix is not present return empty list of indices
            List<Integer> indices = parent != null ? parent.indices : new ArrayList<Integer>();
            return indices;
        }

    }
}
