package edunova.svjetsko;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Pokretanje {
	 public static void main(String[] args) {
		Sastav sastav = new Sastav();
		sastav.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sastav.setVisible(true);
		sastav.pack();
		sastav.setTitle("Sastav za utakmicu");
		JLabel rezSastav = new JLabel("bllb");
		
		Timovi srbija = new Timovi();
		srbija.setNaziv("Srbija");
		Timovi brazil = new Timovi();
		brazil.setNaziv("Brazil");
		
		Okrsaj o = new Okrsaj(brazil,srbija);
		o.setGolGost(2);
		o.setGolDomacin(0);
		o.setPostigoGol("         " +  "Paulinho 36'" + "\n" + "         " + "Thiago Silva 68'");
		System.out.println(o);
		System.out.println();
		System.out.println(o.getPostigoGol());
	}
}
