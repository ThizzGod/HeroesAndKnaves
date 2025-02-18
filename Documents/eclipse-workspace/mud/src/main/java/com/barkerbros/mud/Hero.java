package com.barkerbros.mud;

import java.util.Scanner;


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

    public Hero() { 
        

    }

  

    public void printHealth() {
        System.out.println(this.hp);
    }

	public void pInput() {
	
        Scanner input = new Scanner(System.in);
        playerInput = input.nextLine();
		
        
       }
    

    public boolean findWalls() {
     //int rowPos = rowPos();
     //int colPos = colPos();

	

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
        }
        else {
            move();
            return false;

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
    public void takeDamage(int dmg) {
        this.hp -= dmg;
    }

    public int getRowPos() {
        System.out.println(rowPos);
        return rowPos;
    }
    public int getColPos() {
        System.out.println(colPos);
        return colPos;
    }

}
