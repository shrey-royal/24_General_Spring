package com.company.rest.entity;

import com.company.rest.util.AeroplaneStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aeroplane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aeroplaneId;

    private String model;
    private String manufacturer;
    private Integer capacity;

    @Enumerated(EnumType.STRING)
    private AeroplaneStatus status;
}
