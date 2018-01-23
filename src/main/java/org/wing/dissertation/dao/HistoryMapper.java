package org.wing.dissertation.dao;

import org.apache.ibatis.annotations.Mapper;
import org.wing.dissertation.domain.History;

import java.util.List;
@Mapper
public interface HistoryMapper {
    int deleteByPrimaryKey(Integer id);



    int insertSelective(History record);

    History selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(History record);

    int updateByPrimaryKey(History record);
    //自定义
    List<History> selectByPaperId(Integer id);
    int insert(History record);
}