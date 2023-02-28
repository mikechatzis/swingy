package com.swingy;

import com.swingy.heroes.Hero;
import com.swingy.heroes.Warrior;

/**
 * Program starts here.
 */
public final class Swingy {
    private Swingy() {
    }

    /**
     * MAIN STARTS HERE.
     */
    public static void main(String[] args) {
        try {
            Hero warr = new Warrior("atlas");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
