package com.barkerbros.mud;


public class Maze {
	private Cell cell;
	private Wall[][] mazeWalls;
	private Maze maze;
	private Grid grid;
	/**
	 * Constructor for generating a new maze.
	 * @param size, will generate a maze of size x size cells
	 */
	public Maze(int size) {
		generateMaze(size);
		
	}
	/**
	 * Generates a grid and walls of a specified size.
	 * @param size the maximum size of grid and walls, given in constructor
	 */
	private void generateMaze(int size) {
		this.grid = new Grid(size);
		this.mazeWalls = generateMazeWalls(size);
		
	}
	/**
	 * Generates walls which form a maze that fits over a grid
	 * of the size specified in the parameter. The player cannot walk where
	 * walls objects are generated. The player may walk at any index
	 * pointing to null.
	 * @param size the size of the grid which the maze walls will generate
	 * to fill
	 * @return Wall[][]	A 2D array the same size as grid, where the indices
	 * that contain a wall will point to a wall object, and indices that do
	 * not have a wall will point to null.
	 */
	private Wall[][] generateMazeWalls(int size) {
		Wall[][] walls = new Wall[size][size]; 
		return walls;
	}
}
