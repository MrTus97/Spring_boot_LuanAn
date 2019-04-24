package com.example.demo.services;

import com.example.demo.dao.models.PitchModel;
import com.example.demo.dao.repositories.PitchRepository;
import com.example.demo.define.ResultCode;
import com.example.demo.dto.PitchDTO;
import com.example.demo.dto.response.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PitchService{

    @Autowired
    private PitchRepository pitchRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Lấy danh sách các sân ở khu vực district(Cẩm Lệ) và là type_name (sân 5)
     * @param district
     * @param type_name
     * @return
     */
    public List<PitchDTO> getPitchByDistrictAndName(String district,String type_name){
        try {
            List<PitchDTO> pitchDTOS = new ArrayList<>();
            List<PitchModel> pitchModels = pitchRepository.getAllByDistrictAndName(district,type_name);
            for (PitchModel pitchModel:pitchModels){
                PitchDTO pitchDTO = new PitchDTO();
                pitchDTO = modelMapper.map(pitchModel,pitchDTO.getClass());
                pitchDTOS.add(pitchDTO);
            }
            return pitchDTOS;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public Response getAllPitch(int page, int pageSize) {
        try{
            List<PitchDTO> pitchDTOS = new ArrayList<>();
            List<PitchModel> pitchModels = pitchRepository.getAllPaging(PageRequest.of(page,pageSize));
            for (PitchModel pitchModel:pitchModels){
                PitchDTO pitchDTO = new PitchDTO();
                pitchDTO = modelMapper.map(pitchModel,pitchDTO.getClass());
                pitchDTOS.add(pitchDTO);
            }
            return new Response(ResultCode.SUCCESS,pitchDTOS,ResultCode.STR_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
