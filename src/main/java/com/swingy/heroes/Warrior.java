package com.swingy.heroes;

import java.util.Arrays;

/** Class inherits from the hero abstract class. Stats: hp:20, atk:5 */
public class Warrior extends Hero {
    private String[][] warrMasteries = new String[][] {
        {"deep lacerations", "endurance of the boar", "brutal strikes"},
        {"frenzy", "blade master", "sunderer"},
        {"ignore pain", "cull the weak", "relentless assault"},
        {"Juggernaught", "Defender", "Warbringer"}
    };

    public Warrior(String name) throws IllegalArgumentException {
        super(new String[] {name, "warrior"}, new int[] {20, 5}, new String[] {"sword", "axe", "mace", "hammer", "rifle"});
    }

    /** pass one of the mastery lvls as argument and set it to the value of 'arg' */
    private void setMastery(String[] mastery, String arg) {
        if (mastery.length != 3) {
            throw new IllegalArgumentException("Mastery array is too long.");
        }
        if (arg == null) {
            throw new IllegalArgumentException("Mastery argument cannot be null.");
        }
        mastery = new String[] {arg};
    }
    /** set the appropriate lvl mastery to arg */
    public void setMasteries(int lvl, String arg) {
        switch (lvl) {
            case 10:
                if (!Arrays.asList(warrMasteries[0]).contains(arg)) {
                    throw new IllegalArgumentException("Mastery does not exist.");
                }
                setMastery(warrMasteries[0], arg);
                break;
            case 20:
                if (!Arrays.asList(warrMasteries[1]).contains(arg)) {
                    throw new IllegalArgumentException("Mastery does not exist.");
                }
                setMastery(warrMasteries[1], arg);
                break;
            case 30:
                if (!Arrays.asList(warrMasteries[2]).contains(arg)) {
                    throw new IllegalArgumentException("Mastery does not exist.");
                }
                setMastery(warrMasteries[2], arg);
                break;
            case 40:
                if (!Arrays.asList(warrMasteries[3]).contains(arg)) {
                    throw new IllegalArgumentException("Mastery does not exist.");
                }
                setMastery(warrMasteries[3], arg);
                break;
            default:
                throw new IllegalArgumentException("Lvl benchmark incorrect.");
        }
    }

    /** evaluate the masteries and add the appropriate effect */
    public void evaluateMasteries() {
        if (warrMasteries[0].length > 1)
            return;
        if (warrMasteries[0][0] == "deep lacerations") {
            setAtk(getAtk() + 2);
        } else if (warrMasteries[0][0] == "endurance of the boar") {
            sethp(gethp() + 2);
        } else if (warrMasteries[0][0] == "brutal strikes") {
            setAtk(getAtk() + 1);
            sethp(gethp() + 1);
        }

        if (warrMasteries[1].length > 1)
            return;
        if (warrMasteries[1][0] == "frenzy") {
            setAtk(getAtk() + 2);
        } else if (warrMasteries[1][0] == "blade master") {
            setAtk(getAtk() + 1);
            setDef(getDef() + 1);
        } else if (warrMasteries[1][0] == "sunderer") {
            setAtk(getAtk() + 1);
            setDef(getDef() + 1);
        }

        if (warrMasteries[2].length > 1)
            return;
        if (warrMasteries[2][0] == "ignore pain") {
            sethp(gethp() + 2);
        } else if (warrMasteries[2][0] == "cull the weak") {
            setAtk(getAtk() + 1);
            setDef(getDef() + 1);
        } else if (warrMasteries[2][0] == "relentless assault") {
            setAtk(getAtk() + 1);
            setDef(getDef() + 1);
        }

        if (warrMasteries[3].length > 1)
            return;
        if (warrMasteries[3][0] == "Juggernaught") {
            sethp(gethp() + 2);
        } else if (warrMasteries[3][0] == "Defender") {
            setDef(getDef() + 2);
        } else if (warrMasteries[3][0] == "Warbringer") {
            setAtk(getAtk() + 2);
        }
    }
}
