# 🎮 Words from Word - Level Generator

## 📌 Project Description
This project is a Java module designed to generate game levels from a provided dictionary of Russian words and a list of main words. The algorithm processes input data, validates it, calculates difficulty levels, and generates a structured JSON output. The program correctly handles letter multiplicities, different cases, and the letter 'Ё'.

## ✨ Features
*   **Smart Letter Counting:** Uses `HashMap` to ensure a subword can only be formed if the main word has enough letters (e.g., if the main word has one 'О', the subword cannot have two).
*   **Dynamic Difficulty:** Levels are assigned `EASY`, `MEDIUM`, or `HARD` based on configurable thresholds (word length and subword count).
*   **Level Skipping:** If a main word does not have enough valid subwords to meet the `minWordsToPass` requirement, the level is automatically skipped.
*   **Clean Output:** Generates a beautifully formatted `output.json` using the Gson library.

## 🛡️ Input Validation & Checks
Before generating levels, the program performs rigorous input checks:
1.  **Normalization:** All words are converted to uppercase and 'Ё' is replaced with 'Е' to avoid duplication.
2.  **Duplicates:** The dictionary is passed through a `HashSet` to remove duplicate words.
3.  **Length Filtering:** Words shorter than `minSubWordLength` are ignored.
4.  **Self-Exclusion:** The main word is excluded from the list of subwords.
5.  **Letter Multiplicity:** A strict check ensures the subword uses no more letters than are available in the main word.

## 🛠️ Technologies Used
*   **Language:** Java 17
*   **Libraries:** Gson (JSON Serialization)
*   **Core APIs:** Java Collections Framework (`HashMap`, `HashSet`, `ArrayList`), Java Stream API
*   **Build System:** Maven

## 📂 Project Structure
*   `Main.java` — Entry point, setup of input data, and file generation.
*   `Config.java` — Configuration class with thresholds and minimum lengths.
*   `LevelGenerator.java` — Core logic (filtering, counting, calculating difficulty).
*   `Level.java` — Data model for a level.
*   `SubWord.java` — Data model for a subword.

## ⚙️ Algorithm Overview
1.  **Initialization:** Read dictionary and main words.
2.  **Filtering:** For each main word, iterate through the dictionary.
3.  **Validation:** Check length, check letter multiplicity using the `canBeFormed` method.
4.  **Difficulty Calculation:** If enough subwords are found, calculate difficulty based on `Config` thresholds.
5.  **Serialization:** Save the final list of levels to `output.json` using Gson.

---

## 📸 Detailed Project Screenshots

### 1. Project Structure & Dependencies
*Overview of the classes and Maven Gson dependency.*
<img width="449" height="570" alt="{BCE7B742-1066-4310-B220-FB6B2A9A9AC3}" src="https://github.com/user-attachments/assets/bda259cd-7f6f-4286-bfde-73d5422105c1" />

<img width="933" height="516" alt="{6725AE58-F8AB-45B4-B99E-4FE76C247651}" src="https://github.com/user-attachments/assets/bcb48b6f-d5b2-4cd4-aa5a-d43d9e0fb8fe" />


### 2. Input Data Configuration
*Setup of the dictionary and main words in Main.java.*
<img width="1183" height="70" alt="{C2DF88F0-8669-4185-ADF8-C5641DA16692}" src="https://github.com/user-attachments/assets/bbaa5947-a96b-45e9-ba64-cf5143571b25" />


### 3. Core Algorithm Implementation
*Normalization and filtering logic in LevelGenerator.*
<img width="1001" height="447" alt="{0E598A77-C48A-43EF-A5BD-97E3927CB588}" src="https://github.com/user-attachments/assets/8629effb-9a58-4925-a310-6c80f9c7f844" />


*The `canBeFormed` method checking letter multiplicities using HashMap.*
<img width="722" height="152" alt="{9E610BB7-0440-48BC-9458-CEC7DCE5C11D}" src="https://github.com/user-attachments/assets/9c5e5462-bf97-4480-b76e-311fb34b311c" />


*The `calculateDifficulty` method determining EASY, MEDIUM, or HARD.*
<img width="918" height="284" alt="{A26FF9D4-A831-4CDE-B1C1-04812503D066}" src="https://github.com/user-attachments/assets/6a01cec5-d2d9-46e9-9f79-df9eed017207" />


### 4. Execution & Output
*Console showing successful execution and JSON generation.*
<img width="482" height="148" alt="{BAB6C1E4-10E6-4359-962E-6AD92B8F995D}" src="https://github.com/user-attachments/assets/2f13caba-ea10-43be-b78c-f43a135e91e3" />


*The final generated `output.json` file.*
<img width="1431" height="871" alt="{AB8BAEE1-52A0-410A-8B12-E73F056FDED4}" src="https://github.com/user-attachments/assets/3937202b-9c74-4f57-8fe0-afe1de98c45f" />


### 5. Edge Cases Testing
*Testing with repeated letters ("МОЛОКО") and insufficient subwords ("ЁЖИК").*
<img width="974" height="523" alt="image" src="https://github.com/user-attachments/assets/01073fbc-a7e0-4b6f-b1ca-2a3c9d8b4e4b" />


---

## 👥 Team & Responsibilities
*   **Anna Feklistova** - [GitHub Profile](https://github.com/annnnnnssssssss)
    *   **Role:** Backend Developer / Algorithm Design
    *   **Responsibilities:** Developed the core logic (`LevelGenerator`), implemented letter multiplicity checks using `HashMap`, configured difficulty calculations, and set up JSON serialization using Gson.
*   **Victoria Biryukova** - [GitHub Profile](https://github.com/Виктория_ссылка)
    *   **Role:** QA Engineer / Documentation
    *   **Responsibilities:** Conducted edge-case testing (repeated letters, min length limits), verified the JSON output structure against
