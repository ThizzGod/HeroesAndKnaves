package com.barkerbros.mud;

import java.util.Scanner;
import java.util.List;
import java.util.Arrays;


public class Hero {
    private int hp;
    private int atk;
    String playerInput = "";
    public int rowPos = 1;
    public int colPos = 1;
    private Maze maze;

    public Hero(Maze maze) {
        this.maze = maze;
        this.rowPos = 1;
        this.colPos = 1;
        this.atk = 3;
        this.hp = 20;
    }

   // public Hero() { 
        

   // }

  

    public void printHealth() {
        System.out.println(this.hp);
    }

    // gets players direction of movement when move is
    // selected as non battle action

	public void pInput() {
	
        Scanner input = new Scanner(System.in);
        playerInput = input.nextLine();
		
        
       }
    
    /*Find walls in relation to player characters current position and,
        if move is valid, continue to move method*/

    public boolean findWalls() {
    

	
        List<String> validInputs = Arrays.asList(
        "left", "right", "down", "up");

        if ((playerInput.equals("down")) && 
        (this.maze.getWalls()[rowPos + 1][colPos] != null)) {
            System.out.println("Cannot move here!");
            return true;
        }
        if ((playerInput.equals("up")) && 
        (this.maze.getWalls()[rowPos - 1][colPos] != null)) {
            System.out.println("Cannot move here!");
            return true;
        }
        if ((playerInput.equals("right")) &&
        (this.maze.getWalls()[rowPos][colPos + 1] != null)) {
            System.out.println("Cannot move here!");
            return true;
        }
        if ((playerInput.equals("left")) &&
        (this.maze.getWalls()[rowPos][colPos - 1] != null)) {
            System.out.println("Cannot move here!");
            return true;
        } if (!validInputs.contains(playerInput)) {
            System.out.println("Invalid entry!");
            return true;
        }
        else if (validInputs.contains(playerInput)) {
            move();
            return false;

        }
        else {
            return true;
        }
        //returns true if wall is present in direction of attempted move
        //or if proper direction is not given
    }


    //updates players position if valid movement is entered

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
    public void takeDamage(int dmg) {
        this.hp -= dmg;
    }

        //rowPos getter
    public int getRowPos() {
        System.out.println(rowPos);
        return rowPos;
    }

        //colPos getter
    public int getColPos() {
        System.out.println(colPos);
        return colPos;
    }

}
