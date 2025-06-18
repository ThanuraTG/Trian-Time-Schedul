package com.timeSchedule.timeschedule.controller;

import com.timeSchedule.timeschedule.dto.DriverDTO;
import com.timeSchedule.timeschedule.dto.TimeDTO;
import com.timeSchedule.timeschedule.dto.TrainDTO;
import com.timeSchedule.timeschedule.service.DriverService;
import com.timeSchedule.timeschedule.service.TimeService;
import com.timeSchedule.timeschedule.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/train")

public class TrainController {
    @Autowired
    private TrainService trainService;
    @GetMapping("/get")
    public List<TrainDTO> getAllTrain(){
        return trainService.getAllTrain();
    }
    @PostMapping("/save")
    public TrainDTO saveTrain(@RequestBody TrainDTO trainDTO){
        return trainService.saveTrain(trainDTO);
    }
    @PutMapping("/update")
    public TrainDTO updateTrain(@RequestBody TrainDTO trainDTO){
        return trainService.updateTrain(trainDTO);
    }
    @DeleteMapping("/delete")
    public boolean deleteTrain(@RequestBody TrainDTO trainDTO){
        return trainService.deleteTrain(trainDTO);
    }
    @DeleteMapping("/delete/{TrainNo}")
    public ResponseEntity<String> deleteTrain(@PathVariable int TrainNo){
        try {
            trainService.deleteTrainId(TrainNo);
            return ResponseEntity.ok("Time delete successfuly.");
        } catch (Exception e){
            return ResponseEntity.status(500).body("Failed to delete time.");
        }
    }

    @GetMapping("/{trainNo}")
    public ResponseEntity<TrainDTO> getTrainByNo(@PathVariable int trainNo) {
        TrainDTO trainDTO = trainService.findByTrainNo(trainNo);
        if (trainDTO != null) {
            return ResponseEntity.ok(trainDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
