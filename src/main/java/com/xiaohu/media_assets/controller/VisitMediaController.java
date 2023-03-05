package com.xiaohu.media_assets.controller;

import com.xiaohu.media_assets.model.result.Result;
import com.xiaohu.media_assets.service.MediaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xiaohu
 * @date 2023/03/05/ 11:40
 * @description
 */
@RestController
@RequestMapping("/visit-media")
public class VisitMediaController {
    @Resource
    private MediaService mediaService;

    @ApiOperation("用户请求访问资源")
    @GetMapping("/get-media-url/{mediaId}")
    public Result<String> getMediaUrl(@PathVariable("mediaId") Long mediaId){
        String url = mediaService.getUrl(mediaId);
        return Result.success(url);
    }
}
