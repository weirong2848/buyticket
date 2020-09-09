package com.mapper;

import com.entity.BuyUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BuyUserMapper {
//    INSERT(idnumber,5,10,'****') AS phoneNum
    @Select("select name,phone,idnumber from tb_buyuser where username = #{username}")
    List<BuyUser> findBuyUserByUsername(String username);

    @Select("select * from tb_buyuser where username = #{username} and idnumber = #{idnumber}")
    BuyUser findBuyUserByUsernameAndIdnumber(@Param("idnumber") String idnumber,@Param("username") String username);

    @Insert("insert into tb_buyuser (idnumber,name,phone,username)values(#{idnumber},#{name},#{phone},#{username})")
    void insertBuyUser(BuyUser buyUser);

    @Update("update tb_buyuser set idnumber=#{idnumber},name = #{name},phone=#{phone} where idnumber= #{idnumber} and username = #{username}")
    void updateBuyUser(@Param("idnumber") String idnumber,@Param("name") String name,@Param("phone") String phone, @Param("username") String username);

    @Delete("delete from tb_buyuser where idnumber=#{idnumber} and username=#{username}")
    void deleteBuyUser(@Param("idnumber") String idnumber, @Param("username") String username);
}
