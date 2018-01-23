package org.wing.dissertation.service;


import org.wing.dissertation.domain.Menitor;

import java.util.Map;

public interface MenitorService {
    Menitor login(Map map);
    Menitor seeMenitorInfo(Integer id);
    Integer modifyInfo(Menitor menitor);
    Integer updateImage(Menitor menitor);
}
