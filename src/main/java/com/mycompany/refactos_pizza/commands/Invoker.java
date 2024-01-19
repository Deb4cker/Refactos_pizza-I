package com.mycompany.refactos_pizza.commands;

public class Invoker<T extends Command> {

    private T command;

    public Invoker() {}

    public Invoker(T command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }

    public void setCommand(T command) {
        this.command = command;
    }
}
