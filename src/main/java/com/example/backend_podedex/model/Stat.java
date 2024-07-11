package com.example.backend_podedex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "stat")
public class Stat {
    @JsonIgnore
    @Id
    @Column(name  = "pokemon_id")
    public int pokemon_id;
    @Column(name = "hp")
    public int hp;
    @Column(name = "speed")
    public int speed;
    @Column(name = "attack")
    public int attack;
    @Column(name = "defense")
    public int defense;
    @Column(name = "special_attack")
    public int special_attack;
    @Column(name = "special_defense")
    public int special_defense;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name="pokemon_id")
    public Pokemon pokemon;
    public int getPokemon_id() {
        return pokemon_id;
    }

    public void setPokemon_id(int pokemon_id) {
        this.pokemon_id = pokemon_id;
    }

    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getAttack() {
        return attack;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }
    public int getDefense() {
        return defense;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }
    public int getSpecial_attack() {
        return special_attack;
    }
    public void setSpecial_attack(int special_attack) {
        this.special_attack = special_attack;
    }
    public int getSpecial_defense() {
        return special_defense;
    }
    public void setSpecial_defense(int special_defense) {
        this.special_defense = special_defense;
    }
    public Pokemon getPokemon() {
        return pokemon;
    }
    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }
}
