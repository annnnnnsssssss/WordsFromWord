package org.example;

import java.util.*;

public class LevelGenerator {

    public static List<Level> generate(List<String> dictionary, List<String> mainWords, Config config) {
        List<Level> levels = new ArrayList<>();
        int levelId = 1;

        // 1. Убираем дубликаты и приводим к верхнему регистру (Тест 4 и 6)
        Set<String> uniqueDictionary = new HashSet<>();
        for (String word : dictionary) {
            uniqueDictionary.add(normalize(word));
        }

        // 2. Проходим по каждому главному слову
        for (String mainWordRaw : mainWords) {
            String mainWord = normalize(mainWordRaw);
            List<String> validSubWords = new ArrayList<>();

            // Ищем подслова в словаре
            for (String dictWord : uniqueDictionary) {

                if (dictWord.length() < config.minSubWordLength) continue; // Слишком короткое
                if (dictWord.equals(mainWord)) continue; // Главное слово нельзя использовать как подслово

                // Проверяем, можно ли составить слово из букв главного
                if (canBeFormed(mainWord, dictWord)) {
                    validSubWords.add(dictWord);
                }
            }

            // Если слов меньше, чем нужно для прохождения, уровень не создаем (Тест 7)
            if (validSubWords.size() < config.minWordsToPass) {
                System.out.println("Уровень для слова " + mainWord + " пропущен: мало подслов.");
                continue;
            }

            Collections.sort(validSubWords); // Сортируем по алфавиту для красоты

            // Высчитываем сложность
            String difficulty = calculateDifficulty(mainWord, validSubWords.size(), config);

            // Формируем список подслов
            List<SubWord> subWordsForJson = new ArrayList<>();
            for (String sw : validSubWords) {
                subWordsForJson.add(new SubWord(sw));
            }

            // Создаем уровень
            Level level = new Level(levelId++, mainWord, difficulty, config.minWordsToPass, subWordsForJson);
            levels.add(level);
        }

        return levels;
    }

    // Приводим слово к единому виду (верхний регистр, Ё -> Е)
    private static String normalize(String word) {
        return word.toUpperCase().replace('Ё', 'Е').trim();
    }

    // Проверка: можно ли составить subWord из букв mainWord?
    private static boolean canBeFormed(String mainWord, String subWord) {
        Map<Character, Integer> mainLetters = new HashMap<>();
        for (char c : mainWord.toCharArray()) {
            mainLetters.put(c, mainLetters.getOrDefault(c, 0) + 1);
        }

        for (char c : subWord.toCharArray()) {
            if (!mainLetters.containsKey(c)) return false; // Такой буквы нет
            int count = mainLetters.get(c);
            if (count == 0) return false; // Буквы не хватает
            mainLetters.put(c, count - 1); // Забираем букву
        }
        return true;
    }

    // Расчет сложности
    private static String calculateDifficulty(String mainWord, int subWordsCount, Config config) {
        Config.DifficultyThresholds th = config.difficultyThresholds;

        if (mainWord.length() <= th.easyMaxMainWordLength && subWordsCount <= th.easyMaxSubWords) {
            return "EASY";
        } else if (mainWord.length() <= th.mediumMaxMainWordLength && subWordsCount <= th.mediumMaxSubWords) {
            return "MEDIUM";
        } else {
            return "HARD";
        }
    }
}