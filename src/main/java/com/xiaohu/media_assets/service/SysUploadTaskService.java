package com.xiaohu.media_assets.service;

import com.xiaohu.media_assets.model.domain.SysUploadTask;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaohu.media_assets.model.dto.TaskInfoDTO;
import com.xiaohu.media_assets.model.vo.InitTaskParam;

import java.util.Map;

/**
* @author xiaohu
* @description 针对表【t_sys_upload_task(分片上传-分片任务记录)】的数据库操作Service
* @createDate 2023-04-28 21:16:27
*/
public interface SysUploadTaskService extends IService<SysUploadTask> {

    /**
     * 获取文件上传进度
     * @param identifier
     * @return
     */
    TaskInfoDTO getTaskInfo(String identifier);

    /**
     * 初始化一个上传进度
     * @param param
     * @return
     */
    TaskInfoDTO initTask(InitTaskParam param);

    /**
     * 通过MD5字符串获取上传任务
     * @param identifier
     * @return
     */
    SysUploadTask getByIdentifier(String identifier);

    /**
     * 获取分片的上传地址
     * @param bucketName
     * @param objectKey
     * @param params
     * @return
     */
    String genPreSignUploadUrl(String bucketName, String objectKey, Map<String, String> params);

    /**
     * 获取文件地址
     * @param bucket
     * @param objectKey
     * @return
     */
    String getPath (String bucket, String objectKey);

    /**
     * 合并分片
     * @param identifier
     */
    void merge(String identifier);
}
