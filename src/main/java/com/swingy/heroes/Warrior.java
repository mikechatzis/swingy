package com.swingy.heroes;

import com.swingy.weapons.Weapon;
import java.util.Arrays;

/** Class inherits from the hero abstract class. Stats: hp:20, atk:5 */
public class Warrior extends Hero {
    private final String[] availableWeapons = {"sword", "axe", "mace", "hammer", "rifle"};
    private Weapon[] equipedWeapons = new Weapon[2];
    private boolean dualWielding;

    public Warrior(String name) throws IllegalArgumentException {
        super(new String[] {name, "warrior"}, new int[] {20, 5});
    }

    public String[] getAvailableWeapons() {
        return availableWeapons;
    }

    public Weapon[] getEquipedWeapons() {
        return equipedWeapons;
    }

    public void setEquipedWeapons(Weapon... equipedWeapon) {
        if (equipedWeapon.length > 2) {
            throw new IllegalArgumentException("You can only equip up to 2 weapons at a time.");
        }
        if (equipedWeapon[0].is2Handed() && equipedWeapon[1] != null) {
            throw new IllegalArgumentException("You can only equip 1 2-handed weapon at a time.");
        }
        for (Weapon weapon : equipedWeapon) {
            if (weapon == null) {
                continue;
            }
            if (weapon.getLevelReq() > getLvl()) {
                throw new IllegalArgumentException("You are not high enough level to equip this weapon.");
            }
            if (!Arrays.asList(availableWeapons).contains(weapon.getName())) {
                throw new IllegalArgumentException("You cannot equip this weapon.");
            }
        }
        equipedWeapons = equipedWeapon;
        if (equipedWeapon[0].is2Handed() || equipedWeapon[1].is2Handed()) {
            dualWielding = true;
            boolean is2Handed = equipedWeapon[0].is2Handed();
            if (is2Handed) {
                equipedWeapons[1] = null;
            } else {
                equipedWeapons[0] = null;
            }
        }
        setAtk(getAtk() + equipedWeapon[0].getDamage() + equipedWeapon[1].getDamage());
        setDef(getDef() + equipedWeapon[0].getDefence() + equipedWeapon[1].getDefence());
    }
}
