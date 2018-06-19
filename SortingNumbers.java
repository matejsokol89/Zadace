package edunova;

public class SortingNumbers {
	public static void main(String[] args) {

		int[] numbers = { 5, 3, 2, 6, 8, 10 };
		boolean sorting = false;
		int temp;

		while (sorting == false) {
			sorting = true;
			for (int i = 0; i < numbers.length - 1; i++) {
				if (numbers[i] > numbers[i + 1]) {
					temp = numbers[i + 1];
					numbers[i + 1] = numbers[i];
					numbers[i] = temp;
					sorting = false;

				}

			}
		}
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);

		}
	}
}
