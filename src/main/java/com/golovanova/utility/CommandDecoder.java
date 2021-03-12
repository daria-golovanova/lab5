package com.golovanova.utility;

import com.golovanova.commands.*;

import static com.golovanova.commands.CommandType.*;

public class CommandDecoder {
    public static CommandType decode(String input) {
        String[] split = input.split(" ");
        switch (split[0]) {
            case "help": return help;
            case "info": return info;
            case "add": return add;
            case "show": return show;
            case "update": return update;
            case "remove_by_id": return remove_by_id;
            case "clear": return clear;
            case "save": return save;
            case "execute_script": return execute_script;
            case "exit": return exit;
            case "remove_head": return remove_head;
            case "remove_lower": return  remove_lower;
            case "history": return history;
            case "remove_any_by_organization": return remove_any_by_organization;
            case "average_of_salary": return average_of_salary;
            default: return no_command;
        }
    }
}
