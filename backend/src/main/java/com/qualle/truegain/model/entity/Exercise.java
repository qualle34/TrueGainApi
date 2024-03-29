package com.qualle.truegain.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "exercise", schema = "public")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String equipment;
    private String description;
    private String technique;

    @ManyToOne(fetch = FetchType.LAZY)
    private Image image;

    @ManyToOne(fetch = FetchType.LAZY)
    private Image icon;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Record> records;
}
