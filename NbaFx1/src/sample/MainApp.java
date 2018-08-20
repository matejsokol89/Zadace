package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.model.NbaTeam;
import sample.view.NbaTeamOverviewController;
import sample.view.TeamEditDialogController;
import sample.view.TeamUpdateDialogController;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;
import java.text.Collator;
import java.util.*;


public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    /**
     * The data as an observable list of Teams.
     */
    private ObservableList<NbaTeam> nbaTeamData = FXCollections.observableArrayList();

    /**
     * Constructor
     */
    public MainApp() {
        initDbConnection();
    }

    private Connection veza;
    private PreparedStatement izraz;

    private void initDbConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            veza = DriverManager.getConnection("jdbc:mysql://localhost:3306/NBA_STATS?"
                    + "user=edunova&password=edunova&serverTimezone=CET&useUnicode=true&characterEncoding=utf-8");
            ucitajizBaze();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    private void ucitajizBaze() {
        try {
            izraz = veza.prepareStatement("select * from nbateam");
            ResultSet rs = izraz.executeQuery();
            List<NbaTeam> lista = new ArrayList<>();
            NbaTeam nt;
            while (rs.next()) {
                nt = new NbaTeam();
                nt.setId_team(rs.getInt("id_team"));
                nt.setCity(rs.getString("city"));
                nt.setName(rs.getString("name"));
                lista.add(nt);
            }
            rs.close();
            izraz.close();
            Collections.sort(lista, new Comparator<NbaTeam>() {
                Collator col = Collator.getInstance(new Locale("hr", "HR"));

                public int compare(NbaTeam nt1, NbaTeam nt2) {

                    return col.compare(nt1.getName(), nt2.getName());
                }
            });
            DefaultListModel<NbaTeam> m = new DefaultListModel<>();
            lista.forEach((nbaTeam) -> m.addElement(nbaTeam));
            lista.forEach((item) -> System.out.println(item));
            nbaTeamData.setAll(lista);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the data as an observable list of Persons.
     *
     * @return
     */
    public ObservableList<NbaTeam> getNbaTeamData() {

        return nbaTeamData;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Nba Teams App");

        initRootLayout();

        showNbaTeamOverview();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showNbaTeamOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/NbaTeamOverview.fxml"));
            AnchorPane nbaTeamOverview = (AnchorPane) loader.load();

            // Set team overview into the center of root layout.
            rootLayout.setCenter(nbaTeamOverview);

            // Give the controller access to the main app.
            NbaTeamOverviewController controller = loader.getController();
            controller.setMainApp(this);
            controller.setDbConnection(veza);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Opens a dialog to edit details for the specified person. If the user
     * clicks OK, the changes are saved into the provided person object and true
     * is returned.
     *
     * @param team the person object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean showTeamEditDialog(NbaTeam team) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/TeamEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Team");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            TeamEditDialogController controller = loader.getController();
            controller.setDbConnection(veza);
            controller.setDialogStage(dialogStage);
            controller.setTeam(team);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean showTeamUpdateDialog(NbaTeam team) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            //loader.setLocation(TeamUpdateDialogController.class.getResource("/sample/FXML.fxml"));
            loader.setLocation(MainApp.class.getResource("view/TeamUpdateDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage1 = new Stage();
            dialogStage1.setTitle("Update Team");
            dialogStage1.initModality(Modality.WINDOW_MODAL);
            dialogStage1.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage1.setScene(scene);

            // Set the person into the controller.

            TeamUpdateDialogController controller = loader.getController();
            controller.setDbConnection1(veza);
            controller.setDialogStage1(dialogStage1);
            controller.setTeam1(team);

            // Show the dialog and wait until the user closes it
            dialogStage1.showAndWait();

            return controller.isOkClicked1();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * Returns the main stage.
     *
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}