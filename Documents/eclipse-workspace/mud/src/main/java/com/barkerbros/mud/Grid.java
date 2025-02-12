package com.barkerbros.mud;


public class Grid {
	private Cell[][] gridCells;

 	public Grid(int size) {
 		buildGrid(size);
	}
 	
 	public Cell[][] buildGrid(int size) {
 		gridCells = new Cell[size][size];
 		for (int row = 0; row < size; row++) {
 			for (int col = 0; col < size; col++) {
 				gridCells[row][col] = new Cell();
 			}
 		}
 		return gridCells;
 	}
}
