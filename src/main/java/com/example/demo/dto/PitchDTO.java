package com.example.demo.dto;

import javax.persistence.*;

public class PitchDTO {
    private Long id;
    private Long id_type;
    private String name;
    private String description;
    private String image;
    private Double count;
    private String is_use;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_type() {
        return id_type;
    }

    public void setId_type(Long id_type) {
        this.id_type = id_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getCount() {
        return count;
    }

    public void setCount(Double count) {
        this.count = count;
    }

    public String getIs_use() {
        return is_use;
    }

    public void setIs_use(String is_use) {
        this.is_use = is_use;
    }

    @Override
    public String toString() {
        return "PitchDTO{" +
                "id=" + id +
                ", id_type=" + id_type +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", count=" + count +
                ", is_use='" + is_use + '\'' +
                '}';
    }
}
