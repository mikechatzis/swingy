package com.swingy.heroes;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/** The blueprint class for all heroes. */
public abstract class Hero {
    @NotNull
    @Size(min = 4, max = 14) private String name;
    @NotNull private String hClass;
    @NotNull private int lvl = 1;
    @Size(min = 0) private int xp;
    @Size(min = 0) private int hp;
    @Size(min = 0) private int atk;
    @Size(min = 0) private int def;

    /** constructor arguments: nandc = {String name, String hClass}, stats = {int hp, int atk}. */
    protected Hero(String[] nandc, int[] stats) throws IllegalArgumentException {
        if (nandc.length > 2 || stats.length > 2) {
            throw new IllegalArgumentException("Constructor Syntax: Hero(String[2], int[2])");
        }
        name = nandc[0];
        hClass = nandc[1];
        hp = stats[0];
        atk = stats[1];
    }

    //CHECKSTYLE OFF
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHhClass() {
        return hClass;
    }

    public void sethClass(String hClass1) {
        hClass = hClass1;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int gethp() {
        return hp;
    }

    public void sethp(int hitp) {
        this.hp = hitp;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }
}
