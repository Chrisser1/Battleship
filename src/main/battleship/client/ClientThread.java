package main.battleship.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread{
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;
    public ClientThread(Socket s) {
        this.socket = s;
        try {
            this.input = new BufferedReader( new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // this.output = new PrintWritter(socket.getOutputStream(), true);
    }

    @Override
    public void run() {
        try {
            while (true) {
                String response = input.readLine();
                System.out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
