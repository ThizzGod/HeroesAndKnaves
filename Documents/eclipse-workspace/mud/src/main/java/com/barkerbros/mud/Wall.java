package com.barkerbros.mud;

import java.util.ArrayList;

public class Wall {
	private int rowCoordinate;
	private int colCoordinate;
	private ArrayList<String> legalDirections;
	private boolean isBuildable;
	private Maze maze;
	
	public Wall(int rowCoordinate, int colCoordinate, Maze maze) {
		this.rowCoordinate = rowCoordinate;
		this.colCoordinate = colCoordinate;
		this.maze = maze;
	}
	
	private void createDirectionList() {
		maze.getWalls();
	}
}

