package cn.aixuxi.livedays.mapper;

import cn.aixuxi.livedays.entity.Relationship;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 类描述
 *
 * @author ruozhuliufeng
 * @version 1.0
 * @date 2020/6/6 14:00
 */
public interface RelationshipMapper extends BaseMapper<Relationship> {
    /**
     * 功能描述: 根据id获取另一位的ID
     * @param id 获取到的id
     * @return : 另一位的id
     * @author : ruozhuliufeng
     * @date : 2020/6/7 22:02
     */
    Integer findRefIdById(Integer id);

    /**
     * 功能描述: 根据id获取数据
     * @param id 需要的id
     * @return : Relationship实体类
     * @author : ruozhuliufeng
     * @date : 2020/6/7 22:22
     */
    Relationship findByUserId(Integer id);
}
