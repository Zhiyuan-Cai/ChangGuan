package com.dazhou.service.impl;

import com.dazhou.entity.CategoryEntity;
import com.dazhou.entity.DeviceInfoEntity;
import com.dazhou.entity.ResultData;
import com.dazhou.mapper.DeviceInfoMapper;
import com.dazhou.service.IDeviceService;
import com.dazhou.utils.CreateJWT;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeviceServiceImpl implements IDeviceService {
    @Resource
    private DeviceInfoMapper deviceInfoMapper;

    @Override
    public ResultData getDeviceList(String page){
        int temp=(Integer.parseInt(page.trim())-1)*10;
        List<DeviceInfoEntity> data=deviceInfoMapper.getDeviceList(temp);
        int total = deviceInfoMapper.getDeviceTotal();
        return new ResultData("success",data,200,total);
    }

    @Override
    public ResultData searchDeviceList(String name,String DeviceNum,String category,String deviceIP,String page){
        int temp=(Integer.parseInt(page.trim())-1)*10;
        List<DeviceInfoEntity> data=deviceInfoMapper.searchDeviceList(name,DeviceNum,category,deviceIP,temp);
        int total = deviceInfoMapper.getSearchDeviceTotal(name,DeviceNum,category,deviceIP);
        return new ResultData("success",data,200,total);
    }

    @Override
    public ResultData addDevice(DeviceInfoEntity DeviceInfoEntity){
        DeviceInfoEntity.setDel(false);
//        DeviceInfoEntity.setRole(1);
//        DeviceInfoEntity.setPassword(DeviceInfoEntity.getTelephone());
        Boolean data=deviceInfoMapper.addDevice(DeviceInfoEntity);
        return new ResultData("success",data,200,0);
    }

    @Override
    public ResultData deleteDevice(DeviceInfoEntity DeviceInfoEntity){
        Boolean data=deviceInfoMapper.deleteDevice(DeviceInfoEntity);
        return new ResultData("success",data,200,0);
    }

    @Override
    public ResultData updateDevice(DeviceInfoEntity DeviceInfoEntity){
        Boolean data=deviceInfoMapper.updateDevice(DeviceInfoEntity);
        return new ResultData("success",data,200,0);
    }

    @Override
    public ResultData getDeviceOptions(){
        List<DeviceInfoEntity>  data=deviceInfoMapper.getDeviceOptions();
        return new ResultData("success",data,200,0);
    }

    @Override
    public ResultData getCategoryList(String page){
        int temp=(Integer.parseInt(page.trim())-1)*10;
        List<CategoryEntity> data=deviceInfoMapper.getCategoryList(temp);
        int total = deviceInfoMapper.getCategoryTotal();
        return new ResultData("success",data,200,total);
    }

    @Override
    public ResultData searchCategoryList(String name,String page){
        int temp=(Integer.parseInt(page.trim())-1)*10;
        List<CategoryEntity> data=deviceInfoMapper.searchCategoryList(name,temp);
        int total = deviceInfoMapper.getSearchCategoryTotal(name);
        return new ResultData("success",data,200,total);
    }

    @Override
    public ResultData addCategory(CategoryEntity Category){
        Category.setDel(false);
        Category.setCid("");
//        DeviceInfoEntity.setRole(1);
//        DeviceInfoEntity.setPassword(DeviceInfoEntity.getTelephone());
        Boolean data=deviceInfoMapper.addCategory(Category);
        return new ResultData("success",data,200,0);
    }

    @Override
    public ResultData deleteCategory(CategoryEntity Category){
        Boolean data=deviceInfoMapper.deleteCategory(Category);
        return new ResultData("success",data,200,0);
    }

    @Override
    public ResultData getCategoryOptions(){
        List<CategoryEntity>  data=deviceInfoMapper.getCategoryOptions();
        return new ResultData("success",data,200,0);
    }
}
