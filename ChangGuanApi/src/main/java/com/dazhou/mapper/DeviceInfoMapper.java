package com.dazhou.mapper;

import com.dazhou.entity.CategoryEntity;
import com.dazhou.entity.DeviceInfoEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeviceInfoMapper {
    @Select("select * from deviceinfo order by id asc limit 10 offset #{temp}")
    List<DeviceInfoEntity> getDeviceList(int temp);

    @Select("select count(*) from deviceinfo")
    int getDeviceTotal();

    @Select("select * from deviceinfo where deviceName like concat('%',#{deviceName},'%') and deviceNum like concat('%',#{deviceNum},'%') and category like concat('%',#{category},'%') and deviceIP like concat('%',#{deviceIP},'%') order by id asc limit 10 offset #{temp}")
    List<DeviceInfoEntity> searchDeviceList(String deviceName,String deviceNum,String category,String deviceIP,int temp);

    @Select("select count(*) from deviceinfo where deviceName like concat('%',#{deviceName},'%') and deviceNum like concat('%',#{deviceNum},'%') and category like concat('%',#{category},'%') and deviceIP like concat('%',#{deviceIP},'%')" )
    int getSearchDeviceTotal(String deviceName,String deviceNum,String category,String deviceIP);

    @Insert("insert into deviceinfo(deviceName, deviceNum, deviceIP,category,sceneName, sceneNum,controlName,controlNum,gridName,gridNum,description, remark, isDel) values(#{deviceName},#{deviceNum},#{deviceIP},#{category}," +
            "#{sceneName},#{sceneNum},#{controlName},#{controlNum},#{gridName},#{gridNum},#{description},#{remark},#{isDel})")
    boolean addDevice(DeviceInfoEntity deviceinfo);

    @Delete("delete from deviceinfo where deviceName=#{deviceName} and deviceNum=#{deviceNum}")
    boolean deleteDevice(DeviceInfoEntity deviceinfo);

    @Update("update deviceinfo set deviceName=#{deviceName}, deviceNum=#{deviceNum}, deviceIP=#{deviceIP},category=#{category},sceneName=#{sceneName},sceneNum=#{sceneNum},controlName=#{controlName}, controlNum=#{controlNum},gridName=#{gridName},gridNum=#{gridNum},description=#{description}, remark=#{remark} where id=#{id}")
    boolean updateDevice(DeviceInfoEntity deviceinfo);

    @Select("select * from deviceinfo where isDel=0 order by id asc")
    List<DeviceInfoEntity> getDeviceOptions();

    @Select("select * from category order by id asc limit 10 offset #{temp}")
    List<CategoryEntity> getCategoryList(int temp);

    @Select("select count(*) from category")
    int getCategoryTotal();

    @Select("select * from category where name like concat('%',#{name},'%') order by id asc limit 10 offset #{temp}")
    List<CategoryEntity> searchCategoryList(String name,int temp);

    @Select("select count(*) from category where name like concat('%',#{name},'%')" )
    int getSearchCategoryTotal(String name);

    @Select("select * from category where isDel=0 order by id asc")
    List<CategoryEntity> getCategoryOptions();

    @Insert("insert into category(name, cid, remark, isDel) values(#{name},#{cid},#{remark}, #{isDel})")
    boolean addCategory(CategoryEntity category);

    @Delete("delete from category where name=#{name} and isDel=0")
    boolean deleteCategory(CategoryEntity category);



}
