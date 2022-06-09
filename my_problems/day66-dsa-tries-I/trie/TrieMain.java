package trie;

import java.io.*;

public class TrieMain {
    public static void main(String[] args) {
        // dictionary
        String[] words = new String[] { "mumbai", "bangalore", "pune", "hyderabad", "delhi", "dehradun", "mysore",
                "melbourne", "mardid", "paris", "panama", "mum" };

        // insert all words
        TrieNode root = new TrieNode('$');
        for (String word : words) {
            root.addWord(word);
        }

        // search word
        String wordToSearch = "mumbai";
        System.out.println(root.searchWord(wordToSearch) ? wordToSearch + " found" : wordToSearch + " not found");
        wordToSearch = "pune";
        System.out.println(root.searchWord(wordToSearch) ? wordToSearch + " found" : wordToSearch + " not found");
        wordToSearch = "nashik";
        System.out.println(root.searchWord(wordToSearch) ? wordToSearch + " found" : wordToSearch + " not found");
        wordToSearch = "yeola";
        System.out.println(root.searchWord(wordToSearch) ? wordToSearch + " found" : wordToSearch + " not found");

        // delete word
        String wordToRemove = "pune";
        boolean isRemoved = root.removeWord(wordToRemove);
        System.out.println(isRemoved ? wordToRemove + " is removed" : wordToRemove + " can not be removed");

        // delete word which is substring of another word
        wordToRemove = "mum";
        isRemoved = root.removeWord(wordToRemove);
        System.out.println(isRemoved ? wordToRemove + " is removed" : wordToRemove + " can not be removed");

        // write Trie to file
        writeTrieToFile(root);

        // read Trie from file
        TrieNode rootFromFile = readTrieFromFile("trie.txt");
        wordToSearch = "pune";
        System.out
                .println(rootFromFile.searchWord(wordToSearch) ? wordToSearch + " found" : wordToSearch + " not found");
        wordToSearch = "bangalore";
        System.out
                .println(rootFromFile.searchWord(wordToSearch) ? wordToSearch + " found" : wordToSearch + " not found");
        wordToSearch = "delhi";
        System.out
                .println(rootFromFile.searchWord(wordToSearch) ? wordToSearch + " found" : wordToSearch + " not found");

    }

    /**
     * Write TrieNode into file
     *
     * @param root root node of Trie
     */
    public static void writeTrieToFile(TrieNode root) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("trie.txt");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            // write object to file
            objectOutputStream.writeObject(root);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Read Trie object from File
     *
     * @param fileName name of the file where Trie object is present
     * @return TrieNode root object
     */
    public static TrieNode readTrieFromFile(String fileName) {
        try (FileInputStream fileInputStream = new FileInputStream("trie.txt");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            // read object from file stream
            TrieNode trie = (TrieNode) objectInputStream.readObject();
            return trie;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
