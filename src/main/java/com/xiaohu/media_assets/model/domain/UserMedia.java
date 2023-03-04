package com.xiaohu.media_assets.model.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * 用户--资源关系表
 * @TableName t_user_media
 */
@TableName(value ="t_user_media")
@Data
public class UserMedia implements Serializable {
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 资源id
     */
    @TableField(value = "media_id")
    private Long mediaId;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Long userId;

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