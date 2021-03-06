package sample.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.model.NbaTeam;
import sample.util.NamedParameterStatement;

import java.sql.Connection;

/**
 *
 */
public class TeamUpdateDialogController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField cityField;

    private Stage dialogStage;
    private NbaTeam team;
    private boolean okClicked = false;

    private Connection veza;

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
     * @param dialogStage1
     */
    public void setDialogStage(Stage dialogStage1) {
        this.dialogStage = dialogStage1;
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
            team.setCity(cityField.getText());
            saveToDb();
            okClicked = true;
            dialogStage.close();
        }
    }

    private void saveToDb() {
        if (team == null) {
            //JOptionPane.showMessageDialog(getRootPane(), "Prvo odaberi nbateam");
            return;
        }
        try {
            NamedParameterStatement izraz = new NamedParameterStatement(veza,
                    "update nbateam set name=:name, "
                            + "city=:city"
                            + " where id_team=:id_team");
            izraz.setString("name", nameField.getText());
            izraz.setString("city", cityField.getText());
            izraz.setInt("id_team", team.getId_team());

            System.out.println("updating team: " + team + " with: " + nameField.getText() + " : " + cityField.getText());

            if (izraz.izvedi() == 0) {
                //JOptionPane.showMessageDialog(getRootPane(), "Nije promjenjeno");
            } else {
                //ocistiPolja();
                //ucitajizBaze();
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("NBA Team Update Error");
            alert.setHeaderText("Unable to update team to database");
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
