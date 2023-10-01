package main.battleship.client;

// import main.battleship.gui.App.Program;
// import main.battleship.gui.Controller.Draw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Client
 */
public class Client {
  // private static Program client = new Program();
  public static void main(String[] args) {
    try (Socket socket = new Socket("localhost",6666)){
      //reading the input from server
      BufferedReader input = new BufferedReader( new InputStreamReader(socket.getInputStream()));
      //returing the output to the server : true statement is to flush the buffer otherwise
      //we have to do it manuallyy
      PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
      //taking the user input
      Scanner scanner = new Scanner(System.in);
      String userInput;
      String response;
      String clientName = "empty";
      ClientThread clientThread = new ClientThread(socket);
      clientThread.start();
      //loop closes when user enters exit command
      do {
        if (clientName.equals("empty")) {
          System.out.println("Enter your name ");
          userInput = scanner.nextLine();
          clientName = userInput;
          output.println(userInput);
          if(userInput.equals("exit")) {
            break;
          }
        }
        else {
          String message = ( "(" + clientName + ")"+" message : ");
          System.out.println(message);
          userInput = scanner.nextLine();
          output.println(message + " " + userInput);
          if(userInput.equals("exit")) {
            break;
          }
        }
      } while (!userInput.equals("exit"));
    } catch (IOException e) {
        e.printStackTrace();
    }
  }
}
