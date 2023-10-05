package main.battleship.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import main.battleship.client.App.Program;
import main.battleship.client.Controller.Draw;

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
                serverResponseReader(response);

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

    private void serverResponseReader(String response){
        if (response.contains("Size: ")){
            response = removeColonAndSpace(response);
            Draw.getDraw().getProgram().SetPlayerCount(Integer.parseInt(response));
        }
    }

    private String removeColonAndSpace(String input){        
        // Find the index of ": "
        int indexOfColonSpace = input.indexOf(": ");
        
        // Check if ": " was found
        if (indexOfColonSpace != -1) {
            // Use substring to get the text after the first occurrence of ": "
            String result = input.substring(indexOfColonSpace + 2); // +2 to skip ": "
            return result;
        } else {
            // ": " not found in the string
            System.out.println("': ' not found in the input string");
            return input;
        }
    }
}
