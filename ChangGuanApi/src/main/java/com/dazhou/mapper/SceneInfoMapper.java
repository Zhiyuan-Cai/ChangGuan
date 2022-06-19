package com.dazhou.mapper;

import com.dazhou.entity.SceneInfoEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SceneInfoMapper {
    @Select("select * from sceneinfo order by id asc limit 10 offset #{temp}")
    List<SceneInfoEntity> getSceneList(int temp);

    @Select("select count(*) from sceneinfo")
    int getSceneTotal();

    @Select("select * from sceneinfo where sceneName like concat('%',#{sceneName},'%') and sceneNum like concat('%',#{sceneNum},'%') order by id asc limit 10 offset #{temp}")
    List<SceneInfoEntity> searchSceneList(String sceneName,String sceneNum,int temp);

    @Select("select count(*) from sceneinfo where sceneName like concat('%',#{sceneName},'%') and sceneNum like concat('%',#{sceneNum},'%')" )
    int getSearchSceneTotal(String sceneName,String sceneNum);

    @Insert("insert into sceneinfo(sceneName, sceneNum, controlName,controlNum,gridName,gridNum,description, remark, isDel) values(#{sceneName},#{sceneNum},#{controlName},#{controlNum},#{gridName},#{gridNum},#{description},#{remark},#{isDel})")
    boolean addScene(SceneInfoEntity sceneinfo);

    @Delete("delete from sceneinfo where sceneName=#{sceneName} and sceneNum=#{sceneNum}")
    boolean deleteScene(SceneInfoEntity sceneinfo);

    @Update("update sceneinfo set sceneName=#{sceneName}, sceneNum=#{sceneNum}, controlName=#{controlName}, controlNum=#{controlNum},gridName=#{gridName},gridNum=#{gridNum},description=#{description}, remark=#{remark} where id=#{id}")
    boolean updateScene(SceneInfoEntity sceneinfo);

    @Select("select * from sceneinfo where isDel=0 order by id asc")
    List<SceneInfoEntity> getSceneOptions();

}
