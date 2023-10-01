package main.battleship;

import main.battleship.server.*;

public class BattleshipGame {
  public static void main(String[] args) {
    BattleshipGame e = new BattleshipGame();
    e.givenGreetingClient_whenServerRespondsWhenStarted_thenCorrect();
  }
  public void givenGreetingClient_whenServerRespondsWhenStarted_thenCorrect() {
    Client client = new Client();
    client.startConnection("127.0.0.1", 6666);
    String response = client.sendMessage("hello server");
    System.out.println("hello client".equals(response));
  }
}