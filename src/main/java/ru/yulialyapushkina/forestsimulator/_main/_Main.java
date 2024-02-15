package ru.yulialyapushkina.forestsimulator._main;

import ru.yulialyapushkina.forestsimulator.entity.Hare;
import ru.yulialyapushkina.forestsimulator.util.EventSimulator;

public class _Main {
    public static void main(String[] args) {
        Hare hare = new Hare();
        EventSimulator eventSimulator = new EventSimulator();

        eventSimulator.sleepEvent(hare);
        eventSimulator.eatBerries(hare);
        eventSimulator.eatGrass(hare);
        eventSimulator.eatTreeBark(hare);
        eventSimulator.run(hare);
        eventSimulator.hunterAttack(hare);
        eventSimulator.wolfAttack(hare);
        eventSimulator.foxAttack(hare);
        eventSimulator.searchFood(hare);
        eventSimulator.sitInShelter(hare);
    }
}
