/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Label;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mahmoud
 */
public class Server implements Serializable{
    private ServerSocket serverSocket;
    private Socket socket;
    public static void main(String[] args) throws IOException
    {
        new Server();
        
    }
    public Server() throws IOException
    {
        serverSocket=new ServerSocket(5005);
        while(true)
        {
            
             socket=serverSocket.accept();
             new Handel(socket);
        }
        
    }
}
class Handel extends Thread
{
    DataInputStream dis;
    PrintStream dos;
    private String utrun1="true";
   private String utrun2="false";
   static private int i=0;
    static Vector<Handel> players=new Vector<Handel>();
    public Handel(Socket s) 
    {
        try {
            dos=new PrintStream(s.getOutputStream());
            dis=new DataInputStream(s.getInputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        players.add(this);
//        i++;
        start();
//        if(i==2)
//        {
//            sendTurn();
//        }
    }
    private void sendTurn()
    {
       players.firstElement().dos.println(true);
       players.get(1).dos.println(false);     
    }
    @Override
    public void run()
    {     
       while(true)
      {
      if(!(players.size()<2)){
        try {
            if(i==0){
            sendTurn();
            i++;}
            String fxid=dis.readLine();
            String value=dis.readLine();
//            System.out.println(fxid);
//            System.out.println(value);
            send(fxid);
            sendvalue(value);
        } 
          catch (IOException ex) {
               players.firstElement().dos.println("the other player is out");
               players.remove(this);
               break;
           }
     }
      else
      {
          dos.println("waitting");
      }
    }
    }
    private void send(String labelName) throws IOException
    {
        for (Handel pl: players)
        {
            pl.dos.println(labelName);   
        }   
    }
    private void sendvalue(String value)
    {
        for (Handel pl: players)
        {
            if(pl==players.elementAt(0))
            {
                if(players.elementAt(0).utrun1.equals("true"))
                {
                    players.elementAt(0).utrun1="false";
                }
                else
                {
                    players.elementAt(0).utrun1="true";
                }
                pl.dos.println(value);
                pl.dos.println(players.elementAt(0).utrun1);
                System.out.println("utrn1"+players.elementAt(0).utrun1);
            }
            else if(pl==players.elementAt(1))
            {
                if(players.elementAt(1).utrun2.equals("true"))
                {
                    players.elementAt(1).utrun2="false";
                }
                else
                {
                    players.elementAt(1).utrun2="true";
                }
                pl.dos.println(value);
                pl.dos.println(players.elementAt(1).utrun2);
                System.err.println("utrn2"+players.elementAt(1).utrun2);
            }
    }
}
}
