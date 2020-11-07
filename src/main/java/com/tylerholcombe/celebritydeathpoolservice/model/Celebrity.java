package com.tylerholcombe.celebritydeathpoolservice.model;

public class Celebrity {
    private long celebrityId;
    private String celebrityName;
    private boolean isDead;
    private boolean isWildcard;

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
