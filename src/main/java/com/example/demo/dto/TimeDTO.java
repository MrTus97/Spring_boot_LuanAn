package com.example.demo.dto;


import javax.persistence.*;
import java.sql.Time;

public class TimeDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "starttime")
    private java.sql.Time start_time;

    @Column(name = "endtime")
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
}
