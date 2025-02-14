package com.barkerbros.mud;

/**
 * Grids and walls are generated in a 2D array [row][col]
 * starting from [0][0] being the upper left cell
 * and expanding down and right from there.
 * The grid and the walls exist in two separate arrays so that
 * the objects may have different properties easily, but they
 * should be imagined as superimposed upon each other for the
 * purposes of playing the game.
 * @author maxbarker
 */

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
		generateMazeWalls(size);
		
	}
	/**
	 * Generates walls which form a maze that fits over a grid
	 * of the size specified in the parameter. The player cannot walk where
	 * walls objects are generated. The player may walk at any index
	 * pointing to null.
	 * @param size the size of the grid which the maze walls will generate
	 * to fill
	 * @return Wall[][]	a 2D array the same size as grid, where the indices
	 * that contain a wall will point to a wall object, and indices that do
	 * not have a wall will point to null.
	 */
	private void generateMazeWalls(int size) {
		this.mazeWalls = new Wall[size][size];
		buildExteriorWall(size);
		for (int i = 0; i < size * 10; i++) {
			findExistingWall();
		}
		
	}
	
	private void buildExteriorWall(int mazeSize) {
		//left wall
		for (int i = 0; i < mazeSize; i++) {
			mazeWalls[i][0] = new Wall(i, 0, mazeWalls);
		}
		//top wall
		for (int i = 0; i < mazeSize; i++) {
			mazeWalls[0][i] = new Wall(0, i, mazeWalls);
		}
		//right wall
		for (int i = 0; i < mazeSize; i++) {
			mazeWalls[i][mazeSize - 1] = new Wall(i, mazeSize - 1, mazeWalls);
		}
		// bottom wall
		for (int i = 0; i < mazeSize; i++) {
			mazeWalls[mazeSize - 1][i] = new Wall(mazeSize - 1, i, mazeWalls);		
		}
	}
	
	private void findExistingWall() {
		
	}
	
	private void extendWall(String direction, int startingRow, int startingCol, 
			int mazeSize) {
		if (direction.equals("right")) {
			for (int i = 0; i < mazeSize; i++) {
				if (mazeWalls[startingRow + i + 1][startingCol] != null) break;
				mazeWalls[startingRow + i + 1][startingCol] = new Wall(startingRow + i + 1, startingCol, mazeWalls);
			}
		}
	}
	public Wall[][] getWalls() {
		return 	mazeWalls;
	}
}
