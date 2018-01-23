package org.wing.dissertation.dao;

import org.apache.ibatis.annotations.Mapper;
import org.wing.dissertation.domain.Paper;
@Mapper
public interface PaperMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Paper record);

    Paper selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Paper record);

    int updateByPrimaryKey(Paper record);

    //自定义
    Paper selectByStudentId(Integer id);
    Integer updatePstatus(Integer id);
}