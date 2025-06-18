package com.timeSchedule.timeschedule.dto;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class TrainDTO {
    private int trainNo;
    private String name;
    private String main_root;



}
