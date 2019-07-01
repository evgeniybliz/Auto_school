package com.playtika.homework2.task1.model;

import com.playtika.homework2.task1.model.Device;

public class WashingMachine extends Device {

    public WashingMachine(int power, int cost) {
        super(power, cost);
    }

    @Override
    public int getPower(){
        System.out.println("Invoke getPower from Washing Machine");
        return super.getPower();
    }

    public String toString() {
        return "- Washing Machine {Power: " + this.getPower() + "W, " + "Cost: " + this.getCost() + " BYN}";
    }
}