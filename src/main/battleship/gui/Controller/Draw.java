package main.battleship.gui.Controller;

import main.battleship.gui.Controller.draw.Art;
import main.battleship.gui.Controller.draw.ArtList;
import processing.core.PApplet;
import processing.event.MouseEvent;

public class Draw extends PApplet{
  private ArtList content = new ArtList();
  private int width,height;
  private static Draw art;
  
  public Draw(int screenWidth, int screenHeight){
    width = screenWidth;
    height = screenHeight;
  }

  public static void run() {
    art = new Draw(1000, 1000);
    PApplet.runSketch(new String[] {"Draw"},art);
  }
  
  public static Draw getDraw() {
    return art;
  }
  @Override
  public void settings(){
    size(width, height);
  }
  public void setup(){
  }
  @Override
  public void draw(){
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
