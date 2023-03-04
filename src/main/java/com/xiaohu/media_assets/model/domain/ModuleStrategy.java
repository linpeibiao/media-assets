package com.xiaohu.media_assets.model.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 板块--策略关系表
 * @TableName t_module_strategy
 */
@TableName(value ="t_module_strategy")
@Data
public class ModuleStrategy implements Serializable {
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 板块id
     */
    @TableField(value = "module_id")
    private Long moduleId;

    /**
     * 策略id
     */
    @TableField(value = "strategy_id")
    private Long strategyId;

    /**
     * 备用字段1
     */
    @TableField(value = "backup1")
    private String backup1;

    /**
     * 备用字段2
     */
    @TableField(value = "backup2")
    private String backup2;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @JsonIgnore
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    @JsonIgnore
    private Date updateTime;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}