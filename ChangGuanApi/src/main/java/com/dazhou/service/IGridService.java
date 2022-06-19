package com.dazhou.service;

import com.dazhou.entity.GridInfoEntity;
import com.dazhou.entity.ResultData;

public interface IGridService {
    ResultData getGridList(String page);

    ResultData searchGridList(String name,String jobnum,String page);

    ResultData addGrid(GridInfoEntity GridInfoEntity);

    ResultData deleteGrid(GridInfoEntity GridInfoEntity);

    ResultData updateGrid(GridInfoEntity GridInfoEntity);

    ResultData getGridOptions();

}
