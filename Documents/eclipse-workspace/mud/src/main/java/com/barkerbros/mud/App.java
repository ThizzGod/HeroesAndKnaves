package com.barkerbros.mud;

import java.util.Arrays;

public class App {
  public static void main(String[] args) {
	  Maze maze = new Maze(11);
	  System.out.println(maze);
	  Wall[][] walls = maze.getWalls();
	  System.out.println(walls);
	  System.out.println(maze.buildableWallList);
	  System.out.println(walls.length);
  }
}

