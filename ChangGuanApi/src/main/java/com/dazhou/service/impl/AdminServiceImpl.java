package com.dazhou.service.impl;

import com.dazhou.entity.AdminInfoEntity;
import com.dazhou.entity.ResultData;
import com.dazhou.mapper.AdminInfoMapper;
import com.dazhou.service.IAdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import com.dazhou.utils.CreateJWT;

@Service
public class AdminServiceImpl implements IAdminService {
    @Resource
    private AdminInfoMapper adminInfoMapper;

    @Override
    public ResultData getAdminList(String page){
        int temp=(Integer.parseInt(page.trim())-1)*10;
        List<AdminInfoEntity> data=adminInfoMapper.getAdminList(temp);
        int total = adminInfoMapper.getAdminTotal();
        return new ResultData("success",data,200,total);
    }

    @Override
    public ResultData searchAdminList(String name,String jobNum,String page){
        int temp=(Integer.parseInt(page.trim())-1)*10;
        List<AdminInfoEntity> data=adminInfoMapper.searchAdminList(name,jobNum,temp);
        int total = adminInfoMapper.getSearchAdminTotal(name,jobNum);
        return new ResultData("success",data,200,total);
    }

    @Override
    public ResultData addAdmin(AdminInfoEntity adminInfoEntity){
        adminInfoEntity.setDel(false);
        adminInfoEntity.setRole(1);
        adminInfoEntity.setPassword(adminInfoEntity.getTelephone());
        Boolean data=adminInfoMapper.addAdmin(adminInfoEntity);
        return new ResultData("success",data,200,0);
    }

    @Override
    public ResultData deleteAdmin(AdminInfoEntity adminInfoEntity){
        Boolean data=adminInfoMapper.deleteAdmin(adminInfoEntity);
        return new ResultData("success",data,200,0);
    }

    @Override
    public ResultData updateAdmin(AdminInfoEntity adminInfoEntity){
        Boolean data=adminInfoMapper.updateAdmin(adminInfoEntity);
        return new ResultData("success",data,200,0);
    }

    @Override
    public ResultData login(String username,String password){
        AdminInfoEntity adminInfo = adminInfoMapper.getAdminInfo(username,password);
        String token="";
        if(adminInfo!=null){
            token = CreateJWT.getToken(adminInfo);
        }
        return new ResultData("success",token,200,0);
    }
}
