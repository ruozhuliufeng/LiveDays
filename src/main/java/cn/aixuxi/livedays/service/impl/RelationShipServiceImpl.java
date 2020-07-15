package cn.aixuxi.livedays.service.impl;

import cn.aixuxi.livedays.entity.Relationship;
import cn.aixuxi.livedays.mapper.RelationshipMapper;
import cn.aixuxi.livedays.service.RelationShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 类描述
 *
 * @author ruozhuliufeng
 * @version 1.0
 * @date 2020/6/6 18:07
 */
@Service
public class RelationShipServiceImpl implements RelationShipService {

    @Autowired
    private RelationshipMapper relationShipMapper;
    @Override
    public Relationship findById(Integer id) {
        return relationShipMapper.findByUserId(id);
    }

    @Override
    public Integer findRefIdById(Integer id) {
        return relationShipMapper.findRefIdById(id);
    }

    @Override
    public Relationship findByUserId(Integer id) {
        return relationShipMapper.findByUserId(id);
    }

    @Override
    public void updateById(Relationship relationship) {
        relationShipMapper.updateById(relationship);
    }
}
