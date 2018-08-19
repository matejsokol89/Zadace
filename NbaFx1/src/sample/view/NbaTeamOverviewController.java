package sample.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.MainApp;
import sample.model.NbaTeam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;


public class NbaTeamOverviewController {
    @FXML
    private TableView<NbaTeam> nbaTeamTable;
    @FXML
    private TableColumn<NbaTeam, String> name;
    @FXML
    private TableColumn<NbaTeam, String> city;

    @FXML
    private Label nameLabel;
    @FXML
    private Label cityLabel;

    // Reference to the main application.
    private MainApp mainApp;

    private Connection veza;
    private PreparedStatement izraz;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public NbaTeamOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        name.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        city.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
        
        // Clear person details.
        showNbaTeamDataDetail(null);

        // Listen for selection changes and show the person details when changed.
        nbaTeamTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showNbaTeamDataDetail(newValue));
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        nbaTeamTable.setItems(mainApp.getNbaTeamData());
    }

    /**
     * Sets the connection
     *
     * @param veza
     */
    public void setDbConnection(Connection veza) {
        this.veza = veza;
    }
    public void setDbConnection1(Connection veza) {
        this.veza = veza;
    }


    /**
     * Fills all text fields to show details about the person.
     * If the specified person is null, all text fields are cleared.
     * 
     * @param team the person or null
     */
    private void showNbaTeamDataDetail(NbaTeam team) {
        if (team != null) {
            // Fill the labels with info from the team object.
            nameLabel.setText(team.getName());
            cityLabel.setText(team.getCity());
        } else {
            // Team is null, remove all the text.
            nameLabel.setText("");
            cityLabel.setText("");
        }
    }
    
    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private boolean deleteFromDb() throws SQLException {
        NbaTeam nt = nbaTeamTable.getSelectionModel().getSelectedItem();
        if (nt == null) {
            //JOptionPane.showMessageDialog(getRootPane(), "Prvo odaberi nbateam");
            return false;
        }
        try {
            System.out.println("Selected and deleting " + nt.toString());
            izraz = veza.prepareStatement("delete from nbateam where id_team=?");
            izraz.setInt(1, nt.getId_team());

            if (izraz.executeUpdate() == 0) {
                //  JOptionPane.showMessageDialog(getRootPane(), "Nije ništa obrisao");
            } else {
                //ucitajizBaze();
                // ocistiPolja();
            }
            izraz.close();
            return true;
        } catch (SQLIntegrityConstraintViolationException e) {
            //JOptionPane.showMessageDialog(getRootPane(), "Ne možeš obrisati to jer ima grupe");
            System.out.println(e.getMessage());
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("NBA Team Delete Error");
            alert.setHeaderText("Unable to delete from database");
            Label label = new Label(e.getMessage());
            label.setWrapText(true);
            alert.getDialogPane().setContent(label);

            alert.showAndWait();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @FXML
    private void handleDeleteTeam() throws SQLException {
        int selectedIndex = nbaTeamTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            if (deleteFromDb()) {
                nbaTeamTable.getItems().remove(selectedIndex);
            }
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Team Selected");
            alert.setContentText("Please select a team in the table.");

            alert.showAndWait();
        }
    }




    
    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new person.
     */
    @FXML
    private void handleNewTeam() {

        NbaTeam tempTeam = new NbaTeam();
        boolean okClicked = mainApp.showTeamEditDialog(tempTeam);
        if (okClicked) {
            mainApp.getNbaTeamData().add(tempTeam);
        }
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected person.
     */
    @FXML
    private void handleEditTeam() {
        NbaTeam selectedTeam = nbaTeamTable.getSelectionModel().getSelectedItem();
        if (selectedTeam != null) {
            boolean okClicked1 = mainApp.showTeamUpdateDialog(selectedTeam);
            if (okClicked1) {
               showNbaTeamDataDetail(selectedTeam);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Team Selected");
            alert.setContentText("Please select a team in the table.");
            
            alert.showAndWait();
        }
    }


    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected person.
     */
    @FXML
    private void handleUpdateTeam() {
        NbaTeam selectedTeam = nbaTeamTable.getSelectionModel().getSelectedItem();
        if (selectedTeam != null) {
            boolean okClicked = mainApp.showTeamUpdateDialog(selectedTeam);
            if (okClicked) {
                showNbaTeamDataDetail(selectedTeam);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Team Selected");
            alert.setContentText("Please select a team in the table.");

            alert.showAndWait();
        }
    }
}