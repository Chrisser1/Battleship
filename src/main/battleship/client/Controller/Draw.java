package main.battleship.client.Controller;

import java.util.ArrayList;

import main.battleship.client.App.Program;
import main.battleship.client.Controller.draw.Art;
import main.battleship.client.Controller.draw.ArtList;
import processing.core.PApplet;
import processing.core.PImage;
import processing.event.MouseEvent;

public class Draw extends PApplet{
  private ArtList content = new ArtList();
  private int width,height;
  private static Draw art;
  private ArrayList<ArtList> scenes = new ArrayList<ArtList>();
  private int currentScene =  0;
  private Program prog = new Program();
  private Draw(int screenWidth, int screenHeight){
    width = screenWidth;
    height = screenHeight;
  }

  public PImage getImage(String path){
    return loadImage(path);
  }
  public static void main(String[] args){
    System.out.println("Hello");
  }

  public int addScene(ArtList scene){
    scenes.add(scene);
    return scenes.size()-2;
  }
  public void setScene(int  ID){
    currentScene = ID;
  }
  public static void run() {
    art = new Draw(1000, 1000);
    PApplet.runSketch(new String[] {"Draw"},art);
    System.out.println("startet window");
  }

  public static Draw getDraw() {
    while (art == null){
      System.out.println("draw not available yet\nWait");
      try{
        Thread.sleep(100);
      }catch(InterruptedException ignore){
        break;
      }
    }
    return art;
  }
  @Override
  public void settings(){
    size(width, height);
  }
  @Override
  public void setup(){
    prog.start();
  }
  @Override
  public void draw(){
    for (int i = 0; i < scenes.get(currentScene).size(); i++) {
      scenes.get(currentScene).get(i).draw(g);
    }
    for (int i = 0; i < content.size(); i++) {
      content.get(i).draw(g);
    }
  }
  /**
   * add an item to the draw pile
   * @return the index atributed to the item, use this index for fast removal of item at a later time.
   */
  public int addItem(Art item){
    return content.add(item);
  }
  public boolean removeItem(Art item){
    return content.remove(item);
  }
  public void removeItem(int ID){
    content.remove(ID);
  }
  public Program getProgram(){
    return prog;
  }
  @Override
  public void mousePressed(MouseEvent mouse){
    if(mouse.getButton() == LEFT){
      HID.setLeftClick(true);
    }else if(mouse.getButton() == RIGHT){
      HID.setRigthClick(true);
    }
  }
  @Override
  public void mouseReleased(MouseEvent mouse){
    if(mouse.getButton() == LEFT){
      HID.setLeftClick(false);
    }else if(mouse.getButton() == RIGHT){
      HID.setRigthClick(false);
    }
  }
  @Override
  public void mouseMoved(){
    HID.setMousePosition(mouseX, mouseY);
  }
}
