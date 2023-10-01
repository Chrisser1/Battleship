package main.battleship.server;

import java.net.*;
import java.io.*;

public class Client {
  private Socket clientSocket;
  private PrintWriter out;
  private BufferedReader in;

  public void startConnection(String ip, int port) {
    try {
      clientSocket = new Socket(ip, port);
      out = new PrintWriter(clientSocket.getOutputStream(), true);
      in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String sendMessage(String msg) throws NullPointerException {
    out.println(msg);
    String resp = null;
    try {
      resp = in.readLine();
    } catch(IOException e) {
      e.printStackTrace();
    }
    return resp;
  }

  public void stopConnection() {
    try {
        in.close();
        out.close();
        clientSocket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}