import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hmap = new HashMap<>(); // 字符：前一个出现的索引位置
        int result = 0, left = 0, right = 0;
        char ch;
        while (right < s.length()) {
            ch = s.charAt(right);
            if (hmap.containsKey(ch) == false) {
                // left~right没出现过s[right]字符
                hmap.put(ch, right);
            } else {
                //left~right出现过s[right]字符
                if (hmap.get(ch) < left) {
                    //如果出现在left左侧，例如abba,l==2,r==3时,hmap.get('a')==0
                    //此时不用更新result
                    hmap.put(ch, right);
                    right ++; continue;
                }
                result = Math.max(result, right-left);
                left = hmap.get(ch) + 1;
                hmap.put(ch, right);
            }
            right ++;
        }
        return Math.max(result, right-left);
    }
}
