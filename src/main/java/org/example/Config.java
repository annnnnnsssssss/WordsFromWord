package org.example;

import com.google.gson.annotations.SerializedName;

public class Config {
    @SerializedName("minSubWordLength")
    public int minSubWordLength;

    @SerializedName("minWordsToPass")
    public int minWordsToPass;

    @SerializedName("difficultyThresholds")
    public DifficultyThresholds difficultyThresholds;

    public static class DifficultyThresholds {
        public int easyMaxMainWordLength;
        public int mediumMaxMainWordLength;
        public int easyMaxSubWords;
        public int mediumMaxSubWords;
    }
}