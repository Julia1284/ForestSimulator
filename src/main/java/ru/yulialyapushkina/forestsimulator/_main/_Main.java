package ru.yulialyapushkina.forestsimulator._main;

import ru.yulialyapushkina.forestsimulator.entity.Hare;
import ru.yulialyapushkina.forestsimulator.util.EventSimulator;

public class _Main {
    public static void main(String[] args) {
        Hare hare = new Hare();
        EventSimulator eventSimulator = new EventSimulator();

        eventSimulator.sleepEvent(hare);
    }
}
