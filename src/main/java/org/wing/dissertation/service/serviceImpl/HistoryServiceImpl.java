package org.wing.dissertation.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wing.dissertation.dao.HistoryMapper;
import org.wing.dissertation.domain.History;
import org.wing.dissertation.service.HistoryService;

import java.util.List;

/**
 * Created by yeleia on 17-12-17.
 */
@Service("historyService")
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    private HistoryMapper historyMapper;

    /**
     * 学生查看论文历史记录
     * @param id
     * @return
     */
    @Override
    public List<History> seeHistory(Integer id) {
        return historyMapper.selectByPaperId(id);
    }

    /**
     * 添加记录
     * @param history
     * @return
     */
    @Override
    public Integer insertHistory(History history) {
        return historyMapper.insert(history);
    }
}
