package com.golovanova.commands;

public class ExecuteScriptCommand extends AbstractCommand {
    public ExecuteScriptCommand() {
        super("execute_script file_name", "read and execute the script from the specified " +
                "file. The script contains com.golovanova.commands in the same form as the user enters them interactively.");
    }

    public void execute(String filePath) {

    }
}
