package com.service.impl;

import com.entity.Notice;
import com.mapper.NoticeMapper;
import com.service.NoticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("notiiceSerVice")
public class NoticeServiceImpl implements NoticeService {

    @Resource
    private NoticeMapper noticeMapper;

    @Override
    public List<Notice> findAllNotice() {
        return noticeMapper.findAllNotice();
    }

    @Override
    public List<Notice> findNoticeByDate() {
        return noticeMapper.findNoticeByDate();
    }

    @Override
    public Notice findNoticeByTitle(String title) {
        return noticeMapper.findNoticeByTitle(title);
    }

    @Override
    public Notice findNoticeByid(Integer id) {
        return noticeMapper.findNoticeByid(id);
    }

    @Override
    public List<Notice> findListNoticeByid(Integer id) {
        return noticeMapper.findListNoticeByid(id);
    }

    @Override
    public void delNotice(Integer id) {
        noticeMapper.delNotice(id);
    }

    @Override
    public void insertNotice(String title, String date, String content) {
        noticeMapper.insertNotice(title,date,content);
    }

    @Override
    public void updNotice(String title, String date, String content,Integer id) {
        noticeMapper.updNotice(title, date, content, id);
    }
}
