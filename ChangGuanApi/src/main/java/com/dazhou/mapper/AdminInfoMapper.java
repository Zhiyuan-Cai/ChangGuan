package com.dazhou.mapper;

import com.dazhou.entity.AdminInfoEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminInfoMapper {
    @Select("select * from admininfo order by id asc limit 10 offset #{temp}")
    List<AdminInfoEntity> getAdminList(int temp);

    @Select("select count(*) from admininfo")
    int getAdminTotal();

    @Select("select * from admininfo where name like concat('%',#{name},'%') and jobNum like concat('%',#{jobNum},'%') order by id asc limit 10 offset #{temp}")
    List<AdminInfoEntity> searchAdminList(String name,String jobNum,int temp);

    @Select("select count(*) from admininfo where name like concat('%',#{name},'%') and jobNum like concat('%',#{jobNum},'%')" )
    int getSearchAdminTotal(String name,String jobNum);

    @Insert("insert into admininfo(name, jobNum, sex, telephone, department, post, role, isDel) values(#{name},#{jobNum},#{sex},#{telephone},#{department},#{post},#{role},#{isDel})")
    boolean addAdmin(AdminInfoEntity admininfo);

    @Delete("delete from admininfo where name=#{name} and jobNum=#{jobNum}")
    boolean deleteAdmin(AdminInfoEntity admininfo);

    @Update("update admininfo set name=#{name}, jobNum=#{jobNum}, sex=#{sex}, telephone=#{telephone}, department=#{department}, post=#{post} where id=#{id}")
    boolean updateAdmin(AdminInfoEntity admininfo);

    @Select("select * from admininfo where jobNum=#{jobNum} and password=#{password}")
    AdminInfoEntity getAdminInfo(String jobNum,String password);
}
