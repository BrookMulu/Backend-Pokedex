package com.example.backend_podedex.repository;

import com.example.backend_podedex.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backend_podedex.model.CapturedPokemon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CapturedPokemonRepository extends JpaRepository<CapturedPokemon, Long> {
    List<CapturedPokemon> findByFirebaseUid(String firebaseUid);

    @Query("SELECT p FROM Pokemon p JOIN CapturedPokemon c ON p.id = c.pokemonId WHERE c.firebaseUid = :firebaseUid")
    List<Pokemon> findCapturedPokemonDetailsByFirebaseUid(@Param("firebaseUid") String firebaseUid);
}
