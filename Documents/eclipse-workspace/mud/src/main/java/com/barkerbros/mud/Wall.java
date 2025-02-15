package com.barkerbros.mud;

import java.util.ArrayList;

public class Wall {
	public int rowCoordinate;
	public int colCoordinate;
	public ArrayList<String> legalDirections;
	public boolean isBuildable;
	private Wall[][] mazeWalls;
	
	public Wall(int rowCoordinate, int colCoordinate, Wall[][] mazeWalls) {
		this.rowCoordinate = rowCoordinate;
		this.colCoordinate = colCoordinate;
		this.mazeWalls = mazeWalls;
		legalDirections = new ArrayList<String>();
	}
	
	public void createDirectionList() {
		try {
			if (mazeWalls[rowCoordinate + 1][colCoordinate] == null 
					&& mazeWalls[rowCoordinate + 2][colCoordinate] == null) {
				legalDirections.add("Down");
			}
					
		} catch (ArrayIndexOutOfBoundsException e) {
			//No direction is added to the list
		}
		try {
			if (mazeWalls[rowCoordinate][colCoordinate - 1] == null 
					&& mazeWalls[rowCoordinate][colCoordinate - 2] == null) {
				legalDirections.add("Left");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			//No direction is added to the list
		}
		try {
			if (mazeWalls[rowCoordinate - 1][colCoordinate] == null 
					&& mazeWalls[rowCoordinate - 2][colCoordinate] == null) {
				legalDirections.add("Up");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			//No direction is added to the list
		}
		try {
			if (mazeWalls[rowCoordinate][colCoordinate + 1] == null 
					&& mazeWalls[rowCoordinate][colCoordinate + 2] == null) {
				legalDirections.add("Right");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			//No direction is added to the list
		}
	}
	public void checkIsBuildable() {
		if (rowCoordinate % 2 == 0 
				&& colCoordinate % 2 == 0
				&& legalDirections.size() > 0) {
			isBuildable = true;
		} else isBuildable = false;
	}
}

