package com.dazhou.service;

import com.dazhou.entity.SceneInfoEntity;
import com.dazhou.entity.ResultData;

public interface ISceneService {
    ResultData getSceneList(String page);

    ResultData searchSceneList(String name,String jobnum,String page);

    ResultData addScene(SceneInfoEntity SceneInfoEntity);

    ResultData deleteScene(SceneInfoEntity SceneInfoEntity);

    ResultData updateScene(SceneInfoEntity SceneInfoEntity);

    ResultData getSceneOptions();

}
