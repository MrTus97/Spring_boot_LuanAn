package com.example.demo.services;

import com.example.demo.dao.models.PairModel;
import com.example.demo.dao.repositories.PairRepository;
import com.example.demo.define.Define;
import com.example.demo.define.ResultCode;
import com.example.demo.dto.PairDTO;
import com.example.demo.dto.response.Response;
import net.minidev.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PairService {

    @Autowired
    private PairRepository pairRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Response getAllPair(int page, int pageSize) {
        try {
            List<PairModel> pairModels = pairRepository.getAllByPairOderOrderByCreatedAtDesc(PageRequest.of(page-1,pageSize));
            return new Response(ResultCode.SUCCESS,convertModelToDTO(pairModels),ResultCode.STR_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new Response(ResultCode.BAD_REQUEST,null,e.getMessage());
        }

    }

    public List<PairDTO> convertModelToDTO(List<PairModel> pairModels){
        try {
            List<PairDTO> pairDTOS = new ArrayList<>();
            for (PairModel pairModel :pairModels){
                PairDTO pairDTO = new PairDTO();
                pairDTO = modelMapper.map(pairModel,pairDTO.getClass());
                pairDTOS.add(pairDTO);
            }
            return pairDTOS;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }


    public Response getPairById(Long idCustomer, Optional<Integer> page, Optional<Integer> pageSize) {
        try {
            if (idCustomer != Define.idCustomer){
                return new Response(ResultCode.ACCESS_DENIED,null,ResultCode.STR_ACCESS_DENIED);
            }
            int evalPageSize = pageSize.orElse(Define.initialPageSize);
            int evalPage = (page.orElse(0) < 1) ? Define.initialPage : page.get() - 1;
            List<PairModel> pairModels = pairRepository.getAllByIdCustomer(idCustomer, PageRequest.of(evalPage,evalPageSize));
            return new Response(ResultCode.SUCCESS, convertModelToDTO(pairModels),ResultCode.STR_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new Response(ResultCode.BAD_REQUEST,null,e.getMessage());
        }

    }

    public JSONObject postPair(PairModel pairModel) {
        try {

            JSONObject jsonObject = new JSONObject();
            pairRepository.save(pairModel);
            jsonObject.put("status","OK");
            return jsonObject;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public Response updateStatus(String pair, Long idPair,Long idCustomer) {

        try {
            if (idCustomer != Define.idCustomer){
                return new Response(ResultCode.ACCESS_DENIED,null,ResultCode.STR_ACCESS_DENIED);
            }
            JSONObject jsonObject = new JSONObject();
            PairModel pairModel = pairRepository.getById(idPair);
            pairModel.setPair(pair);
            pairRepository.save(pairModel);
            jsonObject.put("status","OK");
            return new Response(ResultCode.SUCCESS,jsonObject,ResultCode.STR_SUCCESS);

        }catch (Exception e){
            e.printStackTrace();
            return new Response(ResultCode.BAD_REQUEST,null,e.getMessage());
        }

    }
}
