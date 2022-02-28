import java.util.HashMap;
import java.util.HashSet;

//TODO: revisit
class TrieNode {
    HashMap<Character, TrieNode> map;
    boolean endOfWord;

    public TrieNode() {
        map = new HashMap<Character, TrieNode>();
        endOfWord = false;
    }

    public void append(String word) {
        TrieNode curr = this;
        for (char c : word.toCharArray()) {
            if (!curr.map.containsKey(c)) {
                curr.map.put(c, new TrieNode());
            }

            curr = curr.map.get(c);
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = this;
        for (char x : word.toCharArray()) {
            if (!curr.map.containsKey(x))
                return false;
            curr = curr.map.get(x);
        }

        return curr.endOfWord;
    }
}

public class hw_q2_mS {

    public String solve(String[] A, String[] B) {

        int m = B.length;

        TrieNode root = new TrieNode();
        HashSet<String> hs = new HashSet<>();
        for (String word : A) {
            root.append(word);
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String word = B[i];
            int len = word.length();
            hs.add(word);
            char[] w = word.toCharArray();
            boolean ret = false;

            for (int j = 0; j < len; j++) {
                char old = w[j];
                for (char k = 'a'; k <= 'z'; k++) {
                    w[j] = k;
                    String str = new String(w);
                    if (hs.contains(str))
                        continue;
                    ret = root.search(str);
                    if (ret)
                        break;
                }
                if (!ret)
                    w[j] = old;
                else
                    break;
            }
            if (ret)
                ans.append(1);
            else
                ans.append(0);
        }

        return new String(ans);
    }

    public static void main(String[] args) {
        String[] A = new String[] { "data", "circle", "cricket" };
        String[] B = new String[] { "date", "circel", "crikket", "data", "circl", "cata" };

        hw_q2_mS obj = new hw_q2_mS();
        String out = obj.solve(A, B); // 10100
        System.out.println(out);
    }
}
