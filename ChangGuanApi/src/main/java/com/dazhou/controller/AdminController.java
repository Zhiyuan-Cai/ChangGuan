package com.dazhou.controller;

import com.alibaba.fastjson.JSONObject;
import com.dazhou.entity.AdminInfoEntity;
import com.dazhou.entity.ResultData;
import com.dazhou.service.IAdminService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
public class AdminController {
    @Resource
    private IAdminService adminService;

    @RequestMapping(value = "api/admininfo",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ResultData getAdminList(@RequestBody JSONObject jsonObject){

        return  adminService.getAdminList(jsonObject.getString("page"));
    }

    @RequestMapping(value = "api/searchAdmin",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ResultData searchAdminList(@RequestBody JSONObject jsonObject){

        return  adminService.searchAdminList(jsonObject.getString("name"),jsonObject.getString("jobNum"),jsonObject.getString("page"));
    }

    @RequestMapping(value = "api/addAdmin",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ResultData addAdmin(@RequestBody AdminInfoEntity adminInfoEntity){

        return  adminService.addAdmin(adminInfoEntity);
    }

    @RequestMapping(value = "api/deleteAdmin",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ResultData deleteAdmin(@RequestBody AdminInfoEntity adminInfoEntity){

        return  adminService.deleteAdmin(adminInfoEntity);
    }

    @RequestMapping(value = "api/updateAdmin",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ResultData updateAdmin(@RequestBody AdminInfoEntity adminInfoEntity){

        return  adminService.updateAdmin(adminInfoEntity);
    }

    @RequestMapping(value = "api/login",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ResultData login(@RequestBody JSONObject jsonObject){

        return  adminService.login(jsonObject.getString("username"),jsonObject.getString("password"));
    }
}
