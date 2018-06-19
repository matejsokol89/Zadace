package edunova;

public class BigDiff {
	public static int bigDiff(int[] nums) {
		int max= nums[0];
		int min=nums[0];
		
		for (int i = 0; i < nums.length; i++) {
			if ( nums[i] > max) {
				max = nums[i];
	
			}
			if (nums[i] < min) {
				min = nums[i];
			}
		}
		System.out.println(max);
		  return max - min;
	}
	
public static void main(String[] args) {
	int[] numbers= {10, 3, 5, 6};
	BigDiff.bigDiff(numbers);
	
}
}
