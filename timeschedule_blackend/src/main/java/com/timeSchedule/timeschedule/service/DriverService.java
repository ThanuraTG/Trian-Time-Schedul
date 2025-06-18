package com.timeSchedule.timeschedule.service;

import com.timeSchedule.timeschedule.dto.DriverDTO;
import com.timeSchedule.timeschedule.entity.Driver_Details;
import com.timeSchedule.timeschedule.reporitory.DriverReporitory;
import com.timeSchedule.timeschedule.reporitory.TimeReporitory;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DriverService {
    @Autowired
    private DriverReporitory driverReporitory;
    @Autowired
    private ModelMapper modelMapper;

    public DriverDTO saveDriver(DriverDTO driverDTO){
        driverReporitory.save(modelMapper.map(driverDTO, Driver_Details.class));
        return driverDTO;
    }
    public List<DriverDTO> getAllDriver(){
        List<Driver_Details>driverDetailsList=driverReporitory.findAll();
        return modelMapper.map(driverDetailsList,new TypeToken<List<DriverDTO>>(){}.getType());
    }
    public DriverDTO updateDriver(DriverDTO driverDTO){
        driverReporitory.save(modelMapper.map(driverDTO,Driver_Details.class));
        return driverDTO;
    }
    public boolean deleteDriver(DriverDTO driverDTO){
        driverReporitory.delete(modelMapper.map(driverDTO, Driver_Details.class));
        return true;
    }
}
