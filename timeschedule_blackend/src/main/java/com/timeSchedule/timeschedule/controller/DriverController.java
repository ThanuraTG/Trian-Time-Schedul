package com.timeSchedule.timeschedule.controller;

import com.timeSchedule.timeschedule.dto.DriverDTO;
import com.timeSchedule.timeschedule.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/driver")

public class DriverController {
    @Autowired
    private DriverService driverService;
    @GetMapping("/get")
    public List<DriverDTO> getAllDriver(){
        return driverService.getAllDriver();
    }
    @PostMapping("/save")
    public DriverDTO saveDriver(@RequestBody DriverDTO driverDTO){
        return driverService.saveDriver(driverDTO);
    }
    @PutMapping("/update")
    public DriverDTO updateDriver(@RequestBody DriverDTO driverDTO){
        return driverService.updateDriver(driverDTO);
    }
    @DeleteMapping("/delete")
    public boolean deleteDriver(@RequestBody DriverDTO driverDTO){
        return driverService.deleteDriver(driverDTO);
    }
}
