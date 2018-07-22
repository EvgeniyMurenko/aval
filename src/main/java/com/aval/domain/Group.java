package com.aval.domain;

import java.util.Date;

public class Group {

    private Long id;
    private String name;
    private String descr;
    private String date;
    private int countFunctions;
    private int countActiveFunctions;

    public Group() {
    }

    public Group(Long id, String name, String descr, String date, int countFunctions, int countActiveFunctions) {
        this.id = id;
        this.name = name;
        this.descr = descr;
        this.date = date;
        this.countFunctions = countFunctions;
        this.countActiveFunctions = countActiveFunctions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getCountFunctions() {
        return countFunctions;
    }

    public void setCountFunctions(int countFunctions) {
        this.countFunctions = countFunctions;
    }

    public int getCountActiveFunctions() {
        return countActiveFunctions;
    }

    public void setCountActiveFunctions(int countActiveFunctions) {
        this.countActiveFunctions = countActiveFunctions;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                '}';
    }
}
