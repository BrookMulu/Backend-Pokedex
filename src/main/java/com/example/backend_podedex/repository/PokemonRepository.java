package com.example.backend_podedex.repository;

import com.example.backend_podedex.model.Pokemon;
import com.example.backend_podedex.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {

    Page<Pokemon> findAll(Pageable pageable);
    List<Pokemon> findById(int id);
    List<Pokemon> findByName(String name);
    List<Pokemon> findByHeight(int height);
    List<Pokemon> findByWeight(int weight);
    List<Pokemon> findByGenus(String genus);
    @Query("SELECT p FROM Pokemon p JOIN p.types t WHERE t.type = :type")
    List<Pokemon> findByType(String type);
}
