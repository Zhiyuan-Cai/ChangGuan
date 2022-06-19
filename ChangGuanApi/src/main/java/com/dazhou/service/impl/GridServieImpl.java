package com.dazhou.service.impl;

import com.dazhou.entity.GridInfoEntity;
import com.dazhou.entity.ResultData;
import com.dazhou.mapper.GridInfoMapper;
import com.dazhou.service.IGridService;
import com.dazhou.utils.CreateJWT;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GridServieImpl implements IGridService {
    @Resource
    private GridInfoMapper GridInfoMapper;

    @Override
    public ResultData getGridList(String page){
        int temp=(Integer.parseInt(page.trim())-1)*10;
        List<GridInfoEntity> data=GridInfoMapper.getGridList(temp);
        int total = GridInfoMapper.getGridTotal();
        return new ResultData("success",data,200,total);
    }

    @Override
    public ResultData searchGridList(String name,String gridNum,String page){
        int temp=(Integer.parseInt(page.trim())-1)*10;
        List<GridInfoEntity> data=GridInfoMapper.searchGridList(name,gridNum,temp);
        int total = GridInfoMapper.getSearchGridTotal(name,gridNum);
        return new ResultData("success",data,200,total);
    }

    @Override
    public ResultData addGrid(GridInfoEntity GridInfoEntity){
        GridInfoEntity.setDel(false);
//        GridInfoEntity.setRole(1);
//        GridInfoEntity.setPassword(GridInfoEntity.getTelephone());
        Boolean data=GridInfoMapper.addGrid(GridInfoEntity);
        return new ResultData("success",data,200,0);
    }

    @Override
    public ResultData deleteGrid(GridInfoEntity GridInfoEntity){
        Boolean data=GridInfoMapper.deleteGrid(GridInfoEntity);
        return new ResultData("success",data,200,0);
    }

    @Override
    public ResultData updateGrid(GridInfoEntity GridInfoEntity){
        Boolean data=GridInfoMapper.updateGrid(GridInfoEntity);
        return new ResultData("success",data,200,0);
    }

    @Override
    public ResultData getGridOptions(){
        List<GridInfoEntity>  data=GridInfoMapper.getGridOptions();
        return new ResultData("success",data,200,0);
    }

}
