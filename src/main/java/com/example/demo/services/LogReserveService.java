package com.example.demo.services;

import com.example.demo.dao.models.LogReserveModel;
import com.example.demo.dao.models.OwnerModel;
import com.example.demo.dao.repositories.LogReserveRepository;
import com.example.demo.dao.repositories.OwnerRepository;
import com.example.demo.dto.LogReserveDTO;
import com.example.demo.dto.response.Response;
import net.minidev.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class LogReserveService {

    @Autowired
    private LogReserveRepository logReserveRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<LogReserveDTO> getPitchFreeTime(String district, String date, String time, String type) {
        try {
            List<LogReserveDTO> logReserveDTOS = new ArrayList<>();
            Calendar c = Calendar.getInstance();
            Date dDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            c.setTime(dDate);
            c.add(Calendar.DATE,1);
            String SDateAfter = String.valueOf(c.get(Calendar.YEAR)) + "-" +
                    String.valueOf(c.get(Calendar.MONTH)+ 1) + "-" +
                    String.valueOf(c.get(Calendar.DATE));
            List<OwnerModel> owners = ownerRepository.getOwnerModelByDistrict(district);

            List<LogReserveModel> logReserveModels =
                    logReserveRepository.getAllByTimeAndDate(date,
                            SDateAfter,
                            time);
            for (LogReserveModel logReserveModel: logReserveModels){
                LogReserveDTO logReserveDTO = new LogReserveDTO();
                logReserveDTO = modelMapper.map(logReserveModel,logReserveDTO.getClass());
                logReserveDTOS.add(logReserveDTO);
            }
            return logReserveDTOS;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

    }
}
