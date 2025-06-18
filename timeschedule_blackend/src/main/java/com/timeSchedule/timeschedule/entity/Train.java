package com.timeSchedule.timeschedule.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Train")

public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trainNo;
    private String trainName;
    private String main_root;

    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Time> times;
}

