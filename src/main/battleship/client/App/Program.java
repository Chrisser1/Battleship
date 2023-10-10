package main.battleship.client.App;

import java.util.ArrayList;
import java.util.function.Function;

import main.battleship.client.ClientThread;
import main.battleship.client.Controller.Color;
import main.battleship.client.Controller.Draw;
import main.battleship.client.Controller.draw.ArtList;
import main.battleship.client.Controller.draw.ButtonSprite;
import main.battleship.client.Controller.draw.Rect;
import main.battleship.client.Controller.draw.TextBox;
import main.battleship.logic.Board;

public class Program extends Thread{
  ClientThread parent;
  Board board;
  ArtList scene = new ArtList();
  ArrayList<String> awaiting = new ArrayList<>();
  int playerCount;
  TextBox numberOfPlayersDisplayBox = new TextBox("Number of players: " + 0,870, 30, new Color(132, 132, 130), true, 10, 20, 5);
  boolean hasStartButton = false;

  @Override
  public void start(){
    addNewBoard(new Board(50, 250, 400));
    addNewBoard(new Board(550, 250, 400));
    scene.add(new TextBox("Battleship",500, 70, new Color(132, 132, 130), true, 10, 100, 10));
    Draw.getDraw().addScene(scene);
    super.start();
  }

  private void addNewBoard(Board board){
    final int squareSize = board.getSize() / 10;
    
    // Draw the vertical lines
    for (int i = 0; i <= 10; i++) {
        int posX = board.getX() + squareSize * i;
        scene.add(new Rect(posX, board.getY(), 3, board.getSize(), 0, 0, 0));
    }

    // Draw the horizontal lines
    for (int i = 0; i <= 10; i++) {
        int posY = board.getY() + squareSize * i;
        scene.add(new Rect(board.getX(), posY, board.getSize(), 3, 0, 0, 0));
    }
  }

  private void showPlayCount(){
    String currentNumberOfPlayers = "Number of players: " + playerCount;
    if(!numberOfPlayersDisplayBox.getText().contains(currentNumberOfPlayers)){
      Draw.getDraw().removeItem(numberOfPlayersDisplayBox);
      numberOfPlayersDisplayBox = new TextBox("Number of players: " + playerCount,870, 30, new Color(132, 132, 130), true, 10, 20, 5);
      // scene.add(numberOfPlayersDisplayBox);
      // Draw.getDraw().addScene(scene);
      Draw.getDraw().addItem(numberOfPlayersDisplayBox);
    }
  }

  public void SetPlayerCount(int playerCount){
    this.playerCount = playerCount;
  }

  private void checkIfGameIsReadyToStart() {
    if (this.playerCount > 1 && this.hasStartButton == false) {
      AddStartButton();
    }
  }

  private void AddStartButton() {
    ButtonSprite startButton = new ButtonSprite(730, 60, Draw.getDraw().getImage("src\\main\\battleship\\client\\App\\img\\StartButton.png")) {
      @Override
      public void onClick(int ID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onClick'");
      }
    };

    Draw.getDraw().addItem(startButton);
    this.hasStartButton = true;
  }

  @Override
  public void run(){
    int h = 0;
    while(true){
      showPlayCount();
      checkIfGameIsReadyToStart();
      sendMessage("hello " + h);
      h++;
      try {
        sleep(100);
      } catch (Exception e) {}
    }
  }
  public synchronized void setParent(ClientThread parent){
    this.parent = parent;
    for (int i = 0; i < awaiting.size(); i++) {
      this.parent.sendMessage(awaiting.get(i));
    }
  }

  public void sendMessage(String message){
    if(parent == null) {
      awaiting.add(message);
      return;
    }
    parent.sendMessage(message);
  }
}
