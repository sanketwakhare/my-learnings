/* Consistent Hashing */

import java.util.*;

/*
* Problem Description

We have a hash ring where we have locations available from 0 degrees to 359 degrees. Implement a consistent hashing in the following way : You can add a server to the hash ring. We just need to pass the serverID and the hash functions automatically assign them one location on the hash ring. serverID can be strings. To add any server you give input as ADD servername . This will add that server to your hash ring. You also have the option to remove an added server which can be done by giving the input as REMOVE servername . This will remove the server from the hash ring. Lastly, to the servers added on the ring, you can assign incoming requests based on keys. So, when you do ASSIGN STUV, you basically want to assign this request to one of the servers nearest to the name hash location in clockwise direction. ( If no server found in clockwise direction, pick the nearest server from 0 degrees in clockwise direction ) It has been guaranteed that all the key names and server names would be unique. If you try to assign a request, when no server is present on the ring, that request should not get served. Please note that, when you ADD or REMOVE a server, certain requests might get redirected to different servers. So that needs to be accommodated as well.

You are given two string vectors A and B. Strings in A tell you which type of operation/query it is. Strings in B tell you key/server names. For all valid i, A[i] tells you the type of operation of ith query and B[i] tells you the key/server name depending on the type of query. A[i] can only take 3 values - "ADD", "REMOVE", "ASSIGN".

For "ADD" queries, B[i] is an uppercase string with 5 or more letters. They are all unique among add queries.
For "REMOVE" queries, B[i] is an uppercase string with 5 or more letters. They are all unique among remove queries
For "ASSIGN" queries, B[i] is an uppercase string with exactly 4 letters. They are all unique among all queries

You need to return an integer array. Let's call it ans. ans[i] should correspond to the right output for the ith query. The rules for the output are:
For "ADD" queries, ans[i] should be equal to the number of keys that got reassigned to the server added in the ith query.
For "REMOVE" queries, ans[i] should be equal to the number of keys that were in the server(before removal) that is getting removed in the ith query.
For "ASSIGN" queries, ans[i] should be equal to the degree that got assigned to the ith key. It is guaranteed that at least one server exists for "ASSIN" type queries.

It is guaranteed that there will not be any removals of servers that are not already there. It is also guaranteed that number of queries of types "ADD"/"REMOVE" do not exceed 11 each.

You are required to use the following hash function to assign degrees to servers/keys:

int userHash(string username){

    const int p = 31;
    const int n = 360;
    int hashCode = 0;
    long long p_pow = 1;
    for (int i = 0; i &amp;amp;amp;amp;amp;amp;amp;amp;lt; username.length(); i++) {
        char character = username[i];
        hashCode = (hashCode + (character - 'A' + 1) * p_pow) % n;
        p_pow = (p_pow * p) % n;
    }
    return hashCode;

}


Problem Constraints

1 <= A.size() <= 10^4 + 30
1 <= B.size() <= 10^4 + 30
A.size() = B.size()


Input Format

First argument is the string array A. Second argument is string array B.


Output Format

Return an integer array with the corresponding values for each query according to the problem statement.


Example Input

Input 1:
A = [ADD ASSIGN ADD ASSIGN REMOVE ASSIGN]
B = [INDIA NWFJ RUSSIA OYVL INDIA IGAX]
Input 2:

A = [ADD ASSIGN ASSIGN ADD ASSIGN ASSIGN REMOVE ASSIGN]
B = [INDIA IRYA RGJK RUSSIA BGVH SUKJ INDIA RBRF]


Example Output

Output 1:
0 203 0 344 2 131
Output 2:

0 23 226 1 129 271 3 284


Example Explanation

Explanation 1:
"INDIA" gets mapped to hash value 7
"RUSSIA" gets mapped to hash value 117
For the 1st query, there are no keys at all so 0 keys get reassigned.
For the 2nd query, string gets hash value of 203 and gets assigned to "INDIA"
For the 3rd query, "RUSSIA" gets added but no keys get reassigned to "RUSSIA"
For the 4th query, string gets hash value of 344 and gets assigned to "INDIA"
For the 5th query, "INDIA" is removed and 2 keys need to be reassigned.
For the 6th query, string gets hash value of 131 and gets assigned to "RUSSIA"
*  */
public class ConsistentHashing {

    static class Pair {
        int serverHash;
        String machineName;

        Pair(int serverHash, String machineName) {
            this.serverHash = serverHash;
            this.machineName = machineName;
        }
    }

    public static void main(String[] args) {
        ConsistentHashing t1 = new ConsistentHashing();
        {
            String[] A = {"ADD", "ASSIGN", "ASSIGN", "ADD", "ASSIGN", "ASSIGN", "REMOVE", "ASSIGN"};
            String[] B = {"INDIA", "GSZJ", "ORWX", "RUSSIA", "IENS", "TTXU", "INDIA", "CHEX"};
            int[] result = t1.solve(A, B);
            System.out.println(Arrays.toString(result));
            // [0, 212, 20, 1, 47, 235, 2, 40]
        }
        {
            String[] A = {"ADD", "ASSIGN", "ADD", "ASSIGN", "REMOVE", "ASSIGN"};
            String[] B = {"INDIA", "NWFJ", "RUSSIA", "OYVL", "INDIA", "IGAX"};
            int[] result = t1.solve(A, B);
            System.out.println(Arrays.toString(result));
            // [0, 203, 0, 344, 2, 131]
        }
        {
            String[] A = {"ADD", "ASSIGN", "ASSIGN", "ADD", "ASSIGN", "ASSIGN", "REMOVE", "ASSIGN"};
            String[] B = {"INDIA", "IRYA", "RGJK", "RUSSIA", "BGVH", "SUKJ", "INDIA", "RBRF"};
            int[] result = t1.solve(A, B);
            System.out.println(Arrays.toString(result));
            // [0, 23, 226, 1, 129, 271, 3, 284]
        }
        {
            String[] A = {"ADD", "ASSIGN", "ASSIGN", "ASSIGN", "ADD", "ASSIGN", "ASSIGN", "ASSIGN", "ADD", "ASSIGN", "ASSIGN", "ASSIGN", "ADD", "ASSIGN", "ASSIGN", "ASSIGN", "REMOVE", "ASSIGN", "ASSIGN", "ASSIGN", "REMOVE", "ASSIGN", "ASSIGN", "ASSIGN", "REMOVE", "ASSIGN", "ASSIGN"};
            String[] B = {"INDIA", "XXWK", "HLFK", "XPUZ", "RUSSIA", "HYSP", "AYMS", "NZYJ", "CHINA", "MCVT", "SZXJ", "RPXJ", "GERMANY", "XXYV", "NECG", "MTAI", "INDIA", "UAQR", "PUZE", "LISG", "RUSSIA", "ZMYR", "NAKS", "RVDV", "CHINA", "EZUH", "OWCR"};
            int[] result = t1.solve(A, B);
            System.out.println(Arrays.toString(result));
            // [0, 292, 127, 27, 1, 338, 58, 195, 2, 28, 319, 8, 2, 155, 269, 73, 4, 27, 8, 287, 12, 172, 285, 66, 0, 120, 209]
        }
        {
            String[] A = {"ADD", "ASSIGN", "ASSIGN", "ASSIGN", "ADD", "ASSIGN", "ASSIGN", "ASSIGN", "ADD", "ASSIGN", "ASSIGN", "ASSIGN", "ADD", "ASSIGN", "ASSIGN", "ASSIGN", "REMOVE", "ASSIGN", "ASSIGN", "ASSIGN", "REMOVE", "ASSIGN", "ASSIGN", "ASSIGN", "REMOVE", "ASSIGN", "ASSIGN"};
            String[] B = {"INDIA", "DOCG", "YOGF", "IPYH", "RUSSIA", "XABT", "RLQH", "HQZT", "CHINA", "PMGP", "PXGM", "ZDKM", "GERMANY", "ARHY", "ZAXM", "ZQSY", "INDIA", "GCDD", "EHMI", "TEOE", "RUSSIA", "KWJP", "YZRV", "XSMB", "CHINA", "CUMX", "DBYM"};
            int[] result = t1.solve(A, B);
            System.out.println(Arrays.toString(result));
            // [0, 209, 203, 58, 1, 197, 175, 341, 4, 322, 210, 204, 3, 262, 4, 27, 4, 348, 65, 105, 9, 270, 331, 328, 3, 211, 254]
        }
    }

    public int[] solve(String[] A, String[] B) {
        int[] result = new int[A.length];
        Map<Integer, String> serverMap = new TreeMap<>();
        Map<Integer, List<Pair>> machineMap = new TreeMap<>();

        for (int i = 0; i < A.length; i++) {
            String operation = A[i];
            String key = B[i];
            int hash = userHash(key);
            switch (operation) {
                case "ADD":
                    addServer(result, serverMap, machineMap, i, key, hash);
                    break;
                case "REMOVE":
                    removeServer(result, serverMap, machineMap, i, hash);
                    break;
                case "ASSIGN":
                    assignServer(result, serverMap, machineMap, i, key, hash);
                    break;
            }
        }
        return result;
    }

    private void addServer(int[] result, Map<Integer, String> serverMap, Map<Integer, List<Pair>> machineMap, int index, String key, int hash) {
        Set<Integer> serverSet;
        int count;
        serverMap.put(hash, key);
        if (serverMap.size() == 1) {
            // when current server is first server being added
            result[index] = 0;
            return;
        }
        serverSet = serverMap.keySet();
        int prevServer = -1;
        for (int val : serverSet) {
            if (val < hash) {
                prevServer = val;
            } else break;
        }
        if (prevServer != -1) {
            count = 0;
            for (Map.Entry<Integer, List<Pair>> integerPairEntry : machineMap.entrySet()) {
                int machineKey = integerPairEntry.getKey();
                if (machineKey >= prevServer + 1 && machineKey <= hash) {
                    List<Pair> pairs = integerPairEntry.getValue();
                    for (Pair p : pairs) {
                        p.serverHash = hash;
                        count++;
                    }
                    integerPairEntry.setValue(pairs);
                }
            }
            result[index] = count;
            return;
        }
        // assign last server id
        for (int val : serverSet) {
            prevServer = val;
        }
        count = 0;
        for (Map.Entry<Integer, List<Pair>> integerPairEntry : machineMap.entrySet()) {
            int machineKey = integerPairEntry.getKey();
            if ((machineKey >= prevServer + 1 && machineKey < 360) ||
                    (machineKey >= 0 && machineKey <= hash)) {
                List<Pair> pairs = integerPairEntry.getValue();
                for (Pair p : pairs) {
                    p.serverHash = hash;
                    count++;
                }
                integerPairEntry.setValue(pairs);
            }
        }
        result[index] = count;
    }

    private void removeServer(int[] result, Map<Integer, String> serverMap, Map<Integer, List<Pair>> machineMap, int index, int hash) {
        int count;
        Set<Integer> serverSet;
        serverSet = serverMap.keySet();
        int nextServer = -1;
        for (int val : serverSet) {
            if (val > hash) {
                nextServer = val;
                break;
            }
        }
        if (nextServer == -1) {
            // if no next server, then assign all request coming to this server to first server
            if (serverSet.stream().findFirst().isPresent()) {
                nextServer = serverSet.stream().findFirst().get();
            }
        }
        count = 0;
        for (Map.Entry<Integer, List<Pair>> integerPairEntry : machineMap.entrySet()) {
            List<Pair> pairs = integerPairEntry.getValue();
            for (Pair p : pairs) {
                if (p.serverHash == hash) {
                    count++;
                    p.serverHash = nextServer;
                }
            }
            integerPairEntry.setValue(pairs);
        }
        result[index] = count;
        serverMap.remove(hash);
    }

    private void assignServer(int[] result, Map<Integer, String> serverMap, Map<Integer, List<Pair>> machineMap, int index, String key, int hash) {
        Set<Integer> set = serverMap.keySet();
        boolean found = false;
        int serverHash = 0;
        for (int val : set) {
            if (val >= hash) {
                found = true;
                serverHash = val;
                break;
            }
        }
        if (!found) {
            if (set.stream().findFirst().isPresent()) {
                serverHash = set.stream().findFirst().get();
            }
        }
        if (machineMap.containsKey(hash)) {
            machineMap.get(hash).add(new Pair(serverHash, key));
        } else {
            List<Pair> pairs = new ArrayList<>();
            pairs.add(new Pair(serverHash, key));
            machineMap.put(hash, pairs);
        }
        result[index] = hash;
    }

    int userHash(String username) {

        int p = 31;
        long n = 360;
        long hashCode = 0;
        long p_pow = 1;
        for (int i = 0; i < username.length(); i++) {
            char character = username.charAt(i);
            hashCode = (hashCode + (character - 'A' + 1) * p_pow) % n;
            p_pow = (p_pow * p) % n;
        }
        return (int) hashCode;

    }
}
