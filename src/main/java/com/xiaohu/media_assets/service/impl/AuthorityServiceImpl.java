package com.xiaohu.media_assets.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohu.media_assets.mapper.AuthorityMapper;
import com.xiaohu.media_assets.model.domain.Authority;
import com.xiaohu.media_assets.service.AuthorityService;
import org.springframework.stereotype.Service;

/**
* @author xiaohu
* @description 针对表【t_authority(权限表)】的数据库操作Service实现
* @createDate 2023-03-05 00:22:59
*/
@Service
public class AuthorityServiceImpl extends ServiceImpl<AuthorityMapper, Authority>
    implements AuthorityService {

}




