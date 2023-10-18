package com.example.tp5;

import java.io.Serializable;

public class Tache implements Serializable {
    private String tachename;
    private String tachejour;
    private String tachetime;

    public Tache(String tachename, String tachejour, String tachetime) {
        this.tachename = tachename;
        this.tachejour = tachejour;
        this.tachetime = tachetime;
    }

    public String getTachename() {
        return tachename;
    }

    public void setTachename(String tachename) {
        this.tachename = tachename;
    }

    public String getTachejour() {
        return tachejour;
    }

    public void setTachejour(String tachejour) {
        this.tachejour = tachejour;
    }

    public String getTachetime() {
        return tachetime;
    }

    public void setTachetime(String tachetime) {
        this.tachetime = tachetime;
    }

    @Override
    public String toString() {
        return "Tache{" +
                "tachename='" + tachename + '\'' +
                ", tachejour='" + tachejour + '\'' +
                ", tachetime='" + tachetime + '\'' +
                '}';
    }
}
