package com.playtika.homework2.task1.model;

public class Iron extends Device {

    public Iron(int power, int cost) {
        super(power, cost);
    }

    @Override
    public int getPower(){
        System.out.println("Invoke getPower from Iron");
        return super.getPower();
    }

    public String toString() {
        return "- Iron {Power: " + this.getPower() + "W, " + "Cost: " + this.getCost() + " BYN}";
    }
}