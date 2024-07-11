package com.example.backend_podedex.controller;

import com.example.backend_podedex.model.Pokemon;
import com.example.backend_podedex.model.Type;
import com.example.backend_podedex.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000/pokemons")
public class PokemonController {
    public final PokemonService pokemonService;
    @Autowired
    public PokemonController(PokemonService pokemonService){
        this.pokemonService = pokemonService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/pokemon")
    public ResponseEntity<Page<Pokemon>> getAllPokemon(@RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue = "10")int size){
        Page<Pokemon> pokemons = pokemonService.getAllPokemon(PageRequest.of(page,size));
        return  ResponseEntity.ok(pokemons);
    }

    @GetMapping("/pokemon/{id}")
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
    //@CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/pokemon/findByName")
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
    @GetMapping("/pokemon/findByHeight")
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
    @GetMapping("/pokemon/findByWeight")
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
    @GetMapping("/pokemon/findByGenus")
    public ResponseEntity<List<Pokemon>> getByGenus(String genus) {
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
    @GetMapping("/pokemon/byType/{type}")
    public ResponseEntity<List<Pokemon>> getByType(@RequestParam(required=false) String type){
        List<Pokemon> pokemons = pokemonService.findByType(type);
        if(!pokemons.isEmpty()){
            return ResponseEntity.ok(pokemons);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
