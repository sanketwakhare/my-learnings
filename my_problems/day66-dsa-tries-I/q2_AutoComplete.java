
//TODO: revisit
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

class TrieNode1 {
    Character data;
    Map<Character, TrieNode1> children;
    // Set<TrieNode1> children;
    boolean isEnd;
    int freq;

    public TrieNode1(Character data) {
        this.data = data;
        // children = new LinkedHashSet<TrieNode1>();
        children = new LinkedHashMap<Character, TrieNode1>();
        isEnd = false;
        freq = 0;
    }
}

class CustomType {
    String str;
    int weight;

    public CustomType(String str, int weight) {
        this.str = str;
        this.weight = weight;
    }
}

public class q2_AutoComplete {

    public static void main(String[] args) {

        // String[] A = new String[] { "abcd", "aecd", "abaa", "abef", "acdcc", "acbcc"
        // };
        // int[] W = new int[] { 2, 1, 3, 4, 6, 5 };
        // String[] P = new String[] { "ab", "abc", "a" };

        // String[] A = new String[] { "aaaa", "aacd", "abaa", "abaa", "aadcc" };
        // int[] W = new int[] { 3, 4, 1, 2, 6 };
        // String[] P = new String[] { "aa", "aba", "abc" };

        String[] A = new String[] { "bbd", "cbbdec", "eaedbcdd", "bbddc", "ccced", "ed", "aacdbac", "dbaae", "a",
                "bddedee", "abbbdee", "dcddceb", "aede", "c" };
        int[] W = new int[] { 35, 8, 54, 12, 21, 46, 27, 19, 66, 76, 32, 58, 69, 36 };
        String[] P = new String[] { "a", "eaedbcd", "eaedb", "cbb", "ccced", "cbbd", "a", "ccce" };

        ArrayList<CustomType> list = new ArrayList<CustomType>();
        for (int i = 0; i < A.length; i++) {
            list.add(new CustomType(A[i], W[i]));
        }

        list.sort(new Comparator<CustomType>() {
            @Override
            public int compare(CustomType o1, CustomType o2) {
                if (o1.weight < o2.weight) {
                    return 1;
                } else if (o1.weight > o2.weight) {
                    return -1;
                }
                return 0;
            }
        });

        TrieNode1 trie = new TrieNode1('$');
        buildTrie(trie, list);

        for (String pfx : P) {
            ArrayList<String> pfWords = searchPrefix(trie, pfx);
            System.out.println(pfWords);

            ArrayList<CustomType> pfList = new ArrayList<CustomType>();
            for (int i = 0; i < pfWords.size(); i++) {
                String wrd = pfWords.get(i);
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).str.equals(wrd)) {
                        int wt = list.get(j).weight;
                        pfList.add(new CustomType(wrd, wt));
                        break;
                    }
                }
            }
            pfList.sort(new Comparator<CustomType>() {
                @Override
                public int compare(CustomType o1, CustomType o2) {
                    if (o1.weight < o2.weight) {
                        return 1;
                    } else if (o1.weight > o2.weight) {
                        return -1;
                    }
                    return 0;
                }
            });

            // for (CustomType lstItem : pfList) {
            // System.out.println(lstItem.str);
            // }
            System.out.println(pfList);

        }
    }

    private static ArrayList<String> searchPrefix(TrieNode1 trie, String pfx) {
        ArrayList<String> pfWords = new ArrayList<String>();

        TrieNode1 temp = trie;
        for (int i = 0; i < pfx.length(); i++) {
            Character currChar = pfx.charAt(i);
            if (temp.children.containsKey(currChar)) {
                temp = temp.children.get(currChar);
            } else {
                System.out.print("-1 ");
                return pfWords;
            }
        }

        // traverse preorder
        StringBuilder sb = new StringBuilder();
        retrieveWords(temp, pfWords, sb, pfx);
        return pfWords;
    }

    public static void retrieveWords(TrieNode1 root, ArrayList<String> pfWords, StringBuilder sb, String pfx) {

        if (root.isEnd) {
            if (pfWords.size() < 5) {
                int k = root.freq;
                while (k > 0) {
                    pfWords.add(pfx + sb.toString());
                    k--;
                }
            }
            if (root.children.size() == 0) {
                return;
            }
        }
        for (Entry<Character, TrieNode1> childEntry : root.children.entrySet()) {
            sb.append(childEntry.getKey());
            retrieveWords(childEntry.getValue(), pfWords, sb, pfx);
            sb = sb.delete(sb.length() - 1, sb.length());
        }
    }

    private static void buildTrie(TrieNode1 trie, ArrayList<CustomType> list) {

        for (CustomType item : list) {
            String word = item.str;
            TrieNode1 temp = trie;
            for (int i = 0; i < word.length(); i++) {
                char currData = word.charAt(i);
                TrieNode1 child;
                if (temp.children.containsKey(currData)) {
                    child = temp.children.get(currData);
                } else {
                    child = new TrieNode1(currData);
                    temp.children.put(currData, child);
                }
                temp = child;
            }
            temp.isEnd = true;
            temp.freq++;
        }
        System.out.println(trie);
    }

};