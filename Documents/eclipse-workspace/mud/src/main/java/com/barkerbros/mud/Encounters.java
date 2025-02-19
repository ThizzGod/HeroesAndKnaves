package com.barkerbros.mud;

import java.util.Random;
import java.util.ArrayList;
//import java.util.List;
import java.util.Arrays;

public class Encounters {

    private Hero hero;
    private ArrayList<int[]> exploredCells;

    int chance = 30;

    //start encounter test from app

    public Encounters(Hero hero) {
        this.hero = hero;
        exploredCells = new ArrayList<>();
        encounterChance();
    }



    // uses chance variable to provide updateable odds
    // of an encounter in each cell. Needs functionally
    // added to prevent multiple encounter in one cell

    public boolean encounterChance() {
       
        Random random = new Random();
        int encounter = random.nextInt(100);
        int[] currentCell = new int[2];
        int rowPos = hero.getRowPos();
        int colPos = hero.getColPos();
        currentCell[0] = rowPos;
        currentCell[1] = colPos;

        for (int cell = 0; cell < exploredCells.size(); cell++) {

            // Still taking damage on explored cells, if statement always false
            if (Arrays.equals(currentCell, exploredCells.get(cell))) {
                return false;
            }
            
        }
        if (encounter < chance) {
            
            encounterPicker();
            return true;
        } else {
          
            return false;
        }
        
        // return true if random number generated is
        // less than chance variable and start
        // encounterPicker method

    }
    
    // picks random encounter to run when encounter
    // chance returns true

    public void encounterPicker() {
        Random random = new Random();
        int encounter = random.nextInt(1);
        if (encounter == 0) {
            Monster orc = new Monster("orc");
            battle(orc);
        }
        if (encounter == 1) {
            
        }
        if (encounter == 2) {
            
        }
        if (encounter == 3) {
            
        }
        if (encounter == 4) {
            
        }
        if (encounter == 5) {
            
        }
        if (encounter == 6) {
            
        }
        if (encounter == 7) {
            
        }
        if (encounter == 8) {
            
        }
        if (encounter == 9) {
            
        }
        if (encounter == 10) {
            
        }
        if (encounter == 11) {
            
        }
        if (encounter == 12) {
            
        }
        if (encounter == 13) {
            
        }
        if (encounter == 14) {
            
        }
        if (encounter == 15) {
            
        }
        if (encounter == 16) {
            
        }
        if (encounter == 17) {
            
        }
        if (encounter == 18) {
            
        } if (encounter == 19) {

        }
        else {
            
        }

    }

    public void battle(Monster orc) {
        hero.takeDamage(orc.attackHero());
    }

    //add heroes previous positions to list

    public void    addCurrentCell() {
        int[] exploredCell = new int[2];
         int rowPos = hero.getRowPos();
         int colPos = hero.getColPos();
         exploredCell[0] = rowPos;
         exploredCell[1] = colPos;
         exploredCells.add(exploredCell);
    }

    
}
