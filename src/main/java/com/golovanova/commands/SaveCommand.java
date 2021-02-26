package com.golovanova.commands;

import com.golovanova.CollectionInfo;
import com.golovanova.model.Worker;
import com.golovanova.utility.FileManager;

import java.time.LocalDateTime;
import java.util.ArrayDeque;

public class SaveCommand extends AbstractCommand {
    public SaveCommand() {
        super("save", "to save the collection to a file");
    }


    public void execute(ArrayDeque<Worker> workers, FileManager fileManager, CollectionInfo collectionInfo) {
        fileManager.writeCollection(workers);
        collectionInfo.setSaveTime(LocalDateTime.now());
    }
}
