/**
 * 
 */
package com.pupilsky.reactive_sample.model;

import java.util.Date;

/**
 * @author KRISHAN
 *
 */
public class BatsmanRecord {

    public BatsmanRecord(Integer runs, Player player, Date when) {
        super();
        this.runs = runs;
        this.player = player;
        this.when = when;
    }

    Integer runs;
    Player player;
    Date when;

    public Integer getRuns() {
        return runs;
    }

    public void setRuns(Integer runs) {
        this.runs = runs;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Date getWhen() {
        return when;
    }

    public void setWhen(Date when) {
        this.when = when;
    }

    @Override
    public String toString() {
        return "Runs :-" + runs + " Player:-" + player + " when:-" + when;
    }

}
