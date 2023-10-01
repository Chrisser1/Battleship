package main.battleship.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread{
    private Socket socket;
    private ArrayList<ServerThread> threadList;
    public ServerThread(Socket socket, ArrayList<ServerThread> threads) {
        
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