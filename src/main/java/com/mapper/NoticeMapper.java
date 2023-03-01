package com.mapper;

import com.entity.Notice;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoticeMapper {

    @Select("select * from tb_notice order by id desc")
    List<Notice> findAllNotice();

    @Select("select * from tb_notice order by id desc limit 0,4")
    List<Notice> findNoticeByDate();

    @Select("select * from tb_notice where title=#{title}")
    Notice findNoticeByTitle(String title);

    @Select("select * from tb_notice where id=#{id}")
    Notice findNoticeByid(Integer id);

    @Select("select * from tb_notice where id=#{id}")
    List<Notice> findListNoticeByid(Integer id);

    @Delete("delete from tb_notice where id=#{id}")
    void delNotice(Integer id);

    @Insert("insert into tb_notice (title,date,content) values(#{title},#{date},#{content})")
    void insertNotice(@Param("title") String title,@Param("date") String date,@Param("content") String content);

    @Update("update tb_notice set title=#{title},date=#{date},content=#{content} where id=#{id}")
    void updNotice(@Param("title") String title,@Param("date") String date,@Param("content") String content,@Param("id") Integer id);
}
