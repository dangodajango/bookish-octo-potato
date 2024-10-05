package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.REMOVE;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "garden")
@Getter
@Setter
@NoArgsConstructor
public class Garden {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "garden_id")
    private Long gardenId;

    private String location;

    @Column(name = "size_in_square_meters")
    private int sizeInSquareMeters;

    @Column(name = "garden_type")
    @Enumerated(value = STRING)
    private GardenType gardenType;

    @ManyToMany(cascade = MERGE)
    @JoinTable(
            name = "gardener_garden",
            joinColumns = @JoinColumn(name = "garden_id"),
            inverseJoinColumns = @JoinColumn(name = "gardener_id")
    )
    private Set<Gardener> gardeners;

    @OneToMany(mappedBy = "garden", cascade = REMOVE)
    private Set<Plant> plants;
}
