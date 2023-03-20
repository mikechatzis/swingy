package com.swingy.heroes;

/** Class inherits from the hero abstract class. Stats: hp:12, atk:12 */
public class Mage extends Hero {
    private static final int[] STATS = new int[] {12, 12};

    Mage(String name) {
        super(new String[] {name, "mage"}, STATS, new String[] {"staff", "wand", "scepter", "book"});
    }
}
