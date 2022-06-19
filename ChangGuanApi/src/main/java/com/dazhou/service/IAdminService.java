package com.dazhou.service;

import com.dazhou.entity.AdminInfoEntity;
import com.dazhou.entity.ResultData;
import com.dazhou.mapper.AdminInfoMapper;

import java.util.List;

public interface IAdminService {

    ResultData getAdminList(String page);

    ResultData searchAdminList(String name,String jobnum,String page);

    ResultData addAdmin(AdminInfoEntity adminInfoEntity);

    ResultData deleteAdmin(AdminInfoEntity adminInfoEntity);

    ResultData updateAdmin(AdminInfoEntity adminInfoEntity);

    ResultData login(String username,String password);

}
