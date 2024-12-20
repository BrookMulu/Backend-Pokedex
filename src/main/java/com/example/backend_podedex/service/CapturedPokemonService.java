package com.example.backend_podedex.service;

import com.example.backend_podedex.model.CapturedPokemon;
import com.example.backend_podedex.model.Pokemon;
import com.example.backend_podedex.repository.CapturedPokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CapturedPokemonService {

    @Autowired
    private CapturedPokemonRepository capturedPokemonRepository;

    public CapturedPokemon capturePokemon(int pokemonId, String firebaseUid) {
        CapturedPokemon capturedPokemon = new CapturedPokemon();
        capturedPokemon.setPokemonId(pokemonId);
        capturedPokemon.setFirebaseUid(firebaseUid);
        capturedPokemon.setCaptureTime(LocalDateTime.now());
        return capturedPokemonRepository.save(capturedPokemon);
    }

    public List<Pokemon> getCapturedPokemonDetails(String firebaseUid) {
        return capturedPokemonRepository.findCapturedPokemonDetailsByFirebaseUid(firebaseUid);
    }
}

