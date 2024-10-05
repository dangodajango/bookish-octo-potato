package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "gardener")
@Getter
@Setter
@NoArgsConstructor
public class Gardener {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "gardener_id")
    private Long gardenerId;

    private String name;

    @Column(name = "experience_level")
    @Enumerated(value = STRING)
    private ExperienceLevel experienceLevel;

    @Column(name = "gardening_style")
    @Enumerated(value = STRING)
    private GardeningStyle gardeningStyle;

    @Column(name = "join_date")
    private LocalDate joinDate;

    @ManyToMany(mappedBy = "gardeners")
    private Set<Garden> gardens;
}
