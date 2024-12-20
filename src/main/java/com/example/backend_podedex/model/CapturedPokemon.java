package com.example.backend_podedex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "captured_pokemon")
public class CapturedPokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    @Column(name = "pokemon_id")
    public int pokemonId;

    @Column(name = "firebase_uid")
    public String firebaseUid;

    @Column(name = "capture_time")
    public LocalDateTime captureTime;

    public CapturedPokemon() {

    }

    public CapturedPokemon(int id, int pokemonId, String firebaseUid, LocalDateTime captureTime){
        this.id = id;
        this.pokemonId = pokemonId;
        this.firebaseUid = firebaseUid;
        this.captureTime = captureTime;
    }


    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(int pokemonId) {
        this.pokemonId = pokemonId;
    }

    public String getFirebaseUid() {
        return firebaseUid;
    }

    public void setFirebaseUid(String firebaseUid) {
        this.firebaseUid = firebaseUid;
    }

    public LocalDateTime getCaptureTime() {
        return captureTime;
    }

    public void setCaptureTime(LocalDateTime captureTime) {
        this.captureTime = captureTime;
    }
}
