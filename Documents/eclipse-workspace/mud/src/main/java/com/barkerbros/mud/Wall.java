package com.barkerbros.mud;
/**
 * Wall class holds the internal data of Wall type objects that form
 * the mazeWalls in the Maze class. Walls have information about their
 * location as well as their status of whether or not they can be built
 * from.
 */
import java.util.ArrayList;
import java.util.Random;

public class Wall {
	public int rowCoordinate;
	public int colCoordinate;
	public ArrayList<String> legalDirections;
	public boolean isBuildable;
	private Wall[][] mazeWalls;
	
	/**
	 * Constructor for Wall objects. Creates a new wall at a given coordinate
	 * inside a 2D array of type Wall.
	 * @param rowCoordinate the row number for the new Wall object.
	 * @param colCoordinate the column number for the new Wall object.
	 * @param mazeWalls the 2D array of walls which the new wall will belong to.
	 */
	public Wall(int rowCoordinate, int colCoordinate, Wall[][] mazeWalls) {
		this.rowCoordinate = rowCoordinate;
		this.colCoordinate = colCoordinate;
		this.mazeWalls = mazeWalls;
		legalDirections = new ArrayList<String>();
	}
	
	/**
	 * Creates a list of legal directions which a given Wall object may be extended.
	 * A direction will be added to the list if the wall could be extended more than one
	 * position in the array it belongs to in that direction without encountering another Wall
	 * object (all other positions in the array that have not been initialized will be null).
	 * A reference to the list in its current form is stored in the "legalDirection" variable.
	 */
	public void createDirectionList() {
		legalDirections.clear();
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
	
	/**
	 * Assigns the "isBuildable" variable to either true or false based on whether
	 * or not more walls can be built off of the Wall object.
	 */
	public void checkIsBuildable() {
		if (rowCoordinate % 2 == 0 
				&& colCoordinate % 2 == 0
				&& legalDirections.size() > 0) {
			isBuildable = true;
		} else isBuildable = false;
	}
	
	/**
	 * Picks a random direction from the list of "legalDirections".
	 * @return A String representing a direction.
	 */
	public String getRandomDirection() {
		Random random = new Random();
		int index = random.nextInt(legalDirections.size());
		return legalDirections.get(index);
	}
}

