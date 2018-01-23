package org.wing.dissertation.dao;

import org.apache.ibatis.annotations.Mapper;
import org.wing.dissertation.domain.Material;

import java.util.List;

@Mapper
public interface MaterialMapper {

    int insert(Material record);

    int insertSelective(Material record);

    List<Material> selectByMenitorId(Integer id);

    Material selectById(Integer id);

    Integer deleteById(Integer id);

    Integer updateMaterial(Material material);
}