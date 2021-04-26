package com.golovanova.commands;

import java.io.Serializable;

public class HelpCommand extends AbstractCommand implements Serializable {
    static final long SerialVersionUID = -4862926644813433707L;

    public HelpCommand() {
        super("help", "display help for available golovanova.golovanova.commands");
    }

    public void execute() {
        System.out.println("help - " + "display help for available golovanova.golovanova.commands");
        System.out.println("add {element} - " + "add a new item to the collection");
        System.out.println("average_of_salary - " + "output the average value of the salary" +
                " field for all items in the collection");
        System.out.println("clear - " + "clear the collection");
        System.out.println("execute_script file_name - " + "read and execute the script from the specified " +
                "file. The script contains golovanova.golovanova.commands in the same form as the user enters them interactively.");
        System.out.println("exit - " + "end the program (without saving it to a file)");
        System.out.println("filter_by_organization organization - " + "output elements whose organization" +
                " field value is equal to the specified value");
        System.out.println("history - " + "print the last 11 golovanova.golovanova.commands (without their arguments)");
        System.out.println("info - " + "display information about the collection");
        System.out.println("remove_any_by_organization organization - " + "remove one element from the " +
                "collection whose organization field value is equivalent to the specified one");
        System.out.println("remove_by_id id - " + "delete an item from the collection by its id");
        System.out.println("remove_head - " + "print the first item in the collection and delete it");
        System.out.println("remove_lower {element_id} - " + "remove all items from the collection that are " +
                "smaller than the specified one");
        System.out.println("save - " + "to save the collection to a file");
        System.out.println("show - " + "output all elements of the collection " +
                "in a string representation to the standard output stream");
        System.out.println("update id {element} - " + "update the value of a collection " +
                "element whose id is equal to the specified one");
    }
}
