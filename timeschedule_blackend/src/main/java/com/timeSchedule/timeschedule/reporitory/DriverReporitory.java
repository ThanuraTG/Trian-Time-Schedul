package com.timeSchedule.timeschedule.reporitory;

import com.timeSchedule.timeschedule.entity.Driver_Details;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverReporitory extends JpaRepository<Driver_Details,Integer> {
}
