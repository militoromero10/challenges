package com.pica.challenges;

import java.util.UUID;

public record ChallengeDto (Long id, String name, UUID externalId, ChallengeLevel challengeLevel, String description){}
