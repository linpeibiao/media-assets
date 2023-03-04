package com.xiaohu.media_assets.model.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 板块表
 * @TableName t_module
 */
@TableName(value ="t_module")
@Data
public class Module implements Serializable {
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 板块名称
     */
    @TableField(value = "module_name")
    private String moduleName;

    /**
     * 类型
     */
    @TableField(value = "type")
    private String type;

    /**
     * 描述
     */
    @TableField(value = "description")
    private String description;

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