package com.dazhou.mapper;

import com.dazhou.entity.GridInfoEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GridInfoMapper {
    @Select("select * from gridinfo order by id asc limit 10 offset #{temp}")
    List<GridInfoEntity> getGridList(int temp);

    @Select("select count(*) from gridinfo")
    int getGridTotal();

    @Select("select * from gridinfo where name like concat('%',#{name},'%') and gridNum like concat('%',#{gridNum},'%') order by id asc limit 10 offset #{temp}")
    List<GridInfoEntity> searchGridList(String name,String gridNum,int temp);

    @Select("select count(*) from gridinfo where name like concat('%',#{name},'%') and gridNum like concat('%',#{gridNum},'%')" )
    int getSearchGridTotal(String name,String gridNum);

    @Insert("insert into gridinfo(name, gridNum, description, remark, isDel) values(#{name},#{gridNum},#{description},#{remark},#{isDel})")
    boolean addGrid(GridInfoEntity Gridinfo);

    @Delete("delete from gridinfo where name=#{name} and gridNum=#{gridNum}")
    boolean deleteGrid(GridInfoEntity Gridinfo);

    @Update("update gridinfo set name=#{name}, gridNum=#{gridNum}, description=#{description}, remark=#{remark} where id=#{id}")
    boolean updateGrid(GridInfoEntity Gridinfo);

    @Select("select * from gridinfo where isDel=0 order by id asc")
    List<GridInfoEntity> getGridOptions();

}
