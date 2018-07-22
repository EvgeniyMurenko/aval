package com.aval.domain;


public class Param {
    private Long id;
    private Long funkId;
    private String name;
    private String descr;
    private String date;


    public Param() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFunkId() {
        return funkId;
    }

    public void setFunkId(Long funkId) {
        this.funkId = funkId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Param{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descr='" + descr + '\'' +
                '}';
    }
}
