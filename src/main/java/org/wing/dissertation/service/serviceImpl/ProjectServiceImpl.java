package org.wing.dissertation.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wing.dissertation.dao.ProjectMapper;
import org.wing.dissertation.domain.Project;
import org.wing.dissertation.service.ProjectService;

import java.util.List;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    /**
     * 添加课题
     * @param project
     * @return
     */
    @Override
    public Integer addProject(Project project) {
        return projectMapper.insertSelective(project);
    }

    /**
     * 查询所有的课题
     * @return
     */
    @Override
    public List<Project> selectAll(Integer id) {
        return projectMapper.selectAll(id);
    }

    /**
     * 下载课题文档
     * @param id
     * @return
     */
    @Override
    public Project down(Integer id) {
        return projectMapper.selectById(id);
    }

    /**
     * 修改课题
     * @param project
     * @return
     */
    @Override
    public Integer updateById(Project project) {
        return projectMapper.updateById(project);
    }

    /**
     * 删除课题
     * @param id
     * @return
     */
    @Override
    public Integer deleteById(Integer id) {
        return projectMapper.deleteById(id);
    }

    /**
     * 更系状态
     * @param id
     * @return
     */
    @Override
    public Integer updateStatus(Integer id) {
        return projectMapper.updateStatus(id);
    }

    /**
     * 更新状态为0
     * @param id
     * @return
     */
    @Override
    public Integer updateStatus0(Integer id) {
        return projectMapper.updateStatus0(id);
    }
}
