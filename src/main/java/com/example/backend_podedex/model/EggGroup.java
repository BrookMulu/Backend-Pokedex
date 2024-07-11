package com.example.backend_podedex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "egg_group")
public class EggGroup {
    @Id
    @Column(name = "egg_group_id")
    public int egg_group_id;
    @Column(name = "egg_group")
    public String egg_group;
    @JsonIgnore
    @ManyToMany(mappedBy = "egg_groups")
    public List<Pokemon> egg_groups;

    public int getEgg_group_id() {
        return egg_group_id;
    }
    public void setEgg_group_id(int egg_group_id) {
        this.egg_group_id = egg_group_id;
    }

    public String getEgg_group() {
        return egg_group;
    }

    public void setEgg_group(String egg_group) {
        this.egg_group = egg_group;
    }
    public List<Pokemon> getEgg_groups() {
        return egg_groups;
    }
    public void setEgg_groups(List<Pokemon> egg_groups) {
        this.egg_groups = egg_groups;
    }
}
