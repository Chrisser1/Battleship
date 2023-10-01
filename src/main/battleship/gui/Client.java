package main.battleship.gui;

import main.battleship.gui.App.Program;
import main.battleship.gui.Controller.Draw;

/**
 * Client
 */
public class Client {
  Program client = new Program();
  public static void main(String[] args) {
    Draw.run();
  }
}