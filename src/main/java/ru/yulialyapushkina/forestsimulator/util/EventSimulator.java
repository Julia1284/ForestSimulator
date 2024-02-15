package ru.yulialyapushkina.forestsimulator.util;

import ru.yulialyapushkina.forestsimulator.entity.Hare;

public class EventSimulator {
    // сон +30 энергии
    // съел ягоды + 10 энергии
    // съел траву + 10 энергии
    // съел кору деревьев + 5 энергии
    // бегал - 20 энергии
    // напал волк - 30 энергии - 20 здоровья
    // напала лиса -30 энергии  - 20 здоровья
    // напал охотник -20 энергии - 40 здоровья
    // поиск еды - 10 энергии
    // сидит в укрытии + 10 энергии

    public int checkEnergy (int energy){
        if (energy > 100){
            energy = 100;

        } else if (energy<0) {
             energy = 0;
        }
         else  {
             return  energy;
        }
        return energy;
    }

    public void checkHealth (int health){
        if (health > 100){
            health = 100;
        } else if (health<0) {
            health = 0;
            System.out.println("Заяй умер! Game over!");
        }
    }

    public void energyWriterService (int energy, int health){
        System.out.println("Энергия "  + energy + ", 'здоровье " + health);
    }

    public void sleepEvent (Hare hare){
        int energyPoint = hare.getEnergyPoint();
        energyPoint = energyPoint + 30;
        energyPoint = checkEnergy(energyPoint);
        hare.setEnergyPoint(energyPoint);
        System.out.println("Заяц поспал.");
        energyWriterService(hare.getEnergyPoint(), hare.getHealthPoint());

    }
}
