package com.dazhou.service.impl;

import com.dazhou.entity.SceneInfoEntity;
import com.dazhou.entity.ResultData;
import com.dazhou.mapper.SceneInfoMapper;
import com.dazhou.service.ISceneService;
import com.dazhou.utils.CreateJWT;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SceneServiceImpl implements ISceneService {
    @Resource
    private SceneInfoMapper sceneInfoMapper;

    @Override
    public ResultData getSceneList(String page){
        int temp=(Integer.parseInt(page.trim())-1)*10;
        List<SceneInfoEntity> data=sceneInfoMapper.getSceneList(temp);
        int total = sceneInfoMapper.getSceneTotal();
        return new ResultData("success",data,200,total);
    }

    @Override
    public ResultData searchSceneList(String name,String SceneNum,String page){
        int temp=(Integer.parseInt(page.trim())-1)*10;
        List<SceneInfoEntity> data=sceneInfoMapper.searchSceneList(name,SceneNum,temp);
        int total = sceneInfoMapper.getSearchSceneTotal(name,SceneNum);
        return new ResultData("success",data,200,total);
    }

    @Override
    public ResultData addScene(SceneInfoEntity SceneInfoEntity){
        SceneInfoEntity.setDel(false);
//        SceneInfoEntity.setRole(1);
//        SceneInfoEntity.setPassword(SceneInfoEntity.getTelephone());
        Boolean data=sceneInfoMapper.addScene(SceneInfoEntity);
        return new ResultData("success",data,200,0);
    }

    @Override
    public ResultData deleteScene(SceneInfoEntity SceneInfoEntity){
        Boolean data=sceneInfoMapper.deleteScene(SceneInfoEntity);
        return new ResultData("success",data,200,0);
    }

    @Override
    public ResultData updateScene(SceneInfoEntity SceneInfoEntity){
        Boolean data=sceneInfoMapper.updateScene(SceneInfoEntity);
        return new ResultData("success",data,200,0);
    }

    @Override
    public ResultData getSceneOptions(){
        List<SceneInfoEntity>  data=sceneInfoMapper.getSceneOptions();
        return new ResultData("success",data,200,0);
    }

}
