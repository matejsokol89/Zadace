
package sokol.ljetnizadatak;

import de.javasoft.plaf.synthetica.SyntheticaBlackMoonLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlueIceLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlueMoonLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaSilverMoonLookAndFeel;
import javax.swing.UIManager;
import sokol.ljetnizadatak.view.Menu;



/**
 *
 * @author Sokol
 */

//START KLASA
public class Start {

    
    public static void main(String[] args) {
        
        try {
            UIManager.setLookAndFeel(new SyntheticaBlueIceLookAndFeel());
                    new Menu().setVisible(true);

        } catch (Exception e) {
        }
        
        
    }
    
}
