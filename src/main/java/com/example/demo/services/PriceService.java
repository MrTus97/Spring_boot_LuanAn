package com.example.demo.services;

import com.example.demo.dao.models.PriceModel;
import com.example.demo.dao.repositories.PriceRepository;
import net.minidev.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {


    @Autowired
    private PriceRepository priceRepository;

    public Double getPriceOfPitchType(Long idTime,Long idType,String date){
        try {
            JSONObject jsonObject = new JSONObject();
            List<PriceModel> list = priceRepository.getByTimeAndType(idType,idTime);
            for (PriceModel priceModel: list){
                if (priceModel.getDate().toString().contains(date)){
                    return priceModel.getPrice() * priceModel.getRate_of_change();
                }
            }
            return list.get(0).getPrice();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
