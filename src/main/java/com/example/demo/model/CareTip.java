package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "care_tip")
@Getter
@Setter
@NoArgsConstructor
public class CareTip {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "care_tip_id")
    private Long careTipId;

    private String description;

    @Enumerated(STRING)
    private CareTipType type;

    @ManyToOne
    @JoinColumn(name = "plant_id")
    private Plant plant;
}
