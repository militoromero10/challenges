package com.pica.challenges;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;

@Converter(autoApply = true)
public class LevelConverter implements AttributeConverter<ChallengeLevel, String> {

    @Override
    public String convertToDatabaseColumn(ChallengeLevel challengeLevel) {
        return Arrays.stream(ChallengeLevel.values())
                .filter(s -> s == challengeLevel)
                .map(ChallengeLevel::getCode)
                .findFirst().orElseThrow(() -> new IllegalArgumentException("No level found"));
    }

    @Override
    public ChallengeLevel convertToEntityAttribute(String code) {
        return Arrays.stream(ChallengeLevel.values())
                .filter(s -> s.getCode().equalsIgnoreCase(code))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("No level found"));
    }
}