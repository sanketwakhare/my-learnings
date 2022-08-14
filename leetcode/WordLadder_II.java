import java.util.*;

public class WordLadder_II {

    public static void main(String[] args) {
        WordLadder_II t1 = new WordLadder_II();
        {
            String beginWord = "hit";
            String endWord = "cog";
            List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");
            List<List<String>> result = t1.findLadders(beginWord, endWord, wordList);
        }
//        {
//            String beginWord = "hot";
//            String endWord = "dog";
//            List<String> wordList = List.of("hot", "dog");
//            List<List<String>> result = t1.findLadders(beginWord, endWord, wordList);
//        }
//        {
//            String beginWord = "hit";
//            String endWord = "cog";
//            List<String> wordList = List.of("hot", "dot", "dog", "lot", "log");
//            List<List<String>> result = t1.findLadders(beginWord, endWord, wordList);
//        }
//        {
//            String beginWord = "qa";
//            String endWord = "sq";
//            List<String> wordList = List.of("si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye");
//            List<List<String>> result = t1.findLadders(beginWord, endWord, wordList);
//        }
        {
            String beginWord = "cet";
            String endWord = "ism";
            List<String> wordList = List.of("kid", "tag", "pup", "ail", "tun", "woo", "erg", "luz", "brr", "gay", "sip", "kay", "per", "val", "mes", "ohs", "now", "boa", "cet", "pal", "bar", "die", "war", "hay", "eco", "pub", "lob", "rue", "fry", "lit", "rex", "jan", "cot", "bid", "ali", "pay", "col", "gum", "ger", "row", "won", "dan", "rum", "fad", "tut", "sag", "yip", "sui", "ark", "has", "zip", "fez", "own", "ump", "dis", "ads", "max", "jaw", "out", "btu", "ana", "gap", "cry", "led", "abe", "box", "ore", "pig", "fie", "toy", "fat", "cal", "lie", "noh", "sew", "ono", "tam", "flu", "mgm", "ply", "awe", "pry", "tit", "tie", "yet", "too", "tax", "jim", "san", "pan", "map", "ski", "ova", "wed", "non", "wac", "nut", "why", "bye", "lye", "oct", "old", "fin", "feb", "chi", "sap", "owl", "log", "tod", "dot", "bow", "fob", "for", "joe", "ivy", "fan", "age", "fax", "hip", "jib", "mel", "hus", "sob", "ifs", "tab", "ara", "dab", "jag", "jar", "arm", "lot", "tom", "sax", "tex", "yum", "pei", "wen", "wry", "ire", "irk", "far", "mew", "wit", "doe", "gas", "rte", "ian", "pot", "ask", "wag", "hag", "amy", "nag", "ron", "soy", "gin", "don", "tug", "fay", "vic", "boo", "nam", "ave", "buy", "sop", "but", "orb", "fen", "paw", "his", "sub", "bob", "yea", "oft", "inn", "rod", "yam", "pew", "web", "hod", "hun", "gyp", "wei", "wis", "rob", "gad", "pie", "mon", "dog", "bib", "rub", "ere", "dig", "era", "cat", "fox", "bee", "mod", "day", "apr", "vie", "nev", "jam", "pam", "new", "aye", "ani", "and", "ibm", "yap", "can", "pyx", "tar", "kin", "fog", "hum", "pip", "cup", "dye", "lyx", "jog", "nun", "par", "wan", "fey", "bus", "oak", "bad", "ats", "set", "qom", "vat", "eat", "pus", "rev", "axe", "ion", "six", "ila", "lao", "mom", "mas", "pro", "few", "opt", "poe", "art", "ash", "oar", "cap", "lop", "may", "shy", "rid", "bat", "sum", "rim", "fee", "bmw", "sky", "maj", "hue", "thy", "ava", "rap", "den", "fla", "auk", "cox", "ibo", "hey", "saw", "vim", "sec", "ltd", "you", "its", "tat", "dew", "eva", "tog", "ram", "let", "see", "zit", "maw", "nix", "ate", "gig", "rep", "owe", "ind", "hog", "eve", "sam", "zoo", "any", "dow", "cod", "bed", "vet", "ham", "sis", "hex", "via", "fir", "nod", "mao", "aug", "mum", "hoe", "bah", "hal", "keg", "hew", "zed", "tow", "gog", "ass", "dem", "who", "bet", "gos", "son", "ear", "spy", "kit", "boy", "due", "sen", "oaf", "mix", "hep", "fur", "ada", "bin", "nil", "mia", "ewe", "hit", "fix", "sad", "rib", "eye", "hop", "haw", "wax", "mid", "tad", "ken", "wad", "rye", "pap", "bog", "gut", "ito", "woe", "our", "ado", "sin", "mad", "ray", "hon", "roy", "dip", "hen", "iva", "lug", "asp", "hui", "yak", "bay", "poi", "yep", "bun", "try", "lad", "elm", "nat", "wyo", "gym", "dug", "toe", "dee", "wig", "sly", "rip", "geo", "cog", "pas", "zen", "odd", "nan", "lay", "pod", "fit", "hem", "joy", "bum", "rio", "yon", "dec", "leg", "put", "sue", "dim", "pet", "yaw", "nub", "bit", "bur", "sid", "sun", "oil", "red", "doc", "moe", "caw", "eel", "dix", "cub", "end", "gem", "off", "yew", "hug", "pop", "tub", "sgt", "lid", "pun", "ton", "sol", "din", "yup", "jab", "pea", "bug", "gag", "mil", "jig", "hub", "low", "did", "tin", "get", "gte", "sox", "lei", "mig", "fig", "lon", "use", "ban", "flo", "nov", "jut", "bag", "mir", "sty", "lap", "two", "ins", "con", "ant", "net", "tux", "ode", "stu", "mug", "cad", "nap", "gun", "fop", "tot", "sow", "sal", "sic", "ted", "wot", "del", "imp", "cob", "way", "ann", "tan", "mci", "job", "wet", "ism", "err", "him", "all", "pad", "hah", "hie", "aim");
            List<List<String>> result = t1.findLadders(beginWord, endWord, wordList);
        }
    }

    static class QueuNode {
        String word;
        int distance;

        public QueuNode(String word, int distance) {
            this.word = word;
            this.distance = distance;
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();

        // create adjacency list
        Set<String> words = new HashSet<>(wordList);
        words.add(beginWord);
        Map<String, Set<String>> adjMap = buildAdjacencyMap(words);

        // apply BFS and find the shortest distance form beginWord to endWord
        int shortestDistance = bfsFindShortestDistance(beginWord, endWord, adjMap);

        // apply DFS till depth(the shortest distance) and store all paths
        List<String> currPath = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        currPath.add(beginWord);
        visited.add(beginWord);
        dfs(beginWord, endWord, adjMap, shortestDistance, currPath, result, visited);
        System.out.println(result);
        return result;
    }

    private void dfs(String beginWord, String endWord, Map<String, Set<String>> adjMap, int shortestDistance, List<String> currPath, List<List<String>> result, Set<String> visited) {

        if (currPath.size() == shortestDistance + 1 && beginWord.equals(endWord)) {
            // path found
            result.add(new ArrayList<>(currPath));
            return;
        }
        Set<String> neighbors = adjMap.getOrDefault(beginWord, new HashSet<>());
        for (String next : neighbors) {
            if (!visited.contains(next)) {
                currPath.add(next);
                visited.add(next);
                dfs(next, endWord, adjMap, shortestDistance, currPath, result, visited);
                visited.remove(next);
                currPath.remove(currPath.size() - 1);
            }
        }
    }

    private int bfsFindShortestDistance(String beginWord, String endWord, Map<String, Set<String>> adjMap) {
        Queue<QueuNode> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(new QueuNode(beginWord, 0));
        // mark as visited
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            QueuNode curr = queue.poll();
            String currWord = curr.word;
            int currDistance = curr.distance;
            if (currWord.equals(endWord)) {
                return currDistance;
            }
            Set<String> neighbors = adjMap.getOrDefault(currWord, new HashSet<>());
            for (String next : neighbors) {
                if (!visited.contains(next)) {
                    queue.add(new QueuNode(next, currDistance + 1));
                    // mark as visited
                    visited.add(next);
                }
            }
        }
        return 0;
    }

    private Map<String, Set<String>> buildAdjacencyMap(Set<String> words) {
        Map<String, Set<String>> adjMap = new HashMap<>();
        List<String> wordList;
        wordList = new ArrayList<>(words);
        for (int i = 0; i < wordList.size() - 1; i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                String word1 = wordList.get(i);
                String word2 = wordList.get(j);
                if (checkLadderWords(word1, word2)) {
                    Set<String> values1 = adjMap.getOrDefault(word1, new HashSet<>());
                    values1.add(word2);
                    Set<String> values2 = adjMap.getOrDefault(word2, new HashSet<>());
                    values2.add(word1);
                    adjMap.put(word1, values1);
                    adjMap.put(word2, values2);
                }
            }
        }
        return adjMap;
    }

    public boolean checkLadderWords(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
            }
        }
        return diffCount == 1;
    }
}
