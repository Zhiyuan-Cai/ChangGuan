package com.dazhou.service;

import com.dazhou.entity.CategoryEntity;
import com.dazhou.entity.DeviceInfoEntity;
import com.dazhou.entity.ResultData;

public interface IDeviceService {
    ResultData getDeviceList(String page);

    ResultData searchDeviceList(String name,String jobnum,String category,String deviceIP,String page);

    ResultData addDevice(DeviceInfoEntity DeviceInfoEntity);

    ResultData deleteDevice(DeviceInfoEntity DeviceInfoEntity);

    ResultData updateDevice(DeviceInfoEntity DeviceInfoEntity);

    ResultData getDeviceOptions();

    ResultData getCategoryList(String page);

    ResultData searchCategoryList(String name,String page);

    ResultData addCategory(CategoryEntity Category);

    ResultData deleteCategory(CategoryEntity Category);

    ResultData getCategoryOptions();

}
