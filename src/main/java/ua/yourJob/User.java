package ua.yourJob;

import java.util.Date;

public class User {
    private String name;
    private int id;
    private Float money;
    private Date trip;
    private String[] items;

    public Float getMoney() { return money; }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Date getTrip() {
        return trip;
    }

    public void setTrip(Date trip) {
        this.trip = trip;
    }

    public String[] getItems() { return items; }

    public void setItems(String[] items) {
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public User(){

    }

}
