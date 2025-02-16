package com.barkerbros.mud;

import java.util.ArrayList;
import java.util.Random;

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
	private Wall[][] mazeWalls;
	private Cell[][] grid;
	public ArrayList<Wall> buildableWallList;
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
		Grid grid = new Grid(size);
		this.grid = grid.getGrid();
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
		buildableWallList = new ArrayList<Wall>();
		updateBuildableWallList();
		while (buildableWallList.size() > 0) {
			findBuildableWall();
			// calling findBuildableWall will also call extend wall
		}
		//for (int i = 0; i < size * 10; i++) {
		//	findBuildableWall();
		//}
		
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
	
	private void findBuildableWall() {
		updateBuildableWallList();
		if (buildableWallList.size() <= 0) return;
		Random random = new Random();
		int randomIndex = random.nextInt(buildableWallList.size());
		Wall selectedWall = buildableWallList.get(randomIndex);
		String directionString = selectedWall.getRandomDirection();
		extendWall(directionString, selectedWall.rowCoordinate, selectedWall.colCoordinate, mazeWalls[0].length);
	}
	
	private void extendWall(String direction, int startingRow, int startingCol, 
			int mazeSize) {
		ArrayList<Wall> destructableWalls = new ArrayList<Wall>();
		Random random = new Random();
		if (direction.equals("Down")) {
			for (int i = 0; i < mazeSize; i++) {
				if (mazeWalls[startingRow + i + 1][startingCol] != null) break;
				mazeWalls[startingRow + i + 1][startingCol] = new Wall(startingRow + i + 1, startingCol, mazeWalls);
				destructableWalls.add(mazeWalls[startingRow + i + 1][startingCol]);
				
			}
		}
		if (direction.equals("Up")) {
			for (int i = 0; i < mazeSize; i++) {
				if (mazeWalls[startingRow - i - 1][startingCol] != null) break;
				mazeWalls[startingRow - i - 1][startingCol] = new Wall(startingRow - i - 1, startingCol, mazeWalls);
				destructableWalls.add(mazeWalls[startingRow - i - 1][startingCol]);
				
			}
		}
		if (direction.equals("Left")) {
			for (int i = 0; i < mazeSize; i++) {
				if (mazeWalls[startingRow][startingCol - i - 1] != null) break;
				mazeWalls[startingRow][startingCol - i - 1] = new Wall(startingRow, startingCol - i - 1, mazeWalls);
				destructableWalls.add(mazeWalls[startingRow][startingCol - i - 1]);
				
			}
		}
		if (direction.equals("Right")) {
			for (int i = 0; i < mazeSize; i++) {
				if (mazeWalls[startingRow][startingCol + i +1] != null) break;
				mazeWalls[startingRow][startingCol + i + 1] = new Wall(startingRow, startingCol + i + 1, mazeWalls);
				destructableWalls.add(mazeWalls[startingRow][startingCol + i + 1]);
	
			}
		}
		for (int i = 0; i < destructableWalls.size(); i++) {
			Wall destroyWall = destructableWalls.get(i);
			if (destroyWall.colCoordinate % 2 == 0 &&
					destroyWall.rowCoordinate % 2 == 0) {
				destructableWalls.remove(i);
			}
		}
		int removeWallIndex = random.nextInt(destructableWalls.size());
		Wall removeWall = destructableWalls.get(removeWallIndex);
		mazeWalls[removeWall.rowCoordinate][removeWall.colCoordinate] = null;
	}
	
	private void updateBuildableWallList() {
		buildableWallList.clear();
		for (int i = 0; i < mazeWalls[0].length; i++) {
			for (int j = 0; j < mazeWalls[0].length; j++) {
				if (mazeWalls[i][j] == null) continue;
				mazeWalls[i][j].createDirectionList();
				mazeWalls[i][j].checkIsBuildable();
				if (mazeWalls[i][j].isBuildable && !(buildableWallList.contains(mazeWalls[i][j]))) {
					buildableWallList.add(mazeWalls[i][j]);
				}
			}
		}
	}
	
	public Wall[][] getWalls() {
		return 	mazeWalls;
	}
	public String toString() {
		String consoleMaze = "";
		for (int row = 0; row < mazeWalls.length; row++) {
			for (int col = 0; col < mazeWalls.length; col++) {
				if (mazeWalls[row][col] == null) {
					consoleMaze += "  ";
				} else {
					consoleMaze += "@ ";
				}
			}
			consoleMaze += "\n";
		}
		return consoleMaze;
	}
}
