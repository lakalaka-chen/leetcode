public class RotateArray {

    public void rotate(int[] nums, int k) {

        int len = nums.length;

        while (k >=len) k-=len;

        reverse(nums, len-k, len-1);
        reverse(nums, 0, len-k-1);
        reverse(nums, 0, len-1);

    }

    void reverse(int[] nums, int start, int end) {

        if (start >= end)
            return;

        int mid = start + (end - start) / 2;
        for (int i = start; i <= mid; i ++) {
            int temp = nums[i];
            nums[i] = nums[end-i+start];
            nums[end-i+start] = temp;
        }

    }
}
