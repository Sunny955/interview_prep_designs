package org.lld.prep.design_patterns.command;

import java.util.concurrent.locks.ReentrantLock;

interface Command {
    void execute();
}
class Light {
    public void on() {
        System.out.println("Lights on!");
    }

    public void off() {
        System.out.println("Lights off!");
    }
}
class LightsOnCommand implements Command {
    private Light light;
    public LightsOnCommand(Light light) {
        this.light = light;
    }
    @Override
    public void execute() {
        light.on();
    }
}
class LightsOffCommand implements Command {
    private Light light;

    public LightsOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}

class RemoteControl {
    Command slot;
    public RemoteControl() {}
    public void setCommand(Command slot) {
        this.slot = slot;
    }
    public void buttonPressed() {
        slot.execute();
    }
}

public class MainClass {
    public static void main(String[] args) {
        RemoteControl rm = new RemoteControl();
        Light light = new Light();

        rm.setCommand(new LightsOnCommand(light));
        rm.buttonPressed();
        rm.setCommand(new LightsOffCommand(light));
        rm.buttonPressed();
    }
}
