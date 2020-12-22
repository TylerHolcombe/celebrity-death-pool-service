package com.tylerholcombe.celebritydeathpoolservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Celebrity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long celebrityId;
    private String celebrityName;
    private boolean isDead;

    public Celebrity() {
    }

    public Celebrity(String celebrityName) {
        this.celebrityName = celebrityName;
        this.isDead = false;
    }

    public Celebrity(long celebrityId, String celebrityName, boolean isDead) {
        this.celebrityId = celebrityId;
        this.celebrityName = celebrityName;
        this.isDead = isDead;
    }

    public Celebrity(Celebrity other) {
        this.celebrityId = other.celebrityId;
        this.celebrityName = other.celebrityName;
        this.isDead = other.isDead;
    }

    public Celebrity(EntrySelection entrySelection) {
        this(entrySelection.getCelebrity());
    }

    public long getCelebrityId() {
        return celebrityId;
    }

    public void setCelebrityId(long celebrityId) {
        this.celebrityId = celebrityId;
    }

    public String getCelebrityName() {
        return celebrityName;
    }

    public void setCelebrityName(String celebrityName) {
        this.celebrityName = celebrityName;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }
}
