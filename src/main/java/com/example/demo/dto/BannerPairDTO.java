package com.example.demo.dto;

import javax.persistence.*;
import java.util.Date;

public class BannerPairDTO {
    private Long id;
    private Long id_customer;
    private Date start_date;
    private Date end_time;
    private String note;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_customer() {
        return id_customer;
    }

    public void setId_customer(Long id_customer) {
        this.id_customer = id_customer;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "BannerPairDTO{" +
                "id=" + id +
                ", id_customer=" + id_customer +
                ", start_date=" + start_date +
                ", end_time=" + end_time +
                ", note='" + note + '\'' +
                '}';
    }
}
