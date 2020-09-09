package com.service;

import com.entity.Notice;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface NoticeService {

    public List<Notice> findAllNotice();

    public  List<Notice> findNoticeByDate();

    public Notice findNoticeByTitle(String title);

    public Notice findNoticeByid(Integer id);

    public List<Notice> findListNoticeByid(Integer id);

    public void delNotice(Integer id);

    public void insertNotice(String title,String date,String content);

    public void updNotice(String title,String date,String content,Integer id);
}
