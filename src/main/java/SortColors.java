class SortColors {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int temp;
        for (int i = 0; i <= right; i ++) {
            while (nums[i] == 2 && i < right) {
                temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
                right --;
            }
        }
        while (right >= 0 && nums[right] == 2)  right--;
        for (int i = 0; i <= right; i ++) {
            while (nums[i] == 1 && i < right) {
                temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
                right --;
            }
        }
    }
}
