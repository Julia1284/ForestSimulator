package ru.yulialyapushkina.forestsimulator.util;

import ru.yulialyapushkina.forestsimulator.entity.Hare;

public class EventSimulator {
    // сон +30 энергии
    // съел ягоды + 5 * saturation энергия  + 8 здоровья
    // съел траву + 5 * saturation энергия  + 7 здоровья
    // съел кору деревьев + 5 * saturation энергия + 5 здоровья
    // бегал - 20 энергии
    // напал волк - 30 энергии - 20 здоровья
    // напала лиса -30 энергии  - 20 здоровья
    // напал охотник -20 энергии - 40 здоровья
    // поиск еды - 10 энергии
    // сидит в укрытии + 10 энергии

    public int checkEnergy(int energy) {
        if (energy > 100) {
            energy = 100;
        } else if (energy < 0) {
            energy = 0;
        } else
            return energy;
        return energy;
    }

    public int checkHealth(int health) {
        if (health > 100) {
            health = 100;
        } else if (health < 0) {
            health = 0;
            System.out.println("Заяй умер! Game over!");
        } else return health;
        return health;
    }


    public void energyWriterService(int energy, int health) {
        System.out.println("Энергия " + energy + ", 'здоровье " + health);
    }

    public void sleepEvent(Hare hare) {
        int energyPoint = hare.getEnergyPoint();
        energyPoint = energyPoint + 30;
        energyPoint = checkEnergy(energyPoint);
        hare.setEnergyPoint(energyPoint);
        System.out.println("Заяц поспал.");
        energyWriterService(hare.getEnergyPoint(), hare.getHealthPoint());
    }

    public void eatBerries(Hare hare) {
        int energyPoint = hare.getEnergyPoint();
        int healthPoint = hare.getHealthPoint();
        energyPoint = (int) (energyPoint + 5 * hare.getSATURATION_BERRIES());
        energyPoint = checkEnergy(energyPoint);
        healthPoint = healthPoint + 8;
        healthPoint = checkHealth(healthPoint);
        hare.setEnergyPoint(energyPoint);
        hare.setHealthPoint(healthPoint);
        System.out.println("Заяц поел ягоды.");
        energyWriterService(hare.getEnergyPoint(), hare.getHealthPoint());
    }

    public void eatGrass(Hare hare) {
        int energyPoint = hare.getEnergyPoint();
        int healthPoint = hare.getHealthPoint();
        energyPoint = (int) (energyPoint + 5 * hare.getSATURATION_GRASS());
        energyPoint = checkEnergy(energyPoint);
        healthPoint = healthPoint + 7;
        healthPoint = checkHealth(healthPoint);
        hare.setEnergyPoint(energyPoint);
        hare.setHealthPoint(healthPoint);
        System.out.println("Заяц поел траву.");
        energyWriterService(hare.getEnergyPoint(), hare.getHealthPoint());
    }

    public void eatTreeBark(Hare hare) {
        int energyPoint = hare.getEnergyPoint();
        int healthPoint = hare.getHealthPoint();
        energyPoint = (int) (energyPoint + 5 * hare.getSATURATION_TREE_BARK());
        energyPoint = checkEnergy(energyPoint);
        healthPoint = healthPoint + 5;
        healthPoint = checkHealth(healthPoint);
        hare.setEnergyPoint(energyPoint);
        hare.setHealthPoint(healthPoint);
        System.out.println("Заяц поел траву.");
        energyWriterService(hare.getEnergyPoint(), hare.getHealthPoint());
    }
}
