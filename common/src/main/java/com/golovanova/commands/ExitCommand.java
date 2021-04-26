package com.golovanova.commands;

public class ExitCommand extends AbstractCommand {
    public ExitCommand() {
        super("exit", "end the program (without saving it to a file)");
    }

    public void execute() {
        System.exit(0);
    }
}
