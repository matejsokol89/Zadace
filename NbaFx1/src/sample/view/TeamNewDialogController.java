package sample.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.model.NbaTeam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * Dialog to add new details of a team.
 *
 * @author Marco Jakob
 */
public class TeamNewDialogController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField cityField;

    private Stage dialogStage;
    private NbaTeam team;
    private boolean okClicked = false;

    private Connection veza;
    private PreparedStatement izraz;


    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the team to be edited in the dialog.
     *
     * @param team
     */
    public void setTeam(NbaTeam team) {
        this.team = team;
        nameField.setText(team.getName());
        cityField.setText(team.getCity());
    }

    /**
     * Sets the connection
     *
     * @param veza
     */
    public void setDbConnection(Connection veza) {
        this.veza = veza;
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            team.setName(nameField.getText());
            team.setCity(cityField.getText());saveToDb();

            okClicked = true;
            dialogStage.close();
        }
    }

    private void saveToDb() {
        try {

            izraz = veza.prepareStatement("insert into nbateam (name,city) " + " value (?,?)");
            izraz.setString(1, nameField.getText());
            izraz.setString(2, cityField.getText());

            System.out.println("NBA Team Add: " + izraz.toString());
            if (izraz.executeUpdate() == 0) {
                //JOptionPane.showMessageDialog(getRootPane(), "Nije unio ni jedan red");
            } else {
                //ucitajizBaze();
                //ocistiPolja();
            }
            izraz.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("NBA Team Add Error");
            alert.setHeaderText("Unable to add new team to database");
            Label label = new Label(ex.getMessage());
            label.setWrapText(true);
            alert.getDialogPane().setContent(label);

            alert.showAndWait();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (nameField.getText() == null || nameField.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }

        if (cityField.getText() == null || cityField.getText().length() == 0) {
            errorMessage += "No valid city!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}