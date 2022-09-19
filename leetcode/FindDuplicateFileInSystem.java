import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFileInSystem {

    public static void main(String[] args) {
        FindDuplicateFileInSystem obj = new FindDuplicateFileInSystem();
        {
            List<List<String>> result = obj.findDuplicate(
                    new String[]{
                            "root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)",
                            "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"
                    });
            System.out.println("result: " + result);
        }
        {
            List<List<String>> result = obj.findDuplicate(
                    new String[]{
                            "root/a 1.txt(abcd) 2.txt(efsfgh)", "root/c 3.txt(abdfcd)", "root/c/d 4.txt(efggdfh)"
                    });
            System.out.println("result: " + result);
        }
        {
            List<List<String>> result = obj.findDuplicate(
                    new String[]{
                            "root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)"
                    });
            System.out.println("result: " + result);
        }
    }

    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] tokens = path.split(" ");
            String directory = tokens[0];
            System.out.println(directory);
            for (int i = 1; i < tokens.length; i++) {
                String fileName = tokens[i].substring(0, tokens[i].indexOf('('));
                String content = tokens[i].substring(tokens[i].indexOf('(') + 1, tokens[i].length() - 1);
                System.out.println(fileName + " " + content);

                List<String> list = map.getOrDefault(content, new ArrayList<>());
                list.add(directory + "/" + fileName);
                map.put(content, list);
            }
        }
        System.out.println(map);
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> list = entry.getValue();
            if (list.size() > 1) {
                result.add(entry.getValue());
            }
        }
        return result;
    }
}
