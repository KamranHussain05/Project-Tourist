
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class Controller{

    @FXML
    private ProgressBar loadProgress = new ProgressBar();
    private WebView loadImage;
    @FXML
    private TextField userInputs;
    @FXML
    private Label destination;

    @FXML
    public void onEnterButtonClick() throws IOException, InterruptedException {
        Parent root = FXMLLoader.load(getClass().getResource("loadScreen.fxml"));

        Stage window = (Stage) userInputs.getScene().getWindow();
        window.setScene(new Scene(root, 800, 520));

        //changeScreen();
    }

    @FXML
    public void changeScreen() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("endscreen.fxml"));

        Stage window = (Stage) userInputs.getScene().getWindow();
        window.setScene(new Scene(root, 800, 520));
    }

    public void onLaunchActivities() {
        System.out.println("Launching Activities");
    }

    public void onLaunchFlights() {
        System.out.println("Launching Flights");
    }

    public void onLaunchHotels() throws IOException, InterruptedException {
        System.out.println("Launching Hotels");
        changeScreen();
    }
}
