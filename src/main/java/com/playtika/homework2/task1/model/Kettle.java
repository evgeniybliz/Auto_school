package com.playtika.homework2.task1.model;

import com.playtika.homework2.task1.model.Device;

public class Kettle extends Device {

    public Kettle(int power, int cost) {
        super(power, cost);
    }

    @Override
    public int getPower(){
        System.out.println("Invoke getPower from Kettle");
        return super.getPower();
    }

    public String toString() {
        return "- Kettle {Power: " + this.getPower() + "W, " + "Cost: " + this.getCost() + " BYN}";
    }
}