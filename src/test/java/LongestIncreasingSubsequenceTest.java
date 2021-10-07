public class LongestIncreasingSubsequenceTest {
    public static void main(String[] args) {
        LongestIncreasingSubsequence demo = new LongestIncreasingSubsequence();
        assert (demo.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}) == 4);
        assert (demo.lengthOfLIS(new int[]{10}) == 1);
        assert (demo.lengthOfLIS(new int[]{10,8}) == 1);
        assert (demo.lengthOfLIS(new int[]{10,9,2,5}) == 2);
        assert (demo.lengthOfLIS(new int[]{2,3,5,7,101,18}) == 5);
        assert (demo.lengthOfLIS(new int[]{1,2,3,4,5,6,7}) == 7);
        assert (demo.lengthOfLIS(new int[]{2,2,2,2,2,2,2,2}) == 1);
        assert (demo.lengthOfLIS(new int[]{2,2,2,3,2,2,3,3,4,5,1,2}) == 4);
    }
}
