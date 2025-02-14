package com.barkerbros.mud;


public class App {
  public static void main(String[] args) {
	  Maze maze = new Maze(11);
	  System.out.println(maze);
	  Wall[][] walls = maze.getWalls();
	  System.out.println(walls);
	  maze.getWalls()[0][2].createDirectionList();
	  maze.getWalls()[2][0].createDirectionList();
	  maze.getWalls()[10][2].createDirectionList();
	  System.out.println(maze.getWalls()[0][2].legalDirections);
	  System.out.println(maze.getWalls()[2][0].legalDirections);
	  System.out.println(maze.getWalls()[10][2].legalDirections);
  }
}

