package com.example.demo.services;

import com.example.demo.dao.models.LogReserveModel;
import com.example.demo.dao.repositories.LogReserveRepository;
import com.example.demo.define.Define;
import com.example.demo.dto.LogReserveDTO;
import com.example.demo.dto.PitchDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import net.minidev.json.JSONObject;
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
    private ModelMapper modelMapper;


    @Autowired
    private PitchService pitchService;

    @Autowired
    private PriceService priceService;


    public List<JSONObject> getPitchFreeTime(String district, String date, Long idTime, String type) {
        try {
            List<JSONObject> pitchDTOS = new ArrayList<>();
            //Lấy ra danh sách tất cả các loại sân đúng khu vực và loại sân
            List<PitchDTO> pitchFollowDistrictAndType = pitchService.getPitchByDistrictAndName(district,type);

            //Lấy danh sách những sân có log vào ngày và giờ đó
            List<LogReserveDTO> logReserveDTOS = getAllLogByDateAndTime(date,idTime);

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
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("pitch",pitchDTO);
                    jsonObject.put("price",priceService.getPriceOfPitchType(idTime,pitchDTO.getPitchType().getId(),date));
                    pitchDTOS.add(jsonObject);
                }
            }
            return pitchDTOS;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }


    }

    public List<LogReserveDTO> getAllLogByDateAndTime(String date, Long idTime){
        try {
            List<LogReserveDTO> logReserveDTOS = new ArrayList<>();
            String SDateAfter = Define.dateAfter(date);

            //Lấy danh sách đặt sân theo ngày giờ đã chọn (có id sân)
            List<LogReserveModel> logReserveModels =
                    logReserveRepository.getAllByTimeAndDate(date,
                            SDateAfter,
                            idTime);
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

    public JSONObject reservePitch(Long idCustomer, Long idPitch, Long idPrice, Long idTime, String date) {
        try {
            String SDateAfter = Define.dateAfter(date);
            List<LogReserveModel> logReserveModels =
                    logReserveRepository.getAllByTimeAndDateAndPitch(date,
                            SDateAfter,
                            idTime,
                            idPitch);
            JSONObject jsonObject = new JSONObject();
            if (logReserveModels.isEmpty()){
                LogReserveModel logReserveModel = new LogReserveModel();
                Date dDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
                logReserveModel.setDate(dDate);
                logReserveModel.setId_customer(idCustomer);
                logReserveModel.setId_pitch(idPitch);
                logReserveModel.setId_price(idPrice);
                logReserveModel.setId_time(idTime);
                logReserveRepository.save(logReserveModel);
                jsonObject.put("status","OK");
            }else{
                jsonObject.put("status","Lịch đã được đặt");
            }
            return jsonObject;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
