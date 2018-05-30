package edunova.uvjetnagrananja;

public class IfZadatak3 {

	// za unesena 3 broja ispišite najmanji

	// 3 8 9 -> 3
	// 1 2 0 -> 0
	// 8 3 8 -> 3

	public static void main(String[] args) {
		int firstNum = 4;
		int secondNum = 2;
		int thirdNum = 5;

		if (firstNum < secondNum && firstNum < thirdNum) {
			System.out.println(firstNum);

		}
		if (secondNum < firstNum && secondNum < thirdNum) {
			System.out.println(secondNum);
		}

		else {
			System.out.println(thirdNum);
		}
		
		System.out.println((firstNum<secondNum) && firstNum < thirdNum ? firstNum : secondNum<firstNum && secondNum<thirdNum ? secondNum : thirdNum);

	}

}
