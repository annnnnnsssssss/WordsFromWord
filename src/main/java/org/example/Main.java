package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Программа запущена, генерируем уровни...");

        // --- 1. Входные данные ---
        List<String> dictionary = Arrays.asList("десант", "адрес", "армия", "место", "метро", "демон", "стража", "монстр", "яма", "дом");
        List<String> mainWords = Arrays.asList("ДЕМОНСТРАЦИЯ", "ВЗАИМНОСТЬ");

        // Настройки (Config)
        Config config = new Config();
        config.minSubWordLength = 3;
        config.minWordsToPass = 2; // Поставим 2 для теста, чтобы уровень точно создался
        config.difficultyThresholds = new Config.DifficultyThresholds();
        config.difficultyThresholds.easyMaxMainWordLength = 7;
        config.difficultyThresholds.mediumMaxMainWordLength = 10;
        config.difficultyThresholds.easyMaxSubWords = 15;
        config.difficultyThresholds.mediumMaxSubWords = 30;

        // --- 2. Генерация уровней ---
        List<Level> levels = LevelGenerator.generate(dictionary, mainWords, config);

        // --- 3. Сохранение в JSON ---
        OutputWrapper wrapper = new OutputWrapper();
        wrapper.levels = levels;

        // Настраиваем Gson, чтобы JSON был красивым (с отступами)
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(wrapper);

        // Записываем в файл output.json
        try (FileWriter writer = new FileWriter("output.json")) {
            writer.write(json);
            System.out.println("Успех! Файл output.json создан в корне проекта.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи файла: " + e.getMessage());
        }
    }

    // Вспомогательный класс, чтобы в JSON был корень "levels"
    static class OutputWrapper {
        List<Level> levels;
    }
}