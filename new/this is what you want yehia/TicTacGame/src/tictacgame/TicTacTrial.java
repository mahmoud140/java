/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictacgame;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.Bloom;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.imageio.event.IIOWriteWarningListener;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class TicTacTrial implements Initializable {
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Label box1;
    @FXML
    private Label box2,box3,box4,box5,box6,box7,box8, box9,player1,player2;
    Label arrayOfObject[]=new Label[9];
    private String turn="x";
    private boolean flag=true;
    private String[][] values=new String[3][3];
    private boolean playable=true;
    Bloom bloom=new Bloom();
    private String winnerSymbol;
    @FXML
    private Label winWait;
    
    void check(){
        if(flag)
            turn="x";
        else
            turn="o";
            }
    void win()
    {
        for(int x=0;x<3;x++) //horizontal check
        {
           if(!(values[x][1].equals(" "))){              /////////because of all the values[][] will be intialized with the same value
           if(values[x][0].equals(values[x][1]) && values[x][0].equals(values[x][2])){
               playable=false;
               winnerSymbol=values[x][0];
        }}}                                               //////can be one condition but will be very big
        for (int j=0;j<3;j++)//vertical
        {
            if(!(values[1][j].equals(" ")))
            {
                if(values[0][j].equals(values[1][j]) && values[0][j].equals(values[2][j])){
                    playable=false;
                    winnerSymbol=values[1][j];
            }}
        }
        if(!(values[1][1].equals(" "))){
        if(((values[0][0].equals(values[1][1])) && values[0][0].equals(values[2][2])) || (values[0][2].equals(values[1][1]) && values[0][2].equals(values[2][0]))){
        playable=false; 
        winnerSymbol=values[1][1];
        }
      }
        if(!playable)
            writeWinner(winnerSymbol);
    }
    
    private void writeWinner(String winS)
    {
        Platform.runLater(new Runnable()
        {
            @Override
           public void run()
            {
                winWait.setVisible(true);
                winWait.toFront();
                winWait.setText("Winner is player"+winS);  }
        });
    }
        
    void initializeArray()
    {
        for(int i=0;i<3;i++)
        {
            for(int y=0;y<3;y++)
            {
                values[i][y]=" ";
            }
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        player1.setEffect(bloom);
        initializeArray();
        arrayOfObject[0]=box1;
        arrayOfObject[1]=box2;
        arrayOfObject[2]=box3;
        arrayOfObject[3]=box4;
        arrayOfObject[4]=box5;
        arrayOfObject[5]=box6;
        arrayOfObject[6]=box7;
        arrayOfObject[7]=box8;
        arrayOfObject[8]=box9;
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
        for(Label any : arrayOfObject){
            if(event.getTarget().equals(any)){
        if(playable && !(any.getText().equals("x"))&&!(any.getText().equals("o"))){
        if(turn.equals("x")){
            player1.setEffect(null);
            player2.setEffect(bloom);}
        else{
            player1.setEffect(bloom);
            player2.setEffect(null);
        }
        any.setAlignment(Pos.CENTER);
        any.setText(turn);
            System.out.println(event.getTarget().toString().split("=")[1].split(",")[0]);
        switch(event.getTarget().toString().split("=")[1].split(",")[0]){
            case "box1":
            values[0][0]=turn;
            break;
            case "box2":
                values[0][1]=turn;
            break;
            case "box3":
                values[0][2]=turn;
            break;
            case "box4":
                values[1][0]=turn;
            break;
            case "box5":
                values[1][1]=turn;
            break;
            case "box6":
                values[1][2]=turn;
            break;
            case "box7":
                values[2][0]=turn;
            break;
            case "box8":
                values[2][1]=turn;
            break;
            case "box9":
                values[2][2]=turn;
            break;
            
        }
        win();
        flag=!flag;
        check();
        }
       }
      }
    }
}
//
//    private void box2(MouseEvent event) {
//        if(playable && !(box2.getText().equals("x"))&&!(box2.getText().equals("o"))){
//            if(turn.equals("x")){
//            player1.setEffect(null);
//            player2.setEffect(bloom);}
//        else{
//            player1.setEffect(bloom);
//            player2.setEffect(null);
//        }
//        box2.setAlignment(Pos.CENTER);
//        box2.setText(turn);
//        flag=!flag;
//        check();
//        values[0][1]=turn;
//        win();
//        }}
//
//    private void box3(MouseEvent event) {
//        if(playable && !(box3.getText().equals("x"))&&!(box3.getText().equals("o"))){
//            if(turn.equals("x")){
//            player1.setEffect(null);
//            player2.setEffect(bloom);}
//        else{
//            player1.setEffect(bloom);
//            player2.setEffect(null);
//        }
//        box3.setAlignment(Pos.CENTER);
//        box3.setText(turn);
//        flag=!flag;
//        check();
//        values[0][2]=turn;
//        win();
//    }}
//
//    private void box4(MouseEvent event) {
//        if(playable && !(box4.getText().equals("x"))&&!(box4.getText().equals("o"))){
//            if(turn.equals("x")){
//            player1.setEffect(null);
//            player2.setEffect(bloom);}
//        else{
//            player1.setEffect(bloom);
//            player2.setEffect(null);
//        }
//        box4.setAlignment(Pos.CENTER);
//        box4.setText(turn);
//        flag=!flag;
//        check();
//        values[1][0]=turn;
//        win();
//    }}
//
//    private void box5(MouseEvent event) {
//        if(playable && !(box5.getText().equals("x"))&&!(box5.getText().equals("o"))){
//            if(turn.equals("x")){
//            player1.setEffect(null);
//            player2.setEffect(bloom);}
//        else{
//            player1.setEffect(bloom);
//            player2.setEffect(null);
//        }
//        box5.setAlignment(Pos.CENTER);
//        box5.setText(turn);
//        flag=!flag;
//        check();
//        values[1][1]=turn;
//        win();
//    }}
//
//    private void box6(MouseEvent event) {
//        if(playable && !(box6.getText().equals("x"))&&!(box6.getText().equals("o"))){
//            if(turn.equals("x")){
//            player1.setEffect(null);
//            player2.setEffect(bloom);}
//        else{
//            player1.setEffect(bloom);
//            player2.setEffect(null);
//        }
//        box6.setAlignment(Pos.CENTER);
//        box6.setText(turn);
//        flag=!flag;
//        check();
//        values[1][2]=turn;
//        win();
//    }}
//
//    private void box7(MouseEvent event) {
//        if(playable && !(box7.getText().equals("x"))&&!(box7.getText().equals("o"))){
//            if(turn.equals("x")){
//            player1.setEffect(null);
//            player2.setEffect(bloom);}
//        else{
//            player1.setEffect(bloom);
//            player2.setEffect(null);
//        }
//        box7.setAlignment(Pos.CENTER);
//        box7.setText(turn);
//        flag=!flag;
//        check();
//        values[2][0]=turn;
//        win();
//    }}
//
//    private void box8(MouseEvent event) {
//        if(playable && !(box8.getText().equals("x"))&&!(box8.getText().equals("o"))){ 
//            if(turn.equals("x")){
//            player1.setEffect(null);
//            player2.setEffect(bloom);}
//        else{
//            player1.setEffect(bloom);
//            player2.setEffect(null);
//        }
//        box8.setAlignment(Pos.CENTER);
//        box8.setText(turn);
//        flag=!flag;
//        check();
//        values[2][1]=turn;
//        win();
//    }}
//
//    private void box9(MouseEvent event) {
//        if(playable && !(box9.getText().equals("x"))&& !(box9.getText().equals("o"))){
//            if(turn.equals("x")){
//            player1.setEffect(null);
//            player2.setEffect(bloom);}
//        else{
//            player1.setEffect(bloom);
//            player2.setEffect(null);
//        }
//        box9.setAlignment(Pos.CENTER);
//        box9.setText(turn);
//        flag=!flag;
//        check();
//        values[2][2]=turn;
//        win();
//    }
//   }
//    
//}
