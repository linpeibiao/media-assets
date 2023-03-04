package com.xiaohu.media_assets.model.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 资源表
 * @TableName t_media
 */
@TableName(value ="t_media")
@Data
public class Media implements Serializable {
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 资源名称
     */
    @TableField(value = "media_name")
    private String mediaName;

    /**
     * 资源类型
     */
    @TableField(value = "type")
    private String type;

    /**
     * 访问地址
     */
    @TableField(value = "url")
    private String url;

    /**
     * 资源创建者
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 所属模块id
     */
    @TableField(value = "module_id")
    private Long moduleId;

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
    @JsonIgnore
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
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