package main.battleship;

import main.battleship.server.*;

public class BattleshipGame {
  public static void main(String[] args) {
    // Start the server on a new thread
    new Thread(() -> {
            Server server = new Server();
            server.start(6666);
    }).start();

    // Pause to ensure server starts before client tries to connect
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      e.printStackTrace();
    }

    BattleshipGame game = new BattleshipGame();
    game.givenGreetingClient_whenServerRespondsWhenStarted_thenCorrect();
  }
  
  public void givenGreetingClient_whenServerRespondsWhenStarted_thenCorrect() {
    // Assuming Client class and it's methods are correctly defined
    Client client = new Client();
    client.startConnection("127.0.0.1", 6666);
    String response = client.sendMessage("hello server");
    System.out.println("'Hello client' received from server: " + "hello client".equals(response));
  }
}
