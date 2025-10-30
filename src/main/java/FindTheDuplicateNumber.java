
public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        boolean[] db = new boolean[nums.length];

        for (int num : nums) {
            if (db[num]) {
                return num;
            }

            db[num] = true;
        }

        return 0;
    }

}
