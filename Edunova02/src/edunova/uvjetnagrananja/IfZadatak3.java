package edunova.uvjetnagrananja;

public class IfZadatak3 {

	// za unesena 3 broja ispišite najmanji

	// 3 8 9 -> 3
	// 1 2 0 -> 0
	// 8 3 8 -> 3

	public static void main(String[] args) {
		int firstNum = 3;
		int secondNum = 1;
		int thirdNum = 0;

		if (firstNum < secondNum && firstNum < thirdNum) {
			System.out.println(firstNum);

		}
		if (secondNum < firstNum && secondNum < thirdNum) {
			System.out.println(secondNum);
		}

		else {
			System.out.println(thirdNum);
		}
	}

}
