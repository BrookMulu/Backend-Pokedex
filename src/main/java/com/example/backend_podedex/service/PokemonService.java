package com.example.backend_podedex.service;

import com.example.backend_podedex.model.Pokemon;
import com.example.backend_podedex.model.Type;
import com.example.backend_podedex.repository.PokemonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

//@CrossOrigin
@Service
public class PokemonService {
    private final PokemonRepository pokemonRepository;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public Page<Pokemon> filterPokemon(String name, Integer height, Integer weight, String genus, String type, String ability, String eggGroup, Pageable pageable) {
        return pokemonRepository.filterPokemon(name, height, weight, genus, type, ability, eggGroup, pageable );
    }
    public Page<Pokemon> getAllPokemon(Pageable pageable){
        return  pokemonRepository.findAll(pageable);
    }
    public List<Pokemon> findById(int id){
        return pokemonRepository.findById(id);
    }
    public List<Pokemon> findByName(String name){
        return pokemonRepository.findByName(name);
    }
    public List<Pokemon> findByHeight(int height){ return pokemonRepository.findByHeight(height); }
    public List<Pokemon> findByWeight(int weight){return pokemonRepository.findByWeight(weight); }
    public List<Pokemon> findByGenus(String genus){return pokemonRepository.findByGenus(genus); }
    public List<Pokemon> findByType(String type) {return pokemonRepository.findByType(type); }
    public List<Pokemon> findByAbility(String ability) {return pokemonRepository.findByAbility(ability); }
    public List<Pokemon> findByEggGroup(String eggGroup) {return pokemonRepository.findByEggGroup(eggGroup); }
}
