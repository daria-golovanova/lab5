package com.golovanova.dto;

import com.golovanova.model.Worker;

import java.util.List;

public class Payload {
    private List<Worker> workers;

    public Payload(List<Worker> workers) {
        this.workers = workers;
    }

    public List<Worker> getWorkers() {
        return workers;
    }
}
