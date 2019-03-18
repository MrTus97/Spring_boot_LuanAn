package com.example.demo.dao.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "log_reseve")
public class LogReserveModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_price")
    private Long id_price;

    @Column(name = "id_pitch")
    private Long id_pitch;

    @Column(name = "id_time")
    private Long id_time;

    @Column(name = "id_customer")
    private Long id_customer;

    @Column(name = "type")
    private String type;

    @Column(name = "status")
    private String status;

    @Column(name = "date")
    private Date date;
}
