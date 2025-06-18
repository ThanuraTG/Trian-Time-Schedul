package com.timeSchedule.timeschedule.reporitory;

import com.timeSchedule.timeschedule.entity.Time;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimeReporitory extends JpaRepository<Time,Integer> {
    List<Time> findByTrainTrainNo(int trainNo);
}
