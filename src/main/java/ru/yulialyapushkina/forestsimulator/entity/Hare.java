package ru.yulialyapushkina.forestsimulator.entity;

public class Hare {

    private int healthPoint = 100;

    private int energyPoint = 20;

    private final double SATURATION = 2.5;

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public int getEnergyPoint() {
        return energyPoint;
    }

    public void setEnergyPoint(int energyPoint) {
        this.energyPoint = energyPoint;
    }

    public double getSATURATION() {
        return SATURATION;
    }
}
