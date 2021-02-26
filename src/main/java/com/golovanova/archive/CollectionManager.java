package com.golovanova.archive;

import com.golovanova.model.Organization;
import com.golovanova.model.Worker;

import java.time.LocalDateTime;
import java.util.ArrayDeque;

public class CollectionManager {

    private ArrayDeque<Worker> workerArrayDeque = new ArrayDeque<>();

    // TODO private FileManager fileManager;

//    public CollectionManager(FileManager fileManager) {
//        this.lastInitTime = null;
//        this.lastSaveTime = null;
//        this.fileManager = fileManager;
//
//        loadCollection();
//    }

    public ArrayDeque<Worker> getWorkerArrayDeque() {
        return workerArrayDeque;
    }


    public String arrayDequeType() {
        return workerArrayDeque.getClass().getName();
    }

    public int arrayDequeSize() {
        return workerArrayDeque.size();
    }

    public Worker getFirst() {
        if (workerArrayDeque.isEmpty()) return null;
        return workerArrayDeque.getFirst();
    }

    public Worker getLast() {
        if (workerArrayDeque.isEmpty()) return null;
        return workerArrayDeque.getLast();
    }

    public Worker getById(Long id) {
        for (Worker worker : workerArrayDeque ) {
            if (worker.getId().equals(id)) return worker;
        }
        return null;
    }

    public void addToArrayDeque(Worker worker) {
        workerArrayDeque.add(worker);
    }

    public void removeFromArrayDeque(Worker worker) {
        workerArrayDeque.remove(worker);
    }

    public double getAverageSalary() {
        double averageSalary = 0;
        for (Worker worker : workerArrayDeque) {
            averageSalary += worker.getSalary();
        }

        averageSalary = averageSalary/workerArrayDeque.size();

        return averageSalary;
    }

    public String workerFilteredInfo(Organization organizationToFilter) {
        String info = "";
        for (Worker worker : workerArrayDeque) {
            if (worker.getOrganization().equals(organizationToFilter)) {
                info += worker + "\n\n";
            }
        }
        return info.trim();
    }

    public ArrayDeque<Worker> removeWorkerByOrganization(Organization organizationToFilter) {

        for (Worker worker : workerArrayDeque) {
            if (worker.getOrganization().equals(organizationToFilter)) {
                workerArrayDeque.remove();
                break;
            }
        }
        return workerArrayDeque;
    }

    public Worker removeHead(ArrayDeque<Worker> workerArrayDeque) {
        return workerArrayDeque.pollFirst();
    }

//    TODO Компаратор
//    public void removeLower(Worker workerToCompare) {
//        workerArrayDeque.removeIf(worker -> worker.compareTo(workerToCompare) < 0);
//    }

    public void clearArrayDeque() {
        workerArrayDeque.clear();
    }

    public Long generateNextId() {
        if (workerArrayDeque.isEmpty()) return 1L;
        return workerArrayDeque.getLast().getId() + 1L;
    }

//    TODO
//    public void saveCollection() {
//        fileManager.writeCollection(workerArrayDeque);
//    }


//   TODO

//    private void loadCollection() {
//        workerArrayDeque = fileManager.readCollection();
//    }

    @Override
    public String toString() {
        if (workerArrayDeque.isEmpty()) return "Коллекция пуста!";

        String info = "";
        for (Worker worker : workerArrayDeque) {
            info += worker;
            if (worker != workerArrayDeque.getLast()) info += "\n\n";
        }
        return info;
    }

}
