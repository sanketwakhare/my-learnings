import java.util.HashMap;
import java.util.Map;

public class hw_q5_LongestCommonPrefix_Trie {

    class TrieNode {
        Character data;
        Map<Character, TrieNode> children;
        boolean isLeaf;
        int freq;

        public TrieNode(Character data) {
            this.data = data;
            this.children = new HashMap<>();
            this.isLeaf = true;
            this.freq = 0;
        }

        public void insertChar(char data, boolean isLeaf) {
            TrieNode child = new TrieNode(data);
            child.freq += 1;
            child.isLeaf = isLeaf;
            this.children.put(data, child);
        }

        public void insertWord(String word) {
            TrieNode parent = this;
            for(int i=0; i<word.length(); i++) {
                Character ch = word.charAt(i);
                boolean isLeaf = i == word.length() - 1;
                if(parent.children.containsKey(ch)) {
                    TrieNode currNode = parent.children.get(ch);
                    currNode.freq += 1;
                    if(!currNode.isLeaf)
                        currNode.isLeaf = isLeaf;
                } else {
                    parent.insertChar(ch, isLeaf);
                }
                parent = parent.children.get(ch);
            }
        }

        public String getCommonPrefix(int totalWords) {
            StringBuilder commonPrefix = new StringBuilder();
            if(this == null) return commonPrefix.toString();
            TrieNode curr = this;
            boolean done = false;
            while(!done && curr != null) {
                boolean isFreqMatching = false;
                for(Map.Entry<Character, TrieNode> entry: curr.children.entrySet()) {
                    Character ch = entry.getKey();
                    TrieNode value = entry.getValue();
                    if(value.freq == totalWords) {
                        commonPrefix.append(ch);
                        curr = value;
                        isFreqMatching = true;
                        break;
                    }
                }
                if(!isFreqMatching) {
                    done = true;
                }
            }
            return commonPrefix.toString();
        }
    }

    public String longestCommonPrefix(String[] A) {

        int n = A.length;
        TrieNode root = new TrieNode('#');
        for(int i=0; i<A.length; i++) {
            String word = A[i];
            root.insertWord(word);
        }
        // find a last character with freq matching n
        String commonPrefix = root.getCommonPrefix(n);
        return commonPrefix;

    }

    public static void main(String[] args) {
        hw_q5_LongestCommonPrefix_Trie obj = new hw_q5_LongestCommonPrefix_Trie();
        String[] A = {"abcdefgh", "abfghijk", "abcefgh"};
        String commonPrefix = obj.longestCommonPrefix(A);
        System.out.println(commonPrefix);
    }
}
