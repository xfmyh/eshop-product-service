package com.roncoo.eshop.product.service.impl;

import com.roncoo.eshop.product.mapper.BrandMapper;
import com.roncoo.eshop.product.model.Brand;
import com.roncoo.eshop.product.rabbitmq.RabbitMQSender;
import com.roncoo.eshop.product.rabbitmq.RabbitQueue;
import com.roncoo.eshop.product.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {


    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private RabbitMQSender rabbitMQSender;


    @Override
    public void add(Brand brand,String operationType) {

        brandMapper.add(brand);

        String queue = null;

        if(operationType == null || "".equals(operationType)){
            queue = RabbitQueue.DATA_CHANGE_QUEUE;
        }else if("refresh".equals(operationType)){
            queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
        }else if("high".equals(operationType)){
            queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }

        rabbitMQSender.send(queue,"{\"event_type\":\"add\",\"data_type\":\"brand\",\"id\":\"" + brand.getId() + "\"}");
    }

    @Override
    public void update(Brand brand,String operationType) {
        brandMapper.update(brand);

        String queue = null;

        if(operationType == null || "".equals(operationType)){
            queue = RabbitQueue.DATA_CHANGE_QUEUE;
        }else if("refresh".equals(operationType)){
            queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
        }else if("high".equals(operationType)){
            queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }


        rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE,"{\"event_type\":\"update\",\"data_type\":\"brand\",\"id\":\"" + brand.getId() + "\"}");

    }

    @Override
    public void delete(Long id,String operationType) {
        brandMapper.delete(id);

        String queue = null;

        if(operationType == null || "".equals(operationType)){
            queue = RabbitQueue.DATA_CHANGE_QUEUE;
        }else if("refresh".equals(operationType)){
            queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
        }else if("high".equals(operationType)){
            queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }


        rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE,"{\"event_type\":\"delete\",\"data_type\":\"brand\",\"id\":\"" + id + "\"}");


    }

    @Override
    public Brand findById(Long id) {
        return brandMapper.findById(id);
    }

    @Override
    public List<Brand> findByIds(String ids) {
        return brandMapper.findByIds(ids);
    }
}
