package com.dazhou.controller;


import com.alibaba.fastjson.JSONObject;
import com.dazhou.entity.SceneInfoEntity;
import com.dazhou.entity.SceneInfoEntity;
import com.dazhou.entity.SceneInfoEntity;
import com.dazhou.entity.ResultData;
import com.dazhou.service.ISceneService;
import com.dazhou.service.ISceneService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
public class SceneController {
    @Resource
    private ISceneService sceneService;

    @RequestMapping(value = "api/sceneinfo", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ResultData getSceneList(@RequestBody JSONObject jsonObject) {

        return sceneService.getSceneList(jsonObject.getString("page"));
    }

    @RequestMapping(value = "api/searchScene", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ResultData searchSceneList(@RequestBody JSONObject jsonObject) {

        return sceneService.searchSceneList(jsonObject.getString("sceneName").trim(), jsonObject.getString("sceneNum").trim(), jsonObject.getString("page"));
    }

    @RequestMapping(value = "api/addScene", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ResultData addScene(@RequestBody SceneInfoEntity SceneInfoEntity) {

        return sceneService.addScene(SceneInfoEntity);
    }

    @RequestMapping(value = "api/deleteScene", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ResultData deleteScene(@RequestBody SceneInfoEntity SceneInfoEntity) {

        return sceneService.deleteScene(SceneInfoEntity);
    }

    @RequestMapping(value = "api/updateScene", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ResultData updateScene(@RequestBody SceneInfoEntity SceneInfoEntity) {

        return sceneService.updateScene(SceneInfoEntity);
    }

    @RequestMapping(value = "api/getSceneOptions", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public ResultData getSceneOptions() {

        return sceneService.getSceneOptions();
    }

}
