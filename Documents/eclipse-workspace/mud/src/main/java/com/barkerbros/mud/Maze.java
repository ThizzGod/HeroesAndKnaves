package com.barkerbros.mud;


public class Maze {
	private Cell cell;
	private Wall wall;
	private Maze maze;
	private Grid grid;
	/**
	 * constructor for generating a new maze
	 * @param size, will generate a maze of size x size cells
	 */
	public Maze(int size) {
		generateMaze(size);
		
	}
	
	private void generateMaze(int size) {
		this.grid = new Grid(size);
		
	}
}
