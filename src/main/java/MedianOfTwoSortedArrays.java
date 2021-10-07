public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length+nums2.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                arr[k] = nums1[i];
                i ++;
            } else {
                arr[k] = nums2[j];
                j ++;
            }
            k ++;
        }
        for (; i < nums1.length; i ++) {
            arr[k] = nums1[i]; k ++;
        }
        for (; j < nums2.length; j ++) {
            arr[k] = nums2[j]; k ++;
        }
        if (k % 2 == 1)
            return arr[k/2];
        return (arr[k/2] + arr[k/2-1])/2.0;
    }
}
