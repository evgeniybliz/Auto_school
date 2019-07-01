package com.playtika.homework2.task1.model;

import com.playtika.homework2.task1.model.Device;

public class Microwave extends Device {

    public Microwave(int power, int cost) {
        super(power, cost);
    }

    @Override
    public int getPower(){
        System.out.println("Invoke getPower from Microwave");
        return super.getPower();
    }

    public String toString() {
        return "- Microwave {Power: " + this.getPower() + "W, " + "Cost: " + this.getCost() + " BYN}";
    }
}