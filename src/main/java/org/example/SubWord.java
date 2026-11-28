package org.example;

public class SubWord {
public String text;
public String hint;

public SubWord(String text) {
    this.text = text;
    
    // Генерируем подсказку: первая буква видна, остальные скрыты звездочками
    if (text != null && text.length() > 1) {
        StringBuilder sb = new StringBuilder();
        sb.append(text.charAt(0)); // Берем первую букву
        
        // Цикл добавляет звездочки для остальных букв
        for (int i = 1; i < text.length(); i++) {
            sb.append("*"); 
        }
        
        this.hint = sb.toString();
    } else {
        this.hint = text; // Если слово из одной буквы
    }
}
}
