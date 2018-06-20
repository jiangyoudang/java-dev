import java.util.Arrays;
import java.util.HashSet;

public class LongestSubString {
    private int lengthOfLongestSubstring(String s) {
        HashSet<Character> cache = new HashSet<>();
        int left = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!cache.contains(c)) {
                cache.add(c);
            } else {
                while (s.charAt(left) != c) {
                    cache.remove(s.charAt(left));
                    left++;
                }
                left ++;
            }
            ans = Math.max(ans, i-left+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new LongestSubString().lengthOfLongestSubstring(s));
    }

}


