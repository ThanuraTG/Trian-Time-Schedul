package com.timeSchedule.timeschedule.reporitory;

import com.timeSchedule.timeschedule.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainReporitory extends JpaRepository<Train, Integer> {
}
