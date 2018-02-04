/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictacgame;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class Mode implements Initializable {

    @FXML
    private AnchorPane rootPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void back(MouseEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    private void computer(MouseEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("TicTacTrial.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    private void onLine(ActionEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("Client.fxml"));
        rootPane.getChildren().setAll(pane);
        
    }

    @FXML
    private void offLine(ActionEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("TicTacTrial.fxml"));
        rootPane.getChildren().setAll(pane);
    }
    
}
