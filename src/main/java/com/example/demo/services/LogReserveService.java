package com.example.demo.services;

import com.example.demo.dao.models.LogReserveModel;
import com.example.demo.dao.repositories.LogReserveRepository;
import com.example.demo.define.Define;
import com.example.demo.define.ResultCode;
import com.example.demo.dto.LogReserveDTO;
import com.example.demo.dto.PitchDTO;
import com.example.demo.dto.response.Response;
import net.minidev.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.demo.define.ResultCode.*;

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


    public Response getPitchFreeTime(String district, String date, Long idTime, String type) {
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
                    if (pitchDTO.getId() == logReserveDTO.getPitch().getId()){
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
            return new Response(ResultCode.SUCCESS, pitchDTOS,ResultCode.STR_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new Response(BAD_REQUEST,null,e.getMessage());
        }


    }

    public List<LogReserveDTO> getAllLogByDateAndTime(String date, Long idTime){
        try {
            List<LogReserveDTO> logReserveDTOS = new ArrayList<>();
            String SDateAfter = Define.dateAfter(date);

            //Lấy danh sách đặt sân theo ngày giờ đã chọn (có id sân)
            List<LogReserveModel> logReserveModels =
                    logReserveRepository.getAllByTimeAndDate(date+"%",idTime);
            return convertModelToDTO(logReserveModels);
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }

    }

    public Response reservePitch(Long idCustomer, Long idPitch, Long idPrice, Long idTime, String date) {
        try {
            if (idCustomer != Define.idCustomer){
                return new Response(ResultCode.ACCESS_DENIED,null,ResultCode.STR_ACCESS_DENIED);
            }
            String SDateAfter = Define.dateAfter(date);
            List<LogReserveModel> logReserveModels =
                    logReserveRepository.getAllByTimeAndDateAndPitch(date + "%",
                            idTime,
                            idPitch);
            JSONObject jsonObject = new JSONObject();
            if (logReserveModels.isEmpty()){
                LogReserveModel logReserveModel = new LogReserveModel();
                Date dDate = new SimpleDateFormat("yyyy-MM-dd").parse(SDateAfter);
                logReserveModel.setDate(Define.convertUtilToSql(dDate));
                logReserveModel.setId_customer(idCustomer);
                logReserveModel.setId_pitch(idPitch);
                logReserveModel.setId_price(idPrice);
                logReserveModel.setId_time(idTime);
                logReserveRepository.save(logReserveModel);
                jsonObject.put("status","OK");
            }else{
                jsonObject.put("status","Lịch đã được đặt");
            }
            return new Response(ResultCode.SUCCESS,jsonObject,ResultCode.STR_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new Response(BAD_REQUEST,null,e.getMessage());
        }
    }

    public Response getLogByIdCustomer(Long idCustomer,int page,int pageSize){
        try {
            if (idCustomer != Define.idCustomer){
                return new Response(ResultCode.ACCESS_DENIED,null,ResultCode.STR_ACCESS_DENIED);
            }
            List<LogReserveModel> list = logReserveRepository.getAllById_customer(idCustomer, PageRequest.of(page-1,pageSize));
            return new Response(ResultCode.SUCCESS, convertModelToDTO(list),ResultCode.STR_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new Response(BAD_REQUEST,null,e.getMessage());
        }
    }


    private List<LogReserveDTO> convertModelToDTO(List<LogReserveModel> list) {
        List<LogReserveDTO> logReserveDTOS = new ArrayList<>();
        for (LogReserveModel logReserveModel: list){
            LogReserveDTO logReserveDTO = new LogReserveDTO();
            logReserveDTO = modelMapper.map(logReserveModel,logReserveDTO.getClass());
            logReserveDTOS.add(logReserveDTO);
        }
        return logReserveDTOS;
    }

    public Response cancelReserve(Long idCustomer, Long idReserve) {
        try {
            if (idCustomer != Define.idCustomer){
                return new Response(ResultCode.ACCESS_DENIED,null,ResultCode.STR_ACCESS_DENIED);
            }
            LogReserveModel logReserveModel = logReserveRepository.getById(idReserve);
            if (logReserveModel != null){
                //Kiểm tra giờ tại đây
                logReserveRepository.deleteById(idReserve);
                return new Response(SUCCESS,"OK",STR_SUCCESS);
            }else{
                return new Response(BAD_REQUEST,null,STR_BAD_REQUEST);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new Response(BAD_REQUEST,null,STR_BAD_REQUEST);
        }
    }
}
