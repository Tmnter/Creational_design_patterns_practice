package org.example.dispatcher;

import org.example.dispatcher.Logger;
import org.example.dispatcher.ScheduleManager;

interface Command {
    void execute();
    void undo();
    String getDescription();
}

class ChangeFlightTimeCommand implements Command {
    private org.example.dispatcher.ScheduleManager scheduleManager;
    private String previousTime;
    private String newTime;

    public ChangeFlightTimeCommand(org.example.dispatcher.ScheduleManager scheduleManager, String newTime) {
        this.scheduleManager = scheduleManager;
        this.newTime = newTime;
    }

    @Override
    public void execute() {
        this.previousTime = "14:00"; // умовне збереження попереднього стану для демо
        scheduleManager.setTime(newTime);
        Logger.log("Dispatcher", "Виконано: перенесено час рейсу на " + newTime);
    }

    @Override
    public void undo() {
        scheduleManager.setTime(previousTime);
        Logger.log("Dispatcher", "Скасовано: час рейсу повернуто на " + previousTime);
    }

    @Override
    public String getDescription() {
        return "Зміна часу рейсу на " + newTime;
    }
}

abstract class ChangeGateCommand implements Command {
    private ScheduleManager scheduleManager;
    private String previousGate;
    private String newGate;

    public ChangeGateCommand(ScheduleManager scheduleManager, String newGate) {
        this.scheduleManager = scheduleManager;
        this.newGate = newGate;
    }

    @Override
    public void execute() {
        this.previousGate = "A1";
        scheduleManager.setGate(newGate);
        Logger.log("Dispatcher", "Виконано: змінено вихід на посадку на " + newGate);
    }

    @Override
    public void undo() {
        scheduleManager.setGate(previousGate);
        Logger.log("Dispatcher", "Скасовано: вихід повернуто на " + previousGate);
    }

    @Override
    public String getDescription() {
        return "Зміна виходу на посадку на " + newGate;
    }
}