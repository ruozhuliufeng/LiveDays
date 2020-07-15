package cn.aixuxi.livedays.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 类描述 关系绑定表
 *
 * @author ruozhuliufeng
 * @version 1.0
 * @date 2020/6/6 13:53
 */
@Data
@TableName("relationship")
public class Relationship {
    /**
     * 指定自增策略
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer userRefId;
    private Integer status;//双方状态 1 在黑名单中 0 正常
}
