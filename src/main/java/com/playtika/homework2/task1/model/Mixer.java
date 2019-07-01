package com.playtika.homework2.task1.model;

import com.playtika.homework2.task1.model.Device;

public class Mixer extends Device {

    public Mixer(int power, int cost) {
        super(power, cost);
    }

    @Override
    public int getPower(){
        System.out.println("Invoke getPower from Mixer");
        return super.getPower();
    }

    public String toString() {
        return "- Mixer {Power: " + this.getPower() + "W, " + "Cost: " + this.getCost() + " BYN}";
    }
}