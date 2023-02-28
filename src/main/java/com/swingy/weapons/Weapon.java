package com.swingy.weapons;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public abstract class Weapon {
    @NotNull private String name;
    @NotNull private String type;
    @Size(min = 0) private int durability;
    @Size(min = 0) private int damage;
    @Size(min = 0) private int defence;
    @NotNull private int levelReq;
    @Size(min = 0) private int cost;
    @Size(min = 0) private int sellValue;
    private boolean isEquiped;
    private boolean is2Handed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getLevelReq() {
        return levelReq;
    }

    public void setLevelReq(int levelReq) {
        this.levelReq = levelReq;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getSellValue() {
        return sellValue;
    }

    public void setSellValue(int sellValue) {
        this.sellValue = sellValue;
    }

    public boolean isEquiped() {
        return isEquiped;
    }

    public void setEquiped(boolean equiped) {
        this.isEquiped = equiped;
    }

    public boolean is2Handed() {
        return is2Handed;
    }

    public void setIs2Handed(boolean is2Handed) {
        this.is2Handed = is2Handed;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }
}
