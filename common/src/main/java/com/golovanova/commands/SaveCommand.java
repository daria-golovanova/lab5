package com.golovanova.commands;

import com.golovanova.utility.CollectionInfo;
import com.golovanova.model.Worker;
import com.golovanova.utility.FileManager;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayDeque;

public class SaveCommand extends AbstractCommand implements Serializable {
    static final long SerialVersionUID = -4862926644813433707L;
    public SaveCommand() {
        super(CommandType.save);
    }

    public void execute(ArrayDeque<Worker> workers, FileManager fileManager, CollectionInfo collectionInfo) {
        fileManager.writeCollection(workers);
        collectionInfo.setSaveTime(LocalDateTime.now());
    }
}
