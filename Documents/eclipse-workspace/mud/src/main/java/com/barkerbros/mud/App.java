package com.barkerbros.mud;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
	  Maze maze = new Maze(21);
    Hero hero = new Hero(maze);
	  System.out.println(maze);
    
    for (int i = 0; i<10; i++) {
    System.out.println("Enter direction");
    hero.pInput();
    hero.findWalls();
  }
}

  

  

  

    

  


}

