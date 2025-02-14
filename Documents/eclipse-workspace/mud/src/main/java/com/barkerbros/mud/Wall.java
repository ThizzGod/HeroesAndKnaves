package com.barkerbros.mud;

import java.util.ArrayList;

public class Wall {
	private int rowCoordinate;
	private int colCoordinate;
	private ArrayList<String> legalDirections;
	private boolean isBuildable;
	public Wall[][] mazeWalls;
	
	public Wall(int rowCoordinate, int colCoordinate, Wall[][] mazeWalls) {
		this.rowCoordinate = rowCoordinate;
		this.colCoordinate = colCoordinate;
		this.mazeWalls = mazeWalls;
	}
	
	private void createDirectionList() {
		
	}
}

