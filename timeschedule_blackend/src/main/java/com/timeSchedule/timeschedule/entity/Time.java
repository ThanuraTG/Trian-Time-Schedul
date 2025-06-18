package com.timeSchedule.timeschedule.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Time")

public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int no;
    private String root;
    private String time;
    private String date;
    private String start_station;
    private String trainName;
    private String driverName;

    @ManyToOne
    @JoinColumn(name = "train_no", nullable = false)
    private Train train;

}

