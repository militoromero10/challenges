package com.pica.challenges;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/challenges")
public class ChallengeController {

    private final ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }


    @GetMapping
    public List<ChallengeDto> listarMetas() {
        return challengeService.getChallenges();
    }

    @GetMapping("/level/{cl}")
    public List<ChallengeDto> listarPorNivel(@PathVariable String cl) {
        return challengeService.fetchAllByChallengeLevel(ChallengeLevel.fromCode(cl));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ChallengeDto> obtenerPorNombre(@PathVariable String name) {
        return challengeService.fetchChallengeByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChallengeDto> obtenerMeta(@PathVariable Long id) {
        return challengeService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ChallengeDto crearMeta(@RequestBody ChallengeDto meta) {
        return challengeService.create(meta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChallengeDto> actualizarMeta(@PathVariable Long id, @RequestBody ChallengeDto meta) {
        try {
            return ResponseEntity.ok(challengeService.update(id, meta));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMeta(@PathVariable Long id) {
        challengeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
