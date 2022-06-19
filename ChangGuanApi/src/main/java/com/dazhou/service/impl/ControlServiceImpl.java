package com.dazhou.service.impl;

import com.dazhou.entity.ControlInfoEntity;
import com.dazhou.entity.ResultData;
import com.dazhou.mapper.ControlInfoMapper;
import com.dazhou.service.IControlService;
import com.dazhou.utils.CreateJWT;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ControlServiceImpl implements IControlService {
    @Resource
    private ControlInfoMapper controlInfoMapper;

    @Override
    public ResultData getControlList(String page){
        int temp=(Integer.parseInt(page.trim())-1)*10;
        List<ControlInfoEntity> data=controlInfoMapper.getControlList(temp);
        int total = controlInfoMapper.getControlTotal();
        return new ResultData("success",data,200,total);
    }

    @Override
    public ResultData searchControlList(String name,String ControlNum,String page){
        int temp=(Integer.parseInt(page.trim())-1)*10;
        List<ControlInfoEntity> data=controlInfoMapper.searchControlList(name,ControlNum,temp);
        int total = controlInfoMapper.getSearchControlTotal(name,ControlNum);
        return new ResultData("success",data,200,total);
    }

    @Override
    public ResultData addControl(ControlInfoEntity ControlInfoEntity){
        ControlInfoEntity.setDel(false);
//        ControlInfoEntity.setRole(1);
//        ControlInfoEntity.setPassword(ControlInfoEntity.getTelephone());
        Boolean data=controlInfoMapper.addControl(ControlInfoEntity);
        return new ResultData("success",data,200,0);
    }

    @Override
    public ResultData deleteControl(ControlInfoEntity ControlInfoEntity){
        Boolean data=controlInfoMapper.deleteControl(ControlInfoEntity);
        return new ResultData("success",data,200,0);
    }

    @Override
    public ResultData updateControl(ControlInfoEntity ControlInfoEntity){
        Boolean data=controlInfoMapper.updateControl(ControlInfoEntity);
        return new ResultData("success",data,200,0);
    }

    @Override
    public ResultData getControlOptions(){
        List<ControlInfoEntity>  data=controlInfoMapper.getControlOptions();
        return new ResultData("success",data,200,0);
    }

}
