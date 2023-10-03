package main.battleship.client.App;

import java.util.ArrayList;

import main.battleship.client.ClientThread;
import main.battleship.client.Controller.Draw;
import main.battleship.client.Controller.draw.ArtList;
import main.battleship.client.Controller.draw.Rect;
import main.battleship.logic.Board;

public class Program extends Thread{
  ClientThread parent;
  Board board;
  ArrayList<String> awaiting = new ArrayList<>();
  @Override
  public void start(){
    board = new Board();
    addBoundingBox();
    super.start();
  }

  private void addBoundingBox(){
    ArtList scene = new ArtList();
    for (int i = 0; i < 11; i++) {
      scene.add(new Rect(100*i-2,0,3,1000,0,0,0));
    }
    for (int i = 0; i < 11; i++) {
      scene.add(new Rect(0,100*i-2,1000,3,0,0,0));
    }
    Draw.getDraw().addScene(scene);
  }

  @Override
  public void run(){
    int h = 0;
    while(true){
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
  public void serverUpdates(String message) {

  }
  public void sendMessage(String message){
    if(parent == null) {
      awaiting.add(message);
      return;
    }
    parent.sendMessage(message);
  }
}
