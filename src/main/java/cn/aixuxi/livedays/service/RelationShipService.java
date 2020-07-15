package cn.aixuxi.livedays.service;

import cn.aixuxi.livedays.entity.Relationship;
import org.springframework.stereotype.Service;

/**
 * 类描述
 *
 * @author ruozhuliufeng
 * @version 1.0
 * @date 2020/6/6 14:04
 */
public interface RelationShipService {
    Relationship findById(Integer id);

    Integer findRefIdById(Integer id);

    Relationship findByUserId(Integer id);

    void updateById(Relationship relationship);
}
