package main.battleship.client;

// import main.battleship.gui.App.Program;
// import main.battleship.gui.Controller.Draw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import main.battleship.client.Controller.Draw;

/**
 * Client
 */
public class Client {
  // private static Program client = new Program();
  public static void main(String[] args) {
    Draw.run();

    try (Socket socket = new Socket("localhost",6666)){
      //reading the input from server
      // BufferedReader input = new BufferedReader( new InputStreamReader(socket.getInputStream()));
      
      //returing the output to the server : true statement is to flush the buffer otherwise
      //we have to do it manuallyy
      // PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
      ClientThread clientThread = new ClientThread(socket,Draw.getDraw().getProgram());
      Draw.getDraw().getProgram().setParent(clientThread);
      

      clientThread.start();

      do {
        // keeps the socket connections
        // you can also talk to the server from here
      } while (true);
    } catch (IOException e) {
        e.printStackTrace();
    }
  }
}
