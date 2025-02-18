package com.barkerbros.mud;

import java.util.Random;

public class Encounters {

    private Hero hero;

    public Encounters(Hero hero) {
        this.hero = hero;
        encounterPicker();
    }
    int chance = 25;

    public boolean encounterChance() {
        Random random = new Random();
        int encounter = random.nextInt(100);
        if (encounter < chance) {
            encounterPicker();
            return true;
          
        } else {
            return false;
        }

    }
    
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

    
}
