package com.example.demo.dto;

import javax.persistence.*;

public class PitchTypeDTO {
    private Long id;
    private OwnerDTO owner;
    private String name;

    public PitchTypeDTO() {
    }

    public PitchTypeDTO(Long id, OwnerDTO owner, String name) {
        this.id = id;
        this.owner = owner;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OwnerDTO getOwner() {
        return owner;
    }

    public void setOwner(OwnerDTO owner) {
        this.owner = owner;
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
                ", owner=" + owner +
                ", name='" + name + '\'' +
                '}';
    }
}
