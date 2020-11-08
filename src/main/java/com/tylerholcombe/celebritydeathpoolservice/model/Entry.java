package com.tylerholcombe.celebritydeathpoolservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Entity
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long entryId;
    private boolean isApproved;
    private boolean isPaid;

    @JsonIgnore
    @OneToMany(mappedBy = "entry")
    private List<EntrySelection> entrySelections;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private List<Celebrity> selections;

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
        this.selections = entrySelections.stream().map(Celebrity::new).collect(toList());
        this.entrySelections = entrySelections;
    }

    public List<Celebrity> getSelections() {
        return selections;
    }

    public void setSelections(List<Celebrity> selections) {
        this.entrySelections = selections.stream().map(EntrySelection::new).collect(toList());
        this.selections = selections;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Entry syncEntrySelections() {
        this.entrySelections = this.selections.stream().map(EntrySelection::new).collect(toList());
        return this;
    }

    public Entry syncSelections() {
        this.selections = this.entrySelections.stream().map(Celebrity::new).collect(toList());
        return this;
    }
}
