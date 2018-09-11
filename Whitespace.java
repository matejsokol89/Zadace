package vjezbanje;

public class Whitespace {
public static void main(String[] args) {
	String razmak =" Mae Marsh ";
	//ovaj mice prvi razmak
	razmak = razmak.replaceFirst("^ *", "");
	//ovajmice zadnji
	razmak = razmak.replaceFirst("\\s++$", "");

	System.out.println(razmak);

}
}
