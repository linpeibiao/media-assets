package com.xiaohu.media_assets.controller;

import com.xiaohu.media_assets.model.domain.SysUploadTask;
import com.xiaohu.media_assets.model.dto.TaskInfoDTO;
import com.xiaohu.media_assets.model.result.Result;
import com.xiaohu.media_assets.model.vo.InitTaskParam;
import com.xiaohu.media_assets.service.SysUploadTaskService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaohu
 * @date 2023/04/25/ 15:29
 * @description
 */
@RestController
@RequestMapping("/v1/minio/tasks")
public class MediaUploadController {
    /**
     * 服务对象
     */
    @Resource
    private SysUploadTaskService sysUploadTaskService;


    /**
     * 获取上传进度
     * @param identifier 文件md5
     * @return
     */
    @GetMapping("/{identifier}")
    public Result<TaskInfoDTO> taskInfo (@PathVariable("identifier") String identifier) {
        return Result.success(sysUploadTaskService.getTaskInfo(identifier));
    }

    /**
     * 创建一个上传任务
     * @return
     */
    @PostMapping
    public Result<TaskInfoDTO> initTask (@Valid @RequestBody InitTaskParam param, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return Result.fail(bindingResult.getFieldError().getDefaultMessage());
        }
        return Result.success(sysUploadTaskService.initTask(param));
    }

    /**
     * 获取每个分片的预签名上传地址
     * @param identifier
     * @param partNumber
     * @return
     */
    @GetMapping("/{identifier}/{partNumber}")
    public Result<String> preSignUploadUrl (@PathVariable("identifier") String identifier, @PathVariable("partNumber") Integer partNumber) {
        SysUploadTask task = sysUploadTaskService.getByIdentifier(identifier);
        if (task == null) {
            return Result.fail("分片任务不存在");
        }
        Map<String, String> params = new HashMap<>();
        params.put("partNumber", partNumber.toString());
        params.put("uploadId", task.getUploadId());
        return Result.success(sysUploadTaskService.genPreSignUploadUrl(task.getBucketName(), task.getObjectKey(), params));
    }

    /**
     * 合并分片
     * @param identifier
     * @return
     */
    @PostMapping("/merge/{identifier}")
    public Result merge (@PathVariable("identifier") String identifier) {
        sysUploadTaskService.merge(identifier);
        return Result.success(null);
    }

}

