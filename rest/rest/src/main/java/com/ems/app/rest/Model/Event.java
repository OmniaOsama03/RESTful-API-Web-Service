package com.ems.app.rest.Model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Event
{
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String location;

    @Column
    private String category;

    @Column
    private Date date;

    @Column
    private String status;

    @Column
    private int capacity;
}
