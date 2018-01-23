package org.wing.dissertation.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wing.dissertation.dao.MaterialMapper;
import org.wing.dissertation.domain.Material;
import org.wing.dissertation.service.MaterialService;

import java.util.List;

@Service("materialService")
public class MaterialServiceImpl implements MaterialService {
    @Autowired
    private MaterialMapper materialMapper;

    /**
     * 添加资源
     * @param material
     * @return
     */
    @Override
    public Integer addMaterial(Material material) {
        return materialMapper.insertSelective(material);
    }

    /**
     * 查询该导师发布的所有资源
     * @param id
     * @return
     */
    @Override
    public List<Material> showAllMaterial(Integer id) {
        return materialMapper.selectByMenitorId(id);
    }

    /**
     * 下载资源
     * @param id
     * @return
     */
    @Override
    public Material downMaterial(Integer id) {
        return materialMapper.selectById(id);
    }

    /**
     * 根据id删除资源
     * @param id
     * @return
     */
    @Override
    public Integer deleteMaterialById(Integer id) {
        return materialMapper.deleteById(id);
    }

    /**
     * 根据id修改资源
     * @param material
     * @return
     */
    @Override
    public Integer updateMaterial(Material material) {
        return materialMapper.updateMaterial(material);
    }
}
