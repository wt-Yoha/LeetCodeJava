import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int[] tag = new int[s.length()];
        HashMap<Character, Integer> pos = new HashMap<>();
        int maxLength = 0;

        int len = s.length();
        for (int i = 0; i < tag.length; i++) {
            tag[i] = len;
        }

        for (int i = 0; i < len; i++) {
            char key = s.charAt(i);
            if (!pos.containsKey(key)) {
                pos.put(key, i);
            } else {
                tag[pos.get(key)] = i;
                pos.put(key, i);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            int end = tag[i];
            for (int j = i + 1; j < end; j++) {
                if ((end - i) < maxLength) break;
                if (tag[j] < end)
                    end = tag[j];
            }
            if ((end - i) > maxLength) {
                maxLength = (end - i);
            }
        }

        return maxLength;
    }

    public static int lengthOfLongestSubstring1(String s) {
        int ans = 0, i = 0, j = 0, n = s.length();
        Set<Character> set = new HashSet<>();
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return ans;
    }


    public static void main(String[] args) {
//        String s = "abcabcbb";
        String s = "pwabwpwabe";
//        String s = "bbbbb";
//        String s = " ";
        System.out.println(lengthOfLongestSubstring1(s));
    }

}
