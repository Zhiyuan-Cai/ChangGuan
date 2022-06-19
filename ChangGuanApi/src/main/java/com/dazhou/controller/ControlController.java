package com.dazhou.controller;


import com.alibaba.fastjson.JSONObject;
import com.dazhou.entity.ControlInfoEntity;
import com.dazhou.entity.ResultData;
import com.dazhou.service.IControlService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
public class ControlController {
    @Resource
    private IControlService ControlService;

    @RequestMapping(value = "api/controlinfo", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ResultData getControlList(@RequestBody JSONObject jsonObject) {

        return ControlService.getControlList(jsonObject.getString("page"));
    }

    @RequestMapping(value = "api/searchControl", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ResultData searchControlList(@RequestBody JSONObject jsonObject) {

        return ControlService.searchControlList(jsonObject.getString("controlName").trim(), jsonObject.getString("controlNum").trim(), jsonObject.getString("page"));
    }

    @RequestMapping(value = "api/addControl", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ResultData addControl(@RequestBody ControlInfoEntity ControlInfoEntity) {

        return ControlService.addControl(ControlInfoEntity);
    }

    @RequestMapping(value = "api/deleteControl", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ResultData deleteControl(@RequestBody ControlInfoEntity ControlInfoEntity) {

        return ControlService.deleteControl(ControlInfoEntity);
    }

    @RequestMapping(value = "api/updateControl", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ResultData updateControl(@RequestBody ControlInfoEntity ControlInfoEntity) {

        return ControlService.updateControl(ControlInfoEntity);
    }

    @RequestMapping(value = "api/getControlOptions", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public ResultData getControlOptions() {

        return ControlService.getControlOptions();
    }

}
