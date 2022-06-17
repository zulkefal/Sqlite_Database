package com.example.database;

public class dataprovider {

    private  String roll;
    private String name;
    private String fat;
    private String sem;
    private String sec;
    private String mk;
    private String pone;

    public dataprovider(String roll, String name, String fat, String sem, String sec, String mk, String pone) {
        this.roll = roll;
        this.name = name;
        this.fat = fat;
        this.sem = sem;
        this.sec = sec;
        this.mk = mk;
        this.pone = pone;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public String getSem() {
        return sem;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }

    public String getSec() {
        return sec;
    }

    public void setSec(String sec) {
        this.sec = sec;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    public String getPone() {
        return pone;
    }

    public void setPone(String pone) {
        this.pone = pone;
    }

}
