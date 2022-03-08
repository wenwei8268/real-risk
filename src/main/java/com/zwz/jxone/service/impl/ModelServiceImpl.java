package com.zwz.jxone.service.impl;

import com.zwz.jxone.mapper.ModelMapper;
import com.zwz.jxone.po.ModelPO;
import com.zwz.jxone.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl implements ModelService {
    @Autowired
    ModelMapper modelMapper;

    @Override
    public ModelPO insert(ModelPO modelPo) {
        return modelMapper.insert(modelPo);
    }

    @Override
    public ModelPO deleteById(Integer id) {
        return modelMapper.deleteById(id);
    }

    @Override
    public ModelPO updateById(ModelPO modelRulePo) {
        return modelMapper.updateById(modelRulePo);
    }

    @Override
    public ModelPO servicByid(Integer id) {
        return modelMapper.servicByid(id);
    }
}
