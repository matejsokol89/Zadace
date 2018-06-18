package edunova;

public class CatDog {
	public static boolean catDog(String str) {
		int cat=0;
		int dog=0;
		for (int i = 0; i < str.length()-2; i++) {
			if (str.substring(i, i+3).contains("cat")) {
				cat++;
			}
			if (str.substring(i, i+3).contains("dog")) {
				dog++;
			}
		}
		
		return  cat==dog; 
	}
	
	public static void main(String[] args) {
		String word= "catdog";
		boolean invoke = CatDog.catDog(word);
	}

}
