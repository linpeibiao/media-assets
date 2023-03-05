package com.xiaohu.media_assets.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohu.media_assets.exception.BusinessException;
import com.xiaohu.media_assets.mapper.MediaMapper;
import com.xiaohu.media_assets.model.domain.Media;
import com.xiaohu.media_assets.model.domain.Module;
import com.xiaohu.media_assets.model.domain.ModuleStrategy;
import com.xiaohu.media_assets.model.domain.Strategy;
import com.xiaohu.media_assets.model.result.ResultCode;
import com.xiaohu.media_assets.service.MediaService;
import com.xiaohu.media_assets.service.ModuleService;
import com.xiaohu.media_assets.service.ModuleStrategyService;
import com.xiaohu.media_assets.service.StrategyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
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
        Media media = getById(mediaId);
        Long moduleId = media.getModuleId();
        if (moduleId == null){
            throw new BusinessException(ResultCode.NOT_FOUND);
        }
        Module module = moduleService.getById(moduleId);
        // 获取板块的访问策略
        List<Long> strategyIds = moduleStrategyService.list(new QueryWrapper<ModuleStrategy>()
                .eq("module_id", moduleId))
                .stream()
                .map(moduleStrategy -> moduleStrategy.getStrategyId())
                .collect(Collectors.toList());
        List<Strategy> strategies = strategyService.listByIds(strategyIds);
        for (Strategy strategy : strategies){
            // 遍历每一个策略，判断是否满足其中一个
            // 判断当前用户是否满足策略（比如是否为会员，时间是否在有效期内）

        }
        return null;
    }
}




