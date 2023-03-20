package com.swingy.heroes;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.swingy.weapons.Weapon;
import java.util.Arrays;

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
    private final String[] availableWeapons;
    private Weapon[] equipedWeapons = new Weapon[2];
    private boolean dualWielding;

    /** constructor arguments: nandc = {String name, String hClass}, stats = {int hp, int atk}, avWeapons = an array of weapon names as strings. */
    protected Hero(String[] nandc, int[] stats, String[] avWeapons) throws IllegalArgumentException {
        if (nandc.length > 2 || stats.length > 2) {
            throw new IllegalArgumentException("Constructor Syntax: Hero(String[2], int[2])");
        }
        name = nandc[0];
        hClass = nandc[1];
        hp = stats[0];
        atk = stats[1];
        availableWeapons = avWeapons;
    }

    //Assigns a weapon to the hero and returns the previously eqiipped weapons for reference purposes.
    public Weapon[] equipWeapon(Weapon equipedWeapon) {
        if (equipedWeapon == null) {
            return equipedWeapons;
        }
        Weapon[] currentW = equipedWeapons;
        if (equipedWeapon.getLevelReq() > getLvl()) {
            throw new IllegalArgumentException("You are not high enough level to equip this weapon.");
        }
        if (!Arrays.asList(availableWeapons).contains(equipedWeapon.getName())) {
            throw new IllegalArgumentException("You cannot equip this weapon.");
        }
        if (equipedWeapon.is2Handed()) {
            dualWielding = true;
            equipedWeapons[0] = equipedWeapon;
            equipedWeapons[1] = null;
        } else {
            if (equipedWeapons[0] == null) {
                equipedWeapons[0] = equipedWeapon;
            } else {
                equipedWeapons[1] = equipedWeapon;
            }
        }
        setAtk(getAtk() + equipedWeapon.getDamage());
        setDef(getDef() + equipedWeapon.getDefence());
        return currentW;
    }

    //Removes weapons from the hero and returns the previously equipped for reference purposes.
    public Weapon[] unequipWeapons(Weapon... w) {
        for (Weapon weapon : w) {
            if (weapon == null) {
                continue;
            }
            if (!Arrays.asList(equipedWeapons).contains(weapon)) {
                throw new IllegalArgumentException("You cannot unequip a weapon you do not have equipped.");
            }
            Arrays.asList(equipedWeapons).remove(weapon);
            setAtk(getAtk() - weapon.getDamage());
            setDef(getDef() - weapon.getDefence());
        }
        return w;
    }

    public String[] getAvailableWeapons() {
        return availableWeapons;
    }

    public Weapon[] getEquipedWeapons() {
        return equipedWeapons;
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
