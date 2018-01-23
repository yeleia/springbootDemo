package org.wing.dissertation.service;

import org.wing.dissertation.domain.Project;

import java.util.List;

public interface ProjectService {
    Integer addProject(Project project);
    List<Project> selectAll(Integer id);
    Project down(Integer id);
    Integer updateById(Project project);
    Integer deleteById(Integer id);
    Integer updateStatus(Integer id);
    Integer updateStatus0(Integer id);
}
