package main.battleship.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import main.battleship.client.App.Program;

public class ClientThread extends Thread{
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;
    private Program program;
    public ClientThread(Socket s, Program program) {
        this.program = program;
        this.socket = s;
        try {
            this.input = new BufferedReader( new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            this.output = new PrintWriter(s.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        output.println(message);
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Server input
                String response = input.readLine();
                program.serverUpdates(response);
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
