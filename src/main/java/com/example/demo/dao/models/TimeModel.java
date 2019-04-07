package com.example.demo.dao.models;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "time")
public class TimeModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "starttime")
    private Time start_time;

    @Column(name = "endtime")
    private Time end_time;

    @Column(name = "created_at")
    private java.sql.Timestamp createdAt;

    @Column(name = "updated_at")
    private java.sql.Timestamp updateAt;

    public TimeModel(Time start_time, Time end_time, Timestamp createdAt, Timestamp updateAt) {
        this.start_time = start_time;
        this.end_time = end_time;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public TimeModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Time getStart_time() {
        return start_time;
    }

    public void setStart_time(Time start_time) {
        this.start_time = start_time;
    }

    public Time getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Time end_time) {
        this.end_time = end_time;
    }
}
