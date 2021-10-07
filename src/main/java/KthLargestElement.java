public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        if (k == 1) {
            int result = nums[0];
            for (int i = 0; i < nums.length; i ++)
                result = Math.max(nums[i], result);
            return result;
        } else if (k == nums.length) {
            int result = nums[0];
            for (int i = 0; i < k; i ++)
                result = Math.min(nums[i], result);
            return result;
        }
        return helper(nums, 0, nums.length-1, k);
    }

    int helper(int[] nums, int start, int end, int k) {

        int loc = partition(nums, start, end);

        if (loc - start + 1 == k)
            return nums[loc];
        else if (loc - start + 1 < k)
            return helper(nums, loc+1, end, k-loc+start-1);
        else
            return helper(nums, start, loc-1, k);

    }

    int partition(int[] nums, int start, int end) {


        while (start < end) {
            while (start < end && nums[start] >= nums[end]) end --;
            swap(nums, start, end);
            while (start < end && nums[start] >= nums[end]) start++;
            swap(nums, start, end);
        }

        return start;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}