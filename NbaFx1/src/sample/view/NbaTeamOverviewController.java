package sample.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import sample.MainApp;
import sample.model.NbaTeam;

import javax.swing.*;
import java.sql.*;

import static javax.swing.SwingUtilities.getRootPane;


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
    private void deleteFromDb() throws SQLException {
        //TODO: implement sql delete
        NbaTeam nt = nbaTeamTable.getSelectionModel().getSelectedItem();
        if (nt==null) {
            //JOptionPane.showMessageDialog(getRootPane(), "Prvo odaberi nbateam");
            return;
        }
        try {
            izraz = veza.prepareStatement("delete from nbateam where id_team=?");
            izraz.setInt(1, nt.getId_team() );

            if(izraz.executeUpdate()==0){
              //  JOptionPane.showMessageDialog(getRootPane(), "Nije ništa obrisao");
            }
            else{
                //ucitajizBaze();
               // ocistiPolja();
            }
            izraz.close();
        } catch (SQLIntegrityConstraintViolationException e) {
            //JOptionPane.showMessageDialog(getRootPane(), "Ne možeš obrisati to jer ima grupe");
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    @FXML
    private void handleDeleteTeam() throws SQLException {
        int selectedIndex = nbaTeamTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            nbaTeamTable.getItems().remove(selectedIndex);
            deleteFromDb();
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
            boolean okClicked = mainApp.showTeamEditDialog(selectedTeam);
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