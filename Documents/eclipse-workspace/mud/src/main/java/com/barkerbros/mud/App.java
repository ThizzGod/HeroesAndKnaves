package com.barkerbros.mud;


public class App {
  public static void main(String[] args) {
	  Maze maze = new Maze(11);
	  System.out.println(maze);
	  Wall[][] walls = maze.getWalls();
	  System.out.println(walls);
	  maze.getWalls()[0][2].createDirectionList();
	  maze.getWalls()[2][0].createDirectionList();
	  maze.getWalls()[2][0].checkIsBuildable();
	  maze.getWalls()[5][0].createDirectionList();
	  maze.getWalls()[5][0].checkIsBuildable();
	  System.out.println(maze.buildableWallList);
  }
}

