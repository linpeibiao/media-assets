package com.xiaohu.media_assets.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohu.media_assets.exception.BusinessException;
import com.xiaohu.media_assets.mapper.MediaMapper;
import com.xiaohu.media_assets.model.domain.*;
import com.xiaohu.media_assets.model.result.ResultCode;
import com.xiaohu.media_assets.service.MediaService;
import com.xiaohu.media_assets.service.ModuleService;
import com.xiaohu.media_assets.service.ModuleStrategyService;
import com.xiaohu.media_assets.service.StrategyService;
import com.xiaohu.media_assets.util.UserHolder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author xiaohu
* @description 针对表【t_media(资源表)】的数据库操作Service实现
* @createDate 2023-03-05 00:22:59
*/
@Service
public class MediaServiceImpl extends ServiceImpl<MediaMapper, Media>
    implements MediaService{
    @Resource
    private ModuleService moduleService;
    @Resource
    private StrategyService strategyService;
    @Resource
    private ModuleStrategyService moduleStrategyService;

    @Override
    public String getUrl(Long mediaId) {
        if (mediaId == null || mediaId <= 0){
            throw new BusinessException(ResultCode.PARAMS_ERROR, "资源id不合法");
        }
        // 获取资源的板块
        Media media = this.getById(mediaId);
        if (media == null){
            throw new BusinessException(ResultCode.NOT_FOUND, "未找到资源");
        }
        Long moduleId = media.getModuleId();
        if (moduleId == null){
            throw new BusinessException(ResultCode.NOT_FOUND, "未找到资源");
        }
        Module module = moduleService.getById(moduleId);
        // 获取板块的访问策略
        List<Long> strategyIds = moduleStrategyService.list(new QueryWrapper<ModuleStrategy>()
                .eq("module_id", moduleId))
                .stream()
                .map(moduleStrategy -> moduleStrategy.getStrategyId())
                .collect(Collectors.toList());
        // TODO 没有策略，直接返回没有该资源，再添加资源的时候应该有默认策略，尽管是游客访问
        if (strategyIds.isEmpty()){
            throw new BusinessException(ResultCode.NOT_FOUND, "未找到资源");
        }
        List<Strategy> strategies = strategyService.listByIds(strategyIds);
        User curUser = UserHolder.get();
        for (Strategy strategy : strategies){
            // 遍历每一个策略，判断是否满足其中一个
            // 判断当前用户是否满足策略（比如是否为会员，时间是否在有效期内）
            String roleStrategy = strategy.getRoleName();
            if (!StringUtils.isBlank(roleStrategy) && !roleStrategy.equals("游客")){
                if (curUser == null){
                    throw new BusinessException(ResultCode.NOT_LOGIN, "未登录");
                }
                // 角色
                String roleName = curUser.getRoleName().getRoleName();
                // TODO 按照角色（int）判断提高可扩展性，只需要判断大小，不用equals
                if (roleStrategy.equals(roleName)){
                    return media.getUrl();
                }
            }else{
                // TODO 判断时间、地点等其他环境
            }
        }
        return "无法访问";
    }
}




