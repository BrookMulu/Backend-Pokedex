package com.example.backend_podedex.controller;

import com.example.backend_podedex.model.CapturedPokemon;
import com.example.backend_podedex.model.Pokemon;
import com.example.backend_podedex.service.CapturedPokemonService;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/capture")
public class CapturedPokemonController {

    @Autowired
    private CapturedPokemonService capturedPokemonService;

    @PostMapping
    public ResponseEntity<CapturedPokemon> capturePokemon(
            @RequestParam int pokemonId,
            @RequestHeader("Authorization") String token
    ) {
        try {
            String firebaseUid = FirebaseAuth.getInstance().verifyIdToken(token.replace("Bearer ", "")).getUid();

            CapturedPokemon capturedPokemon = capturedPokemonService.capturePokemon(pokemonId, firebaseUid);
            return ResponseEntity.ok(capturedPokemon);
        } catch (FirebaseAuthException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    @GetMapping
    public ResponseEntity<List<Pokemon>> getCapturedPokemons(@RequestHeader("Authorization") String token) {
        try {
            String firebaseUid = FirebaseAuth.getInstance().verifyIdToken(token.replace("Bearer ", "")).getUid();

            List<Pokemon> capturedPokemonDetails = capturedPokemonService.getCapturedPokemonDetails(firebaseUid);
            return ResponseEntity.ok(capturedPokemonDetails);
        } catch (FirebaseAuthException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
