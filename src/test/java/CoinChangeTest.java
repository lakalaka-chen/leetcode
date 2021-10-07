public class CoinChangeTest {
    public static void main(String[] args) {
        CoinChange demo = new CoinChange();
        assert(demo.coinChange(new int[]{2, 5, 10, 1}, 27) == 4);
    }
}
