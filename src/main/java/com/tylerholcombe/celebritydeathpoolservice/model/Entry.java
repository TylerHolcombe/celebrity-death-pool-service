package com.tylerholcombe.celebritydeathpoolservice.model;

import java.util.List;

public class Entry {
    private long entryId;
    private boolean isApproved;
    private boolean isPaid;
    private List<Celebrity> selections;
    private Player player;

    public long getEntryId() {
        return entryId;
    }

    public void setEntryId(long entryId) {
        this.entryId = entryId;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public List<Celebrity> getSelections() {
        return selections;
    }

    public void setSelections(List<Celebrity> selections) {
        this.selections = selections;
    }

    public Player getPlayer() {
        return player;
    }

    public Entry setPlayer(Player player) {
        this.player = player;
        return this;
    }
}
