package com.project.fruits_legumes.controllers;

import com.project.fruits_legumes.models.Legume;
import com.project.fruits_legumes.services.LegumeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/legumes")
public class LegumeController {
    @Autowired
    private LegumeService legumeService;


    @Operation(summary = "Get all legumes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of legumes retrieved successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Legume.class)) })
    })
    @GetMapping("/")
    public List<Legume> getAllLegumes() {
        return legumeService.getAllLegumes();
    }

    @Operation(summary = "Add a legume")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Legume added successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Legume.class)) })
    })
    @PostMapping("/")
    public ResponseEntity<Legume> addLegume(@RequestBody Legume legume) {
        Legume savedLegume = legumeService.addLegume(legume);
        return new ResponseEntity<>(savedLegume, HttpStatus.CREATED);
    }


    @Operation(summary = "Get a legume by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Legume retrieved successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Legume.class)) }),
            @ApiResponse(responseCode = "404", description = "Legume not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Legume> getLegumeById(@PathVariable Long id) {
        Optional<Legume> optionalLegume = legumeService.getLegumeById(id);
        return optionalLegume.map(legume -> new ResponseEntity<>(legume, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Delete a legume by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Legume deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Legume not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLegumeById(@PathVariable Long id) {
        if (legumeService.existsById(id)) {
            legumeService.deleteLegumeById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
