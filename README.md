# Words from Word - Level Generator :)

## Project Description

Words from Word - Level Generator is a Java module that automatically creates game levels from a provided dictionary of Russian words and a list of main words. The program normalizes and validates input data, selects valid subwords considering letter multiplicities, calculates the difficulty level, and saves the structured result to a JSON file.

## Features

- Automatically loading a dictionary and a list of main words.
- Normalizing all words to uppercase and replacing the letter `Ё` with `Е`.
- Removing duplicate words from the dictionary using `HashSet`.
- Checking letter multiplicities using `HashMap` so a subword cannot use more identical letters than the main word contains.
- Filtering out words shorter than the configured minimum length and excluding the main word itself.
- Skipping levels automatically if the number of found subwords is lower than `minWordsToPass`.
- Calculating level difficulty (`EASY`, `MEDIUM`, or `HARD`) based on configurable thresholds.
- Generating a formatted `output.json` file using the Gson library.

## Input Validation

The program includes input validation and edge-case checks to ensure correct level generation:

- Different letter cases are normalized to uppercase before comparison.
- The letter `Ё` is automatically replaced with `Е` to prevent duplicates.
- Duplicate words in the dictionary are removed automatically.
- Subwords shorter than `minSubWordLength` are ignored.
- The main word is excluded from its own list of subwords.
- Repeated letters are strictly checked (for example, in words like `"МОЛОКО"`, a subword cannot use more letters than available).
- Main words with too few valid subwords (for example, `"ЁЖИК"`) are skipped instead of creating invalid levels.

<img width="1001" height="447" alt="{0E598A77-C48A-43EF-A5BD-97E3927CB588}" src="https://github.com/user-attachments/assets/8629effb-9a58-4925-a310-6c80f9c7f844" />
<img width="722" height="152" alt="{9E610BB7-0440-48BC-9458-CEC7DCE5C11D}" src="https://github.com/user-attachments/assets/9c5e5462-bf97-4480-b76e-311fb34b311c" />
<img width="974" height="523" alt="image" src="https://github.com/user-attachments/assets/01073fbc-a7e0-4b6f-b1ca-2a3c9d8b4e4b" />

## Technologies Used

- Java 17
- Maven
- IntelliJ IDEA
- Gson (JSON Serialization)
- Java Collections Framework (`HashMap`, `HashSet`, `ArrayList`)
- Java Stream API

## Project Structure

```text
WordsFromWord/
│
├── src/
│   └── main/
│       └── java/
│           └── org/
│               └── example/
│                   ├── Main.java
│                   ├── Config.java
│                   ├── LevelGenerator.java
│                   ├── Level.java
│                   └── SubWord.java
│
├── pom.xml
└── output.json
```

The `pom.xml` file configures the Maven project and Gson dependency, and the generated `output.json` file is saved in the project root directory.

## Division of Work

### Anna Feklistova

- Setting up the Maven project and configuring the Gson dependency in `pom.xml`.
- Creating the data model classes (`Level`, `SubWord`) and `Config` class.
- Implementing the core logic in `LevelGenerator`.
- Implementing the `canBeFormed()` method to check letter multiplicities using `HashMap`.
- Implementing the `calculateDifficulty()` method to assign `EASY`, `MEDIUM`, or `HARD` difficulty.
- Setting up JSON serialization to `output.json` in `Main.java`.

### Victoria Biryukova

- Preparing test dictionaries, main word lists, and input configurations in `Main.java`.
- Testing input normalization (letter case handling and replacing `Ё` with `Е`) and duplicate removal.
- Conducting edge-case testing with repeated letters (`"МОЛОКО"`) and insufficient subwords (`"ЁЖИК"`).
- Verifying minimum word length filtering and self-exclusion of main words.
- Checking the final generated `output.json` structure and console output.
- Preparing project documentation and screenshots.

## How to Run the Program

1. Clone the repository and open the project in IntelliJ IDEA.
2. Wait for Maven to load the project and
715777210-8629effb-9a58-4925-a310-6c80f9c7f844.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAVCODYLSA53PQK4ZA%2F20261126%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20261126T153855Z&X-Amz-Expires=300&X-Amz-Signature=f6fa0d480fd45ce32ef3790dfcaec
github-production-user-asset-6210df.s3.amazonaws.com




download the Gson dependency from `pom.xml`.
3. Open `src/main/java/org/example/Main.java`.
4. Check or adjust the dictionary, main words, and configuration parameters in `Config.java` if needed.
5. Run the `main()` method in `Main.java`.
6. Check the console output for successful execution and open the generated `output.json` file in the project root directory.

<img width="449" height="570" alt="{BCE7B742-1066-4310-B220-FB6B2A9A9AC3}" src="https://github.com/user-attachments/assets/bda259cd-7f6f-4286-bfde-73d5422105c1" />
<img width="933" height="516" alt="{6725AE58-F8AB-45B4-B99E-4FE76C247651}" src="https://github.com/user-attachments/assets/bcb48b6f-d5b2-4cd4-aa5a-d43d9e0fb8fe" />
<img width="1183" height="70" alt="{C2DF88F0-8669-4185-ADF8-C5641DA16692}" src="https://github.com/user-attachments/assets/bbaa5947-a96b-45e9-ba64-cf5143571b25" />
<img width="918" height="284" alt="{A26FF9D4-A831-4CDE-B1C1-04812503D066}" src="https://github.com/user-attachments/assets/6a01cec5-d2d9-46e9-9f79-df9eed017207" />
<img width="482" height="148" alt="{BAB6C1E4-10E6-4359-962E-6AD92B8F995D}" src="https://github.com/user-attachments/assets/2f13caba-ea10-43be-b78c-f43a135e91e3" />
<img width="1431" height="871" alt="{AB8BAEE1-52A0-410A-8B12-E73F056FDED4}" src="https://github.com/user-attachments/assets/3937202b-9c74-4f57-8fe0-afe1de98c45f" />

## Algorithm

1. The program loads the dictionary, main words, and configuration thresholds from `Config`.
2. All words are normalized to uppercase, `Ё` is replaced with `Е`, and duplicates are removed with `HashSet`.
3. For each main word, the program iterates through the cleaned dictionary.
4. Words shorter than `minSubWordLength` and the main word itself are skipped.
5. The `canBeFormed()` method counts letter frequencies with `HashMap` to verify that each candidate subword can be built from the main word.
6. If the number of valid subwords meets `minWordsToPass`, `calculateDifficulty()` assigns `EASY`, `MEDIUM`, or `HARD`; otherwise, the level is skipped.
7. All generated levels are serialized into a formatted `output.json` file using Gson.

## Conclusion

The project is a Java application for automatically generating game levels for the "Words from Word" puzzle. It uses Maven and Gson for JSON serialization, Java Collections (`HashMap`, `HashSet`, `ArrayList`) for word normalization and letter-multiplicity validation, and configurable thresholds for difficulty calculation. The work was divided between two team members, covering both core algorithm development and testing with documentation.
