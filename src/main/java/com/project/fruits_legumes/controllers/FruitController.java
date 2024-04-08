package com.project.fruits_legumes.controllers;

import com.project.fruits_legumes.models.Fruit;
import com.project.fruits_legumes.services.FruitService;
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
@RequestMapping("/api/fruits")
public class FruitController {

    @Autowired
    private FruitService fruitService;

    @Operation(summary = "Get all fruits")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of fruits retrieved successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Fruit.class)) })
    })
    @GetMapping("/")
    public List<Fruit> getAllFruits() {
        return fruitService.getAllFruits();
    }

    @Operation(summary = "Add a fruit")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Fruit added successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Fruit.class)) })
    })
    @PostMapping("/")
    public ResponseEntity<Fruit> addFruit(@RequestBody Fruit fruit) {
        Fruit savedFruit = fruitService.addFruit(fruit);
        return new ResponseEntity<>(savedFruit, HttpStatus.CREATED);
    }

    @Operation(summary = "Get a fruit by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fruit retrieved successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Fruit.class)) }),
            @ApiResponse(responseCode = "404", description = "Fruit not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Fruit> getFruitById(@PathVariable Long id) {
        Optional<Fruit> optionalFruit = fruitService.getFruitById(id);
        return optionalFruit.map(fruit -> new ResponseEntity<>(fruit, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Delete a fruit by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Fruit deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Fruit not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFruitById(@PathVariable Long id) {
        if (fruitService.existsById(id)) {
            fruitService.deleteFruitById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
