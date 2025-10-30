

public class SignOfTheProductOfAnArray {

    public int arraySign(int[] nums) {
        boolean isOdd = false;
        for (int number : nums) {
            if (number == 0) {
                return 0;
            }
            if (number < 0) {
                isOdd = !isOdd;
            }
        }
        return isOdd ? -1 : 1;
    }

    public static void main(String[] args) {
        SignOfTheProductOfAnArray signOfTheProductOfAnArray = new SignOfTheProductOfAnArray();
        System.out.println(signOfTheProductOfAnArray.arraySign(new int[]{-1, -2, -3, -4, 3, 2, 1}));
        System.out.println(signOfTheProductOfAnArray.arraySign(new int[]{1, 5, 0, 2, -3}));
        System.out.println(signOfTheProductOfAnArray.arraySign(new int[]{-1, 1, -1, 1, -1}));
    }

}
