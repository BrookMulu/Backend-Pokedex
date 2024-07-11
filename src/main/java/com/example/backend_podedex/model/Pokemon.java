package com.example.backend_podedex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pokemon")
public class Pokemon {

    @Id
    @Column(name = "id")
    public int id;
    @Column(name = "name")
    public String name;
    //@JsonIgnore
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "pokemon_type",
            joinColumns = @JoinColumn(name = "pokemon_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id")
    )
    public List<Type> types;
    @Column(name = "height")
    public int height;
    @Column(name = "weight")
    public int weight;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "pokemon_ability",
            joinColumns = @JoinColumn(name = "pokemon_id"),
            inverseJoinColumns = @JoinColumn(name = "ability_id")
    )
    public List<Ability> abilities;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "pokemon_egg_group",
            joinColumns = @JoinColumn(name = "pokemon_id"),
            inverseJoinColumns = @JoinColumn(name = "egg_group_id")
    )
    public List<EggGroup> egg_groups;
    @Column(name = "genus")
    public String genus;
    @Column(name = "description")
    public String description;
    @OneToOne(mappedBy = "pokemon")
    public Stat stat;

    public Pokemon(){}

    public Pokemon(int id, String name, int height, int weight, String genus, String description){
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.genus = genus;
        this.description = description;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    @JsonIgnore
    @JsonManagedReference
    public List<Type> getType() {
        return types;
    }
    public void setType(List<Type> types) {
        this.types = types;
    }

    public int getHeight(){
        return height;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public int getWeight(){
        return weight;
    }
    public void setWeight(int weight){
        this.weight = weight;
    }
    @JsonManagedReference
    public List<Ability> getAbilities() {
        return abilities;
    }
    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }
    @JsonManagedReference
    public List<EggGroup> getEgg_groups() {
        return egg_groups;
    }
    public void setEgg_groups(List<EggGroup> egg_groups) {
        this.egg_groups = egg_groups;
    }
    public String getGenus(){
        return genus;
    }
    public void setGenus(String genus){
        this.genus = genus;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public Stat getStat() {
        return stat;
    }
    public void setStat(Stat stat) {
        this.stat = stat;
    }
}
