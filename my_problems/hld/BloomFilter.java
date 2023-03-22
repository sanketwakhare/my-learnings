public class BloomFilter {

    static boolean bitarray[] = new boolean[1003001];
    static int arrSize = bitarray.length;

    // hash 1
    static int h1(String s)
    {
        long hash = 0;
        for (int i = 0; i < s.length(); i++)
        {
            hash = (hash + ((long)s.charAt(i)));
            hash = hash % (long)arrSize;
        }
        return (int)hash;
    }

    // hash 2
    static int h2(String s)
    {
        long hash = 1;
        for (int i = 0; i < s.length(); i++)
        {
            hash = hash + (long)i * (long)s.charAt(i);
            hash = hash % (long)arrSize;
        }
        return (int)(hash % (long)arrSize);
    }

    // hash 3
    static int h3(String s)
    {
        long hash = 7l;
        for (int i = 0; i < s.length(); i++)
        {
            hash = (hash * 31 + (long)s.charAt(i)) % (long)arrSize;
        }
        return (int)(hash % (long)arrSize);
    }

    // hash 4
    static int h4(String s)
    {
        long hash = 3l;
        int p = 7;
        for (int i = 0; i < s.length(); i++) {
            hash += hash * 7l + (long)s.charAt(i) * (long)(i);
            hash = hash % (long)arrSize;
        }
        return (int)(hash % (long)arrSize);
    }

    static Boolean lookup(String s){
        // Complete the function
        int a = h1(s);
        int b = h2(s);
        int c = h3(s);
        int d = h4(s);

        if (bitarray[a] && bitarray[b] && bitarray[c]
                && bitarray[d])
            return true;
        else
            return false;
    }

    static void insert(String s){
        // Complete the function
        // check if the element in already present or not
        if (!lookup(s))
        {
            int a = h1(s);
            int b = h2(s);
            int c = h3(s);
            int d = h4(s);

            bitarray[a] = true;
            bitarray[b] = true;
            bitarray[c] = true;
            bitarray[d] = true;
        }
    }

    public static void main(String[] args) {
        insert("hello");
        insert("world");
        insert("coder");
        insert("tester");
        insert("hustler");
        insert("tutor");
        String[] words = {"apple", "banana", "cherry", "date", "elderberry"};
        for (String word : words) {
            insert(word);
        }

        System.out.println("Testing lookup...");
        System.out.println("apple is in filter: " + lookup("apple"));
        System.out.println("banana is in filter: " + lookup("banana"));
        System.out.println("cherry is in filter: " + lookup("cherry"));
        System.out.println("date is in filter: " + lookup("date"));
        System.out.println("elderberry is in filter: " + lookup("elderberry"));
        System.out.println("grape is in filter: " + lookup("grape"));
        System.out.println(lookup("coder"));
        System.out.println(lookup("world"));
        System.out.println(lookup("hello"));
        System.out.println(lookup("tester1"));
        System.out.println(lookup("tutor"));
        System.out.println(lookup("abc"));
        System.out.println(lookup("cooder"));
    }
}
