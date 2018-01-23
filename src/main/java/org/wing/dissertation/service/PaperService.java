package org.wing.dissertation.service;

import org.wing.dissertation.domain.Paper;

/**
 * Created by yeleia on 17-12-17.
 */
public interface PaperService {
    Paper seeMyPaper(Integer id);

    Integer insertPaper(Paper paper);

    Paper selectById(Integer id);

    Integer updatePs(Integer id);

}
