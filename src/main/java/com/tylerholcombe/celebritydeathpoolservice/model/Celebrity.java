package com.tylerholcombe.celebritydeathpoolservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Celebrity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long celebrityId;
    private String celebrityName;
    private boolean isDead;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private boolean isWildcard;

    public Celebrity() {
    }

    public Celebrity(long celebrityId, String celebrityName, boolean isDead, boolean isWildcard) {
        this.celebrityId = celebrityId;
        this.celebrityName = celebrityName;
        this.isDead = isDead;
        this.isWildcard = isWildcard;
    }

    public Celebrity(Celebrity other) {
        this.celebrityId = other.celebrityId;
        this.celebrityName = other.celebrityName;
        this.isDead = other.isDead;
        this.isWildcard = other.isWildcard;
    }

    public Celebrity(EntrySelection entrySelection) {
        this(entrySelection.getCelebrity());
        this.isWildcard = entrySelection.isWildcard();
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

    public boolean isWildcard() {
        return isWildcard;
    }

    public void setWildcard(boolean wildcard) {
        isWildcard = wildcard;
    }
}
