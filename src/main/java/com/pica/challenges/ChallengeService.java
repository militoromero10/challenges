package com.pica.challenges;

import java.util.List;
import java.util.Optional;

public interface ChallengeService {
    List<ChallengeDto> getChallenges();
    Optional<ChallengeDto> getById(Long id);
    ChallengeDto create(ChallengeDto challengeDto);
    ChallengeDto update(Long id, ChallengeDto challengeDto);
    void delete(Long id);
    Optional<ChallengeDto> fetchChallengeByName(String name);
    List<ChallengeDto> fetchAllByChallengeLevel(ChallengeLevel cl);
}
