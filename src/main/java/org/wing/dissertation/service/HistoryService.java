package org.wing.dissertation.service;

import org.wing.dissertation.domain.History;

import java.util.List;

/**
 * Created by yeleia on 17-12-17.
 */
public interface HistoryService {
    List<History> seeHistory(Integer id);
    Integer insertHistory(History history);
}
