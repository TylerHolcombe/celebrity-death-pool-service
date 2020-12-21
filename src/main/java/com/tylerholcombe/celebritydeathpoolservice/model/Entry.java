package com.tylerholcombe.celebritydeathpoolservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long entryId;
    private boolean isApproved;
    private boolean isPaid;

    @OneToMany(mappedBy = "entry")
    private List<EntrySelection> entrySelections;

    @ManyToOne
    @JoinColumn(name = "player_id")
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

    public List<EntrySelection> getEntrySelections() {
        return entrySelections;
    }

    public void setEntrySelections(List<EntrySelection> entrySelections) {
        this.entrySelections = entrySelections;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
