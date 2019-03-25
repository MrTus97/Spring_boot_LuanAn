package com.example.demo.dto;


import javax.persistence.*;
import java.sql.Time;

public class TimeDTO {
    private Long id;
    private java.sql.Time start_time;
    private java.sql.Time end_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.sql.Time getStart_time() {
        return start_time;
    }

    public void setStart_time(java.sql.Time start_time) {
        this.start_time = start_time;
    }

    public java.sql.Time getEnd_time() {
        return end_time;
    }

    public void setEnd_time(java.sql.Time end_time) {
        this.end_time = end_time;
    }

    @Override
    public String toString() {
        return "TimeDTO{" +
                "id=" + id +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                '}';
    }
}
