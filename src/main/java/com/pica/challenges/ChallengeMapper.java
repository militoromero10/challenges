package com.pica.challenges;

import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class ChallengeMapper implements Mapper<Challenge, ChallengeDto> {

    @Override
    public Challenge toEntity(ChallengeDto challengeDto) {
        Challenge challenge = new Challenge();
        challenge.setExternalId(challengeDto.externalId());
        challenge.setName(challengeDto.name());
        challenge.setDescription(challengeDto.description());
        challenge.setChallengeLevel(challengeDto.challengeLevel());
        return challenge;
    }

    @Override
    public ChallengeDto toDto(Challenge challenge) {
        if(isNull(challenge.getId())) throw new IllegalArgumentException("Could not map entity");
        return new ChallengeDto(challenge.getId(), challenge.getName(), challenge.getExternalId(), challenge.getChallengeLevel(), challenge.getDescription());
    }
}
