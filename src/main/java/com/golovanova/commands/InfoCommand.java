package com.golovanova.commands;

import com.golovanova.CollectionInfo;
import com.golovanova.utility.FileManager;

import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;

public class InfoCommand extends AbstractCommand {


    public InfoCommand() {
        super("info", "display information about the collection");
    }

    public void execute(ArrayDeque workers, CollectionInfo collectionInfo) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatInitTime = collectionInfo.getInitTime().format(formatter);
        String formatSaveTime = collectionInfo.getSaveTime().format(formatter);
        System.out.println("Size of the collection: " + workers.size());
        System.out.println("Init time: " + formatInitTime);
        System.out.println("Last save time: " + formatSaveTime);
    }
}
