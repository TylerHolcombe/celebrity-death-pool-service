package com.tylerholcombe.celebritydeathpoolservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class EntrySelection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long entrySelectionId;
    private boolean isWildcard;

    @ManyToOne
    @JoinColumn(name = "entry_id")
    private Entry entry;

    @ManyToOne
    @JoinColumn(name = "celebrity_id")
    private Celebrity celebrity;

    public EntrySelection() {
    }

    public EntrySelection(long entrySelectionId, boolean isWildcard) {
        this.entrySelectionId = entrySelectionId;
        this.isWildcard = isWildcard;
    }

    public EntrySelection(Celebrity celebrity) {
        this.celebrity = celebrity;
        this.setWildcard(celebrity.isWildcard());
    }

    public long getEntrySelectionId() {
        return entrySelectionId;
    }

    public void setEntrySelectionId(long entrySelectionId) {
        this.entrySelectionId = entrySelectionId;
    }

    public boolean isWildcard() {
        return isWildcard;
    }

    public void setWildcard(boolean wildcard) {
        isWildcard = wildcard;
    }

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    public Celebrity getCelebrity() {
        return celebrity;
    }

    public void setCelebrity(Celebrity celebrity) {
        this.celebrity = celebrity;
    }
}
