package com.golovanova.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

public class CollectionInfo {
    private LocalDateTime initTime;
    private LocalDateTime saveTime;
    private Collection collection;

    public CollectionInfo(Collection collection) {
        this.collection = collection;
        initTime = LocalDateTime.now();
        saveTime = LocalDateTime.now();
    }

    public LocalDateTime getInitTime() {
        return initTime;
    }

    public LocalDateTime getSaveTime() {
        return saveTime;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setInitTime(LocalDateTime initTime) {
        this.initTime = initTime;
    }

    public void setSaveTime(LocalDateTime saveTime) {
        this.saveTime = saveTime;
    }

    public int getCollectionSize() {
        return collection.size();
    }

    public String summary() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formatInitTime = initTime.format(formatter);
        String formatSaveTime = saveTime.format(formatter);
        String summary =
                "Size of the collection: " +  getCollectionSize()
                        + "Init time: " + formatInitTime
                        + "Last save time: " + formatSaveTime;
        return summary;
    }
}
