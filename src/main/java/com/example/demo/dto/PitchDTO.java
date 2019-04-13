package com.example.demo.dto;

import net.minidev.json.JSONObject;

public class PitchDTO {
    private Long id;
    private PitchTypeDTO pitchType;
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

    public PitchTypeDTO getPitchType() {
        return pitchType;
    }

    public void setPitchType(PitchTypeDTO pitchType) {
        this.pitchType = pitchType;
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
}
