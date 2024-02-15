package ru.yulialyapushkina.forestsimulator.entity;

public class Hare {

    private int healthPoint = 20;

    private int energyPoint = 20;



    private final double SATURATION_BERRIES = 2.5;
    private final double SATURATION_GRASS = 3.3;
    private final double SATURATION_TREE_BARK = 1.8;

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

    public double getSATURATION_BERRIES() {
        return SATURATION_BERRIES;
    }


    public double getSATURATION_GRASS() {
        return SATURATION_GRASS;
    }

    public double getSATURATION_TREE_BARK() {
        return SATURATION_TREE_BARK;
    }

}
