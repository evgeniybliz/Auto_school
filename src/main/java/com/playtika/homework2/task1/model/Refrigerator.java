package com.playtika.homework2.task1.model;

import com.playtika.homework2.task1.model.Device;

public class Refrigerator extends Device {

    public Refrigerator(int power, int cost) {
        super(power, cost);
    }

    @Override
    public int getPower(){
        System.out.println("Invoke getPower from Regrigirator");
        return super.getPower();
    }

    public String toString() {
        return "- Regrigirator {Power: " + this.getPower() + "W, " + "Cost: " + this.getCost() + "$ }";
    }
}