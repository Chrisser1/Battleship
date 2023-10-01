package main.battleship.client.App;

import main.battleship.client.Controller.Draw;
import main.battleship.client.Controller.draw.ArtList;
import main.battleship.client.Controller.draw.Rect;

public class Program extends Thread{
  public void start(){
    super.start();
  }
  @Override
  public void run(){
    ArtList scene = new ArtList();
    scene.add(new Rect(10,10,2,980,0,0,0));
    Draw.getDraw().addScene(scene);
  }
}
