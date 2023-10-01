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
    game.givenClient_whenServerEchosMessage_thenCorrect();
  }

  public void givenClient_whenServerEchosMessage_thenCorrect() {
    Client client = new Client();
    client.startConnection("127.0.0.1", 6666);
    String resp1 = client.sendMessage("hello");
    String resp2 = client.sendMessage("world");
    String resp3 = client.sendMessage("!");
    String resp4 = client.sendMessage("good bye");

    assertEquals("hello", resp1);
    assertEquals("world", resp2);
    assertEquals("!", resp3);
    assertEquals("good bye", resp4);
    String terminate = client.sendMessage(".");
  }
  
  public void assertEquals(String one, String two) {
    System.out.println("is "+ one + " equal to " + two + ": " + one.equals(two));
  }
}
