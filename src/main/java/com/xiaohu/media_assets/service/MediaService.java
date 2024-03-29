package com.xiaohu.media_assets.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaohu.media_assets.model.domain.Media;

/**
* @author xiaohu
* @description 针对表【t_media(资源表)】的数据库操作Service
* @createDate 2023-03-05 00:22:59
*/
public interface MediaService extends IService<Media> {


    /**
     * 获取资源的访问地址
     * @param mediaId
     * @return
     */
    String getUrl(Long mediaId);
}
