
public class CenterNum {

    public static int centeredAverage(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }

        return (sum - max - min) / (nums.length - 2);
    }

    public static void main(String args[]) {
        int[] brojevi = {5, 101, 4, 4, 100};
        CenterNum.centeredAverage(brojevi);
    }

}
