package com.playtika.homework2.task1.model;

import com.playtika.homework2.task1.model.Device;

public class Oven extends Device {

    public Oven(int power, int cost) {
        super(power, cost);
    }

    @Override
    public int getPower(){
        System.out.println("Invoke getPower from Oven");
        return super.getPower();
    }

    public String toString() {
        return "- Oven {Power: " + this.getPower() + "W, " + "Cost: " + this.getCost() + "$ }";
    }
}