package com.pica.challenges;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChallengeServiceImpl implements ChallengeService {
    private final ChallengeRepository challengeRepository;
    private final Mapper<Challenge, ChallengeDto> challengeMapper;

    public ChallengeServiceImpl(ChallengeRepository challengeRepository, Mapper<Challenge, ChallengeDto> challengeMapper) {
        this.challengeRepository = challengeRepository;
        this.challengeMapper = challengeMapper;
    }

    @Override
    public Optional<ChallengeDto> fetchChallengeByName(String name) {
        return challengeRepository.getChallengeByName(name)
                .map(challengeMapper::toDto);
    }

    @Override
    public List<ChallengeDto> fetchAllByChallengeLevel(ChallengeLevel cl) {
        return challengeRepository.getAllByChallengeLevel(cl)
                .stream()
                .map(challengeMapper::toDto)
                .toList();
    }

    public List<ChallengeDto> getChallenges() {
        return challengeRepository.findAll()
                .stream()
                .map(challengeMapper::toDto)
                .toList();

    }

    public Optional<ChallengeDto> getById(Long id) {
        return challengeRepository.findById(id).map(challengeMapper::toDto);
    }

    public ChallengeDto create(ChallengeDto challengeDto) {
        Challenge toSave = challengeMapper.toEntity(challengeDto);
        toSave.setExternalId(UUID.randomUUID());
        challengeRepository.save(toSave);
        return challengeDto;
    }

    public ChallengeDto update(Long id, ChallengeDto challengeDto) {
        return challengeRepository.findById(id)
                .map(challenge -> {
                    challenge.setName(challengeDto.name());
                    challenge.setDescription(challengeDto.description());
                    challenge.setChallengeLevel(challengeDto.challengeLevel());
                    return challengeMapper.toDto(challengeRepository.save(challenge));
                }).orElseThrow(() -> new RuntimeException("Challenge not found"));
    }

    public void delete(Long id) {
        challengeRepository.deleteById(id);
    }
}
