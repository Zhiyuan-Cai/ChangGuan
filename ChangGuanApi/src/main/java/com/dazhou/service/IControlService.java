package com.dazhou.service;

import com.dazhou.entity.ControlInfoEntity;
import com.dazhou.entity.ResultData;

public interface IControlService {
    ResultData getControlList(String page);

    ResultData searchControlList(String name,String jobnum,String page);

    ResultData addControl(ControlInfoEntity ControlInfoEntity);

    ResultData deleteControl(ControlInfoEntity ControlInfoEntity);

    ResultData updateControl(ControlInfoEntity ControlInfoEntity);

    ResultData getControlOptions();

}
