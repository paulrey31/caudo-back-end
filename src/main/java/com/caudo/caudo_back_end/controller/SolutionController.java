package com.caudo.caudo_back_end.controller;

import com.caudo.caudo_back_end.model.Solution;
import com.caudo.caudo_back_end.repository.SolutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/solutions")
public class SolutionController {

    @Autowired
    private SolutionRepository repository;

    @PostMapping
    public Solution createSolution(@RequestBody Solution solution) {
        return repository.save(solution);
    }

    @PostMapping("/bulk")
    public ResponseEntity<Void> createManySolutions(@RequestBody List<Solution> solutions) {
        repository.saveAll(solutions);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Solution> getAllSolutions() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Solution getSolution(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteSolution(@PathVariable String id) {
        repository.deleteById(id);
    }

    @DeleteMapping
    public void deleteAllSolutions() {
        repository.deleteAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Solution> updateSolution(
            @PathVariable String id,
            @RequestBody Solution updatedSolution) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setSolution(updatedSolution.getSolution());
                    existing.setStatus(updatedSolution.getStatus());
                    repository.save(existing);
                    return ResponseEntity.ok(existing);
                })
                .orElse(ResponseEntity.notFound().build());
    }  
}
