package org.wing.dissertation.dao;


import org.apache.ibatis.annotations.Mapper;
import org.wing.dissertation.domain.Menitor;

import java.util.Map;
@Mapper
public interface MenitorMapper {
    Menitor selectByMap(Map map);
    Menitor selectById(Integer id);
    Integer updateInfo(Menitor menitor);
    Integer updateImage(Menitor menitor);
}