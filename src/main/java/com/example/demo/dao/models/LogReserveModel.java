package com.example.demo.dao.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "log_reserve")
public class LogReserveModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @Column(name = "id_price")
    private Long id_price;

    @JsonIgnore
    @Column(name = "id_pitch")
    private Long id_pitch;

    @JsonIgnore
    @Column(name = "id_time")
    private Long id_time;

    @JsonIgnore
    @Column(name = "id_customer")
    private Long id_customer;

    @Column(name = "type")
    private String type;

    @Column(name = "status")
    private String status;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "id_price", insertable = false, updatable = false)
    private PriceModel priceModel;

    @ManyToOne
    @JoinColumn(name = "id_pitch", insertable = false, updatable = false)
    private PitchModel pitchModel;

    @ManyToOne
    @JoinColumn(name = "id_time", insertable = false, updatable = false)
    private TimeModel timeModel;

    @ManyToOne
    @JoinColumn(name = "id_customer", insertable = false, updatable = false)
    private CustomerModel customerModel;

    @Column(name = "created_at")
    private java.sql.Timestamp createdAt;

    @Column(name = "updated_at")
    private java.sql.Timestamp updateAt;

}
