package ru.yulialyapushkina.forestsimulator.util;

import ru.yulialyapushkina.forestsimulator.entity.Hare;

public class EventSimulator {
    // 20% 0-20 сон +30 энергии
    // 10% 20-30 съел ягоды + 5 * saturation энергия  + 8 здоровья
    // 10% 30-40 съел траву + 5 * saturation энергия  + 7 здоровья
    // 10% 40-50 съел кору деревьев + 5 * saturation энергия + 5 здоровья
    // 5% 50-55 бегал - 20 энергии
    // 10% 55-65 напал волк - 30 энергии - 20 здоровья
    // 10% 65-75 напала лиса -20 энергии  - 20 здоровья
    // 10% 75-85 напал охотник -20 энергии - 40 здоровья
    // 10% 85-95 поиск еды - 10 энергии
    // 5% 95-100 сидит в укрытии + 10 энергии здоровье +10

    public void startSimulation(Hare hare) {
        while (isAlive(hare)) {
            int eventRandomizer = (int) (Math.random() * 100);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (eventRandomizer >= 0 && eventRandomizer < 20) {
                sleep(hare);
            } else if (eventRandomizer >= 20 && eventRandomizer < 30) {
                eatBerries(hare);
            } else if (eventRandomizer >= 30 && eventRandomizer < 40) {
                eatGrass(hare);
            } else if (eventRandomizer >= 40 && eventRandomizer < 50) {
                eatTreeBark(hare);
            } else if (eventRandomizer >= 50 && eventRandomizer < 55) {
                run(hare);
            } else if (eventRandomizer >= 55 && eventRandomizer < 65) {
                attackByWolf(hare);
            } else if (eventRandomizer >= 65 && eventRandomizer < 75) {
                attackFox(hare);
            } else if (eventRandomizer >= 75 && eventRandomizer < 85) {
                attackByHunter(hare);
            } else if (eventRandomizer >= 85 && eventRandomizer < 95) {
                searchFood(hare);
            } else if (eventRandomizer >= 95 && eventRandomizer < 100) {
                sitInShelter(hare);
            }
        }
        System.out.println("Заяц умер!!! Game over!!");
    }

    private void checkEnergy(Hare hare) {
        int energy = hare.getEnergyPoint();
        int health = hare.getHealthPoint();
        if (energy > 100) {
            energy = 100;
        } else if (energy <= 0) {
            energy = 0;
            health = health - 5;
        }
        hare.setEnergyPoint(energy);
        hare.setHealthPoint(health);
    }

    private void checkHealth(Hare hare) {
        int health = hare.getHealthPoint();
        if (health > 100) {
            health = 100;
        } else if (health <= 0) {
            health = 0;
        }
        hare.setHealthPoint(health);
    }

    private void energyWriterService(int energy, int health) {
        System.out.println("Энергия " + energy + ", здоровье " + health);
    }

    private void sleep(Hare hare) {
        int energyPoint = hare.getEnergyPoint();
        energyPoint = energyPoint + 30;
        hare.setEnergyPoint(energyPoint);
        checkEnergy(hare);
        System.out.println("Заяц поспал.");
        energyWriterService(hare.getEnergyPoint(), hare.getHealthPoint());
    }

    private void eatBerries(Hare hare) {
        int energyPoint = hare.getEnergyPoint();
        int healthPoint = hare.getHealthPoint();
        energyPoint = (int) (energyPoint + 5 * hare.getSATURATION_BERRIES());
        healthPoint = healthPoint + 8;
        hare.setEnergyPoint(energyPoint);
        hare.setHealthPoint(healthPoint);
        checkEnergy(hare);
        checkHealth(hare);
        System.out.println("Заяц поел ягоды.");
        energyWriterService(hare.getEnergyPoint(), hare.getHealthPoint());
    }

    private void eatGrass(Hare hare) {
        int energyPoint = hare.getEnergyPoint();
        int healthPoint = hare.getHealthPoint();
        energyPoint = (int) (energyPoint + 5 * hare.getSATURATION_GRASS());
        healthPoint = healthPoint + 7;
        hare.setEnergyPoint(energyPoint);
        hare.setHealthPoint(healthPoint);
        checkEnergy(hare);
        checkHealth(hare);
        System.out.println("Заяц поел траву.");
        energyWriterService(hare.getEnergyPoint(), hare.getHealthPoint());
    }

    private void eatTreeBark(Hare hare) {
        int energyPoint = hare.getEnergyPoint();
        int healthPoint = hare.getHealthPoint();
        energyPoint = (int) (energyPoint + 5 * hare.getSATURATION_TREE_BARK());
        healthPoint = healthPoint + 5;
        hare.setEnergyPoint(energyPoint);
        hare.setHealthPoint(healthPoint);
        checkEnergy(hare);
        checkHealth(hare);
        System.out.println("Заяц поел кору деревьев.");
        energyWriterService(hare.getEnergyPoint(), hare.getHealthPoint());
    }

    private void run(Hare hare) {
        int energyPoint = hare.getEnergyPoint();
        energyPoint = energyPoint - 20;
        hare.setEnergyPoint(energyPoint);
        checkEnergy(hare);
        System.out.println("Заяц побегал.");
        energyWriterService(hare.getEnergyPoint(), hare.getHealthPoint());
    }

    private void attackByHunter(Hare hare) {
        int energyPoint = hare.getEnergyPoint();
        int healthPoint = hare.getHealthPoint();
        energyPoint = energyPoint - 20;
        healthPoint = healthPoint - 40;
        hare.setEnergyPoint(energyPoint);
        hare.setHealthPoint(healthPoint);
        checkEnergy(hare);
        checkHealth(hare);
        System.out.println("На зайца напал охотник");
        energyWriterService(hare.getEnergyPoint(), hare.getHealthPoint());
    }

    private void attackByWolf(Hare hare) {
        int energyPoint = hare.getEnergyPoint();
        int healthPoint = hare.getHealthPoint();
        energyPoint = energyPoint - 30;
        healthPoint = healthPoint - 20;
        hare.setEnergyPoint(energyPoint);
        hare.setHealthPoint(healthPoint);
        checkEnergy(hare);
        checkHealth(hare);
        System.out.println("На зайца напал волк");
        energyWriterService(hare.getEnergyPoint(), hare.getHealthPoint());
    }

    private void attackFox(Hare hare) {
        int energyPoint = hare.getEnergyPoint();
        int healthPoint = hare.getHealthPoint();
        energyPoint = energyPoint - 20;
        healthPoint = healthPoint - 20;
        hare.setEnergyPoint(energyPoint);
        hare.setHealthPoint(healthPoint);
        checkEnergy(hare);
        checkHealth(hare);
        System.out.println("На зайца напала лиса");
        energyWriterService(hare.getEnergyPoint(), hare.getHealthPoint());
    }

    private void searchFood(Hare hare) {
        int energyPoint = hare.getEnergyPoint();
        energyPoint = energyPoint - 10;
        hare.setEnergyPoint(energyPoint);
        checkEnergy(hare);
        System.out.println("Заяц ищет еду.");
        energyWriterService(hare.getEnergyPoint(), hare.getHealthPoint());
    }

    private void sitInShelter(Hare hare) {
        int energyPoint = hare.getEnergyPoint();
        int healthPoint = hare.getHealthPoint();
        energyPoint = energyPoint + 10;
        healthPoint = healthPoint + 10;
        hare.setEnergyPoint(energyPoint);
        hare.setHealthPoint(healthPoint);
        checkEnergy(hare);
        checkHealth(hare);
        System.out.println("Заяц сидит в укрытии");
        energyWriterService(hare.getEnergyPoint(), hare.getHealthPoint());
    }

    private boolean isAlive(Hare hare) {
        if (hare.getHealthPoint() <= 0) {
            return false;
        } else {
            return true;
        }
    }
}
