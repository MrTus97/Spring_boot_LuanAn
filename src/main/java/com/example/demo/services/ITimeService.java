package com.example.demo.services;

import com.example.demo.dao.models.TimeModel;
import com.example.demo.dto.TimeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITimeService {

    List<TimeDTO> getAllTime();

    List<TimeDTO> convertModelToDTO(List<TimeModel> list);
}
