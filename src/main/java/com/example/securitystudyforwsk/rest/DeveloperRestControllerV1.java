package com.example.securitystudyforwsk.rest;

import com.example.securitystudyforwsk.model.Developer;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperRestControllerV1 {
    private List<Developer> DEVELOPERS = Stream.of(
            new Developer(1L, "Ivan", "Ivanov"),
            new Developer(2L, "Sergey", "Sergeev"),
            new Developer(3L, "Petr", "Petrov")
    ).collect(Collectors.toList());

    @GetMapping
    public List<Developer> getAll() {
        return DEVELOPERS;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('user','admin')")
    public Developer getById(@PathVariable Long id) {
        return DEVELOPERS.stream().filter(developer -> developer.getId().equals(id)).findFirst().orElse(null);
    }

    @PostMapping
    @PreAuthorize("hasRole('admin')")
    public Developer create(@RequestBody Developer developer){
        this.DEVELOPERS.add(developer);
        return developer;
    }

    @DeleteMapping
    @PreAuthorize("hasRole('admin')")
    public void deleteById (Long id){
        this.DEVELOPERS.removeIf(developer -> developer.getId().equals(id));
    }

}