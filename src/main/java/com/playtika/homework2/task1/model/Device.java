package com.playtika.homework2.task1.model;

public class Device {

    private int power;
    private int cost;
    private boolean state;

    public Device(int power, int cost) {
        this.power = power;
        this.cost = cost;
    }

    public int getPower() {
        return power;
    }

    public int getCost() {
        return cost;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void turnOn() {
        state = true;
    }

    public void turnOff() {
        state = false;
    }

    public String toString() {
        return " - Device {Power: " + this.power + "W, ";
    }
}