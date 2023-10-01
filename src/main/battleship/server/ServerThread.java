package main.battleship.server;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread{
    private Socket socket;
    private ArrayList<ServerThread> threadList;
    private PrintWriter output;
    public ServerThread(Socket socket, ArrayList<ServerThread> threads) {
        this.socket = socket;
        this.threadList = threads;
    }

    @Override
    public void run() {
        try {
            //Reading the input from Client
            OutputStream outputStream = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
            BufferedWriter input = new BufferedWriter(writer);
            
            //returning the output to the client : true statement is to flush the buffer otherwise
            //we have to do it manually
            output = new PrintWriter(socket.getOutputStream(),true);


            //infite loop for the server
            while(true) {
                String outputString = input.
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //using serversocket as argument to automatically close the socket
        //the port number is unique for each server
        
        //list to add all the clients thread
        ArrayList<ServerThread> threadList = new ArrayList<>();
        try(ServerSocket serverSocket = new ServerSocket(6666)) {
            while(true) {
                Socket socket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket, threadList);
                // Staring the thread
                threadList.add(serverThread);
                serverThread.start();

                //Get all the list of currently running thread
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}