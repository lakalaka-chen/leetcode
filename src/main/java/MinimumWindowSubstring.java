import java.util.HashMap;
import java.util.Map;

class MinimumWindowSubstring {

    int matched = 0;
    public String minWindow(String s, String t) {

        int slen = s.length(), tlen = t.length();
        if (slen < tlen)
            return "";

        char ch;
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < tlen; i ++) {
            ch = t.charAt(i);
            if (tMap.containsKey(ch)) {
                tMap.put(ch, tMap.get(ch)+1);
            } else {
                tMap.put(ch, 1);
            }
        }

        int right=0, left=-1;
        int minLen = slen+1;
        int i=0,j=slen;

        while (right < slen) {
            right = forward(s, left+1, tlen, new HashMap<>(tMap));
            if (matched != tlen)    break;
            left = backward(s, right, tlen, new HashMap<>(tMap));
            if (minLen > (right-left)) {
                i = left; j = right;
                minLen = right-left;
            }
        }

        if (minLen == slen + 1)
            return "";

        return s.substring(i, j);

    }
    int forward(String s, int start, int tlen, Map<Character, Integer> tMap) {
        int right = start;
        matched = 0;
        char ch;
        for (; right < s.length() && matched != tlen; right ++) {
            ch = s.charAt(right);
            if (tMap.containsKey(ch)) {
                if (tMap.get(ch) == 1) {
                    tMap.remove(ch);
                } else {
                    tMap.put(ch, tMap.get(ch)-1);
                }
                matched ++;
            }
        }
        return right;
    }
    int backward(String s, int right, int tlen, Map<Character, Integer> tempMap) {
        int left = right-1;
        char ch;
        matched = 0;
        for (; left >= 0 && matched != tlen; left --) {
            ch = s.charAt(left);
            if (tempMap.containsKey(ch)) {
                if (tempMap.get(ch) == 1) {
                    tempMap.remove(ch);
                } else {
                    tempMap.put(ch, tempMap.get(ch)-1);
                }
                matched ++;
            }
        }
        return left+1;
    }
}
