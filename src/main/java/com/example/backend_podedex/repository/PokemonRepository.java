package com.example.backend_podedex.repository;

import com.example.backend_podedex.model.Pokemon;
import com.example.backend_podedex.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {

    @Query("SELECT p FROM Pokemon p " +
            "WHERE (:name IS NULL OR p.name = :name) " +
            "AND (:height IS NULL OR p.height = :height) " +
            "AND (:weight IS NULL OR p.weight = :weight) " +
            "AND (:genus IS NULL OR p.genus = :genus) " +
            "AND (:type IS NULL OR EXISTS (SELECT t FROM p.types t WHERE t.type = :type)) " +
            "AND (:ability IS NULL OR EXISTS (SELECT a FROM p.abilities a WHERE a.ability = :ability)) " +
            "AND (:eggGroup IS NULL OR EXISTS (SELECT e FROM p.egg_groups e WHERE e.egg_group = :eggGroup))")
    Page<Pokemon> filterPokemon(@Param("name") String name,
                                @Param("height") Integer height,
                                @Param("weight") Integer weight,
                                @Param("genus") String genus,
                                @Param("type") String type,
                                @Param("ability") String ability,
                                @Param("eggGroup") String eggGroup,
                                Pageable pageable);

    Page<Pokemon> findAll(Pageable pageable);
    List<Pokemon> findById(int id);
    @Query("SELECT p FROM Pokemon p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Pokemon> findByName(@Param("name") String name);
    List<Pokemon> findByHeight(int height);
    List<Pokemon> findByWeight(int weight);
    List<Pokemon> findByGenus(String genus);
    @Query("SELECT p FROM Pokemon p JOIN p.types t WHERE t.type = :type")
    List<Pokemon> findByType(String type);

    @Query("SELECT p FROM Pokemon p JOIN p.abilities a WHERE a.ability = :ability")
    List<Pokemon> findByAbility(String ability);
    @Query("SELECT p FROM Pokemon p JOIN p.egg_groups e WHERE e.egg_group = :eggGroup")
    List<Pokemon> findByEggGroup(String eggGroup);
}
