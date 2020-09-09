package com.mapper;

import com.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Insert("insert into tb_user(email,username,password,idnumber,name,phone,integral,isadmin)values(#{email},#{username},#{password},#{idnumber},#{name},#{phone},#{integral},#{isadmin})")
    void insertUser(User user);

    @Select("select * from tb_user where email=#{email}")
    User selectUserByEmail(String email);

    @Select("select * from tb_user where username=#{username}")
    User selectUserByUsername(String username);

    @Select("select * from tb_user where idnumber=#{ idnumber}")
    User selectUserByIdNum(String idnumber);

    @Update("update tb_user set password=#{password} where username=#{username}")
    void updatePassword(@Param("username")String username,@Param("password") String password);

}
