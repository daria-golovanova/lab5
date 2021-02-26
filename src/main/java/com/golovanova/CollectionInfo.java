package com.golovanova;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Collection;

@Getter
public class CollectionInfo {
    @Setter
    private LocalDateTime initTime;
    @Setter
    private LocalDateTime saveTime;
    private Collection collection;

    public CollectionInfo(Collection collection) {
        this.collection = collection;
        initTime = LocalDateTime.now();
        saveTime = LocalDateTime.now();
    }
}
