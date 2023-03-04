package com.xiaohu.media_assets.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohu.media_assets.mapper.UserMediaMapper;
import com.xiaohu.media_assets.model.domain.UserMedia;
import com.xiaohu.media_assets.service.UserMediaService;
import org.springframework.stereotype.Service;

/**
* @author xiaohu
* @description 针对表【t_user_media(用户--资源关系表)】的数据库操作Service实现
* @createDate 2023-03-05 00:22:59
*/
@Service
public class UserMediaServiceImpl extends ServiceImpl<UserMediaMapper, UserMedia>
    implements UserMediaService{

}




