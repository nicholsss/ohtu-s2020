/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import statistics.Player;

/**
 *
 * @author nicholas
 */
public class HasFewerThan implements Matcher {

    Matcher hasFewerThan;

    public HasFewerThan(int value, String category) {
        this.hasFewerThan = new Not(new HasAtLeast(value, category));
    }

    @Override
    public boolean matches(Player p) {

        return this.hasFewerThan.matches(p);
    }

}
