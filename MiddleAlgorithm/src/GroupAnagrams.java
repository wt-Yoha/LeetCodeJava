import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams01(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        List<int[]> setsMap = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            boolean newSet = true;
            int sNo;
            for (sNo = 0; sNo < setsMap.size(); sNo++) {
                int[] sMap = setsMap.get(sNo).clone();
                int j;
                for (int c = 0; c < strs[i].length(); c++)
                    sMap[strs[i].charAt(c) - 'a']--;
                for (j = 0; j < sMap.length; j++)
                    if (sMap[j] != 0)
                        break;
                if (j == sMap.length) {
                    newSet = false;
                    break;
                }
            }
            if (newSet) {
                int[] sMap = new int[26];
                for (int c = 0; c < strs[i].length(); c++)
                    sMap[strs[i].charAt(c) - 'a']++;
                setsMap.add(sMap);
                List<String> oneResult = new ArrayList<>();
                oneResult.add(strs[i]);
                result.add(oneResult);
            } else {
                result.get(sNo).add(strs[i]);
            }
        }
        return result;
    }

    private static List<List<String>> groupAnagrams02(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        List<char[]> setsMap = new ArrayList<>();
        for (String s : strs) {
            boolean newSet = true;
            int sNo;
            char[] stringChars = s.toCharArray();
            Arrays.sort(stringChars);
            for (sNo = 0; sNo < setsMap.size(); sNo++) {
                char[] sMap = setsMap.get(sNo);
                int c;
                if (s.length() != sMap.length)
                    continue;
                for (c = 0; c < stringChars.length; c++) {
                    if (stringChars[c] != sMap[c])
                        break;
                }
                if (c == stringChars.length) {
                    newSet = false;
                    break;
                }
            }
            if (newSet) {
                setsMap.add(stringChars);
                List<String> oneResult = new ArrayList<>();
                oneResult.add(s);
                result.add(oneResult);
            } else {
                result.get(sNo).add(s);
            }
        }
        return result;
    }

    private static List<List<String>> groupAnagrams03(String[] strs) {
        /*
            N 是 strs 的长度，K为最长字符串长度
            时间复杂度为 O(N^2K) 当 K>>N 比较省时
         */

        List<List<String>> result = new ArrayList<>();
        List<int[]> setsMap = new ArrayList<>();
        for (String s : strs) {
            boolean newSet = true;
            int sNo;
            for (sNo = 0; sNo < setsMap.size(); sNo++) {
                int[] sMap = setsMap.get(sNo).clone();
                int c;
                if (s.length() != sMap[26])
                    continue;
                for (c = 0; c < s.length(); c++) {
                    if (--sMap[s.charAt(c) - 'a'] < 0)
                        break;
                }
                if (c == s.length()) {
                    newSet = false;
                    break;
                }
            }
            if (newSet) {
                int[] sMap = new int[27];
                List<String> oneResult = new ArrayList<>();
                for (int c = 0; c < s.length(); c++) {
                    ++sMap[s.charAt(c) - 'a'];
                    ++sMap[26];
                }
                setsMap.add(sMap);
                oneResult.add(s);
                result.add(oneResult);
            } else {
                result.get(sNo).add(s);
            }
        }
        return result;
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> setsMap = new HashMap<>();
        for (String s : strs) {
            int[] sMap = new int[26];
            for (int i = 0; i < s.length(); i++) {
                ++sMap[s.charAt(i) - 'a'];
            }
            String sKey = Arrays.toString(sMap);
            if (!setsMap.containsKey(sKey)) {
                List<String> oneResult = new ArrayList<>();
                oneResult.add(s);
                setsMap.put(sKey, oneResult);
            } else {
                setsMap.get(sKey).add(s);
            }
        }
        return new ArrayList(setsMap.values());
    }

    public static void main(String[] args) {
//        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs = {};
//        String[] strs = {"apple", "ppela", "baidu", "di"};

        List<List<String>> result = groupAnagrams(strs);
        System.out.println(result);
//        int[] a = {1, 3, 4, 5, 8, 6, 3};
//        int[] c = {1, 3, 4, 5, 8, 6, 3};
//        String s = Arrays.toString(a);
//        String b = "[1, 3, 4, 5, 8, 6, 3]";
//        System.out.println("s.hascode= " + s.hashCode() + " b.hashcode()= " + b.hashCode());
//        System.out.println("a.hascode= " + a.hashCode() + " c.hashcode()= " + c.hashCode());
    }
}
