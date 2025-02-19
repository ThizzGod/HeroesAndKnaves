package com.barkerbros.mud;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
	  Maze maze = new Maze(21);
    Hero hero = new Hero(maze);
	 
    
    for (int i = 0; i<30; i++) {
      System.out.println(maze.toString(hero));
    System.out.println("Enter direction");
    hero.pInput();
    boolean wall = hero.findWalls();
    if (wall) continue;
    Encounters encounter = new Encounters(hero);
    encounter.addCurrentCell();
    
    hero.printHealth();
  }
}

  

  

  

    

  


}

