package com.timeSchedule.timeschedule.service;

import com.timeSchedule.timeschedule.dto.TimeDTO;
import com.timeSchedule.timeschedule.entity.Time;
import com.timeSchedule.timeschedule.reporitory.TimeReporitory;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class TimeService {
    @Autowired
    private TimeReporitory timeReporitory;
    @Autowired
    private ModelMapper modelMapper;

    public TimeDTO saveTime(TimeDTO timeDTO){
        timeReporitory.save(modelMapper.map(timeDTO, Time.class));
        return timeDTO;
    }
    public List<TimeDTO> getAllTime(){
        List<Time>timeList=timeReporitory.findAll();
        return modelMapper.map(timeList,new TypeToken<List<TimeDTO>>(){}.getType());
    }
    public TimeDTO updateTime(TimeDTO timeDTO){
        timeReporitory.save(modelMapper.map(timeDTO,Time.class));
        return timeDTO;
    }
    public boolean deleteTime(TimeDTO timeDTO){
        timeReporitory.delete(modelMapper.map(timeDTO, Time.class));
        return true;
    }
    public void deleteTimeId(int No){
        timeReporitory.deleteById(No);
    }
}
