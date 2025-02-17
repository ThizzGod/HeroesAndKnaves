package com.barkerbros.mud;

import java.util.Scanner;


public class Hero {

    String playerInput = "";
    private int rowPos;
    private int colPos;
    private Maze maze;

    public Hero(Maze maze) {
        this.maze = maze;
        this.rowPos = 1;
        this.colPos = 1;
    }


	public void pInput() {
	
        Scanner input = new Scanner(System.in);
        playerInput = input.nextLine();
		
        
       }
    

    public void findWalls() {
     //int rowPos = rowPos();
     //int colPos = colPos();

	

        if ((playerInput.equals("down")) && 
        (this.maze.getWalls()[rowPos + 1][colPos] != null)) {
            System.out.println("Cannot move here!");
            return;
        }
        if ((playerInput.equals("up")) && 
        (this.maze.getWalls()[rowPos - 1][colPos] != null)) {
            System.out.println("Cannot move here!");
            return;
        }
        if ((playerInput.equals("right")) &&
        (this.maze.getWalls()[rowPos][colPos + 1] != null)) {
            System.out.println("Cannot move here!");
            return;
        }
        if ((playerInput.equals("left")) &&
        (this.maze.getWalls()[rowPos][colPos - 1] != null)) {
            System.out.println("Cannot move here!");
            return;
        }
        else {
            move();
        }
    }


    private void move() {
        if (playerInput.equals("down")) {
           rowPos = (rowPos + 1);
        }
        if (playerInput.equals("up")) {
            rowPos = (rowPos - 1);
        }
        if (playerInput.equals("right")) {
            colPos = (colPos + 1);
         }
         else if (playerInput.equals("left")) {
             colPos = (colPos - 1);
         }
    }

}
