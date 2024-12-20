package com.example.backend_podedex.controller;

import com.example.backend_podedex.model.Pokemon;
import com.example.backend_podedex.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {
    public final PokemonService pokemonService;
    @Autowired
    public PokemonController(PokemonService pokemonService){
        this.pokemonService = pokemonService;
    }
    @GetMapping("/all")
    public ResponseEntity<Page<Pokemon>> getAllPokemon(@RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue = "10")int size){
        Page<Pokemon> pokemons = pokemonService.getAllPokemon(PageRequest.of(page,size));
        return  ResponseEntity.ok(pokemons);
    }
    @GetMapping("/filter")
    public ResponseEntity<Page<Pokemon>> filterPokemon(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer height,
            @RequestParam(required = false) Integer weight,
            @RequestParam(required = false) String genus,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String ability,
            @RequestParam(required = false) String eggGroup,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            Pageable pageable = PageRequest.of(page, size);
            Page<Pokemon> pokemons = pokemonService.filterPokemon(name, height, weight, genus, type, ability, eggGroup, pageable);
            if (pokemons.isEmpty()) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(pokemons);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    //Test api's
    @GetMapping("/findByID/{id}")
    public ResponseEntity<List<Pokemon>> getByID(@PathVariable int id){
        try {
            if(pokemonService.findById(id)!= null) {
                return ResponseEntity.ok(pokemonService.findById(id));
            }
            else{
                return ResponseEntity.notFound().build();
            }
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/findByName")
    public ResponseEntity<List<Pokemon>> getByName(@RequestParam(required = false) String name){
        try{
            if(pokemonService.findByName(name)!=null){
                return ResponseEntity.ok(pokemonService.findByName(name));
            }
            else{
                return ResponseEntity.notFound().build();
            }
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping("/findByHeight")
    public ResponseEntity<List<Pokemon>> getByHeight(@RequestParam(required = false) int height){
        try{
            if(pokemonService.findByHeight(height)!=null){
                return ResponseEntity.ok(pokemonService.findByHeight(height));
            }
            else{
                return ResponseEntity.notFound().build();
            }
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping("/findByWeight")
    public ResponseEntity<List<Pokemon>> getByWeight(@RequestParam(required = false) int weight){
        try{
            if(pokemonService.findByWeight(weight)!=null){
                return ResponseEntity.ok(pokemonService.findByWeight(weight));
            }
            else{
                return ResponseEntity.notFound().build();
            }
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping("/findByGenus")
    public ResponseEntity<List<Pokemon>> getByGenus(@RequestParam(required = false) String genus) {
        try {
            if (pokemonService.findByGenus(genus) != null) {
                return ResponseEntity.ok(pokemonService.findByGenus(genus));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping("/findByType")
    public ResponseEntity<List<Pokemon>> getByType(@RequestParam(required = false) String type){
        try{
            if(pokemonService.findByType(type)!=null){
                return ResponseEntity.ok(pokemonService.findByType(type));
            }
            else{
                return ResponseEntity.notFound().build();
            }
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping("/findByAbility")
    public ResponseEntity<List<Pokemon>> getByAbility(@RequestParam(required = false) String ability){
        try{
            if(pokemonService.findByAbility(ability)!=null){
                return ResponseEntity.ok(pokemonService.findByAbility(ability));
            }
            else{
                return ResponseEntity.notFound().build();
            }
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping("/findByEggGroup")
    public ResponseEntity<List<Pokemon>> getByEggGroup(@RequestParam(required = false) String eggGroup){
        try{
            if(pokemonService.findByEggGroup(eggGroup)!=null){
                return ResponseEntity.ok(pokemonService.findByEggGroup(eggGroup));
            }
            else{
                return ResponseEntity.notFound().build();
            }
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
