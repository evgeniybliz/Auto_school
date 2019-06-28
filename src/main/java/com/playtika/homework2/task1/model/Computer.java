package com.playtika.homework2.task1.model;

import com.playtika.homework2.task1.model.Device;

public class Computer extends Device {

    public Computer(int power, int cost) {
        super(power, cost);
    }

    @Override
    public int getPower(){
        System.out.println("Invoke getPower from Computer");
        return super.getPower();
    }

    public String toString() {
        return "- Computer {Power: " + this.getPower() + "W, " + "Cost: " + this.getCost() + "$ }";
    }
}