package org.wing.dissertation.dao;

import org.apache.ibatis.annotations.Mapper;
import org.wing.dissertation.domain.Project;

import java.util.List;
@Mapper
public interface ProjectMapper {

    int insertSelective(Project record);
    List<Project> selectAll(Integer id);
    Project selectById(Integer id);
    Integer updateById(Project project);
    Integer deleteById(Integer id);
    Integer updateStatus(Integer id);
    Integer updateStatus0(Integer id);



}