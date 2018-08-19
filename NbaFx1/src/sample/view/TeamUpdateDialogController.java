package sample.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.model.NbaTeam;
import sample.util.NamedParameterStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 */
public class TeamUpdateDialogController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField id_team;

    private Stage dialogStage1;
    private NbaTeam team;
    private boolean okClicked1 = false;

    private Connection veza;
    private PreparedStatement izraz;

    @FXML
    private TableView<NbaTeam> nbaTeamTable;

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
    public void setDialogStage1(Stage dialogStage1) {
        this.dialogStage1 = dialogStage1;
    }

    /**
     * Sets the team to be edited in the dialog.
     *
     * @param team
     */
    public void setTeam1(NbaTeam team) {
        this.team = team;
        nameField.setText(team.getName());
        cityField.setText(team.getCity());
    }

    /**
     * Sets the connection
     *
     * @param veza
     */
    public void setDbConnection1(Connection veza) {
        this.veza = veza;
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked1() {
        return okClicked1;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk1() {
        if (isInputValid()) {
            team.setName(nameField.getText());
            team.setCity(cityField.getText());
            saveToDb1();
            okClicked1 = true;
            dialogStage1.close();
        }
    }

    private void saveToDb1() {
        NbaTeam nt = nbaTeamTable.getSelectionModel().getSelectedItem();
        if (nt == null) {
            //JOptionPane.showMessageDialog(getRootPane(), "Prvo odaberi nbateam");
            return ;
        }
        try {
            NamedParameterStatement izraz = new NamedParameterStatement(veza,
                    "update nbateam set name=:name, "
                            + "city=:city"
                            + " where id_team=:id_team");
            izraz.setString("name", nameField.getText());
            izraz.setString("city", nameField.getText());
            izraz.setInt("id_team", nt.getId_team());

            if(izraz.izvedi()==0){
                //JOptionPane.showMessageDialog(getRootPane(), "Nije promjenjeno");
            }
            else{
                //ocistiPolja();
                //ucitajizBaze();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage1.close();
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
            alert.initOwner(dialogStage1);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}
