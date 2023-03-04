package com.xiaohu.media_assets.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohu.media_assets.mapper.UserMapper;
import com.xiaohu.media_assets.model.domain.User;
import com.xiaohu.media_assets.service.UserService;
import org.springframework.stereotype.Service;

/**
* @author xiaohu
* @description 针对表【t_user(用户表)】的数据库操作Service实现
* @createDate 2023-03-05 00:22:59
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




