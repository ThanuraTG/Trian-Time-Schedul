package com.timeSchedule.timeschedule.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Driver_Details")

public class Driver_Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int DriverID;
    private String name;

}
