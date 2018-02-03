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
        start();
    }
    @Override
    public void run()
    {
      
       while(true)
      {
//       if(!(players.size()<2)){
        try {
//            String value=dis.readLine();
            String fxid=dis.readLine();
            System.out.println(fxid);
//            System.out.println(value);
            send(fxid);
//            send(value);
        } 
          catch (IOException ex) {
              // Logger.getLogger(Handel.class.getName()).log(Level.SEVERE, null, ex);
               players.remove(this);
               break;
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
}
