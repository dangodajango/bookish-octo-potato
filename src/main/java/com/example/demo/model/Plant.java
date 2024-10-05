package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

import static jakarta.persistence.CascadeType.REMOVE;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "plant")
@Getter
@Setter
@NoArgsConstructor
public class Plant {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "plant_id")
    private Long plantId;

    private String name;

    private String species;

    @Column(name = "planting_date")
    private LocalDate plantingDate;

    @ManyToOne
    @JoinColumn(name = "garden_id", nullable = false)
    private Garden garden;

    @OneToMany(mappedBy = "plant", cascade = REMOVE)
    private Set<CareTip> careTips;
}
