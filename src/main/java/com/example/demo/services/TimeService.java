package com.example.demo.services;

import com.example.demo.dao.models.TimeModel;
import com.example.demo.dao.repositories.TimeRepository;
import com.example.demo.define.ResultCode;
import com.example.demo.dto.TimeDTO;
import com.example.demo.dto.response.Response;
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

    public Response getAllTime() {
        try {
            List<TimeModel> timeModels = timeRepository.getAllTime();
            return new Response(ResultCode.SUCCESS,convertModelToDTO(timeModels),ResultCode.STR_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new Response(ResultCode.BAD_REQUEST,null,e.getMessage());
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
