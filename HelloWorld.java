package hello;

public class HelloWorld {

	public static void main(String[] args) {

		// 1. na�in

		System.out.println("Hello World");

		// 2. na�in

		String word = "Hello World";

		System.out.println(word);

		// 3. petljanje po petlji ali mo�e to i bolje :D

		String helloSvijete[] = { "Hello ", "World" };

		for (int i = 0; i < helloSvijete.length; i++) {
			System.out.print(helloSvijete[i]);

		}

	}

}