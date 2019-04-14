package com.example.demo.services;

import com.example.demo.dao.models.TimeModel;
import com.example.demo.dao.repositories.TimeRepository;
import com.example.demo.dto.TimeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimeService{
    @Autowired
    private TimeRepository timeRepository;

    @Autowired
    private ModelMapper modelMapper;



    public List<TimeDTO> getAllTime() {
        try {
            List<TimeModel> timeModels = timeRepository.getAllTime();
            return convertModelToDTO(timeModels);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public List<TimeDTO> convertModelToDTO(List<TimeModel> list) {
        try {
            List<TimeDTO> timeDTOS = new ArrayList<>();
            for (TimeModel timeModel:list){
                TimeDTO timeDTO = new TimeDTO();
                timeDTO = modelMapper.map(timeModel,timeDTO.getClass());
                timeDTOS.add(timeDTO);
            }
            return timeDTOS;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
