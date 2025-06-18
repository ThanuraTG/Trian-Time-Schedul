package com.timeSchedule.timeschedule.controller;

import com.timeSchedule.timeschedule.dto.TimeDTO;
import com.timeSchedule.timeschedule.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/time")

public class TimeController {
    @Autowired
    private TimeService timeService;
    @GetMapping("/get")
    public List<TimeDTO> getAllTime(){
        return timeService.getAllTime();
    }
    @PostMapping("/save")
    public TimeDTO saveTime(@RequestBody TimeDTO timeDTO){
        return timeService.saveTime(timeDTO);
    }
    @PutMapping("/update")
    public TimeDTO updateTime(@RequestBody TimeDTO timeDTO){
        return timeService.updateTime(timeDTO);
    }
    @DeleteMapping("/delete")
    public boolean deleteTime(@RequestBody TimeDTO timeDTO){
        return timeService.deleteTime(timeDTO);
    }
    @DeleteMapping("/delete/{No}")
    public ResponseEntity<String> deleteTime(@PathVariable int No){
        try {
            timeService.deleteTimeId(No);
            return ResponseEntity.ok("Time delete successfuly.");
        } catch (Exception e){
            return ResponseEntity.status(500).body("Failed to delete time.");
        }
    }
}
