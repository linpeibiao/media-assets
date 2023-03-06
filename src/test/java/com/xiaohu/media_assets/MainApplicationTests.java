package com.xiaohu.media_assets;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaohu.media_assets.model.domain.Media;
import com.xiaohu.media_assets.service.MediaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xiaohu
 * @date 2023/03/05/ 23:06
 * @description
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MainApplicationTests {
    @Autowired
    private MediaService mediaService;
    @Test
    public void getUrlTest(){
        Media byId = mediaService.getOne(new QueryWrapper<Media>().eq("id", 1L));
        System.out.println(byId);
        System.out.println();
    }
}
