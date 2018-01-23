package org.wing.dissertation.service;

import org.wing.dissertation.domain.Material;

import java.util.List;

public interface MaterialService {
    Integer addMaterial(Material material);
    List<Material> showAllMaterial(Integer id);
    Material downMaterial(Integer id);
    Integer deleteMaterialById(Integer id);
    Integer updateMaterial(Material material);
}
