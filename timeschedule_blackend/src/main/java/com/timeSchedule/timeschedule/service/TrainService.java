package com.timeSchedule.timeschedule.service;

import com.timeSchedule.timeschedule.dto.TimeDTO;
import com.timeSchedule.timeschedule.dto.TrainDTO;
import com.timeSchedule.timeschedule.entity.Time;
import com.timeSchedule.timeschedule.entity.Train;
import com.timeSchedule.timeschedule.reporitory.TimeReporitory;
import com.timeSchedule.timeschedule.reporitory.TrainReporitory;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TrainService {
    @Autowired
    private TrainReporitory trainReporitory;
    @Autowired
    private ModelMapper modelMapper;

    public TrainDTO saveTrain(TrainDTO trainDTO){
        trainReporitory.save(modelMapper.map(trainDTO, Train.class));
        return trainDTO;
    }
    public List<TrainDTO> getAllTrain(){
        List<Train>trainList=trainReporitory.findAll();
        return modelMapper.map(trainList,new TypeToken<List<TrainDTO>>(){}.getType());
    }
    public TrainDTO updateTrain(TrainDTO trainDTO){
        trainReporitory.save(modelMapper.map(trainDTO,Train.class));
        return trainDTO;
    }
    public boolean deleteTrain(TrainDTO trainDTO){
        trainReporitory.delete(modelMapper.map(trainDTO, Train.class));
        return true;
    }
    public void deleteTrainId(int TrainNo){
        trainReporitory.deleteById(TrainNo);
    }

    public TrainDTO findByTrainNo(int trainNo){
        Optional<Train> train = trainReporitory.findById(trainNo);
        return train.map(t -> modelMapper.map(t, TrainDTO.class)).orElse(null);
    }
}
