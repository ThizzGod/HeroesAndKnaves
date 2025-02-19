package com.barkerbros.mud;

/**
 * The Grid class builds and contains all of the individual cells
 * of the grid that lie "under" the maze walls in the Maze class
 * @author Max Barker
 * @version 2/18/25
 */

public class Grid {
	private Cell[][] gridCells;

	/**
	 * Grid constructor, creates Grid object with a square 
	 * 2D array of Cell, size x size elements.
	 * @param size the number size of the number of row and column elements
	 * in the square Cell array.
	 */
 	public Grid(int size) {
 		buildGrid(size);
	}
 	/**
 	 * Creates a square array of the size specified in the constructor.
 	 * Assigns a reference of this array to the instance variable "gridCells".
 	 * @param size the size of the array as passed in by the constructor.
 	 */
 	
 	private void buildGrid(int size) {
 		gridCells = new Cell[size][size];
 		for (int row = 0; row < size; row++) {
 			for (int col = 0; col < size; col++) {
 				gridCells[row][col] = new Cell();
 			}
 		}
 	}
 	
 	/**
 	 * Getter method for the "gridCells" instance variable.
 	 * @return the 2D array of Cell "gridCells" that was created and assigned
 	 * by the buildGrid method.
 	 */
 	public Cell[][] getGrid() {
 		return gridCells;
 	}
}
