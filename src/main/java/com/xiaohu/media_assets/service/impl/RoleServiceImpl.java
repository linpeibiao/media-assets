package com.xiaohu.media_assets.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohu.media_assets.mapper.RoleMapper;
import com.xiaohu.media_assets.model.domain.Role;
import com.xiaohu.media_assets.service.RoleService;
import org.springframework.stereotype.Service;

/**
* @author xiaohu
* @description 针对表【t_role(角色表)】的数据库操作Service实现
* @createDate 2023-03-05 00:22:59
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




