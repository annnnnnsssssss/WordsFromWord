# Words from Word Generator

A Java module that generates game levels from a dictionary and a list of main words.

## Tech Stack
- Java
- Gson (for JSON serialization)
- Maven

## Task Description
The program takes a dictionary of Russian words and a list of main words. It generates a JSON structure containing levels. Each level has a main word, a set of subwords, difficulty, and the minimum number of subwords required to pass. Words are filtered based on a config file (minimum length, letter multiplicity, etc.).

## Input Example
**Dictionary:** `["десант", "адрес", "армия", "место", "метро", "демон"]`
**Main Words:** `["ДЕМОНСТРАЦИЯ", "ВЗАИМНОСТЬ"]`

## Output Example
```json
{
  "levels": [
    {
      "id": 1,
      "mainWord": "ДЕМОНСТРАЦИЯ",
      "difficulty": "HARD",
      "minWordsToPass": 2,
      "subWords": [
        { "text": "АДРЕС", "hint": "" },
        { "text": "АРМИЯ", "hint": "" }
      ]
    }
  ]
}
