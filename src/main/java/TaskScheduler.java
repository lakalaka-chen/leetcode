import java.util.*;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {

        HashSet<Character> charSet = new HashSet<>();
        HashMap<Character, Integer> charMap = new HashMap<>();

        int len = tasks.length;

        for (int i = 0; i < len; i ++) {
            charSet.add(tasks[i]);
            charMap.put(tasks[i], charMap.getOrDefault(tasks[i], 0)+1);
        }

        boolean[] isFilled = new boolean[(n+1)*len];

        Iterator iter = charSet.iterator();
        int ans = 0;
        while (iter.hasNext()) {
            Character ch = (Character)iter.next();
            int ct = charMap.get(ch);
            int loc = 0;
            for (int i = 0; i < ct; i ++) {
                while (isFilled[loc]) loc ++;
                isFilled[loc] = true;
                loc += n+1;
            }
            ans = Math.max(ans, loc-(n+1));
        }

        return ans+1;

    }
}
