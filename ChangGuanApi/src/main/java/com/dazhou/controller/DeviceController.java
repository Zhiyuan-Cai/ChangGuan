package com.dazhou.controller;


import com.alibaba.fastjson.JSONObject;
import com.dazhou.entity.*;
import com.dazhou.entity.DeviceInfoEntity;
import com.dazhou.entity.DeviceInfoEntity;
import com.dazhou.service.IDeviceService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
public class DeviceController {
    @Resource
    private IDeviceService deviceService;

    @RequestMapping(value = "api/deviceinfo", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ResultData getDeviceList(@RequestBody JSONObject jsonObject) {

        return deviceService.getDeviceList(jsonObject.getString("page"));
    }

    @RequestMapping(value = "api/searchDevice", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ResultData searchDeviceList(@RequestBody JSONObject jsonObject) {

        return deviceService.searchDeviceList(jsonObject.getString("deviceName").trim(), jsonObject.getString("deviceNum").trim(),
                jsonObject.getString("category").trim(),jsonObject.getString("deviceIP").trim(),jsonObject.getString("page"));
    }

    @RequestMapping(value = "api/addDevice", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ResultData addDevice(@RequestBody DeviceInfoEntity DeviceInfoEntity) {

        return deviceService.addDevice(DeviceInfoEntity);
    }

    @RequestMapping(value = "api/deleteDevice", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ResultData deleteDevice(@RequestBody DeviceInfoEntity DeviceInfoEntity) {

        return deviceService.deleteDevice(DeviceInfoEntity);
    }

    @RequestMapping(value = "api/updateDevice", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ResultData updateDevice(@RequestBody DeviceInfoEntity DeviceInfoEntity) {

        return deviceService.updateDevice(DeviceInfoEntity);
    }

    @RequestMapping(value = "api/getDeviceOptions", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public ResultData getDeviceOptions() {

        return deviceService.getDeviceOptions();
    }

    @RequestMapping(value = "api/category", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ResultData getCategoryList(@RequestBody JSONObject jsonObject) {

        return deviceService.getCategoryList(jsonObject.getString("page"));
    }

    @RequestMapping(value = "api/searchCategory", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ResultData searchCategoryList(@RequestBody JSONObject jsonObject) {

        return deviceService.searchCategoryList(jsonObject.getString("name").trim(),jsonObject.getString("page"));
    }

    @RequestMapping(value = "api/addCategory", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ResultData addDevice(@RequestBody CategoryEntity Category) {

        return deviceService.addCategory(Category);
    }

    @RequestMapping(value = "api/deleteCategory", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ResultData deleteDevice(@RequestBody CategoryEntity Category) {

        return deviceService.deleteCategory(Category);
    }

    @RequestMapping(value = "api/getCategoryOptions", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public ResultData getCategoryOptions() {

        return deviceService.getCategoryOptions();
    }
}
