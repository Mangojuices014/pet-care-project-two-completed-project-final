package com.dailycodework.universalpetcare.model;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;
@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @jakarta.persistence.Column(name = "created_date")
    private String createdDate = new Timestamp(new Date().getTime()).toString();

    @Column(name = "updated_date")
    private String updatedDate = new Timestamp(new Date().getTime()).toString();
}