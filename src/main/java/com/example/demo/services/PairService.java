package com.example.demo.services;

import com.example.demo.dao.models.PairModel;
import com.example.demo.dao.repositories.PairRepository;
import com.example.demo.define.Define;
import com.example.demo.dto.PairDTO;
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

    public List<PairDTO> getAllPair(int page, int pageSize) {
        try {
            List<PairModel> pairModels = pairRepository.getAllByStatusOrderByCreatedAt("YES", PageRequest.of(page,pageSize));
            return convertModelToDTO(pairModels);
        }catch (Exception e){
            e.printStackTrace();
            return null;
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


    public List<PairDTO> getPairById(Long idCustomer, Optional<Integer> page, Optional<Integer> pageSize) {
        try {
            int evalPageSize = pageSize.orElse(Define.initialPageSize);
            int evalPage = (page.orElse(0) < 1) ? Define.initialPage : page.get() - 1;
            List<PairModel> pairModels = pairRepository.getAllByIdCustomer(idCustomer, PageRequest.of(evalPage,evalPageSize));
            return convertModelToDTO(pairModels);
        }catch (Exception e){
            e.printStackTrace();
            return null;
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

    public JSONObject updateStatus(String status, Long idPair) {

        try {
            JSONObject jsonObject = new JSONObject();
            PairModel pairModel = pairRepository.getById(idPair);
            pairModel.setStatus(status);
            pairRepository.save(pairModel);
            jsonObject.put("status","OK");
            return jsonObject;

        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }

    }
}
