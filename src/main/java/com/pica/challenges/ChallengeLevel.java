package com.pica.challenges;

public enum ChallengeLevel {
    EASY("E"), MEDIUM("M"), HARD("H");

    private final String code;

    ChallengeLevel(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static ChallengeLevel fromCode(String code) {
        for (ChallengeLevel difficulty : ChallengeLevel.values()) {
            if (difficulty.getCode().equals(code)) {
                return difficulty;
            }
        }
        throw new IllegalArgumentException("No enum constant with code " + code);
    }
}
