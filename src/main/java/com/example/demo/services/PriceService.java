package com.example.demo.services;

import com.example.demo.dao.models.PriceModel;
import com.example.demo.dao.repositories.PriceRepository;
import com.example.demo.define.Define;
import net.minidev.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class PriceService {


    @Autowired
    private PriceRepository priceRepository;

    public JSONObject getPriceOfPitchType(Long idTime,Long idType,String date){
        try {
            JSONObject jsonObject = new JSONObject();
            List<PriceModel> list = priceRepository.getByTimeAndType(idType,idTime);
            if (!list.isEmpty()){
                for (PriceModel priceModel: list){
                    if (priceModel.getDate().toString().contains(date)){
                        jsonObject.put("id",priceModel.getId());
                        jsonObject.put("price",priceModel.getPrice());
                        return jsonObject;
                    }
                }
                jsonObject.put("id",list.get(0).getId());
                jsonObject.put("price",list.get(0).getPrice());
                return jsonObject;
            }else{
                PriceModel priceModel = new PriceModel();
                priceModel.setRate_of_change(Define.DEFAULT_NONE);
                Date date1 = new Date();
                priceModel.setCreatedAt(new Timestamp(date1.getTime()));
                priceModel.setUpdateAt(new Timestamp(date1.getTime()));
                priceModel.setId_time(idTime);
                priceModel.setId_type(idType);
                priceModel.setDate(new Date());
                priceModel.setPrice(Define.DEFAULT_PRICE);
                priceRepository.save(priceModel);
                jsonObject.put("id",priceModel.getId());
                jsonObject.put("price",priceModel.getPrice());
                return jsonObject;
            }

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
