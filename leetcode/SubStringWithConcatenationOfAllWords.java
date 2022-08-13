import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubStringWithConcatenationOfAllWords {

    public static void main(String[] args) {

        SubStringWithConcatenationOfAllWords t1 = new SubStringWithConcatenationOfAllWords();

        String s = "barfoothefoobarman";
        String[] words = new String[]{"foo", "bar"};
        System.out.println(t1.findSubstring(s, words));

        s = "ababababab";
        words = new String[]{"ababa", "babab"};
        System.out.println(t1.findSubstring(s, words));
    }

    public List<Integer> findSubstring(String s, String[] words) {

        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            int currFreq = wordsMap.getOrDefault(word, 0);
            wordsMap.put(word, currFreq + 1);
        }

        List<Integer> result = new ArrayList<>();
        int n = s.length();
        int m = words[0].length();
        int windowSize = words.length * words[0].length();

        Map<String, Integer> mapCopy = deepCopy(wordsMap);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < windowSize; i++) {
            char currChar = s.charAt(i);
            sb.append(currChar);
            if ((i + 1) % m == 0) {
                String key = sb.toString();
                int currFreq = mapCopy.getOrDefault(key, 0);
                if (currFreq > 0) {
                    if (currFreq == 1) {
                        mapCopy.remove(key);
                    } else {
                        mapCopy.put(key, currFreq - 1);
                    }
                }
                sb = new StringBuilder();
            }
        }
        if (mapCopy.size() == 0) {
            result.add(0);
        }

        for (int i = 1; i <= n - windowSize; i++) {
            mapCopy = deepCopy(wordsMap);
            sb = new StringBuilder();
            for (int j = i; j < i + windowSize; j++) {
                char currChar = s.charAt(j);
                sb.append(currChar);
                if ((j - i + 1) % m == 0) {
                    String key = sb.toString();
                    int currFreq = mapCopy.getOrDefault(key, 0);
                    if (currFreq == 0) {
                        break;
                    }
                    if (currFreq > 0) {
                        if (currFreq == 1) {
                            mapCopy.remove(key);
                        } else {
                            mapCopy.put(key, currFreq - 1);
                        }
                    }
                    sb = new StringBuilder();
                }
            }
            if (mapCopy.size() == 0) {
                result.add(i);
            }
        }

        return result;
    }

    public Map<String, Integer> deepCopy(Map<String, Integer> map) {
        Map<String, Integer> copy = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            copy.put(key, value);
        }
        return copy;
    }
}
