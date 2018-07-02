package edunova.svjetsko;

import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;

public class Sastav extends JFrame {
	private ImageIcon slika;
	private JLabel label;

	Sastav() {
		setLayout(new FlowLayout());
		slika = new ImageIcon(getClass().getResource("sastavi.png"));
		label = new JLabel(slika);
		add(label);

	}
}
