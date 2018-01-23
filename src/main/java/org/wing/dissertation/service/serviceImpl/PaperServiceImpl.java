package org.wing.dissertation.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wing.dissertation.dao.PaperMapper;
import org.wing.dissertation.domain.Paper;
import org.wing.dissertation.service.PaperService;

/**
 * Created by yeleia on 17-12-17.
 */
@Service("paperService")
public class PaperServiceImpl implements PaperService {
    @Autowired
    private PaperMapper paperMapper;
    /**
     * 学生查看自己的论文
     * @param id
     * @return
     */
    @Override
    public Paper seeMyPaper(Integer id) {
        return paperMapper.selectByStudentId(id);
    }

    /**
     * 学生上传论文
     * @param paper
     * @return
     */
    @Override
    public Integer insertPaper(Paper paper) {
        return paperMapper.insert(paper);
    }

    /**
     * 下载论文
     * @param id
     * @return
     */
    @Override
    public Paper selectById(Integer id) {
        return paperMapper.selectByPrimaryKey(id);
    }

    /**
     * 阅
     * @param id
     * @return
     */
    @Override
    public Integer updatePs(Integer id) {
        return paperMapper.updatePstatus(id);
    }
}
