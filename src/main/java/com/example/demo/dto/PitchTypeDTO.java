package com.example.demo.dto;

import javax.persistence.*;

public class PitchTypeDTO {
    private Long id;
    private Long id_owner;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_owner() {
        return id_owner;
    }

    public void setId_owner(Long id_owner) {
        this.id_owner = id_owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PitchTypeDTO{" +
                "id=" + id +
                ", id_owner=" + id_owner +
                ", name='" + name + '\'' +
                '}';
    }
}
