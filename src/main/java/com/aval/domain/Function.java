package com.aval.domain;

public class Function {
    private Long id;
    private Long groupId;
    private String name;
    private String descr;
    private String date;
    private boolean isActive;
    private int countParam;

    public Function() {
    }

    public Function(Long id, Long groupId, String name, String descr, String date, boolean isActive) {
        this.id = id;
        this.groupId = groupId;
        this.name = name;
        this.descr = descr;
        this.date = date;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getCountParam() {
        return countParam;
    }

    public void setCountParam(int countParam) {
        this.countParam = countParam;
    }

    @Override
    public String toString() {
        return "Function{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
