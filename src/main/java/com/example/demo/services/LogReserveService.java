package com.example.demo.services;

import com.example.demo.dao.models.LogReserveModel;
import com.example.demo.dao.repositories.LogReserveRepository;
import com.example.demo.dto.LogReserveDTO;
import com.example.demo.dto.PitchDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private OwnerService ownerService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PitchTypeService pitchTypeService;

    @Autowired
    private PitchService pitchService;


    public List<PitchDTO> getPitchFreeTime(String district, String date, String time, String type) {
        try {
            List<PitchDTO> pitchDTOS = new ArrayList<>();
            //Lấy ra danh sách tất cả các loại sân đúng khu vực và loại sân
            List<PitchDTO> pitchFollowDistrictAndType = pitchService.getPitchByDistrictAndName(district,type);

            //Lấy danh sách những sân có log vào ngày và giờ đó
            List<LogReserveDTO> logReserveDTOS = getAllLogByDateAndTime(date,time);

            //Lọc ra những thứ có không có trong log thì giữ lại
            for (PitchDTO pitchDTO: pitchFollowDistrictAndType){
                boolean isOk = true;
                for (LogReserveDTO logReserveDTO: logReserveDTOS){
                    if (pitchDTO.getId() == logReserveDTO.getPitchDTO().getId()){
                        isOk = false;
                        break;
                    }
                }
                if (isOk){
                    pitchDTOS.add(pitchDTO);
                }
            }
            return pitchDTOS;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }


    }

    public List<LogReserveDTO> getAllLogByDateAndTime(String date, String time){
        try {
            List<LogReserveDTO> logReserveDTOS = new ArrayList<>();
            Calendar c = Calendar.getInstance();
            Date dDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            c.setTime(dDate);
            c.add(Calendar.DATE,1);
            String SDateAfter = String.valueOf(c.get(Calendar.YEAR)) + "-" +
                    String.valueOf(c.get(Calendar.MONTH)+ 1) + "-" +
                    String.valueOf(c.get(Calendar.DATE));

            //Lấy danh sách đặt sân theo ngày giờ đã chọn (có id sân)
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
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }

    }
}
