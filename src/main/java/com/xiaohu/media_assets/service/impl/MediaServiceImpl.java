package com.xiaohu.media_assets.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohu.media_assets.mapper.MediaMapper;
import com.xiaohu.media_assets.model.domain.Media;
import com.xiaohu.media_assets.service.MediaService;
import org.springframework.stereotype.Service;

/**
* @author xiaohu
* @description 针对表【t_media(资源表)】的数据库操作Service实现
* @createDate 2023-03-05 00:22:59
*/
@Service
public class MediaServiceImpl extends ServiceImpl<MediaMapper, Media>
    implements MediaService{

}




