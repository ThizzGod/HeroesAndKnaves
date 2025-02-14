package com.barkerbros.mud;


public class App {
  public static void main(String[] args) {
	  Maze maze = new Maze(11);
	  System.out.println(maze);
	  Wall[][] walls = maze.getWalls();
	  System.out.println(walls);
	  System.out.println(walls[0][0].mazeWalls);
  }
}

