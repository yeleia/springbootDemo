package org.wing.dissertation.service.serviceImpl;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wing.dissertation.dao.MenitorMapper;
import org.wing.dissertation.domain.Menitor;
import org.wing.dissertation.service.MenitorService;

import java.util.Map;

@Service("menitorService")
public class MenitorServiceImpl implements MenitorService {
    @Autowired
    private MenitorMapper menitorMapper;
    @Override
    public Menitor login(Map map) {
        System.out.println("Monitor");
        return menitorMapper.selectByMap(map);
    }

    @Override
    public Menitor seeMenitorInfo(Integer id) {
        return menitorMapper.selectById(id);
    }

    @Override
    public Integer modifyInfo(Menitor menitor) {
        return menitorMapper.updateInfo(menitor);
    }

    @Override
    public Integer updateImage(Menitor menitor) {
        return menitorMapper.updateImage(menitor);
    }

}
