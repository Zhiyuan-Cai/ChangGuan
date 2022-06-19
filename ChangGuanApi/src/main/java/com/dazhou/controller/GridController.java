package com.dazhou.controller;


import com.alibaba.fastjson.JSONObject;
import com.dazhou.entity.GridInfoEntity;
import com.dazhou.entity.ResultData;
import com.dazhou.service.IGridService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
public class GridController {
    @Resource
    private IGridService GridService;

    @RequestMapping(value = "api/gridinfo", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ResultData getGridList(@RequestBody JSONObject jsonObject) {

        return GridService.getGridList(jsonObject.getString("page"));
    }

    @RequestMapping(value = "api/searchGrid", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ResultData searchGridList(@RequestBody JSONObject jsonObject) {

        return GridService.searchGridList(jsonObject.getString("name"), jsonObject.getString("gridNum"), jsonObject.getString("page"));
    }

    @RequestMapping(value = "api/addGrid", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ResultData addGrid(@RequestBody GridInfoEntity GridInfoEntity) {

        return GridService.addGrid(GridInfoEntity);
    }

    @RequestMapping(value = "api/deleteGrid", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ResultData deleteGrid(@RequestBody GridInfoEntity GridInfoEntity) {

        return GridService.deleteGrid(GridInfoEntity);
    }

    @RequestMapping(value = "api/updateGrid", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ResultData updateGrid(@RequestBody GridInfoEntity GridInfoEntity) {

        return GridService.updateGrid(GridInfoEntity);
    }

    @RequestMapping(value = "api/getGridOptions", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public ResultData getGridOptions() {

        return GridService.getGridOptions();
    }

}
