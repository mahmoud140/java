/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictacgame;

import java.awt.Button;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.Bloom;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import static javax.management.Query.value;
import java.io.Serializable;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * FXML Controller class
 *
 * @author Mahmoud
 */
public class Client implements Initializable, Runnable {
    private Socket mySocket;
    private DataInputStream dis;
    private PrintStream dos;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Label box2,box3,box4,box5,box6,box7,box8,box9,player1,player2;
    @FXML
    private Label box1;
    private String turn="x";
    private boolean flag=true;
    private String[][] values={{" "," "," "},{" "," "," "},{" "," "," "}};
    Label arrayOfObject[]=new Label[9];
    private boolean playable=true;
    Bloom bloom=new Bloom(); 
    @FXML
    private Label winWait;
    private String winnerSymbol;
    String value="";    
//    private void box1(ActionEvent event) 
//    {
//        if(playable && !(box1.getText().equals("x"))&&!(box1.getText().equals("o"))){
//        dos.println("box1");
//        values[0][0]=turn;
//      }
//    }
        @Override
        public void run() 
        {
            String fxid="";
//            turn="x";
            while(playable)
            {   
                if(turn.equals("x")){
                player1.setEffect(bloom);
                player2.setEffect(null);}
                else{
                player1.setEffect(null);
                player2.setEffect(bloom);
                }
                try {
                     fxid=dis.readLine();
                     value=dis.readLine();
                }
                 catch (IOException  | IllegalStateException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
                    switch(fxid)
                    {
                        case "box1" :
                    Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                       box1.setAlignment(Pos.CENTER);
                       values[0][0]=value;
                       box1.setText(value); 
                }});     
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        flag=!flag;
                        check();
                        win();
                        break;
                        case "box2" :
                           Platform.runLater(new Runnable() {
                           @Override
                           public void run() {
                             box2.setAlignment(Pos.CENTER);
                             values[0][1]=value;
                             box2.setText(value); 
                }});       
                           try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    }
                          flag=!flag;
                          check();
                          win();
                        break;
                        case "box3" :
                           Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                       box3.setAlignment(Pos.CENTER); 
                       values[0][2]=value;
                       box3.setText(value); 
                }});    
                        try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    }   
                        flag=!flag;
                        check();
                        win();
                        break;
                        case "box4" :
                            Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                       box4.setAlignment(Pos.CENTER);
                       values[1][0]=value;
                       box4.setText(value); 
                    }});  
                          try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    }
                          flag=!flag;
                          check();
                          win();
                        break;
                        case "box5" :
                    Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                       box5.setAlignment(Pos.CENTER);
                       values[1][1]=value;
                       box5.setText(value); 
                    }});
                        try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        flag=!flag;
                        check();
                        win();
                        break;
                    case "box6" :
                    Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                       box6.setAlignment(Pos.CENTER);
                       values[1][2]=value;
                       box6.setText(value); 
                }});    
                        try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        flag=!flag;
                        check();
                        win();
                        break;
                        case "box7" :
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                       box7.setAlignment(Pos.CENTER); 
                       values[2][0]=value;
                       box7.setText(value); 
                       win();
                }});     
                        try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        flag=!flag;
                        check();
                        win();
                        break;
                        case "box8" :
                         Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                       box8.setAlignment(Pos.CENTER);
                       values[2][1]=value;
                       box8.setText(value); 
                }});    
                        try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        flag=!flag;
                        check();
                        win();
                        break;
                        case "box9" :
                        Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                       box9.setAlignment(Pos.CENTER);
                       values[2][2]=value;
                       box9.setText(value); 
                }});    
                        try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        flag=!flag;
                        check();
                        win();
                        break;
                    }
                
//            }
        }
    }
    
        private void writeWinner(String winS)
    {
        Platform.runLater(new Runnable()
        {
            @Override
           public void run()
            {
                if(winS.equals("x")){
                    winWait.setText("Player1 is the winner");
                    winWait.setVisible(true);
                    winWait.toFront();}
                else if(winS.equals("o")){
                    winWait.setText("Player2 is the winner");
                    winWait.setVisible(true);
                    winWait.toFront();}
            }    
        });
    }
    
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        player1.setEffect(bloom);
         arrayOfObject[0]=box1;arrayOfObject[1]=box2;arrayOfObject[2]=box3;arrayOfObject[3]=box4;arrayOfObject[4]=box5;arrayOfObject[5]=box6;arrayOfObject[6]=box7;arrayOfObject[7]=box8;
        arrayOfObject[8]=box9;
        try {
        mySocket=new Socket("127.0.0.1",5005);
        dis=new DataInputStream(mySocket.getInputStream());
        dos=new PrintStream(mySocket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        Thread readThread =new Thread(this);
        readThread.start();
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
    private void box1(MouseEvent event) throws InterruptedException {
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
        dos.println(event.getTarget().toString().split("=")[1].split(",")[0]);
        dos.println(turn);
//        switch(event.getTarget().toString().split("=")[1].split(",")[0]){
//            case "box1":
//            values[0][0]=turn;
//            win();
//            break;
//            case "box2":
//                values[0][1]=turn;
//                win();
//            break;
//            case "box3":
//                values[0][2]=turn;
//                win();
//            break;
//            case "box4":
//                values[1][0]=turn;
//                win();
//            break;
//            case "box5":
//                values[1][1]=turn;
//                win();
//            break;
//            case "box6":
//                values[1][2]=turn;
//                win();
//            break;
//            case "box7":
//                values[2][0]=turn;
//                win();
//            break;
//            case "box8":
//                values[2][1]=turn;
//                win();
//            break;
//            case "box9":
//                values[2][2]=turn;
//                win();
//            break;
//            
//        }
//        Thread.sleep(100);
//        win();
//        flag=!flag;
//        check();
        }
       }
      }
    }
}
