package com.golovanova.utility;

import com.golovanova.CollectionInfo;
import com.golovanova.adapter.ZonedDateTimeAdapter;
import com.golovanova.model.Worker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.NoSuchElementException;

public class FileManager {
    
    private final Gson g = new GsonBuilder()
            .registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeAdapter())
            .enableComplexMapKeySerialization()
            .create();

    private File file;

    public FileManager(File file) {
        this.file = file;
    }

    public void writeCollection(Collection<?> collection) {
        if (file == null || !file.isFile() || !file.exists() || !file.canWrite()) {
            System.err.println("File is corrupted.");
            return;
        }

        try (PrintWriter collectionFileWriter = new PrintWriter(file)) {
            collectionFileWriter.write(g.toJson(collection));
            System.out.println("Коллекция успешна сохранена в файл!");
        } catch (IOException exception) {
            System.err.println("Загрузочный файл является директорией/не может быть открыт!");
        }
    }

    public ArrayDeque<Worker> readCollection() {
        if (file == null) {
            System.err.println("File is null.");
            return new ArrayDeque<>();
        }

        if (!file.isFile() || !file.exists() || !file.canRead()) {
            System.err.println("File is corrupted.");
            return new ArrayDeque<>();
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            ArrayDeque<Worker> collection = new ArrayDeque<>();
            Type collectionType = new TypeToken<ArrayDeque<Worker>>() {}.getType();
            collection = g.fromJson(reader.readLine().trim(), collectionType);
            System.out.println("Collection is downloaded!");

            CollectionInfo collectionInfo = new CollectionInfo(collection);
            collectionInfo.setSaveTime(LocalDateTime.now());
            collectionInfo.setInitTime(LocalDateTime.now());

            Worker.updateIdSequence(collection);

            return collection;
        } catch (FileNotFoundException exception) {
            System.err.println("Загрузочный файл не найден!");
        } catch (NoSuchElementException exception) {
            System.err.println("Загрузочный файл пуст!");
        } catch (JsonParseException | NullPointerException exception) {
            System.err.println("В загрузочном файле не обнаружена необходимая коллекция!" + exception);
        } catch (IllegalStateException | IOException exception) {
            System.err.println("Непредвиденная ошибка!");
            System.exit(0);
        }


        return new ArrayDeque<>();
    }

    public ArrayDeque<Worker> readObject() {
        if (file == null || !file.isFile() || !file.exists()) {
            return new ArrayDeque<>();
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            ArrayDeque<Worker> collection = new ArrayDeque<>();
            Type type = new TypeToken<Worker>() {}.getType();
            Worker w = g.fromJson(reader.readLine().trim(), type);
            collection.add(w);

            System.out.println("Object is downloaded!");
            return collection;


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayDeque<>();
    }


    @Override
    public String toString() {
        String string = "FileManager (класс для работы с загрузочным файлом)";
        return string;
    }

}
