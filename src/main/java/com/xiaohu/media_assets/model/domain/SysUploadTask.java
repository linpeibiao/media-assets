package com.xiaohu.media_assets.model.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 分片上传-分片任务记录
 * @TableName t_sys_upload_task
 */
@TableName(value ="t_sys_upload_task")
@Data
@Accessors(chain = true)
public class SysUploadTask implements Serializable {
    /**
     * 
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 分片上传的uploadId
     */
    @TableField(value = "upload_id")
    private String uploadId;

    /**
     * 文件唯一标识（md5）
     */
    @TableField(value = "file_identifier")
    private String fileIdentifier;

    /**
     * 文件名
     */
    @TableField(value = "file_name")
    private String fileName;

    /**
     * 所属桶名
     */
    @TableField(value = "bucket_name")
    private String bucketName;

    /**
     * 文件的key
     */
    @TableField(value = "object_key")
    private String objectKey;

    /**
     * 文件大小（byte）
     */
    @TableField(value = "total_size")
    private Long totalSize;

    /**
     * 每个分片大小（byte）
     */
    @TableField(value = "chunk_size")
    private Long chunkSize;

    /**
     * 分片数量
     */
    @TableField(value = "chunk_num")
    private Integer chunkNum;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}