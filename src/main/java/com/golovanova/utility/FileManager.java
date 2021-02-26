package com.golovanova.utility;

import com.golovanova.model.Worker;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class FileManager {
        private Gson g = new Gson();
        private File file;

        public FileManager(File file) {
            this.file = file;
        }
    //TODO Парсер
//    File file = new File("C:\\Dropbox\\Мой ПК (Darya)\\Desktop\\data.json"); //??????????
//
//    public void readFromFile() throws IOException {
//        //InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
//        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
    //BufferedReader reader = new BufferedReader(new InputStreamReader(new File(System.getenv().get(envVariable))));
//        String line = reader.readLine();
//    }
//
//    public void parse() {
//        Gson g = new Gson();
//        Worker worker = g.fromJson(jsonString, Worker.class);
//    }

    public void writeCollection(Collection<?> collection) {
        if (file != null && file.isFile() && file.exists()) {
            try (PrintWriter collectionFileWriter = new PrintWriter(file)) {
                collectionFileWriter.write(g.toJson(collection));
                System.out.println("Коллекция успешна сохранена в файл!");
            } catch (IOException exception) {
                System.err.println("Загрузочный файл является директорией/не может быть открыт!");
            }
        } else
            System.err.println("Системная переменная с загрузочным файлом не найдена!");
    }

     public ArrayDeque<Worker> readCollection() {
            if (file != null && file.isFile() && file.exists()) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
                    ArrayDeque<Worker> collection;
                    Type collectionType = new TypeToken<ArrayDeque<Worker>>() {}.getType();
                    collection = g.fromJson(reader.readLine().trim(), collectionType);
                    System.out.println("Collection is downloaded!");
                    return collection;
                } catch (FileNotFoundException exception) {
                    System.err.println("Загрузочный файл не найден!");
                } catch (NoSuchElementException exception) {
                    System.err.println("Загрузочный файл пуст!");
                } catch (JsonParseException | NullPointerException exception) {
                    System.err.println("В загрузочном файле не обнаружена необходимая коллекция!");
                } catch (IllegalStateException | IOException exception) {
                    System.err.println("Непредвиденная ошибка!");
                    System.exit(0);
                }
            } else System.err.println("Системная переменная с загрузочным файлом не найдена!");
            return new ArrayDeque<Worker>();
        }

    @Override
    public String toString() {
        String string = "FileManager (класс для работы с загрузочным файлом)";
        return string;
    }

}
