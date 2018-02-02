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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mahmoud
 */
public class Server {
    private ServerSocket serverSocket;
    private Socket socket;
    public static void main(String[] args) throws IOException
    {
        new Server();
        
    }
    public Server() throws IOException
    {
        serverSocket=new ServerSocket(5005);
        socket=serverSocket.accept();
        new Handel(socket);
    }
}
class Handel extends Thread
{
    ObjectInputStream ois;
    ObjectOutputStream oos;
    static Vector<Handel> players=new Vector<Handel>();
    public Handel(Socket s) 
    {
        try {
            ois=new ObjectInputStream(s.getInputStream());
            oos=new ObjectOutputStream(s.getOutputStream());
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
        try {
            Label labelName=(Label)ois.readObject();
            send(labelName);
        } 
          catch (ClassNotFoundException | IOException ex) {
               Logger.getLogger(Handel.class.getName()).log(Level.SEVERE, null, ex);
           }
      } 
     } 
    private void send(Label labelName) throws IOException
    {
        for (Handel pl: players)
        {
            pl.oos.writeObject(labelName);
        }
    }
}
