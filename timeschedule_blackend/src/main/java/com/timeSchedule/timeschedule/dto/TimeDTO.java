package com.timeSchedule.timeschedule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class TimeDTO {
    private  int no;
    private String root;
    private String time;
    private String start_station;
    private String date;
    private String trailNo;
    private String trainName;
    private String driverName;

}
