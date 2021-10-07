import javafx.util.Pair;

import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        TreeSet<Pair<Integer,Integer>> set = new TreeSet<Pair<Integer, Integer>>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                if (o1.getKey() > o2.getKey()) return -1;
                if (o1.getKey() <= o2.getKey()) return 1;
                return -1;
            }
        });

        int left = 0, right = 0, len = nums.length;
        while (right < len) {
            while (right < len && nums[left] == nums[right]) right++;
            set.add(new Pair<>(right-left, nums[left]));
            left = right;
        }

        int[] result = new int[k];
        List<Pair<Integer,Integer>> list = new ArrayList<>(set);
        for (int i = 0; i < k; i ++)
            result[i] = list.get(i).getValue();
        return result;
    }
}
