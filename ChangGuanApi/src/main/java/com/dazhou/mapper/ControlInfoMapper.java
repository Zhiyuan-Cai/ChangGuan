package com.dazhou.mapper;

import com.dazhou.entity.ControlInfoEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ControlInfoMapper {
    @Select("select * from controlinfo order by id asc limit 10 offset #{temp}")
    List<ControlInfoEntity> getControlList(int temp);

    @Select("select count(*) from controlinfo")
    int getControlTotal();

    @Select("select * from controlinfo where controlName like concat('%',#{controlName},'%') and controlNum like concat('%',#{controlNum},'%') order by id asc limit 10 offset #{temp}")
    List<ControlInfoEntity> searchControlList(String controlName,String controlNum,int temp);

    @Select("select count(*) from controlinfo where controlName like concat('%',#{controlName},'%') and controlNum like concat('%',#{controlNum},'%')" )
    int getSearchControlTotal(String controlName,String controlNum);

    @Insert("insert into controlinfo(controlName, controlNum, gridName,gridNum,description, remark, isDel) values(#{controlName},#{controlNum},#{gridName},#{gridNum},#{description},#{remark},#{isDel})")
    boolean addControl(ControlInfoEntity controlinfo);

    @Delete("delete from controlinfo where controlName=#{controlName} and controlNum=#{controlNum}")
    boolean deleteControl(ControlInfoEntity controlinfo);

    @Update("update controlinfo set controlName=#{controlName}, controlNum=#{controlNum}, gridName=#{gridName},gridNum=#{gridNum},description=#{description}, remark=#{remark} where id=#{id}")
    boolean updateControl(ControlInfoEntity controlinfo);

    @Select("select * from controlinfo where isDel=0 order by id asc")
    List<ControlInfoEntity> getControlOptions();

}
