import java.util.*;

public class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();
        int slen = s.length(), plen = p.length();
        if (slen < plen)
            return result;

        HashMap<Character, Integer> target = new HashMap<>();
        HashMap<Character, Integer> current = new HashMap<>();
        char ch;

        for (int i = 0; i < plen; i ++) {
            ch = p.charAt(i);
            target.put(ch, target.getOrDefault(ch, 0) + 1);
        }

        int left = 0, right = 0;
        int count = 0;
        while (right < left + plen) {
            ch = s.charAt(right);
            current.put(ch, current.getOrDefault(ch, 0) + 1);
            right ++;
        }
        if (current.equals(target)) {
            result.add(left);
        }
        while (right < slen) {
            ch = s.charAt(left);
            count = current.get(ch);
            if (count == 1)
                current.remove(ch);
            else
                current.put(ch, count - 1);
            ch = s.charAt(right);
            current.put(ch, current.getOrDefault(ch, 0) + 1);
            left ++; right ++;
            if (current.equals(target)) {
                result.add(left);
            }
        }

        return result;
    }
}
