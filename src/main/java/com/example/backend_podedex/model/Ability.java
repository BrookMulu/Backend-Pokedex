package com.example.backend_podedex.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ability")
public class Ability {
    @Id
    @Column(name = "ability_id")
    public int abilityId;
    @Column(name = "ability")
    public String ability;
    public int getAbilityId() {
        return abilityId;
    }
    public void setAbilityId(int abilityId) {
        this.abilityId = abilityId;
    }
    public String getAbility() {
        return ability;
    }
    public void setAbility(String ability) {
        this.ability = ability;
    }
}
