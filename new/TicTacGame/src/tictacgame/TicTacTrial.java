/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictacgame;

import java.awt.Button;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import static javax.management.Query.value;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class TicTacTrial implements Initializable {
    @FXML
    private javafx.scene.control.Button btn1;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Label box1;
    private Label h;
    @FXML
    private Label box2;
    @FXML
    private Label box3;
    @FXML
    private Label box4;
    @FXML
    private Label box5;
    @FXML
    private Label box6;
    @FXML
    private Label box7;
    @FXML
    private Label box8;
    @FXML
    private Label box9;
    private String turn="x";
    private boolean flag=true;
    private String[][] values=new String [3][3];
    private boolean playable=true;
    void check(){
        if(flag)
            turn="x";
        else
            turn="o";
            }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    

    @FXML
    private void pause(MouseEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
       rootPane.getChildren().setAll(pane);
    }

    @FXML
    private void exit(MouseEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
       rootPane.getChildren().setAll(pane);
    }
    
    @FXML
    private void box1(MouseEvent event) {
        if(playable){
        box1.setAlignment(Pos.CENTER);
        if(box1.getText().equals("")){
        box1.setText(turn);
        flag=!flag;
        check();
        values[0][0]=turn;
        }}
    }

    @FXML
    private void box2(MouseEvent event) {
        if(playable && !(box2.getText().equals("x"))&&!(box2.getText().equals("o"))){
        box2.setAlignment(Pos.CENTER);
        box2.setText(turn);
        flag=!flag;
        check();
        values[0][1]=turn;
        }}

    @FXML
    private void box3(MouseEvent event) {
        if(playable && !(box3.getText().equals("x"))&&!(box3.getText().equals("o"))){
        box3.setAlignment(Pos.CENTER);
        box3.setText(turn);
        flag=!flag;
        check();
        values[0][2]=turn;
    }}

    @FXML
    private void box4(MouseEvent event) {
        if(playable && !(box4.getText().equals("x"))&&!(box4.getText().equals("o"))){
        box4.setAlignment(Pos.CENTER);
        box4.setText(turn);
        flag=!flag;
        check();
        values[1][0]=turn;
    }}

    @FXML
    private void box5(MouseEvent event) {
        if(playable && !(box5.getText().equals("x"))&&!(box5.getText().equals("o"))){
        box5.setAlignment(Pos.CENTER);
        box5.setText(turn);
        flag=!flag;
        check();
        values[1][1]=turn;
    }}

    @FXML
    private void box6(MouseEvent event) {
        if(playable && !(box6.getText().equals("x"))&&!(box6.getText().equals("o"))){
        box6.setAlignment(Pos.CENTER);
        box6.setText(turn);
        flag=!flag;
        check();
        values[1][2]=turn;
    }}

    @FXML
    private void box7(MouseEvent event) {
        if(playable && !(box7.getText().equals("x"))&&!(box7.getText().equals("o"))){
        box7.setAlignment(Pos.CENTER);
        box7.setText(turn);
        flag=!flag;
        check();
        values[2][0]=turn;
    }}

    @FXML
    private void box8(MouseEvent event) {
        if(playable && !(box8.getText().equals("x"))&&!(box8.getText().equals("o"))){   
        box8.setAlignment(Pos.CENTER);
        box8.setText(turn);
        flag=!flag;
        check();
        values[2][1]=turn;
    }}

    @FXML
    private void box9(MouseEvent event) {
        if(playable && !(box9.getText().equals("x"))&& !(box9.getText().equals("o"))){
        box9.setAlignment(Pos.CENTER);
        box9.setText(turn);
        flag=!flag;
        check();
        values[2][2]=turn;
    }}
    
}
