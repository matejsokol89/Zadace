package vjezbanje;

public class Palindrome {
	static int rez;

	public static int longestPalindrome(final String s) {
		if (s.equals("")) {
			return 0;
		}
		for (int palindromeSize = s.length(); palindromeSize > 0; palindromeSize--) {
			for (int i = 0; i + palindromeSize <= s.length(); i++) {
				int substr = i + palindromeSize;
				String test;
				if (substr > s.length()) {
					test = s.substring(i);
				} else {
					test = s.substring(i, substr);
				}
				if (isPalindrome(test)) {
					rez = test.length();
					return rez;
				}

			}

		}
		return rez;

	}

	public static boolean isPalindrome(String str) {
		if (str == null || str.trim().equals("")) {
			return false;
		} else if (str.length() == 1) {
			return true;
		}

		for (int i = 0, j = str.length() - 1; i <= j; i++, j--) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
		}
		return true;
	}

}
