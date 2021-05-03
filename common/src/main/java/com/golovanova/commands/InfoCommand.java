package com.golovanova.commands;

import com.golovanova.utility.CollectionInfo;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;

public class InfoCommand extends AbstractCommand implements Serializable {
    static final long SerialVersionUID = -4862926644813433707L;

    public InfoCommand() {
        super(CommandType.info);
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
