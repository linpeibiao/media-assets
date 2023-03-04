package com.xiaohu.media_assets.model.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 策略表
 * @TableName t_strategy
 */
@TableName(value ="t_strategy")
@Data
public class Strategy implements Serializable {
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 策略名称
     */
    @TableField(value = "strategy_name")
    private String strategyName;

    /**
     * 描述/规则
     */
    @TableField(value = "description")
    private String description;

    /**
     * 角色要求
     */
    @TableField(value = "role")
    private String role;

    /**
     * 时间要求
     */
    @TableField(value = "time_require")
    private Date timeRequire;

    /**
     * 其他环境要求
     */
    @TableField(value = "outher")
    private String outher;

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
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 逻辑删除
     */
    @JsonIgnore
    @ApiModelProperty(value = "逻辑删除")
    @TableField(value = "is_deleted", fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDeleted;

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

    /**
     * 乐观锁
     */
    @JsonIgnore
    @ApiModelProperty(value = "乐观锁")
    @TableField(value = "version", fill = FieldFill.INSERT)
    @Version
    private Integer version;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}