package com.barkerbros.mud;

public class Monster {

    private int hp;
    private int atk;
    private String name;

    public Monster(String type) {
        if (type.equals("orc")) {
            this.hp = 10;
            this.atk = 2;
            this.name = "orc";
        }
    }
    public int attackHero() {
        return this.atk;
    }
}
