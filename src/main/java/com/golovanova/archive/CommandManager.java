package com.golovanova.archive;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedTransferQueue;

public class CommandManager {
//
//    private final int COMMAND_HISTORY_SIZE = 11;
//
//    private String[] commandHistory = new String[COMMAND_HISTORY_SIZE];
//    private Queue<Command> history = new LinkedTransferQueue<>();
//    private List<Command> commands = new ArrayList<>();
//
//    private Command helpCommand;
//    private Command infoCommand;
//    private Command showCommand;
//    private Command addCommand;
//    private Command updateCommand;
//    private Command removeByIdCommand;
//    private Command clearCommand;
//    private Command saveCommand;
//    private Command exitCommand;
//    private Command executeScriptCommand;
//    private Command removeHeadCommand;
//    private Command removeLowerCommand;
//    private Command historyCommand;
//    private Command removeAnyByOrganizationCommand;
//    private Command averageOfSalaryCommand;
//    private Command filterByOrganizationCommand;
//
//    public CommandManager(String[] commandHistory, List<Command> commands, Command helpCommand,
//                          Command infoCommand, Command showCommand, Command addCommand,
//                          Command updateCommand, Command removeByIdCommand, Command clearCommand,
//                          Command saveCommand, Command exitCommand, Command executeScriptCommand,
//                          Command removeHeadCommand, Command removeLowerCommand,
//                          Command historyCommand, Command removeAnyByOrganizationCommand,
//                          Command averageOfSalaryCommand, Command filterByOrganizationCommand) {
//        this.commandHistory = commandHistory;
//        this.commands = commands;
//        this.helpCommand = helpCommand;
//        this.infoCommand = infoCommand;
//        this.showCommand = showCommand;
//        this.addCommand = addCommand;
//        this.updateCommand = updateCommand;
//        this.removeByIdCommand = removeByIdCommand;
//        this.clearCommand = clearCommand;
//        this.saveCommand = saveCommand;
//        this.exitCommand = exitCommand;
//        this.executeScriptCommand = executeScriptCommand;
//        this.removeHeadCommand = removeHeadCommand;
//        this.removeLowerCommand = removeLowerCommand;
//        this.historyCommand = historyCommand;
//        this.removeAnyByOrganizationCommand = removeAnyByOrganizationCommand;
//        this.averageOfSalaryCommand = averageOfSalaryCommand;
//        this.filterByOrganizationCommand = filterByOrganizationCommand;
//        //?
//        commands.add(helpCommand);
//        commands.add(showCommand);
//        commands.add(addCommand);
//        commands.add(updateCommand);
//        commands.add(removeByIdCommand);
//        commands.add(clearCommand);
//        commands.add(saveCommand);
//        commands.add(exitCommand);
//        commands.add(executeScriptCommand);
//        commands.add(removeHeadCommand);
//        commands.add(removeLowerCommand);
//        commands.add(historyCommand);
//        commands.add(removeAnyByOrganizationCommand);
//        commands.add(averageOfSalaryCommand);
//        commands.add(filterByOrganizationCommand);
//    }
//
//    public String[] getCommandHistory() {
//        return commandHistory;
//    }
//
//    public List<Command> getCommands() {
//        return commands;
//    }
//
//    public void addToHistory(String commandToAdd) {
//        for (Command command : commands) {
//            if (command.getName().split(" ")[0].equals(commandToAdd)) {
//                for (int i = COMMAND_HISTORY_SIZE-1; i>0;i--) {
//                    commandHistory[i] = commandHistory[i-1];
//                }
//                commandHistory[0] = commandToAdd;
//            }
//        }
    //}

//    TODO
//    public boolean noSuchCommand(String command) {
//        Console.println("Command '" + command + "' is not found. Type 'help' for instruction.");
//        return false;
//    }

    //TODO Add all com.golovanova.commands
    //public boolean exit(String argument) {
    //        return exitCommand.execute(argument);
    //    }
}
