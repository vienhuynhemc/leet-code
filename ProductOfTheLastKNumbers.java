public class ProductOfTheLastKNumbers {

    class ProductOfNumbers {
        final byte[] data = new byte[40000];
        int size = 0;

        public ProductOfNumbers() {

        }

        public void add(int num) {
            data[size++] = (byte) num;
        }

        public int getProduct(int k) {
            int ans = 1;
            for (int i = size - k; i < size; i++) {
                ans *= data[i];
            }

            return ans;
        }
    }
}
