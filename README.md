# Words from Word Generator 🎮

A Java module that generates game levels from a dictionary and a list of main words. The program calculates difficulty and filters subwords based on specific rules.

## 🛠 Tech Stack
*   **Language:** Java (JDK 17+)
*   **Libraries:** Gson (for JSON serialization)
*   **Collections:** Java Collections Framework, Stream API
*   **Build Tool:** Maven

## 🧠 How it works
The program takes a dictionary and a list of main words. For each main word, it finds valid subwords. A subword is valid if:
1. Its length is not less than `minSubWordLength`.
2. It can be formed from the letters of the main word (considering letter multiplicity).
3. It is not a duplicate.
4. The main word itself is not included in the subwords list.

Based on the number of found subwords and the length of the main word, the program calculates the difficulty (`EASY`, `MEDIUM`, `HARD`). If there are not enough subwords to pass the level (`minWordsToPass`), the level is skipped.

## 📥 Input Example
```java
Dictionary: ["десант", "адрес", "армия", "место", "метро", "демон"]
Main Words: ["ДЕМОНСТРАЦИЯ", "ВЗАИМНОСТЬ"]
